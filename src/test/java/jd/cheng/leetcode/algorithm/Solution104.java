package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">Max depth of binary tree</a>
 */
public class Solution104 {

  public int maxDepth(TreeNode root) {
    if(null == root) {
      return 0;
    } else {
      return _maxDepth(root, 0);
    }
  }

  private int _maxDepth(TreeNode n, int depth) {
    if(n == null) {
      return depth;
    } else {
      return Math.max(_maxDepth(n.left, depth+1), _maxDepth(n.right, depth+1));
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode t1 = new TreeNode(0);
    t1.left = new TreeNode(1);
    t1.left.left = new TreeNode(2);
    t1.left.left.left = new TreeNode(3);

    assertThat(maxDepth(t1)).isEqualTo(4);

    TreeNode t2 = new TreeNode(3);
    t2.left = new TreeNode(9);
    t2.right = new TreeNode(20);
    t2.right.left = new TreeNode(15);
    t2.right.right = new TreeNode(7);

    assertThat(maxDepth(t2)).isEqualTo(3);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      this.val = x;
    }
  }
}
