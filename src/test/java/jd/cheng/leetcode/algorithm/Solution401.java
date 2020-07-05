package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/binary-watch/">link</a>
 */
public class Solution401 {

  public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<>();

    for (int h = 0; h <= 11; h++) {
      for (int m = 0; m <= 59; m++) {
        // to check the count of digit 1 is equal to the num
        if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
          result.add(String.format("%d:%02d", h, m));
        }
      }
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.readBinaryWatch(1))
        .containsExactlyInAnyOrder("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08",
            "0:16", "0:32");
    assertThat(this.readBinaryWatch(2))
        .containsExactlyInAnyOrder("0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18",
            "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08",
            "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02",
            "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16",
            "8:32", "9:00", "10:00");
  }
}
