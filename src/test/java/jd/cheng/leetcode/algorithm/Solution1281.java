package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 */
public class Solution1281 {

	public int subtractProductAndSum(int n) {
		
		// get the length of number
		int _n = n;
		int length = 0;
		while(_n != 0) {
			_n /= 10;
			length++;
		}
		
		// multip all digits -> x
		// add all digits -> y
		// x minus y -> result
		
		int x = 1;
		int y = 0;
		
		for(int i=0; i < length; i++) {
			int m = (int) ((n / Math.pow(10, i)) % 10);
			x *= m;
			y += m;
		}
		
		return x - y;
    }
	
	@Test
	public void test() {
		assertThat(new Solution1281())
			.extracting(
					s -> s.subtractProductAndSum(234),
					s -> s.subtractProductAndSum(4421))
			.containsExactly(15, 21);
	}
}
