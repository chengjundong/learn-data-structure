package jd.cheng.linkedlist;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredLinkedListQueueTest {

	@Test
	public void test() throws Exception {
		JaredLinkedListQueue queue = new JaredLinkedListQueue();
		
		assertThat(queue)
			.extracting(JaredLinkedListQueue::size, JaredLinkedListQueue::isEmpty)
			.containsExactly(0, true);
		
		queue.enqueue(10).enqueue(20).enqueue(30);
		assertThat(queue)
			.extracting(JaredLinkedListQueue::size, 
					JaredLinkedListQueue::isEmpty, 
					JaredLinkedListQueue::getFront)
			.containsExactly(3, false, 10);
		// 10 -> 20 -> 30
		queue.print();
		
		assertThat(queue.dequeue()).isEqualTo(10);
		queue.enqueue(40);
		assertThat(queue)
			.extracting(JaredLinkedListQueue::size, 
					JaredLinkedListQueue::isEmpty, 
					JaredLinkedListQueue::getFront)
			.containsExactly(3, false, 20);
		// 20 -> 30 -> 40
		queue.print();
	}
}
