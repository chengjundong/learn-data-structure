package jd.cheng.leetcode.algorithm;

public class Solution28 {

	public int strStr(String haystack, String needle) {
		return this.indexOf(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }
	
	private int indexOf(char[] source, int sourceCount, char[] target, int targetCount) {
        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Solution28 s = new Solution28();
		System.out.println(s.strStr("aaaaa", "bba"));
	}
}
