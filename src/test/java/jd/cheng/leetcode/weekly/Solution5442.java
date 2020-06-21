package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-194/problems/avoid-flood-in-the-city/">link</a>
 */
public class Solution5442 {

  public int[] avoidFlood(int[] rains) {
    int[] ans = new int[rains.length];
    Pools pools = new Pools();

    for (int i = 0; i < rains.length; i++) {
      int pool = rains[i];
      if (pool != 0) {
        if (pools.contains(pool)) {
          return new int[]{};
        } else {
          ans[i] = -1;
          pools.dump(pool);
        }
      } else {
        // draw water
        if (pools.isEmpty()) {
          ans[i] = 1;
        } else {
          ans[i] = findFullPoolToDraw(i, rains, pools);
        }
      }
    }
    return ans;
  }

  // try to find the pool which is already full and draw it
  private int findFullPoolToDraw(int i, int[] rains, Pools pools) {
    boolean foundFullPool = false;
    for(int j=i+1; j<rains.length; j++) {
      if(rains[j] == 0) continue;
      else if(pools.contains(rains[j])) {
        foundFullPool = true;
        return pools.draw(rains[j]);
      }
    }
    if(!foundFullPool) {
      return pools.draw();
    }
    return -1;
  }

  private static class Pools {

    private final Set<Integer> set = new HashSet<>();

    public int draw() {
      Integer result = set.iterator().next();
      set.remove(result);
      return result;
    }

    public int draw(int nextPool) {
      set.remove(nextPool);
      return nextPool;
    }

    public void dump(int i) {
      set.add(i);
    }

    public boolean contains(int i) {
      return set.contains(i);
    }

    public boolean isEmpty() {
      return set.isEmpty();
    }
  }

  @Test
  public void test() throws Exception {
    assertThat(this.avoidFlood(new int[]{1, 2, 3, 4})).containsExactly(-1, -1, -1, -1);
    assertThat(this.avoidFlood(new int[]{1, 2, 0, 0, 2, 1})).containsExactly(-1, -1, 2, 1, -1, -1);
    assertThat(this.avoidFlood(new int[]{1, 2, 0, 1, 2})).isEmpty();
    assertThat(this.avoidFlood(new int[]{69, 0, 0, 0, 69})).containsExactly(-1, 69, 1, 1, -1);
    assertThat(this.avoidFlood(new int[]{10, 20, 20})).isEmpty();
    assertThat(this.avoidFlood(new int[]{1,2,0,2,3,0,1})).containsExactly(-1,-1,2,-1,-1,1,-1);
    assertThat(this.avoidFlood(new int[]{3,5,4,0,1,0,1,5,2,8,9})).containsExactly(-1,-1,-1,5,-1,1,-1,-1,-1,-1,-1);
  }
}
