package jd.cheng.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RecursionArraySumTest {

	@Parameters
	public static Object[][] data() {
		return new Object[][] {
			{new int[] {1,2,3}, 6},
			{new int[] {1,2,2}, 5},
			{new int[] {3,3,3,3,3,3,3}, 21},
			{new int[] {10}, 10},
			{new int[] {}, 0},
		};
	}
	
	@Parameter(0)
	public int[] input;
	
	@Parameter(1)
	public int expectation;
	
	@Test
	public void test() {
		assertThat(RecursionArraySum.sum(input)).isEqualTo(expectation);
	}
}
