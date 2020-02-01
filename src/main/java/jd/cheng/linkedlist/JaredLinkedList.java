package jd.cheng.linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

public class JaredLinkedList<E> {

	// internal node
	// the name of generic type should be different from JaredLinkedList
	// otherwise, you will see "The type parameter E is hiding the type E"
	private class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
		public Node() {
			this(null, null);
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}
	
	private int size;
	private Node<E> dummyHead;
	private Node<E> tail;
	
	public JaredLinkedList() {
		this.dummyHead = new Node<E>();
		this.size = 0;
	}

	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return 0 == this.size;
	}

	public void addFirst(E value) {
		add(0, value);
	}
	
	public void addLast(E value) {
		if(isEmpty()) {
			addFirst(value);
		} else {
			tail.next = new Node<E>(value, null);
			tail = tail.next;
			size++;
		}
	}
	
	public void add(int index, E value) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("invalid index");
		}
		
		Node<E> prev = dummyHead;
		for(int i=0; i<index; i++) {
			prev = prev.next;
		}
		prev.next = new Node<E>(value, prev.next);
		size++;
		// if insert at the last position, then change the tail
		if(index == size-1) {
			tail = prev.next;
		}
	}
	
	public void print() {
		StringJoiner sj = new StringJoiner("->");
		Node<E> current = dummyHead.next;
		for(int i=0; i<size; i++) {
			sj.add(current.value.toString());
			current = current.next;
		}
		System.out.println(sj.toString());
	}
	
	public E get(int index) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("invalid index");
		}
		
		Node<E> current = dummyHead.next;
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		
		return current.value;
	}
	
	public E getFirst() {
		return this.get(0);
	}
	
	public E getLast() {
		return this.get(size - 1);
	}
	
	public void set(int index, E value) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("invalid index");
		}
		
		Node<E> current = dummyHead.next;
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		
		current.value = value;
	}
	
	public boolean contains(E value) {
		for(Node<E> current = dummyHead.next; current != null; current = current.next) {
			if(Objects.equals(value, current.value)) {
				return true;
			}
		}
		return false;
	}
	
	public E remove(int index) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("invalid index");
		}
		
		if(isEmpty()) {
			throw new IllegalStateException("It is empty, nothing to remove!");
		}
		
		// to find the prev of target
		Node<E> prev = dummyHead;
		for(int i=0; i<index; i++) {
			prev = prev.next;
		}
		// target
		Node<E> target = prev.next;
		E result = target.value;
		// change link & clear target
		prev.next = target.next;
		target.next = null;
		
		size--;
		// if remove the last one, then change tail
		if(index == size) {
			tail = prev;
		}
		
		return result;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	public void removeByValue(E e) {
		if(isEmpty()) {
			throw new IllegalStateException("It is empty, nothing to remove!");
		}
		
		Node<E> prev = dummyHead;
		while(prev.next != null) {
			if(Objects.equals(prev.next.value, e)) {
				Node<E> target = prev.next;
				prev.next = target.next;
				target.next = null;
				size--;
			} else {
				prev = prev.next;
			}
		}
	}
	
	public E getTail() {
		return null == tail ? null : tail.value;
	}
	
	public E getByValue(E e) {
		if(isEmpty()) {
			throw new IllegalStateException("It is empty, nothing to remove!");
		}
		
		Node<E> prev = dummyHead;
		while(prev.next != null) {
			if(Objects.equals(prev.next.value, e)) {
				return prev.next.value;
			} else {
				prev = prev.next;
			}
		}
		return null;
	}
}
