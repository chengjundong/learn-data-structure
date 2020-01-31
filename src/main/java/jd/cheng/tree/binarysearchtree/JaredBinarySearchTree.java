package jd.cheng.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringJoiner;

public class JaredBinarySearchTree<E extends Comparable<E>> {

	private class TreeNode {
		private E value;
		private TreeNode left;
		private TreeNode right;
		private int depth;
		
		public TreeNode(E value, int depth) {
			this.value = value;
			this.depth = depth;
		}
		
		/**
		 * print node information in this format "value[depth]"
		 */
		@Override
		public String toString() {
			return new StringBuilder().append(value)
					.append("[").append(depth).append("]").toString();
		}
		
	}
	
	private TreeNode root;
	private int size;
	private int treeDepth;
	
	public JaredBinarySearchTree() {
		
	}
	
	public boolean isEmpty() {
		return 0 == this.size;
	}
	
	public int size() {
		return this.size;
	}
	
	public int depth() {
		return this.treeDepth;
	}

	/**
	 * add element to tree by recursion
	 * 
	 * @param e
	 */
	public JaredBinarySearchTree<E> add(E e) {
		if(null == e) {
			throw new IllegalArgumentException("invalid input: NULL!");
		}
		root = addByRecursion(root, e, 0);
		return this;
	}
	
	private TreeNode addByRecursion(TreeNode node, E e, int currentDepth) {
		// if input is null, then return a new node
		if(node == null) {
			size++;
			// set tree depth
			if(currentDepth - this.treeDepth > 0) {
				this.treeDepth = currentDepth;
			}
			// create a new node
			return new TreeNode(e, currentDepth);
		}
		
		if(node.value.compareTo(e) == 1) {
			// link to the left by recursion
			node.left = addByRecursion(node.left, e, currentDepth+1);
		} else if(node.value.compareTo(e) == -1) {
			// link to the right by recursion
			node.right = addByRecursion(node.right, e, currentDepth+1);
		}
		
		// return self since no self-value change
		return node;
	}
	
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(TreeNode n, E e) {
		if(n == null) {
			return false;
		} else if(n.value.compareTo(e) == 0) {
			return true;
		} else if(n.value.compareTo(e) == 1){
			// gt n.value, go to left
			return contains(n.left, e);
		} else {
			// lt n.value, go to right
			return contains(n.right, e);
		}
	}
	
	/**
	 * mid -> left -> right
	 * @return self
	 */
	public JaredBinarySearchTree<E> preOrder() {
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
	public JaredBinarySearchTree<E> inOrder() {
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
	public JaredBinarySearchTree<E> postOrder() {
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
	public JaredBinarySearchTree<E> preOrderByStack() {
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
	public JaredBinarySearchTree<E> levelOrder() {
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
}
