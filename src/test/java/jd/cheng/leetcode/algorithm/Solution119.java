package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">Pascals-Triangle-2</a>
 */
public class Solution119 {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>(1);
    result.add(1);

    if(0 == rowIndex) {
      return result;
    }

    for(int i=1; i <= rowIndex; i++) {
      result = _generate(result);
    }

    return result;
  }

  public List<Integer> _generate(List<Integer> above) {
    List<Integer> result = new ArrayList<>(above.size()+1);

    // add the 1st
    result.add(above.get(0));

    // add the elements in mid
    for (int i=1; i < above.size(); i++) {
      result.add(above.get(i-1) + above.get(i));
    }

    // add the last one
    result.add(above.get(above.size()-1));

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(getRow(0)).containsExactly(1);
    assertThat(getRow(3)).containsExactly(1,3,3,1);
    assertThat(getRow(4)).containsExactly(1,4,6,4,1);
  }
}
