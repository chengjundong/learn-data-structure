package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/">link</a>
 */
public class Solution60 {
  public double[] twoSum(int n) {
    double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
    for(int i=2;i<=n;i++){
      double tmp[]=new double[5*i+1];
      for(int j=0;j<pre.length;j++)
        for(int x=0;x<6;x++)
          tmp[j+x]+=pre[j]/6;
      pre=tmp;
    }
    return pre;
  }

//  @Test
  public void test() throws Exception {
    assertThat(this.twoSum(2)).containsExactly(0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778);
  }
}
