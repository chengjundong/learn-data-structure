package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">link</a>
 */
public class Solution235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> lp = new ArrayList<>();
    List<TreeNode> lq = new ArrayList<>();
    this.find(root, p, lp);
    this.find(root, q, lq);

    TreeNode result = root;
    for(int i=0, j=0;i < lp.size() && j < lq.size(); i++,j++) {
      if(lp.get(i) == lq.get(j)) {
        result = lp.get(i);
      } else {
        break;
      }
    }

    return result;
  }

  private void find(TreeNode root, TreeNode n, List<TreeNode> list) {
    if(root == n) {
      list.add(n);
      return;
    } else if(root.val > n.val) {
      list.add(root);
      find(root.left, n, list);
    } else {
      list.add(root);
      find(root.right, n, list);
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode t =  new TreeNode(6);
    t.left = new TreeNode(2);
    t.right = new TreeNode(8);
    t.left.right = new TreeNode(4);
    t.left.left = new TreeNode(0);

    assertThat(this.lowestCommonAncestor(t, t.left, t.left.right)).isEqualTo(t.left);
    assertThat(this.lowestCommonAncestor(t, t.left.left, t.left.right)).isEqualTo(t.left);
    assertThat(this.lowestCommonAncestor(t, t.left, t.right)).isEqualTo(t);
  }
}
