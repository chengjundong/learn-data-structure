package jd.cheng.leetcode1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Foo {

	// 1st -> 2nd
	private CountDownLatch l1 = new CountDownLatch(1);
	
	// 2nd -> 3rd
	private CountDownLatch l2 = new CountDownLatch(1);
	
	public Foo() {
		
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		l1.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		l1.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		l2.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		l2.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
	
	public static void main(String[] args) {
		Foo f = new Foo();
		
//		Runnable r = new Runnable() {() -> System.out.println("")};
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		// 3rd
		pool.submit(() -> {
			try {
				f.third(() -> System.out.println("third"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		// 2nd
		pool.submit(() -> {
			try {
				f.second(() -> System.out.println("second"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		// 1st
		pool.submit(() -> {
			try {
				f.first(() -> System.out.println("first"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
