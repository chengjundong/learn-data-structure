package jd.cheng.queue;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class JaredQueueTest {

	@Test
	public void test_arrayQueue() throws Exception {
		JaredArrayQueue queue = arrayQueue(6);
		System.out.println(queue);
		assertThat(queue).extracting(JaredArrayQueue::showCapacity, JaredQueue::size, JaredQueue::isEmpty)
				.containsExactly(6, 0, true);

		queue.enqueue(100).enqueue(200).enqueue(300).enqueue(400).enqueue(500);
		System.out.println(queue);

		assertThat(queue.dequeue()).isEqualTo(100);
		assertThat(queue.dequeue()).isEqualTo(200);
		assertThat(queue.getFront()).isEqualTo(300);
		assertThat(queue).extracting(JaredArrayQueue::showCapacity, JaredQueue::size, JaredQueue::isEmpty)
				.containsExactly(6, 3, false);

		System.out.println(queue);
	}
	
	@Test
	public void test_loopQueue() throws Exception {
		JaredLoopQueue q = loopQueue(4);
		q.enqueue(100).enqueue(200).enqueue(300);
		assertThat(q.dequeue()).isEqualTo(100);
		q.enqueue(400);
		assertThat(q.dequeue()).isEqualTo(200);
		assertThat(q.dequeue()).isEqualTo(300);
		q.enqueue(500);
		assertThat(q).extracting(JaredLoopQueue::getFront, JaredLoopQueue::getTail).containsExactly(400, 500);
		assertThat(q.size()).isEqualTo(2);
		System.out.println(q);
		// test resize
		q.enqueue(600).enqueue(700).enqueue(800);
		assertThat(q.dequeue()).isEqualTo(400);
		assertThat(q).extracting(JaredLoopQueue::getFront, JaredLoopQueue::getTail).containsExactly(500, 800);
		assertThat(q.showCapacity()).isEqualTo(8);
		System.out.println(q);
	}
	@Test
	public void test_OneHundredMillion_Dequeue() throws Exception {
		// array queue
		// init queue with size = Integer.MAX to avoid resize
		int oneHundredMillion = 100000000;
		JaredQueue queue = arrayQueue(oneHundredMillion);
		for(int i=0; i<oneHundredMillion; i++) {
			queue.enqueue(i);
		}
		
		Stopwatch sw = Stopwatch.createStarted();
		queue.dequeue();
		System.out.println("microsecond spent on array dequeue once: " + sw.stop().elapsed(TimeUnit.MICROSECONDS));
		// try to trigger gc & wait 1s
		queue = null;
		System.gc();
		TimeUnit.SECONDS.sleep(1);
		// loop queue
		queue = loopQueue(oneHundredMillion);
		for(int i=0; i<oneHundredMillion; i++) {
			queue.enqueue(i);
		}
		sw.reset().start();
		queue.dequeue();
		System.out.println("microsecond spent on loop dequeue once: " + sw.stop().elapsed(TimeUnit.MICROSECONDS));
	}
	
	private JaredArrayQueue arrayQueue(int capacity) {
		return new JaredArrayQueue(capacity);
	}
	
	private JaredLoopQueue loopQueue(int capacity) {
		return new JaredLoopQueue(capacity);
	}
}
