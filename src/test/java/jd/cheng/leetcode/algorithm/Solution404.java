package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">link</a>
 */
public class Solution404 {

  public int sumOfLeftLeaves(TreeNode root) {
    return this.recur(root, false);
  }

  private int recur(TreeNode node, boolean isLeft) {
    if(node == null) return 0;

    int sum = 0;
    if(node.left == null && node.right == null) {
      if(isLeft) sum = node.val;
    } else {
      sum += recur(node.left, true);
      sum += recur(node.right, false);
    }
    return sum;
  }

  @Test
  public void test() throws Exception {
    TreeNode n1 = new TreeNode(3);
    n1.left = new TreeNode(9);
    n1.right = new TreeNode(8);
    n1.right.left = new TreeNode(15);

    assertThat(this.sumOfLeftLeaves(n1)).isEqualTo(24);

    n1.left.right = new TreeNode(2);
    assertThat(this.sumOfLeftLeaves(n1)).isEqualTo(15);
  }
}
