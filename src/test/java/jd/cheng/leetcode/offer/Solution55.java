package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/">link</a>
 */
public class Solution55 {

  public int maxDepth(TreeNode root) {
    return this._maxDepth(root, 0);
  }

  private int _maxDepth(TreeNode n, int depth) {
    if(n == null) return depth;
    return Math.max(_maxDepth(n.left, depth+1), _maxDepth(n.right, depth+1));
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    boolean result = Math.abs(_maxDepth(root.left, 0) - _maxDepth(root.right, 0)) < 2;
    return result && isBalanced(root.left) && isBalanced(root.right);
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(1);
    n.left = new TreeNode(2);
    n.left.left = new TreeNode(3);

    assertThat(this.maxDepth(n)).isEqualTo(3);
    assertThat(this.isBalanced(n)).isFalse();

    TreeNode n1 = new TreeNode(3);
    n1.left = new TreeNode(4);
    n1.right = new TreeNode(5);
    n1.right.left = new TreeNode(6);
    assertThat(this.isBalanced(n1)).isTrue();
  }
}
