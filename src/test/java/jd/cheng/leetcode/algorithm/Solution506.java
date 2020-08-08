package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/relative-ranks/">link</a>
 */
public class Solution506 {

    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];

        List<Tuple> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            list.add(new Tuple(nums[i], i));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++) {
            String str = null;
            if(i == 0) str = "Gold Medal";
            else if(i == 1) str = "Silver Medal";
            else if(i == 2) str = "Bronze Medal";
            else str = String.valueOf(i+1);
            ans[list.get(i).index] = str;
        }

        return ans;
    }

    @Test
    public void test() throws Exception {
        int[] arr = new int[]{3,5,4,1,2};
        assertThat(this.findRelativeRanks(arr))
                .containsExactly("Bronze Medal", "Gold Medal", "Silver Medal", "5", "4");
    }

    private static class Tuple implements Comparable<Tuple> {

        private int value;
        private int index;

        public Tuple (int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Tuple t) {
            return t.value - this.value;
        }
    }
}
