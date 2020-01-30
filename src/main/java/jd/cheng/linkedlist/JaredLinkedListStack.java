package jd.cheng.linkedlist;

import jd.cheng.stack.JaredStack;

public class JaredLinkedListStack implements JaredStack {

	private JaredLinkedList<Integer> list;
	
	public JaredLinkedListStack() {
		this.list = new JaredLinkedList<>();
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(int e) {
		list.addFirst(e);
	}

	@Override
	public int pop() {
		return list.removeFirst();
	}

	@Override
	public int peek() {
		return list.getFirst();
	}
	
	public void print() {
		this.list.print();
	}
}
