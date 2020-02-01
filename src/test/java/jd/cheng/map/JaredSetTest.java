package jd.cheng.map;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

import jd.cheng.map.JaredLinkedListSet;
import jd.cheng.map.JaredTreeSet;

public class JaredSetTest {

	@Test
	public void testJaredTreeSet() throws Exception {
		JaredTreeSet<Double> tSet = new JaredTreeSet<>();
		
		tSet.add(10.8);
		tSet.add(10.8);
		tSet.add(10.8);
		tSet.add(20.8);
		tSet.add(20.8);
		tSet.add(0.99);
		tSet.add(0.99);
		
		assertThat(tSet.size()).isEqualTo(3);
		assertThat(tSet.contains(20.8)).isTrue();
		tSet.remove(20.8);
		assertThat(tSet.contains(20.8)).isFalse();
		assertThat(tSet.size()).isEqualTo(2);
	}
	
	@Test
	public void testJaredLinkedListSet() throws Exception {
		JaredLinkedListSet<Double> lSet = new JaredLinkedListSet<>();
		
		lSet.add(10.8);
		lSet.add(10.8);
		lSet.add(10.8);
		lSet.add(20.8);
		lSet.add(20.8);
		lSet.add(0.99);
		lSet.add(0.99);
		
		assertThat(lSet.size()).isEqualTo(3);
		assertThat(lSet.contains(20.8)).isTrue();
		lSet.remove(20.8);
		assertThat(lSet.contains(20.8)).isFalse();
		assertThat(lSet.size()).isEqualTo(2);
	}
	
	@Test
	public void testPerformance() throws Exception {
		JaredLinkedListSet<Integer> lSet = new JaredLinkedListSet<>();
		JaredTreeSet<Integer> tSet = new JaredTreeSet<>();
		
		Stopwatch sw = Stopwatch.createStarted();
		for(int i=0; i<10000; i++) {
			tSet.add(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
		}
		System.out.println("JaredTreeSet add 10000, takes " + sw.stop().elapsed(TimeUnit.MICROSECONDS) + " microseconds");
		
		sw.reset().start();
		for(int i=0; i<10000; i++) {
			lSet.add(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
		}
		System.out.println("JaredLinkedListSet add 10000, takes " + sw.stop().elapsed(TimeUnit.MICROSECONDS) + " microseconds");
		
		Integer target = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
		tSet.add(target);
		lSet.add(target);
		
		sw.reset().start();
		tSet.remove(target);
		System.out.println("JaredTreeSet remove one element, takes " + sw.stop().elapsed(TimeUnit.MICROSECONDS) + " microseconds");
		
		sw.reset().start();
		lSet.remove(target);
		System.out.println("JaredLinkedListSet remove one element, takes " + sw.stop().elapsed(TimeUnit.MICROSECONDS) + " microseconds");
	}
}
