package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle/">Pascals Triangle</a>
 */
public class Solution118 {

  public List<List<Integer>> generate(int numRows) {
    if(numRows < 1) {
      return new ArrayList<>(1);
    }

    List<List<Integer>> result = new ArrayList<>(numRows);

    // top level
    List<Integer> top = new ArrayList<>(1);
    top.add(1);
    result.add(top);

    // generate the other floors
    for(int i=1; i < numRows; i++) {
      List<Integer> above = result.get(i - 1);
      List<Integer> current = _generate(above);
      result.add(current);
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
    assertThat(generate(1)).hasSize(1)
        .extracting(l -> l.get(0))
        .containsExactly(1);

    List<List<Integer>> l2 = generate(2);
    assertThat(l2).hasSize(2);
    assertThat(l2.get(0)).containsExactly(1);
    assertThat(l2.get(1)).containsExactly(1, 1);

    List<List<Integer>> l3 = generate(3);
    assertThat(l3).hasSize(3);
    assertThat(l3.get(0)).containsExactly(1);
    assertThat(l3.get(1)).containsExactly(1, 1);
    assertThat(l3.get(2)).containsExactly(1, 2, 1);

    List<List<Integer>> l5 = generate(5);
    assertThat(l5).hasSize(5);
    assertThat(l5.get(0)).containsExactly(1);
    assertThat(l5.get(1)).containsExactly(1, 1);
    assertThat(l5.get(2)).containsExactly(1, 2, 1);
    assertThat(l5.get(3)).containsExactly(1,3,3,1);
    assertThat(l5.get(4)).containsExactly(1,4,6,4,1);
  }
}
