package jd.cheng.array;

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
		if(this.size == data.length) {
			throw new IllegalArgumentException("fail to add because array is full!");
		}
		
		if(0 > index || size < index) {
			throw new IllegalArgumentException("invalid index");
		}
		
		// move existing data
		for(int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		
		data[index] = element;
		size++;
	}
	
	public int remove(int index) {
		// check size
		
		
		return 0;
	}
}
