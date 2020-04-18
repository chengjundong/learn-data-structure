package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see https://leetcode-cn.com/problems/add-binary/
 *
 */
public class Solution67 {

	public String addBinary(String a, String b) {
		
		int size = a.length() > b.length() ? a.length() : b.length();
		
		char[] c = new char[size];
		
		int m = 0;
		for(int i = a.length()-1, j=b.length()-1, n = size-1; n >= 0; i--, j--, n--) {
			int _a = i >= 0 ? (int)a.charAt(i) - 48 : 0;
			int _b = j >= 0 ? (int)b.charAt(j) - 48 : 0;
			
			int x = _a + _b + m;
			m = 0;
			
			if(0 == x) {
				c[n] = '0';
			} else if(1 == x) {
				c[n] = '1';
			} else if(2 == x) {
				c[n] = '0';
				m = 1;
			} else {
				c[n] = '1';
				m = 1;
			}
		}
		
		if(0 == m) {
			return new String(c);
		} else {
			return "1" + new String(c);
		}
    }
	
	@Test
	public void test() throws Exception {
		assertThat(this.addBinary("11", "1")).isEqualTo("100");
		assertThat(this.addBinary("1010", "1011")).isEqualTo("10101");
	}
}
