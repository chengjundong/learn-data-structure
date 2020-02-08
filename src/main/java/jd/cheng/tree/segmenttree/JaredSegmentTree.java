package jd.cheng.tree.segmenttree;

import java.util.StringJoiner;
import java.util.function.BiFunction;

public class JaredSegmentTree<E> {
	
	private static final String FORMAT = "%s[%d]";
	
	private E[] data;
	private E[] tree;
	private BiFunction<E, E, E> function;
	
	public JaredSegmentTree(E[] arr, BiFunction<E, E, E> f) {
		data = arr.clone();
		tree = (E[])new Object[data.length * 4];
		this.function = f;
		build(0, 0, data.length-1);
	}
	
	private void build(int index, int left, int right) {
		if(left == right) {
			tree[index] = data[left];
		} else {
			// to avoid over case, use base + offset
			int mid = left + (right-left)/2;
			
			int leftChildIndex = leftChildIndex(index);
			int rightChildIndex = rightChildIndex(index);
			build(leftChildIndex, left, mid);
			build(rightChildIndex, mid+1, right);
			
			tree[index] = function.apply(tree[leftChildIndex], tree[rightChildIndex]);
		}
		
	}
	
	public E get(int index) {
		if(index < 0 || index >= data.length) {
			throw new IllegalArgumentException("invalid index");
		}
		return data[index];
	}
	
	public int size() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return data.length == 0;
	}
	
	/**
	 * 
	 * @param queryL -- left
	 * @param queryR -- right
	 * @return
	 */
	public E query(int queryL, int queryR) {
		// index check
		if(queryL < 0 || queryL > data.length-1 
				|| queryR < 0 || queryR > data.length-1 || queryL > queryR) {
			throw new IllegalArgumentException("invalid index");
		}
		
		return query(0, 0, data.length-1, queryL, queryR);
	}
	
	private E query(int index, int left, int right, int queryL, int queryR) {
		if(queryL == left && queryR == right) {
			return tree[index];
		}
		
		int mid = left + (right-left)/2;
		int leftChildIndex = leftChildIndex(index);
		int rightChildIndex = rightChildIndex(index);
		
		if(queryL >= mid+1) {
			// query interval at right
			return query(rightChildIndex, mid+1, right, queryL, queryR);
		} else if(queryR <= mid) {
			// query interval at left
			return query(leftChildIndex, left, mid, queryL, queryR);
		}
		
		// query interval cover both left & right
		E el = query(leftChildIndex, left, mid, queryL, mid);
		E er = query(rightChildIndex, mid+1, right, mid+1, queryR);
		return function.apply(el, er);
	}
	
	public void set(int index, E e) {
		data[index] = e;
		set(0, 0, data.length-1, index, e);
	}
	
	private void set(int treeIndex, int left, int right, int dataIndex, E e) {
		// leaf found, set it
		if(left == right) {
			tree[treeIndex] = e;
			return;
		}
		
		int mid = left + (right-left)/2;
		int leftChildIndex = leftChildIndex(treeIndex);
		int rightChildIndex = rightChildIndex(treeIndex);
		
		if(dataIndex >= mid+1) {
			// go to right child
			set(rightChildIndex, mid+1, right, dataIndex, e);
		} else {
			// go to left child
			set(leftChildIndex, left, mid, dataIndex, e);
		}
		
		tree[treeIndex] = function.apply(tree[leftChildIndex], tree[rightChildIndex]);
	}
	
	public void print() {
		if(!isEmpty()) {
			StringJoiner sj = new StringJoiner(";");
			levelOrderRecursion(0, sj, 1);
			System.out.println(sj.toString());
		}
	}
	
	private void levelOrderRecursion(int index, StringJoiner sj, int level) {
		if(tree.length > index) {
			E value = tree[index];
			if(value != null) {				
				sj.add(String.format(FORMAT, value, level));
			}
			levelOrderRecursion(leftChildIndex(index), sj, level+1);
			levelOrderRecursion(rightChildIndex(index), sj, level+1);
		}
	}
	
	private static int leftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}
	
	private static int rightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}
}
