package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-196/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/">link</a>
 */
public class Solution5455 {

  int[] SORTED = new int[1];

  public String minInteger(String num, int k) {
    int[] arr = this.toArray(num);
    if(arr == SORTED) return num;

    int h = 0;
    while(k > 0) {
      int minIndex = this.findMin(arr, h);
      if(minIndex <= k) {
        this.moveToTop(arr, minIndex);
        k = k-minIndex;
        h++;
      } else {
        // switch from h
        while(k>0) {
          doSwitch(arr, h);
          k--;
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for(int a : arr) {
      sb.append(String.valueOf(a));
    }

    return sb.toString();
  }

  private void doSwitch(int[] arr, int start) {
    for(int i=start; i<arr.length-1; i++) {
      if(arr[i] > arr[i+1]) {
        int t = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = t;
        break;
      }
    }
  }

  private void moveToTop(int[] arr, int index) {
    for(int i=index; i>0; i--) {
      int t = arr[i];
      arr[i] = arr[i-1];
      arr[i-1] = t;
    }
  }

  private int findMin(int[] arr, int start) {
    int ans = start;
    int min = Integer.MAX_VALUE;
    for(int i=start; i < arr.length; i++) {
      if(arr[i] < min) {
        min = arr[i];
        ans = i;
      }
    }
    return ans;
  }

  private int[] toArray(String num) {
    int[] arr = new int[num.length()];

    int i=0;
    Integer prev = null;
    boolean isSorted = true;
    for(char n : num.toCharArray()) {
      int cur = (int)(n - '0');
      arr[i++] = cur;
      if(prev == null) {
        prev = cur;
      } else if(isSorted && prev > cur) {
        isSorted = false;
      }
    }

    return isSorted ? SORTED : arr;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.minInteger("4321", 3)).isEqualTo("1432");
    assertThat(this.minInteger("4321", 4)).isEqualTo("1342");
    assertThat(this.minInteger("36789", 1000)).isEqualTo("36789");
//    assertThat(this.minInteger("9438957234785635408", 23)).isEqualTo("0345989723478563548");
  }
}
