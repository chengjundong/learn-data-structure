package jd.cheng.array;

import java.util.StringJoiner;

public class JaredArray {

	private int size;
	private int[] data;
	
	public JaredArray(int capacity) {
		this.size = 0;
		data = new int[capacity];
	}
	
	/**
	 * default capacity is 10
	 */
	public JaredArray() {
		this(10);
	}

	public boolean isEmpty() {
		return 0 == this.size;
	}
	
	public int size() {
		return this.size;
	}
	
	public int showCapacity() {
		return this.data.length;
	}
	
	public int get(int index) {
		if(0 > index || size <= index) {
			throw new IllegalArgumentException("input index is invalid");
		} else {			
			return this.data[index];
		}
	}
	
	public void set(int index, int element) {
		if(0 > index || size <= index) {
			throw new IllegalArgumentException("input index is invalid");
		} else {			
			this.data[index] = element;
		}
	}
	
	public void addLast(int element) {
		this.add(size, element);
	}
	
	public void addFirst(int element) {
		this.add(0, element);
	}
	
	public void add(int index, int element) {
		if(0 > index || size < index) {
			throw new IllegalArgumentException("invalid index");
		}
		
		// once array is full, then enlarge it at first
		if(this.size == data.length) {
			resize(this.data.length * 2);
		}
		
		// move existing data
		for(int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		
		data[index] = element;
		size++;
	}
	
	/**
	 * @param newCapacity -- capacity of resized array
	 */
	private void resize(int newCapacity) {
		// new array has double capacity
		int[] newData = new int[newCapacity];
		
		// copy elements
		for(int i = size-1; i >=0; i--) {
			newData[i] = data[i];
		}
		
		// change reference
		this.data = newData;
	}
	
	public int remove(int index) {
		// check size
		if(isEmpty()) {
			throw new IllegalArgumentException("fail to remove because array is empty!");
		}
		
		// check index
		if(index < 0 || index >= size-1) {
			throw new IllegalArgumentException("invalid index");
		}
		
		int result = data[index];
		
		// move existing data
		for(int i = index+1; i < size; i++) {
			data[i-1] = data[i];
		}
		
		// remove
		size--;
		
		// if size is less then half of capacity, then shrink it
		if(size == data.length/2) {
			resize(data.length/2);
		}
		
		return result;
	}
	
	public int removeFirst() {
		return this.remove(0);
	}
	
	public int removeLast() {
		return this.remove(size-1);
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",");
		for(int i=0; i<size; i++) {
			sj.add(String.valueOf(data[i]));
		}
		return new StringBuffer().append('[').append(sj.toString()).append(']').toString();
	}
}
