package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/fizz-buzz/">link</a>
 */
public class Solution412 {

  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>(n);
    for(int i=1; i<=n; i++) {
      String str = "";
      if(i % 3 == 0) {
        str += "Fizz";
      }
      if(i % 5 == 0) {
        str += "Buzz";
      }
      if(str.isEmpty()) {
        str = String.valueOf(i);
      }
      list.add(str);
    }
    return list;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.fizzBuzz(15)).containsExactly(
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz");
  }
}
