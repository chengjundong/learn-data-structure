package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.StringJoiner;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/keyboard-row/">link</a>
 */
public class Solution500 {

  public String[] findWords(String[] words) {
    String line1 = "QWERTYUIOPqwertyuiop";
    String line2 = "ASDFGHJKLasdfghjkl";
    String line3 = "ZXCVBNMzxcvbnm";

    String line = null;
    StringJoiner ans = new StringJoiner(",");

    N1:
    for (int i=0; i< words.length; i++) {
      String w = words[i];
      // find the line of the 1st character of the word
      if (line1.contains(w.substring(0, 1))) {
        line = line1;
      } else if (line2.contains(w.substring(0, 1))) {
        line = line2;
      } else if (line3.contains(w.substring(0, 1))) {
        line = line3;
      }

      N2:
      for (int j = 1; j < w.length(); j++) {
        String str = String.valueOf(w.charAt(j));
        if(!line.contains(str)) continue N1;
      }

      ans.add(w);
    }

    return ans.length() == 0 ? new String[]{} : ans.toString().split(",");
  }

  @Test
  public void test() throws Exception {
    String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
    assertThat(this.findWords(words)).containsExactly("Alaska", "Dad");

    words = new String[]{"Hello", "Peace"};
    assertThat(this.findWords(words)).isEmpty();

    words = new String[]{"qz","wq","asdddafadsfa","adfadfadfdassfawde"};
    assertThat(this.findWords(words)).containsExactly("wq","asdddafadsfa");
  }
}
