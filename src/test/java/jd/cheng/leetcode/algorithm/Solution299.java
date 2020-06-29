package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/bulls-and-cows/">link</a>
 */
public class Solution299 {

  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;

    Map<Integer, Set<Integer>> map = new HashMap<>(secret.length());

    for(int i=secret.length()-1; i>=0; i--) {
      int x = (int)secret.charAt(i) - 48;
      if(map.containsKey(x)) {
        map.get(x).add(i);
      } else {
        Set<Integer> set = new HashSet<>();
        set.add(i);
        map.put(x, set);
      }
    }

    // check bulls;
    Set<Integer> foundBulls = new HashSet<>();
    for(int i=guess.length()-1; i>=0; i--) {
      int y = (int)guess.charAt(i) - 48;
      if(map.containsKey(y) && map.get(y).contains(i)) {
        map.get(y).remove(i);
        foundBulls.add(i);
        if(map.get(y).isEmpty()) {
          map.remove(y);
        }
        bulls++;
      }
    }

    // check cows
    for(int i=guess.length()-1; i>=0; i--) {
      if(foundBulls.contains(i)) continue;
      int y = (int)guess.charAt(i) - 48;
      if(map.containsKey(y)) {
        Iterator<Integer> it = map.get(y).iterator();
        it.next();
        it.remove();
        if(map.get(y).isEmpty()) {
          map.remove(y);
        }
        cows++;
      }
    }

    return String.format("%dA%dB",bulls,cows);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.getHint("1807","7810")).isEqualTo("1A3B");
    assertThat(this.getHint("1123","0111")).isEqualTo("1A1B");
    assertThat(this.getHint("11","10")).isEqualTo("1A0B");
  }
}
