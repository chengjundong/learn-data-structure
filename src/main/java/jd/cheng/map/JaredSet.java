package jd.cheng.map;

public interface JaredSet<E> {

	void add(E e);
	void remove(E e);
	boolean contains(E e);
	int size();
	boolean isEmpty();
}
