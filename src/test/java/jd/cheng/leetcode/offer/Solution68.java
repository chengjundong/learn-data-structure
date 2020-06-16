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

  public TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> listP = new ArrayList<>();
    List<TreeNode> listQ = new ArrayList<>();

    this._recur(root, p, listP);
    this._recur(root, q, listQ);

    TreeNode result = root;
    for(int i=listP.size()-1, j=listQ.size()-1; i >=0 && j >= 0; i--,j--) {
      if(listP.get(i) == listQ.get(j)) {
        result= listP.get(i);
      } else {
        break;
      }
    }

    return result;
  }

  private boolean _recur(TreeNode n, TreeNode p, List<TreeNode> list) {
    if(n == null) return false;
    if(n == p) {
      list.add(n);
      return true;
    }
    boolean found = _recur(n.left, p, list) || _recur(n.right, p, list);
    if(found) {
      list.add(n);
    }
    return found;
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


    TreeNode x = new TreeNode(3);
    x.left = new TreeNode(5);
    x.right = new TreeNode(1);
    x.left.right = new TreeNode(2);
    x.left.left = new TreeNode(6);
    x.right.left = new TreeNode(8);

    assertThat(this._lowestCommonAncestor(n, n.left, n.right)).isEqualTo(n);
    assertThat(this._lowestCommonAncestor(n, n.left, n.left.right)).isEqualTo(n.left);
    assertThat(this._lowestCommonAncestor(x, x.left, x.left.right)).isEqualTo(x.left);
    assertThat(this._lowestCommonAncestor(x, x.left.left, x.left.right)).isEqualTo(x.left);
  }
}
