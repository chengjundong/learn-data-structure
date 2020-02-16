package jd.cheng.tree.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class JaredAVL<K extends Comparable<K>, V> {

	private class TreeNode {
		private K key;
		private V value;
		private TreeNode left;
		private TreeNode right;
		private int height;
		
		public TreeNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.height = 1;
		}
		
		/**
		 * print node information in this format "value[depth]"
		 */
		@Override
		public String toString() {
			return key.toString();
		}
	}
	
	private TreeNode root;
	private int size;
	
	public boolean isEmpty() {
		return 0 == this.size;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * @param n
	 * @return height of node
	 */
	private int getNodeHeight(TreeNode n) {
		return null == n ? 0 : n.height;
	}
	
	/**
	 * @param n
	 * @return left.height minus right.height
	 */
	private int getBalanceFactor(TreeNode n) {
		return null == n ? 0 : getNodeHeight(n.left) - getNodeHeight(n.right);
	}

	/**
	 * add element to tree by recursion
	 * 
	 * @param e
	 */
	public JaredAVL<K, V> add(K key, V val) {
		if(null == key) {
			throw new IllegalArgumentException("invalid input: NULL!");
		}
		root = addByRecursion(root, key, val);
		return this;
	}
	
	private TreeNode addByRecursion(TreeNode node, K key, V val) {
		// if input is null, then return a new node
		if(node == null) {
			size++;
			// create a new node
			return new TreeNode(key, val);
		}
		
		if(node.key.compareTo(key) > 0) {
			// link to the left by recursion
			node.left = addByRecursion(node.left, key, val);
		} else if(node.key.compareTo(key) < 0) {
			// link to the right by recursion
			node.right = addByRecursion(node.right, key, val);
		} else {
			// replace the value
			node.value = val;
		}
		
		// update height
		updateHeight(node);
		
		// check balance factor
		int bf = getBalanceFactor(node);
		
		if(bf > 1) {
			// unbalance at left child
			if(getBalanceFactor(node.left) >= 0) {
				// LL
				return rightRotation(node);
			} else {
				// LR
				node.left = leftRotation(node.left);
				return rightRotation(node);
			}
		} else if(bf < -1) {
			// unbalance at right child
			if(getBalanceFactor(node.right) <= 0) {				
				// RR
				return leftRotation(node);
			} else {
				// RL
				node.right = rightRotation(node.right);
				return leftRotation(node);
			}
		}
		
		// return self since no self-value change
		return node;
	}
	
	

	private void updateHeight(TreeNode node) {
		node.height = 1 + Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
	}
	
	private TreeNode rightRotation(TreeNode n) {
		// get node
		TreeNode result = n.left;
		TreeNode t = result.right;
		// rotation
		result.right = n;
		n.left = t;
		// update height
		this.updateHeight(n);
		this.updateHeight(result);
		
		return result;
	}
	
	private TreeNode leftRotation(TreeNode n) {
		// get nod
		TreeNode result = n.right;
		TreeNode t = result.left;
		// rotation
		result.left = n;
		n.right = t;
		// update height
		this.updateHeight(n);
		this.updateHeight(result);
		
		return result;
	}
	
	public boolean contains(K e) {
		return contains(root, e);
	}
	
	private boolean contains(TreeNode n, K e) {
		if(n == null) {
			return false;
		} else if(n.key.compareTo(e) == 0) {
			return true;
		} else if(n.key.compareTo(e) > 0){
			// gt n.value, go to left
			return contains(n.left, e);
		} else {
			// lt n.value, go to right
			return contains(n.right, e);
		}
	}
	
	public V get(K e) {
		return get(root, e);
	}
	
	private V get(TreeNode n, K e) {
		if(n == null) {
			return null;
		} else if(n.key.compareTo(e) == 0) {
			return n.value;
		} else if(n.key.compareTo(e) > 0){
			// gt n.value, go to left
			return get(n.left, e);
		} else {
			// lt n.value, go to right
			return get(n.right, e);
		}
	}
	
	public void set(K key, V val) {
		set(root, key, val);
	}
	
	private void set(TreeNode n, K key, V val) {
		if(n == null) {
			return;
		} else if(n.key.compareTo(key) > 0) {
			set(n.left, key, val);
		} else if(n.key.compareTo(key) < 0) {
			set(n.right, key, val);
		} else {
			n.value = val;
		}
	}
	
	/**
	 * mid -> left -> right
	 * @return self
	 */
	public JaredAVL<K, V> preOrder() {
		System.out.print("pre-order traverse: ");
		preOrder(root);
		System.out.println();
		return this;
	}
	
	private void preOrder(TreeNode n) {
		if(n == null) {
			return;
		} else {
			System.out.print(n+";");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	/**
	 * left -> mid -> right
	 * @return self
	 */
	public JaredAVL<K, V> inOrder() {
		System.out.print("in-order traverse: ");
		inOrder(root);
		System.out.println();
		return this;
	}
	
	private void inOrder(TreeNode n) {
		if(n != null) {
			inOrder(n.left);
			System.out.print(n+";");
			inOrder(n.right);
		}
	}
	
	/**
	 * left -> right -> mid
	 * @return self
	 */
	public JaredAVL<K, V> postOrder() {
		System.out.print("post-order traverse: ");
		postOrder(root);
		System.out.println();
		return this;
	}
	
	private void postOrder(TreeNode n) {
		if(n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n+";");
		}
	}
	
	/**
	 * use stack to do pre-order traverse of entire tree.
	 * push root to stack, then repeat these steps until stack is empty
	 * <ol>
	 * <li>pop stack and access node.value</li>
	 * <li>push node.right to stack if exists</li>
	 * <li>push node.left to stack if exists</li>
	 * </ol>
	 * 
	 * @return self
	 */
	public JaredAVL<K, V> preOrderByStack() {
		// empty tree, skip
		if(isEmpty()) {
			return this;
		}

		StringJoiner sj = new StringJoiner(";");
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			sj.add(node.toString());
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println("pre-order traverse by stack: " + sj.toString());
		
		return this;
	}
	
	/**
	 * traverse the tree by level, level 0 -> level max
	 * 
	 * @return self
	 */
	public JaredAVL<K, V> levelOrder() {
		if(isEmpty()) {
			return this;
		}
		
		StringJoiner sj = new StringJoiner(";");
		LinkedList<TreeNode> l = new LinkedList<>();
		
		for(l.add(root); !l.isEmpty();) {
			TreeNode n = l.removeFirst();
			sj.add(n.toString());
			if(n.left != null) {
				l.add(n.left);
			}
			if(n.right != null) {
				l.add(n.right);
			}
		}
		
		System.out.println("level-order traverse: " + sj.toString());
		
		return this;
	}
	
	/**
	 * @return the min value
	 */
	public K min() {
		return isEmpty() ? null : min(root).key;
	}
	
	private TreeNode min(TreeNode n) {
		return null == n.left ? n: min(n.left);
	}
	
	/**
	 * @return the max value
	 */
	public K max() {
		return isEmpty() ? null : max(root).key;
	}
	
	private TreeNode max(TreeNode n) {
		return null == n.right ? n : max(n.right);
	}
	
	public K removeMax() {
		if(isEmpty()) {
			throw new IllegalStateException("nothing to remove");
		}
		// it is used to store the min value to return
		TreeNode result = new TreeNode(null, null);
		root = removeMax(root, result);
		return result.key;
	}
	
	private TreeNode removeMax(TreeNode n, TreeNode max) {
		if(n == null) {
			return null;
		}
		else if(n.right == null) {
			max.key = n.key;
			TreeNode result = n.left;
			n.left = null;
			size--;
			return result;
		} else {
			n.right = removeMax(n.right, max);
			return n;
		}
	}
	
	public V remove(K key) {
		
		if(isEmpty()) {
			throw new IllegalStateException("nothing to remove");
		}
		
		V result = this.get(key);
		root = remove(root, key);
		return result;
	}
	
	private TreeNode remove(TreeNode n, K key) {
		
		TreeNode result = null;
		
		if(n == null) {
			return null;
		} else if(n.key.compareTo(key) > 0) {
			n.left = remove(n.left, key);
			result = n;
		} else if(n.key.compareTo(key) < 0) {
			n.right = remove(n.right, key);
			result = n;
		} else {
			// match
			if(n.left == null) {
				result = n.right;
				n.right = null;
				size--;
			} else if(n.right == null) {
				result = n.left;
				n.left = null;
				size--;
			} else {
				result = min(n.right);
				result.right = remove(n.right, result.key);
				result.left = n.left;
				n.right = n.left = null;
			}
		}
		
		if(result != null) {
			// update height
			this.updateHeight(result);
			
			// check balance factor
			int bf = getBalanceFactor(result);
			
			if(bf > 1) {
				// unbalance at left child
				if(getBalanceFactor(result.left) >= 0) {
					// LL
					return rightRotation(result);
				} else {
					// LR
					result.left = leftRotation(result.left);
					return rightRotation(result);
				}
			} else if(bf < -1) {
				// unbalance at right child
				if(getBalanceFactor(result.right) <= 0) {				
					// RR
					return leftRotation(result);
				} else {
					// RL
					result.right = rightRotation(result.right);
					return leftRotation(result);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * @return in-order traverse all node, should be ascend ordering
	 */
	public boolean isBinarySearchTree() {
		List<K> list = new ArrayList<K>();
		inOrder(root, list);
		
		for (int i=list.size()-1; i>0; i--) {
			if(list.get(i).compareTo(list.get(i-1)) <= 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private void inOrder(TreeNode n, List<K> list) {
		if(n != null) {
			inOrder(n.left, list);
			list.add(n.key);
			inOrder(n.right, list);
		}
	}
	
	/**
	 * @return the gap between leftChild and rightChild <= 1
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(TreeNode n) {
		if(n == null) {
			return true;
		} else {
			if(Math.abs(this.getBalanceFactor(n)) > 1) {
				return false;
			}
			return isBalanced(n.left) && isBalanced(n.right);
		}
	}
}
