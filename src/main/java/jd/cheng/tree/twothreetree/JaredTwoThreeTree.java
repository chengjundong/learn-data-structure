package jd.cheng.tree.twothreetree;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 2-3 tree
 * 
 * @author jucheng
 * @deprecated unfinished implementation
 *
 */
@Deprecated
public class JaredTwoThreeTree {

	public static class Node {
		// value
		private int leftValue;
		private int rightValue;
		// children
		private Node leftChild;
		private Node midChild;
		private Node rightChild;
		// parent
		private Node parent;
		// flag
		private boolean isThreeNode;
		
		public Node(int leftValue) {
			this.leftValue = leftValue;
		}
	}

	private int size = 0;
	private Node root = null;

	public JaredTwoThreeTree add(int val) {
		if(null == root) {
			root = new Node(val);
			size++;
			return this;
		} else {
			this.add(root, val);
		}
		
		return this;
	}
	
	private void add(Node n, int val) {

		if(n.isThreeNode) {
			// 3-node
			if(n.leftChild == null && n.midChild == null && n.rightChild == null) {
				// leaf
				bottomUp(val, n);
				size++;
			} else if(n.leftChild != null && n.midChild != null && n.rightChild != null) {
				if(val == n.leftValue || val == n.rightValue) {
					// duplicate
				} else if(val < n.leftValue) {
					add(n.leftChild, val);
				} else if(val > n.rightValue) {
					add(n.rightChild, val);
				} else {
					add(n.midChild, val);
				}
			} else {
				throw new IllegalStateException(String.format("unbalance found at 3-node"));
			}
		} else {
			// 2-node
			if(n.leftChild == null && n.midChild == null) {
				// leaf
				if(val == n.leftValue) {
					// duplicate
				} else if(val > n.leftValue) {
					// greater than
					// covert to 3-node
					n.isThreeNode = true;
					n.rightValue = val;
					size++;
				} else {
					// less than
					n.isThreeNode = true;
					n.rightValue = n.leftValue;
					n.leftValue = val;
					size++;
				}
			} else if(n.leftChild != null && n.midChild != null) {
				if(val == n.leftValue) {
					// duplicate
				} else if(val > n.leftValue) {
					add(n.midChild, val);
				} else {
					add(n.leftChild, val);
				}
			} else {
				throw new IllegalStateException(String.format("unbalance found at 2-node"));
			}
		}
	}
	
	private void bottomUp(int val, Node n) {
		if(n.isThreeNode) {
			if(val < n.leftValue) {
				int up = n.leftValue;
				n.leftValue = val;
				
				if(root == n) {
					Node parent = new Node(up);
					parent.leftChild = new Node(n.leftValue);
					parent.rightChild = new Node(n.rightValue);
					
					
					
				} else {					
					bottomUp(up, n.parent);
				}
			} else if(val > n.rightValue) {
				int up = n.rightValue;
				n.rightValue = val;
				bottomUp(up, n.parent);
			} else {
				bottomUp(val, n.parent);
			}
		} else {
			n.isThreeNode = true;
			 if(val > n.leftValue) {
				// greater than
				// covert to 3-node
				n.isThreeNode = true;
				n.rightValue = val;
			} else {
				// less than
				n.isThreeNode = true;
				n.rightValue = n.leftValue;
				n.leftValue = val;
			}
		}
	}
	
	/**
	 * 2-3 tree must be absolute balance
	 * 
	 * @return
	 */
	public boolean isAbsoluteBalance() {
		// empty tree
		if(size ==  0) {
			return true;
		}
		
		Set<Integer> depths = new HashSet<>();
		findLeaf(root, 1, depths);
		
		return 1 == depths.size();
	}
	
	public void findLeaf(Node n, int depth, Set<Integer> depths) {
		if(!n.isThreeNode) {
			findLeafAtTwoNode(n, depth, depths);
		} else {
			if(n.leftChild == null && n.rightChild == null && n.midChild == null) {
				// leat found
				depths.add(depth);
			} else if(n.leftChild != null && n.rightChild != null && n.midChild != null) {
				// full child
				int newDepth = depth+1;
				findLeaf(n.leftChild, newDepth, depths);
				findLeaf(n.rightChild, newDepth, depths);
				findLeaf(n.midChild, newDepth, depths);
			} else {
				// unbalance, throw exception
				throw new IllegalStateException(String.format("unbalance found at 3-node"));
			}
		}
	}

	private void findLeafAtTwoNode(Node n, int depth, Set<Integer> depths) {
		if(n.leftChild == null && n.midChild == null) {
			// leaf found
			depths.add(depth);
		} else if(n.leftChild != null && n.midChild != null) {
			// has two child
			int newDepth = depth+1;
			findLeaf(n.leftChild, newDepth, depths);
			findLeaf(n.midChild, newDepth, depths);
		} else {
			// unbalance, throw exception			
			throw new IllegalStateException(String.format("unbalance found at 2-node %d", n.leftValue));
		}
	}

	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",");
		toString(root, sj);
		return sj.toString();
	}
	
	private void toString(Node n, StringJoiner sj) {
		if(n != null) {
			if(n.isThreeNode) {
				sj.add(String.format("[%d|%d]", n.leftValue, n.rightValue));
				toString(n.leftChild, sj);
				toString(n.midChild, sj);
				toString(n.rightChild, sj);
			} else {
				sj.add(String.format("[%d]", n.leftValue));
				toString(n.leftChild, sj);
				toString(n.midChild, sj);
			}
		}
	}
}
