package jd.cheng.leetcode.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Solution1195 {

	// Initialize the permit, limit to one.
    private Semaphore sema = new Semaphore(1);
    
    // The current number.
    private int curNum = 1;
    
    private int n;

    public Solution1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;) {
            // Acquire the permit, try to run the logic exclusively.
            this.sema.acquire(1);
            
            try {
                if (this.curNum > n) {
                    return;    
                }
                
                if ((this.curNum % 3 == 0) && (this.curNum % 5 != 0)) {
                    printFizz.run();    
                    this.curNum++;
                }
            } finally {
                // Release the permit anyway.
                this.sema.release(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;) {            
            this.sema.acquire(1);
                
            try {
                if (this.curNum > n) {
                    return;
                }
                
                if ((this.curNum % 3 != 0) && (this.curNum % 5 == 0)) {
                    printBuzz.run();
                    this.curNum++;
                }    
            } finally {
                this.sema.release(1);
            }   
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);
                
            try {
                if (this.curNum > n) {
                    return;
                }
                
                if ((this.curNum % 3 == 0) && (this.curNum % 5 == 0)) {
                    printFizzBuzz.run();    
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;) {
            this.sema.acquire(1);
        
            try {
                if (this.curNum > n) {
                    return;
                }
                
                if ((this.curNum % 3 != 0) && (this.curNum % 5 != 0)) {
                    printNumber.accept(this.curNum);  
                    this.curNum++;
                }
            } finally {
                this.sema.release(1);
            }
        }
    }
    
    public static void main(String[] args) {
    	Solution1195 fb = new Solution1195(15);
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.submit(() -> {
			try {
				fb.fizz(() -> System.out.println("fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		es.submit(() -> {
			try {
				fb.buzz(() -> System.out.println("buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		es.submit(() -> {
			try {
				fb.fizzbuzz(() -> System.out.println("fizzbuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		es.submit(() -> {
			try {
				fb.number(n -> System.out.println(n));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		es.shutdown();
	}
}
