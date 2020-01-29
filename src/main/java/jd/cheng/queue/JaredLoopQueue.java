package jd.cheng.queue;

import java.util.StringJoiner;

public class JaredLoopQueue implements JaredQueue {

	private int[] data;
	private int size = 0;
	private int pFront = 0;
	private int pTail = 0;
	
	public JaredLoopQueue() {
		this(10);
	}
	
	public JaredLoopQueue(int capacity) {
		data = new int[capacity+1];
	}

	@Override
	public JaredQueue enqueue(int e) {
		
		if((pTail + 1) % data.length == pFront) {
			this.resize(this.showCapacity() * 2);
		}
		
		data[pTail] = e;
		size++;
		pTail = (pTail + 1) % data.length;
		return this;
	}

	@Override
	public int dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("empty queue!");
		}
		
		int result = data[pFront];
		size--;
		pFront = (pFront + 1) % data.length;
		return result;
	}
	
	private void resize(int newCapacity) {
		int[] newData = new int[newCapacity + 1];
		for(int i=0; i<data.length; i++) {
			newData[i] = data[(i+pFront) % data.length];
		}
		// reset pointer
		pFront = 0;
		pTail = size;
		data = newData;
	}

	@Override
	public int getFront() {
		if(isEmpty()) {
			throw new IllegalStateException("empty queue!");
		}
		return data[pFront];
	}
	
	public int getTail() {
		if(isEmpty()) {
			throw new IllegalStateException("empty queue!");
		} else if(pTail == 0) {
			return data[data.length-1];
		} else {
			return data[pTail-1];
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int showCapacity() {
		return this.data.length - 1;
	}

	@Override
	public boolean isEmpty() {
		return pFront == pTail;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",");
		for(int i=pFront; i!=pTail; i=(i+1) % data.length) {
			sj.add(String.valueOf(data[i]));
		}
		return new StringBuffer().append('[').append(sj.toString()).append(']').toString();
	}
}
