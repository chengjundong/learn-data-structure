package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/">link1</a>
 * @see <a href="https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/">link2</a>
 */
public class Solution57 {

  public int[] twoSum(int[] nums, int target) {
    for(int i=0, j=nums.length-1; i<j; ) {
      if(nums[i] + nums[j] == target) {
        return new int[]{nums[i],nums[j]};
      } else if(nums[i] + nums[j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return null;
  }

  public int[][] findContinuousSequence(int target) {
    List<int[]> list = new ArrayList<>();

    for(int l=1,r=2; r<target;) {
      int sum = (l+r)*(r-l+1)/2;
      if(sum == target) {
        int[] arr = new int[r-l+1];
        for(int i=l, j=0; i<=r; i++, j++) {
          arr[j] = i;
        }
        list.add(arr);
        l++;
      } else if(sum > target) {
        l++;
      } else if(sum < target) {
        r++;
      }
    }

    int[][] result = new int[list.size()][];
    int i = 0;
    for(int[] arr : list) {
      result[i] = arr;
      i++;
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.twoSum(new int[]{1,6,10,15,19}, 20)).containsExactlyInAnyOrder(1,19);
    assertThat(this.twoSum(new int[]{2,7,11,15}, 9)).containsExactlyInAnyOrder(2,7);

    int[][] result = this.findContinuousSequence(9);
    assertThat(result[0]).containsExactly(2,3,4);
    assertThat(result[1]).containsExactly(4,5);
  }
}
