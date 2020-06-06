package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/">link</a>
 */
public class Solution39 {

  public int majorityElement(int[] nums) {
    int x = 0, votes = 0;
    for(int num : nums){
      if(votes == 0) x = num;
      votes += num == x ? 1 : -1;
    }
    return x;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2})).isEqualTo(2);
    assertThat(this.majorityElement(new int[]{47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27})).isEqualTo(47);
  }
}
