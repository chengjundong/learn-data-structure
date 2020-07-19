package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">link</a>
 */
public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] arr = new int[nums.length];

        for(int num : nums) {
            arr[num-1]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) result.add(i+1);
        }

        return result;
    }

    @Test
    public void test() throws Exception {
        assertThat(this.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})).containsExactlyInAnyOrder(5,6);
    }
}
