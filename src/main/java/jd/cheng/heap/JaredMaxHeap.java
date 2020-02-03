package jd.cheng.heap;

import java.util.StringJoiner;

import jd.cheng.array.JaredArray;

public class JaredMaxHeap {

	private static final String FORMAT = "%d[%d]";
	
	private JaredArray array;
	
	public JaredMaxHeap() {
		this(10);
	}
	
	public JaredMaxHeap(int capacity) {
		this.array = new JaredArray(capacity);
	}
	
	private JaredMaxHeap(int[] input) {
		this.array = JaredArray.copyOf(input);
	}
	
	public int size() {
		return this.array.size();
	}
	
	public boolean isEmpty() {
		return this.array.isEmpty();
	}
	
	public JaredMaxHeap add(int element) {
		// 1. add to the last of array
		this.array.addLast(element);
		// 2. get index
		int index = this.array.size() - 1;
		// 3. sift-up by recursion
		this.siftUp(index, element);
		
		return this;
	}
	
	private void siftUp(int index, int element) {
		if(0 != index) {
			// compare to parent
			int parentIndex = parentIndex(index);
			int parent = this.array.get(parentIndex);
			if(parent < element) {
				this.array.set(parentIndex, element);
				this.array.set(index, parent);
				// continue to its parent
				siftUp(parentIndex, element);
			}
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new IllegalStateException("empty heap");
		} else {
			return this.array.getFirst();
		}
	}
	
	public int extract() {
		if(isEmpty()) {
			throw new IllegalStateException("empty heap, nothing to be extracted");
		}
		
		int result = this.array.getFirst();
		int last = this.array.removeLast();
		
		if(!isEmpty()) {
			this.array.set(0, last);
			siftDown(0, last);
		}
		
		return result;
	}
	
	private void siftDown(int index, int element) {
		int size = this.size();
		if(this.size() > index) {
			int leftChildIndex = leftChildIndex(index);
			int rightChildIndex = rightChildIndex(index);

			if(leftChildIndex >= size) {
				// no child, do nothing
				return;
			} else if(rightChildIndex >= size) {
				// only left child
				int left = this.array.get(leftChildIndex);
				// if left > parent, swap
				if(element < left) {
					this.array.set(index, left);
					this.array.set(leftChildIndex, element);
					this.siftDown(leftChildIndex, element);
				}
			} else {
				// two children
				int left = this.array.get(leftChildIndex);
				int right = this.array.get(rightChildIndex);
				if(left > right) {
					// use left
					if(element < left) {
						this.array.set(index, left);
						this.array.set(leftChildIndex, element);
						this.siftDown(leftChildIndex, element);
					}
				} else {
					// use right
					if(element < right) {
						this.array.set(index, right);
						this.array.set(rightChildIndex, element);
						this.siftDown(rightChildIndex, element);
					}
				}
			}
		}
	}
	
	public int replace(int element) {
		if(isEmpty()) {
			throw new IllegalStateException("empty heap, nothing to be replaced");
		}
		
		int result = this.array.getFirst();
		
		this.array.set(0, element);
		siftDown(0, element);
		
		return result;
	}
	
	public void print() {
		if(!isEmpty()) {
			StringJoiner sj = new StringJoiner(";");
			levelOrderRecursion(0, sj, 1);
			System.out.println(sj.toString());
		}
	}
	
	private void levelOrderRecursion(int index, StringJoiner sj, int level) {
		if(this.array.size() > index) {
			int value = this.array.get(index);
			sj.add(String.format(FORMAT, value, level));
			levelOrderRecursion(leftChildIndex(index), sj, level+1);
			levelOrderRecursion(rightChildIndex(index), sj, level+1);
		}
	}
	
	private static int parentIndex(int childIndex) {
		if(0 == childIndex) {
			throw new IllegalArgumentException("index = 0 doesn't have parent!");
		}
		return (childIndex-1) / 2;
	}
	
	private static int leftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}
	
	private static int rightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}

	/**
	 * covert an array into a heap
	 * 
	 * @param input
	 */
	public static JaredMaxHeap heapify(int[] input) {
		
		if(null == input || input.length == 0) {
			throw new IllegalArgumentException("can't heapify an empty array");
		}
		
		JaredMaxHeap result = new JaredMaxHeap(input);
		if(result.size() == 1) {
			return result;
		}
		
		int lastIndex = result.array.size() - 1;
		int lastParentIndex = parentIndex(lastIndex);
		
		for(int i=lastParentIndex; i >= 0; i--) {
			result.siftDown(i, result.array.get(i));
		}
		
		return result;
	}
}
