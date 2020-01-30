package jd.cheng.linkedlist;

import jd.cheng.queue.JaredQueue;

public class JaredLinkedListQueue implements JaredQueue {

	private JaredLinkedList<Integer> list;
	
	public JaredLinkedListQueue() {
		this.list = new JaredLinkedList<>();
	}
	
	@Override
	public JaredQueue enqueue(int e) {
		this.list.addLast(e);
		return this;
	}

	@Override
	public int dequeue() {
		return this.list.removeFirst();
	}

	@Override
	public int getFront() {
		return this.list.getFirst();
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public int showCapacity() {
		// no need
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public void print() {
		this.list.print();
	}
}
