package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/path-sum/">Path Sum</a>
 */
public class Solution112 {

  public boolean hasPathSum(TreeNode root, int sum) {
    return _hasPathSum(root, sum);
  }

  private boolean _hasPathSum(TreeNode n, int sum) {
    if(n == null) {
      return false;
    } else if(n.val == sum && n.left == null && n.right == null) {
      return true;
    } else {
      int remain = sum - n.val;
      return _hasPathSum(n.left, remain) || _hasPathSum(n.right, remain);
    }
  }

  @Test
  public void test() {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(3);
    assertThat(hasPathSum(t1, 4)).isTrue();
    assertThat(hasPathSum(t1, 3)).isTrue();
    assertThat(hasPathSum(t1, 1)).isFalse();
    assertThat(hasPathSum(t1, 2)).isFalse();

    TreeNode t2 = new TreeNode(5);
    t2.left = new TreeNode(4);
    t2.left.left = new TreeNode(11);
    t2.left.left.left = new TreeNode(7);
    t2.left.left.right = new TreeNode(2);
    t2.right = new TreeNode(8);
    t2.right.left = new TreeNode(13);
    t2.right.right = new TreeNode(4);
    t2.right.right.right = new TreeNode(1);
    assertThat(hasPathSum(t2, 22)).isTrue();

    TreeNode t3 = new TreeNode(-2);
    t3.right = new TreeNode(-3);
    assertThat(hasPathSum(t3, -5)).isTrue();
  }
}
