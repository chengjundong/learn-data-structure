package jd.cheng.leetcode.algorithm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution1115 {

	private boolean isFoo = true;
	private int n;

    public Solution1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {
        
        for (int i = 0; i < n; i++) {
            
        	synchronized (this) {				
        		// printFoo.run() outputs "foo". Do not change or remove this line.
        		if(!isFoo) {        			
        			wait();
        		}
        		
        		printFoo.run();
    			isFoo = false;
    			this.notify();
			}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	synchronized (this) {
        		if(isFoo) {
        			wait();
        		}
        		
        		printBar.run(); 
    			isFoo = true;
    			this.notify();
			}
        }
    }
    
    public static void main(String[] args) {
    	final Solution1115 fooBar = new Solution1115(2);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(() -> {
			try {
				fooBar.foo(() -> System.out.println("foo"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executorService.submit(() -> {
			try {
				fooBar.bar(() -> System.out.println("bar"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();
	}
}
