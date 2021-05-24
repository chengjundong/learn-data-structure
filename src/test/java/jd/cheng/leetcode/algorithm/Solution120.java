package jd.cheng.leetcode.algorithm;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Objects;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/triangle/">triangle</a>
 */
public class Solution120 {

  /**
   * use Key120 to present a combination of row + column and it can be used to point to a triangle
   * store each triangle's min total as the value
   */
  private Map<Key120, Integer> minTotalOfEachTriangle = new HashMap<>();

  public int minimumTotal(List<List<Integer>> triangle) {

    int countOfRow = triangle.size();

    // put the last row elements into map
    List<Integer> lastRow = triangle.get(countOfRow - 1);
    for (int y = 0; y < lastRow.size(); y++) {
      minTotalOfEachTriangle.put(new Key120(countOfRow - 1, y), lastRow.get(y));
    }

    // start from the row before the last row
    for (int x = countOfRow - 2; x >= 0; x--) {
      List<Integer> rowOfElements = triangle.get(x);
      for (int y = 0; y < rowOfElements.size(); y++) {
        Key120 k = new Key120(x, y);
        int result = rowOfElements.get(y)
            + Math.min(minTotalOfEachTriangle.get(new Key120(x+1,y)), minTotalOfEachTriangle.get(new Key120(x+1,y+1)));
        minTotalOfEachTriangle.put(k, result);
      }
    }

    return minTotalOfEachTriangle.get(new Key120(0,0));
  }

  private static class Key120 {

    private final int row;
    private final int col;

    public Key120(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Key120 key120 = (Key120) o;
      return row == key120.row &&
          col == key120.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }

  @Test
  public void test() {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>() {
      {
        add(ImmutableList.of(2));
        add(ImmutableList.of(3, 4));
        add(ImmutableList.of(6, 5, 7));
        add(ImmutableList.of(4, 1, 8, 3));
      }
    };

    assertThat(this.minimumTotal(triangle)).isEqualTo(11);

    triangle = new ArrayList<List<Integer>>() {
      {
        add(ImmutableList.of(2));
      }
    };

    assertThat(this.minimumTotal(triangle)).isEqualTo(2);

    triangle = new ArrayList<List<Integer>>() {
      {
        add(ImmutableList.of(2));
        add(ImmutableList.of(3, 4));
        add(ImmutableList.of(6, 5, 1));
        add(ImmutableList.of(4, 1, 8, 1));
      }
    };

    assertThat(this.minimumTotal(triangle)).isEqualTo(8);
  }
}
