package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/same-tree/">Same Tree</a>
 */
public class Solution100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {

    if(p == null && q == null) {
      return true;
    } else if(p == null || q == null) {
      return false;
    } else if(p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(3);

    TreeNode t2 = new TreeNode(1);
    t2.left = new TreeNode(2);
    t2.right = new TreeNode(3);

    assertThat(isSameTree(t1, t2)).isTrue();

    TreeNode t3 = new TreeNode(1);
    t3.left = new TreeNode(2);

    TreeNode t4 = new TreeNode(1);
    t4.right = new TreeNode(2);

    assertThat(isSameTree(t3, t4)).isFalse();


    TreeNode t5 = new TreeNode(1);
    t5.left = new TreeNode(2);
    t5.right = new TreeNode(1);

    TreeNode t6 = new TreeNode(1);
    t6.left = new TreeNode(1);
    t6.right = new TreeNode(2);

    assertThat(isSameTree(t5, t6)).isFalse();

    TreeNode t7 = new TreeNode(10);
    t7.left = new TreeNode(5);
    t7.right = new TreeNode(15);

    TreeNode t8 = new TreeNode(10);
    t8.left = new TreeNode(5);
    t8.left.right = new TreeNode(15);

    assertThat(isSameTree(t7, t8)).isFalse();
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
