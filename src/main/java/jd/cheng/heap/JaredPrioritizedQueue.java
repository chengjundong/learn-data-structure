package jd.cheng.heap;

import jd.cheng.queue.JaredQueue;

public class JaredPrioritizedQueue implements JaredQueue {

	private JaredMaxHeap heap;
	
	public JaredPrioritizedQueue() {
		this.heap = new JaredMaxHeap();
	}
	
	public JaredPrioritizedQueue(int capacity) {
		this.heap = new JaredMaxHeap(capacity);
	}
	
	@Override
	public JaredQueue enqueue(int e) {
		heap.add(e);
		return this;
	}

	@Override
	public int dequeue() {
		return heap.extract();
	}

	@Override
	public int getFront() {
		return heap.peek();
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

}
