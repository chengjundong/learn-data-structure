package jd.cheng.queue;

public interface JaredQueue {

	JaredQueue enqueue(int e);
	int dequeue();
	int getFront();
	int size();
	int showCapacity();
	boolean isEmpty();
}
