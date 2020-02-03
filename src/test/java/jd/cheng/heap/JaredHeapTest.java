package jd.cheng.heap;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class JaredHeapTest {

	@Test
	public void testJaredMaxHeap() throws Exception {
		JaredMaxHeap heap = new JaredMaxHeap();
		
		assertThat(heap).extracting(JaredMaxHeap::size, JaredMaxHeap::isEmpty)
			.containsExactly(0, true);
		
		heap.add(61).add(32).add(45).add(88).print();
		assertThat(heap.size()).isEqualTo(4);
		
		assertThat(heap.extract()).isEqualTo(88);
		assertThat(heap.size()).isEqualTo(3);
		heap.print();
		
		assertThat(heap.replace(3)).isEqualTo(61);
		assertThat(heap.size()).isEqualTo(3);
		heap.print();
	}
	
	@Test
	public void testHeapOrdering() throws Exception {
		JaredMaxHeap heap = new JaredMaxHeap();
		
		Stopwatch sw = Stopwatch.createStarted();
		for(int i = 100000; i > 0; i--) {
			heap.add(ThreadLocalRandom.current().nextInt());
		}
		System.out.println("add 100000 costs: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
		
		// convert to array
		int[] a = new int[heap.size()];
		for(int i=a.length-1; i>=0; i--) {
			a[i] = heap.extract();
		}
		heap = null;
		
		// check
		for(int i=a.length-1; i>0; i--) {
			if(a[i] < a[i-1]) {
				throw new IllegalStateException("fail");
			}
		}
	}
	
	@Test
	public void testHeapify() throws Exception {
		int[] input = new int[100000];
		
		for(int i=0; i<input.length; i++) {
			input[i] = ThreadLocalRandom.current().nextInt();
		}
		
		Stopwatch sw = Stopwatch.createStarted();
		JaredMaxHeap heap = JaredMaxHeap.heapify(input);
		System.out.println("heapify 100000 costs: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");
		
		assertThat(heap.size()).isEqualTo(input.length);
		
		// convert to array
		int[] a = new int[heap.size()];
		for(int i=a.length-1; i>=0; i--) {
			a[i] = heap.extract();
		}
		heap = null;
		
		// check
		for(int i=a.length-1; i>0; i--) {
			if(a[i] < a[i-1]) {
				throw new IllegalStateException("fail");
			}
		}
	}
}
