package jd.cheng.sort;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class JaredSortTest {
	
	private static final int ARRAY_COUNT = 100;
	private static final int NUMBER_PER_ARRAY = 5000;
	
	@Test
	public void testSort() {
		// init assertion
		assertThat(new int[] {1,2,3}).isSorted();
		// do test
		this.test(new JaredInsertionSort(), true);
		this.test(new JaredMergeSort(), true);
		this.test(new JaredQuickSort(), true);
	}
	
	/**
	 * To generate 10 test data, each one has 100 numbers generated randomly.
	 * We are able to sort the test data at first, it is used to test the algorithm when the data is already sorted  
	 * Then, sort them and check the result.
	 * 
	 * @param target
	 * @param isSorted -- the test data is sorted or not
	 */
	private void test(JaredSort target, boolean isSorted) {
		// generate test data
		int[][] data = new int[ARRAY_COUNT][NUMBER_PER_ARRAY];
		
		for(int i=0; i<ARRAY_COUNT; i++) {
			for(int j=0; j<NUMBER_PER_ARRAY; j++) {
				data[i][j] = ThreadLocalRandom.current().nextInt();
			}
			if(isSorted) {
				Arrays.sort(data[i]);
			}
		}
		
		// do sort
		Stopwatch sw = Stopwatch.createStarted();
		for(int i=0; i<ARRAY_COUNT; i++) {
			assertThat(target.sort(data[i])).isSorted();
		}
		System.out.println(target.getClass().getSimpleName() + " " 
				+ target.getClass().getAnnotation(TimeComplexity.class).value() 
				+ " costs " + sw.stop().elapsed(TimeUnit.MILLISECONDS) + " ms");
		
		data = null;
	}
}
