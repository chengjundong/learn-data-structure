package jd.cheng.leetcode.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jucheng
 * @link <a href="https://leetcode-cn.com/problems/the-dining-philosophers/">link</a>
 */
public class Solution1226 {


}

class DiningPhilosophers {

  // only allow 4 philosophers to grab the fork
  private final Semaphore eatLimit = new Semaphore(4);

  // lock of fork
  private final ReentrantLock[] forks = new ReentrantLock[5];

  public DiningPhilosophers() {
    forks[0] = new ReentrantLock();
    forks[1] = new ReentrantLock();
    forks[2] = new ReentrantLock();
    forks[3] = new ReentrantLock();
    forks[4] = new ReentrantLock();
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putLeftFork,
      Runnable putRightFork) throws InterruptedException {

    int leftFork = (philosopher+1)%5;
    int rightFork = philosopher;

    // 1, acquire the right
    eatLimit.acquire();

    // 2, try lock fork
    forks[leftFork].lock();
    forks[rightFork].lock();

    // 3. pick lock
    pickLeftFork.run();
    pickRightFork.run();

    // 4. eat
    eat.run();

    // 5. put lock
    putLeftFork.run();
    putRightFork.run();

    // 6. release lock
    forks[leftFork].unlock();
    forks[rightFork].unlock();

    // 7. increase the limit
    eatLimit.release();
  }
}
