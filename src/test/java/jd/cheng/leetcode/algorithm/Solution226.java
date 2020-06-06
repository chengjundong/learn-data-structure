package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution226 {

  public TreeNode invertTree(TreeNode root) {
    _invertTree(root);
    return root;
  }

  private void _invertTree(TreeNode n) {
    if (n == null) {
      return;
    }
    if (n.left == null && n.right == null) {
      return;
    }

    TreeNode temp = n.left;
    n.left = n.right;
    n.right = temp;

    _invertTree(n.left);
    _invertTree(n.right);
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(4);
    n.left = new TreeNode(2);
    n.right = new TreeNode(7);
    n.left.left = new TreeNode(1);
    n.left.right = new TreeNode(3);
    n.right.left = new TreeNode(6);
    n.right.right = new TreeNode(9);

    TreeNode rev = invertTree(n);
    assertThat(rev.val).isEqualTo(4);
    assertThat(rev.left.val).isEqualTo(7);
    assertThat(rev.left.right.val).isEqualTo(6);
    assertThat(rev.left.left.val).isEqualTo(9);
    assertThat(rev.right.val).isEqualTo(2);
    assertThat(rev.right.left.val).isEqualTo(3);
    assertThat(rev.right.right.val).isEqualTo(1);
  }
}
