package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-194/problems/making-file-names-unique/">link</a>
 */
public class Solution5441 {

  private static final String wrapper = "%s(%d)";

  public String[] getFolderNames(String[] names) {
    final LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    final Map<String, Integer> max = new HashMap<>();
    for(String name : names) {
      if(map.containsKey(name)) {
        int k = max.containsKey(name) ? max.get(name) : 0;
        k = recur(name, k, map);
        max.put(name, k);
      } else {
        map.put(name, 0);
      }
    }

    String[] result = new String[names.length];
    int i = 0;
    for(Entry<String, Integer> e : map.entrySet()) {
      result[i++] = e.getKey();
    }

    return result;
  }

  private int recur(String name, int k, LinkedHashMap<String, Integer> map) {
    String n = String.format(wrapper, name, k+1);
    if(map.containsKey(n)) {
      return recur(name, k+1, map);
    } else {
      map.put(n, k+1);
      return k+1;
    }
  }

  @Test
  public void test() throws Exception {
    assertThat(this.getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"})).containsExactly("pes","fifa","gta","pes(2019)");
    assertThat(this.getFolderNames(new String[]{"gta","gta(1)","gta","avalon"})).containsExactly("gta","gta(1)","gta(2)","avalon");
    assertThat(this.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"})).containsExactly("onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)");
    assertThat(this.getFolderNames(new String[]{"wano","wano","wano","wano"})).containsExactly("wano","wano(1)","wano(2)","wano(3)");
    assertThat(this.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"})).containsExactly("kaido","kaido(1)","kaido(2)","kaido(1)(1)");
    assertThat(this.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"})).containsExactly("kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)");
  }
}
