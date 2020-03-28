package jd.cheng.leetcode1342;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Solution {

	public int numberOfSteps (int num) {
		
		int steps = 0;
		while(num != 0) {
			if(num % 2 == 0) {
				num /= 2;
			} else {
				num -=1;
			}
			steps++;
		}
		
		return steps;
    }
	
	@Test
	public void test() {
		assertThat(numberOfSteps(14)).isEqualTo(6);
		assertThat(numberOfSteps(8)).isEqualTo(4);
		assertThat(numberOfSteps(123)).isEqualTo(12);
	}
}
