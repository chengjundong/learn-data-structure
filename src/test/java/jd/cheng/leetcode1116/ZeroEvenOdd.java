package jd.cheng.leetcode1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	private int n;
	
	private boolean isZero;
	private int current;

	public ZeroEvenOdd(int n) {
		this.n = n;
		this.isZero = true;
		this.current = 1;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		while(current <= n) {
			synchronized (this) {
				if(isZero) {
					printNumber.accept(0);
					isZero = false;
				}
				
				this.notifyAll();
				wait();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		while(current <= n) {
			synchronized (this) {
				if(!isZero && current % 2 == 0) {
					printNumber.accept(current++);
					isZero = true;
					
					if(current > n) {
						this.notifyAll();
						break;
					}
				}
				
				this.notifyAll();
				wait();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		while(current <= n) {
			synchronized (this) {
				if(!isZero && current % 2 == 1) {
					printNumber.accept(current++);
					isZero = true;
					
					if(current > n) {
						this.notifyAll();
						break;
					}
				}
				
				this.notifyAll();
				wait();
			}
		}
	}
	
	public static void main(String[] args) {
		final ZeroEvenOdd z = new ZeroEvenOdd(5);
		
		new Thread(() -> {
			try {
				z.zero(x -> System.out.println(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},  "zero").start();
		new Thread(() -> {
			try {
				z.even(x -> System.out.println(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "even").start();
		new Thread(() -> {
			try {
				z.odd(x -> System.out.println(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "odd").start();
	}
}
