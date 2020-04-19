package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/symmetric-tree/">Symmetric Tree</a>
 */
public class Solution101 {

  public boolean isSymmetric(TreeNode root) {
    if(null == root) {
      return true;
    } else {
      return isSameTree(root.left, root.right);
    }
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    } else if(p == null || q == null) {
      return false;
    } else if(p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(2);

    assertThat(isSymmetric(t1)).isTrue();

    TreeNode t2 = new TreeNode(1);
    t2.left = new TreeNode(2);
    t2.left.left = new TreeNode(3);
    t2.left.right =  new TreeNode(4);
    t2.right = new TreeNode(2);
    t2.right.left = new TreeNode(4);
    t2.right.right = new TreeNode(3);

    assertThat(isSymmetric(t2)).isTrue();

    TreeNode T3 = new TreeNode(1);
    T3.left = new TreeNode(2);
    T3.left.right = new TreeNode(3);
    T3.right = new TreeNode(2);
    T3.right.right = new TreeNode(3);

    assertThat(isSymmetric(T3)).isFalse();
  }

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }
}
