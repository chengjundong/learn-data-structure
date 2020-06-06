package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/">拥有最多糖果的孩子</a>
 */
public class Solution1431 {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();

    // get the max
    int max = 0;
    for(int c : candies) {
      if(c > max) max = c;
    }

    if(extraCandies >= max) {
      for(int c : candies) {
        result.add(true);
      }
    } else {
      for(int c : candies) {
        result.add(max - c <= extraCandies);
      }
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.kidsWithCandies(new int[]{2,3,5,1,3}, 3)).containsExactly(true,true,true,false,true);
  }

}
