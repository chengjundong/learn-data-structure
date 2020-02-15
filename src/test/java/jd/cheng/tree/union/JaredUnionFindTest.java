package jd.cheng.tree.union;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class JaredUnionFindTest {

	@Test
	public void testQuickFind() throws Exception {
		JaredQuickFind quickFind = new JaredQuickFind(10);
		
		assertThat(quickFind.size()).isEqualTo(10);
		assertThat(quickFind.isConnected(0, 8)).isFalse();
		quickFind.union(0, 8);
		assertThat(quickFind.isConnected(0, 8)).isTrue();
	}
	
	@Test
	public void testQuickUnion() throws Exception {
		JaredQuickUnion quickUnion = new JaredQuickUnion(10);
		
		assertThat(quickUnion.size()).isEqualTo(10);
		assertThat(quickUnion.isConnected(0, 8)).isFalse();
		quickUnion.union(0, 8);
		quickUnion.union(2, 0);
		quickUnion.union(2, 8);
		assertThat(quickUnion.isConnected(0, 8)).isTrue();
		assertThat(quickUnion.isConnected(2, 8)).isTrue();
		
	}
	
	@Test
	public void testPerformance() throws Exception {
		int limit = 100000;
		JaredQuickUnion quickUnion = new JaredQuickUnion(limit);
		
		Stopwatch sw = Stopwatch.createStarted();
		for(int i=0; i<limit; i++) {
			int a = ThreadLocalRandom.current().nextInt(limit);
			int b = ThreadLocalRandom.current().nextInt(limit);
			quickUnion.union(a, b);
		}
		
		for(int i=0; i<limit; i++) {
			int a = ThreadLocalRandom.current().nextInt(limit);
			int b = ThreadLocalRandom.current().nextInt(limit);
			quickUnion.isConnected(a, b);
		}
		
		// quick union spend after optimize by tree-depth: 123781
		// quick union spend before optimize by tree-depth: 13763063
		System.out.println("quick union spend: " + sw.stop().elapsed(TimeUnit.MICROSECONDS));
	}
	
	
}
