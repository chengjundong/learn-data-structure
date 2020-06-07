package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">link</a>
 */
public class Solution53 {

  public int search(int[] nums, int target) {
    if(null == nums || 0 == nums.length) return 0;

    int count = 0;
    int mid = nums[nums.length/2];
    if(mid > target) {
      for(int i=0; i<nums.length/2; i++) {
        if(target == nums[i]) count++;
      }
    } else if(mid < target) {
      for(int i=nums.length/2; i<nums.length; i++) {
        if(target == nums[i]) count++;
      }
    } else {
      for(int i=0; i<nums.length; i++) {
        if(target == nums[i]) count++;
      }
    }

    return count;
  }

  public int missingNumber(int[] nums) {
    if(null == nums || 0 == nums.length) return 0;

    int n = nums.length+1;
    int sum = n*(n-1)/2;

    for (int num : nums) {
      sum -= num;
    }

    return sum;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.search(new int[]{5,7,7,8,8,10}, 8)).isEqualTo(2);
    assertThat(this.search(new int[]{5,7,7,8,8,10}, 7)).isEqualTo(2);
    assertThat(this.search(new int[]{5,7,7,8,8,10}, 10)).isEqualTo(1);
    assertThat(this.search(new int[]{5,7,7,8,8,10}, 6)).isEqualTo(0);
    assertThat(this.search(new int[]{}, 8)).isEqualTo(0);

    assertThat(this.missingNumber(new int[]{0,1,3})).isEqualTo(2);
    assertThat(this.missingNumber(new int[]{0,1,2,3,4,5,6,7,9})).isEqualTo(8);
  }
}
