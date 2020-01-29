package jd.cheng.queue;

import jd.cheng.array.JaredArray;

public class JaredArrayQueue implements JaredQueue {
	
	private JaredArray data;

	public JaredArrayQueue() {
		this.data = new JaredArray();
	}
	
	public JaredArrayQueue(int capacity) {
		this.data = new JaredArray(capacity);
	}

	@Override
	public JaredQueue enqueue(int e) {
		this.data.addLast(e);
		return this;
	}

	@Override
	public int dequeue() {
		return this.data.removeFirst();
	}

	@Override
	public int getFront() {
		return this.data.getFirst();
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public int showCapacity() {
		return this.data.showCapacity();
	}

	@Override
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
