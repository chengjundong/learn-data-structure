package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/">link</a>
 */
public class Solution68 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    List<TreeNode> listP = new ArrayList<>();
    List<TreeNode> listQ = new ArrayList<>();

    this.recur(root, p, listP);
    this.recur(root, q, listQ);

    TreeNode result = root;
    for(int i=0, j=0; i<listP.size() && j<listQ.size(); i++,j++) {
      if(listP.get(i) == listQ.get(i)) {
        result= listP.get(i);
      } else {
        break;
      }
    }

    return result;
  }

  private void recur(TreeNode n, TreeNode p, List<TreeNode> list) {
    if(n == null) {
      return;
    } else if(n == p) {
      list.add(n);
    } else if(n.val > p.val) {
      list.add(n);
      recur(n.left, p, list);
    } else {
      list.add(n);
      recur(n.right, p, list);
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(6);
    n.left = new TreeNode(2);
    n.right = new TreeNode(8);
    n.left.right = new TreeNode(4);
    n.right.left = new TreeNode(7);

    assertThat(this.lowestCommonAncestor(n, n.left, n.right)).isEqualTo(n);
    assertThat(this.lowestCommonAncestor(n, n.left, n.left.right)).isEqualTo(n.left);
  }
}
