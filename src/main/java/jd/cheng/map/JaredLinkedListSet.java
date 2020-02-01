package jd.cheng.map;

import jd.cheng.linkedlist.JaredLinkedList;

public class JaredLinkedListSet<E> implements JaredSet<E> {

	private JaredLinkedList<E> list;
	
	public JaredLinkedListSet() {
		this.list = new JaredLinkedList<>();
	}
	
	@Override
	public void add(E e) {
		if(!list.contains(e)) {
			list.addLast(e);
		}
	}

	@Override
	public void remove(E e) {
		list.removeByValue(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
