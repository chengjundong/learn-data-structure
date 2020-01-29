package jd.cheng.stack;

import java.util.StringJoiner;

import jd.cheng.array.JaredArray;

public class JaredArrayStack implements Stack {

	private JaredArray array;
	
	public JaredArrayStack() {
		this.array = new JaredArray();
	}
	
	public JaredArrayStack(int capacity) {
		this.array = new JaredArray(capacity);
	}
	
	@Override
	public int size() {
		return this.array.size();
	}

	@Override
	public boolean isEmpty() {
		return this.array.isEmpty();
	}

	@Override
	public void push(int e) {
		this.array.addLast(e);
	}

	@Override
	public int pop() {
		return this.array.removeLast();
	}

	@Override
	public int peek() {
		return this.array.getLast();
	}
	
	public int showCapacity() {
		return this.array.showCapacity();
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",");
		for(int i=array.size()-1; i>=0; i--) {
			sj.add(String.valueOf(this.array.get(i)));
		}
		return new StringBuffer().append('[').append(sj.toString()).append(']').toString();
	}
}
