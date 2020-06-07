package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">link</a>
 */
public class Solution29 {

  public int[] spiralOrder(int[][] matrix) {
    if(null == matrix || matrix.length == 0) return new int[0];

    int high = matrix.length;
    int length = matrix[0].length;
    int[] result = new int[high * length];

    Map<Tuple2, Integer> map = new HashMap<>();
    for(int i=0; i<high; i++) {
      for(int j=0; j<length; j++) {
        map.put(Tuple2.of(i,j), matrix[i][j]);
      }
    }

    recur(map, 0, high-1, 0, length-1, result, 0);

    return result;
  }

  private void recur(Map<Tuple2, Integer> map, int startRow, int endRow,
      int startCol, int endCol, int[] output, int index) {
    if(startRow > endRow || startCol > endCol) return;

    if(startRow == endRow && startCol == endCol) {
      output[index] = map.get(Tuple2.of(startRow, startCol));
      return;
    }

    // top at startRow, startCol -> endCol-1
    for(int i = startCol; i<endCol; i++) {
      output[index++] = map.get(Tuple2.of(startRow, i));
    }

    // right at endCol, startRow -> endRow-1
    for(int i = startRow; i < endRow; i++) {
      output[index++] = map.get(Tuple2.of(i, endCol));
    }

    // bottom at endRow, endCol -> startCol-1
    if(startRow == endRow) {
      output[index++] = map.get(Tuple2.of(endRow, endCol));
    } else {
      for(int i = endCol; i > startCol; i--) {
        output[index++] = map.get(Tuple2.of(endRow, i));
      }
    }

    // left at startCol, endRow -> startRow-1
    if(startCol == endCol) {
      output[index++] = map.get(Tuple2.of(endRow, startCol));
    } else {
      for(int i = endRow; i > startRow; i--) {
        output[index++] = map.get(Tuple2.of(i, startCol));
      }
    }

    recur(map, startRow+1, endRow-1, startCol+1, endCol-1, output, index);
  }

  private static class Tuple2 {
    int row;
    int col;

    Tuple2(int row, int col) {
      this.row = row;
      this.col = col;
    }

    static Tuple2 of(int row, int col) {
      return new Tuple2(row, col);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Tuple2 tuple2 = (Tuple2) o;
      return row == tuple2.row &&
          col == tuple2.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }

  @Test
  public void test() throws Exception {
    int[][] input = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12}
    };

    assertThat(this.spiralOrder(input)).containsExactly(1,2,3,4,8,12,11,10,9,5,6,7);

    input = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9},
    };
    assertThat(this.spiralOrder(input)).containsExactly(1,2,3,6,9,8,7,4,5);

    assertThat(this.spiralOrder(new int[][]{{1,2,3}})).containsExactly(1,2,3);
    assertThat(this.spiralOrder(new int[][]{{1},{2},{3}})).containsExactly(1,2,3);
  }
}
