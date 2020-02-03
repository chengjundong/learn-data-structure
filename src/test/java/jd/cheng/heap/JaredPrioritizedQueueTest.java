package jd.cheng.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredPrioritizedQueueTest {

	@Test
	public void test() throws Exception {
		JaredPrioritizedQueue q = new JaredPrioritizedQueue();
		
		assertThat(q.size()).isEqualTo(0);
		
		q.enqueue(100).enqueue(80).enqueue(120).enqueue(70).enqueue(0).enqueue(150).enqueue(75);
		assertThat(q.size()).isEqualTo(7);
		assertThat(q.getFront()).isEqualTo(150);
	}
}
