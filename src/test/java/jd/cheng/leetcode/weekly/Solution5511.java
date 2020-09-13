package jd.cheng.leetcode.weekly;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-206/problems/special-positions-in-a-binary-matrix/">link</a>
 */
public class Solution5511 {

    private static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numSpecial(int[][] mat) {
        if(mat == null) return 0;
        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> rowCtn = new HashMap<>();
        Map<Integer, Integer> colCtn = new HashMap<>();

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    pairs.add(new Pair(i,j));
                    rowCtn.put(i, rowCtn.getOrDefault(i, 0)+1);
                    colCtn.put(j, colCtn.getOrDefault(j, 0)+1);
                }
            }
        }

        int ans = 0;
        for(Pair p : pairs) {
            if(rowCtn.get(p.row) == 1 && colCtn.get(p.col) == 1) {
                ans++;
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] mat = new int[][]{
                {0,0,0,1},
                {1,0,0,0},
                {0,1,1,0},
                {0,0,0,0},
        };
        assertThat(this.numSpecial(mat)).isEqualTo(2);
        assertThat(this.numSpecial(null)).isEqualTo(0);

        mat = new int[][]{
                {0,1}
        };
        assertThat(this.numSpecial(mat)).isEqualTo(1);

        mat = new int[][] {
                {0},
                {1}
        };
        assertThat(this.numSpecial(mat)).isEqualTo(1);
    }
}
