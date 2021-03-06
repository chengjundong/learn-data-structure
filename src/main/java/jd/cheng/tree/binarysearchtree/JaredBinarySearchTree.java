package jd.cheng.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringJoiner;

public class JaredBinarySearchTree<K extends Comparable<K>, V> {

	private class TreeNode {
		private K key;
		private V value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(K key, V value) {
			this.key = key;
		}
		
		/**
		 * print node information in this format "value[depth]"
		 */
		@Override
		public String toString() {
			return String.format("[%s | %s]", key, value);
		}
		
	}
	
	private TreeNode root;
	private int size;
	
	public JaredBinarySearchTree() {
		
	}
	
	public boolean isEmpty() {
		return 0 == this.size;
	}
	
	public int size() {
		return this.size;
	}

	/**
	 * add element to tree by recursion
	 * 
	 * @param e
	 */
	public JaredBinarySearchTree<K,V> add(K key, V value) {
		if(null == key) {
			throw new IllegalArgumentException("invalid input: NULL!");
		}
		root = addByRecursion(root, key, value);
		return this;
	}
	
	private TreeNode addByRecursion(TreeNode node, K key, V value) {
		// if input is null, then return a new node
		if(node == null) {
			size++;
			// create a new node
			return new TreeNode(key, value);
		}
		
		if(node.key.compareTo(key) > 0) {
			// link to the left by recursion
			node.left = addByRecursion(node.left, key, value);
		} else if(node.key.compareTo(key) < 0) {
			// link to the right by recursion
			node.right = addByRecursion(node.right, key, value);
		}
		
		// return self since no self-value change
		return node;
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
	
	/**
	 * mid -> left -> right
	 * @return self
	 */
	public JaredBinarySearchTree<K, V> preOrder() {
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
	public JaredBinarySearchTree<K, V> inOrder() {
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
	public JaredBinarySearchTree<K, V> postOrder() {
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
	public JaredBinarySearchTree<K, V> preOrderByStack() {
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
	public JaredBinarySearchTree<K, V> levelOrder() {
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
	
	public K removeMin() {
		if(isEmpty()) {
			throw new IllegalStateException("nothing to remove");
		}
		// it is used to store the min value to return
		TreeNode result = new TreeNode(null, null);
		root = removeMin(root, result);
		return result.key;
	}
	
	private TreeNode removeMin(TreeNode n, TreeNode min) {
		if(n == null) {
			return null;
		}
		else if(n.left == null) {
			min.key = n.key;
			TreeNode result = n.right;
			n.right = null;
			size--;
			return result;
		} else {
			n.left = removeMin(n.left, min);
			return n;
		}
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
	
	public void remove(K value) {
		
		if(isEmpty()) {
			throw new IllegalStateException("nothing to remove");
		}
		
		root = remove(root, value);
	}
	
	private TreeNode remove(TreeNode n, K value) {
		if(n == null) {
			return null;
		} else if(n.key.compareTo(value) > 0) {
			n.left = remove(n.left, value);
			return n;
		} else if(n.key.compareTo(value) < 0) {
			n.right = remove(n.right, value);
			return n;
		} else {
			// match
			if(n.left == null) {
				TreeNode result = n.right;
				n.right = null;
				size--;
				return result;
			} else if(n.right == null) {
				TreeNode result = n.left;
				n.left = null;
				size--;
				return result;
			} else {
				TreeNode minNode = new TreeNode(null, null);
				minNode.right = removeMin(n.right, minNode);
				minNode.left = n.left;
				n.right = n.left = null;
				return minNode;
			}
		}
	}
	
	public void set(K key, V value) {
		set(root, key, value);
	}
	
	private void set(TreeNode n, K key, V value) {
		if(n == null) {
			return;
		} else if(n.key.compareTo(key) > 0) {
			set(n.left, key, value);
		} else if(n.key.compareTo(key) < 0) {
			set(n.right, key, value);
		} else {
			n.value = value;
		}
	}
}
