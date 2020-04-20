package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution110 {

  public boolean isBalanced(TreeNode root) {
    if(null == root) {
      return true;
    } else {
      return _isBalanced(root, 1);
    }
  }

  private boolean _isBalanced(TreeNode n, int depth) {
    if(n == null) {
      return true;
    }

    int leftDepth = this.getDepth(n.left, depth);
    int rightDepth = this.getDepth(n.right, depth);

    return 1 >= Math.abs(leftDepth-rightDepth)
        && _isBalanced(n.left, depth+1)
        && _isBalanced(n.right, depth+1);
  }

  private int getDepth(TreeNode n, int depth) {
    if(null == n) {
      return depth;
    } else {
      depth++;
      return Math.max(getDepth(n.left, depth), getDepth(n.right, depth));
    }
  }

  @Test
  public void test() {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(3);
    assertThat(this.isBalanced(t1)).isTrue();

    t1.left.left = new TreeNode(4);
    assertThat(this.isBalanced(t1)).isTrue();

    t1.right.left = new TreeNode(5);
    assertThat(this.isBalanced(t1)).isTrue();

    TreeNode t2 = new TreeNode(1);
    t2.right = new TreeNode(2);
    t2.left = new TreeNode(2);
    t2.left.left = new TreeNode(3);
    t2.left.right = new TreeNode(3);
    t2.left.left.left = new TreeNode(4);
    t2.left.left.right = new TreeNode(4);
    assertThat(this.isBalanced(t2)).isFalse();

    TreeNode t3 = new TreeNode(1);
    t3.right = new TreeNode(2);
    t3.right.right = new TreeNode(3);
    assertThat(this.isBalanced(t3)).isFalse();

    TreeNode t4 = new TreeNode(1);
    t4.left = new TreeNode(2);
    t4.right = new TreeNode(2);
    t4.left.left = new TreeNode(3);
    t4.left.left.left = new TreeNode(4);
    t4.right.right = new TreeNode(3);
    t4.right.right.right = new TreeNode(4);
    assertThat(this.isBalanced(t4)).isFalse();
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
