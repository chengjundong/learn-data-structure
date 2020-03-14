package jd.cheng.leetcode13;

import static org.junit.Assert.assertEquals;

import java.util.EnumMap;
import java.util.EnumSet;

import org.junit.Test;

public class Solution {
	
	private static enum RomanMapping {
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);
		
		private final int value;

		private RomanMapping(int value) {
			this.value = value;
		}
		
		public int sub(RomanMapping r) {
			return this.value - r.value;
		}
	}
	
	private static final EnumMap<RomanMapping, EnumSet<RomanMapping>> PENDING_ALLOWED = new EnumMap<>(RomanMapping.class);
	
	static {
		PENDING_ALLOWED.put(RomanMapping.I, EnumSet.of(RomanMapping.V, RomanMapping.X));
		PENDING_ALLOWED.put(RomanMapping.X, EnumSet.of(RomanMapping.L, RomanMapping.C));
		PENDING_ALLOWED.put(RomanMapping.C, EnumSet.of(RomanMapping.D, RomanMapping.M));
	}

	public int romanToInt(String s) {

		if (null == s || "".equals(s.trim())) {
			return 0;
		}

		int result = 0;
		RomanMapping pending = null;
		
		for (char c : s.toCharArray()) {
			// convert to enum
			RomanMapping r = RomanMapping.valueOf(String.valueOf(c));
			
			// it has pending number to be processed
			if(pending == null) {
				if(PENDING_ALLOWED.containsKey(r)) {
					// put it to pending
					pending = r;
				} else {
					// directly accumulate
					result += r.value;
				}
			} else {
				if(PENDING_ALLOWED.get(pending).contains(r)) {
					result += r.sub(pending);
					pending = null;
				} else {
					result += pending.value;
					pending = null;
					if(PENDING_ALLOWED.containsKey(r)) {
						pending = r;
					} else {
						result += r.value;
					}
				}
			}
		}
		
		if(pending != null) {
			result += pending.value;
		}

		return result;
	}

	@Test
	public void test() {
		Solution s = new Solution();

		assertEquals(3, s.romanToInt("III"));
		assertEquals(4, s.romanToInt("IV"));
		assertEquals(9, s.romanToInt("IX"));
		assertEquals(27, s.romanToInt("XXVII"));
		assertEquals(58, s.romanToInt("LVIII"));
		assertEquals(1994, s.romanToInt("MCMXCIV"));
		assertEquals(1884, s.romanToInt("MDCCCLXXXIV"));
	}
}
