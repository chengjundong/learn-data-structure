package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof">link</a>
 */
public class Solution28 {

  public boolean isSymmetric(TreeNode root) {
    return null == root ? true : _isSymmetric(root.left, root.right);
  }

  private boolean _isSymmetric(TreeNode n1, TreeNode n2) {
    if(n1 == null && n2 == null) return true;
    else if(n1 == null || n2 == null || n1.val != n2.val) return false;
    return _isSymmetric(n1.right, n2.left) && _isSymmetric(n1.left, n2.right);
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(1);
    n.left = new TreeNode(2);
    n.right = new TreeNode(2);
    n.left.left = new TreeNode(3);
    n.left.right = new TreeNode(4);
    n.right.left = new TreeNode(4);
    n.right.right = new TreeNode(3);

    assertThat(this.isSymmetric(n)).isTrue();
  }
}
