package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">Min depth of binary tree</a>
 */
public class Solution111 {

  public int minDepth(TreeNode root) {
    return _minDepth(root, 0);
  }

  private int _minDepth(TreeNode n, int depth) {
    if(n == null) {
      return depth;
    } else {
      int currentDepth = depth+1;
      int lDepth = _minDepth(n.left, currentDepth);
      int rDepth = _minDepth(n.right, currentDepth);
      if(lDepth == currentDepth) {
        return rDepth;
      } else if(rDepth == currentDepth) {
        return lDepth;
      } else {
        return Math.min(lDepth, rDepth);
      }
    }
  }

  @Test
  public void test() {
    TreeNode t1 = new TreeNode(3);
    t1.left = new TreeNode(9);
    t1.left.left = new TreeNode(10);
    assertThat(minDepth(t1)).isEqualTo(3);

    assertThat(minDepth(null)).isZero();

    TreeNode t2 = new TreeNode(3);
    t2.left = new TreeNode(9);
    t2.right = new TreeNode(20);
    t2.right.left = new TreeNode(15);
    t2.right.right = new TreeNode(7);
    assertThat(minDepth(t2)).isEqualTo(2);

    TreeNode t3 = new TreeNode(3);
    t1.left = new TreeNode(9);
    assertThat(minDepth(t1)).isEqualTo(2);
  }
}
