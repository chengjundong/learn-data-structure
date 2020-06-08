package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">link</a>
 */
public class Solution54 {

  public int kthLargest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    return list.get(list.size()-k);
  }

  private void inOrder(TreeNode node, List<Integer> list) {
    if(node == null) return;
    inOrder(node.left, list);
    list.add(node.val);
    inOrder(node.right, list);
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(3);
    n.left = new TreeNode(1);
    n.right = new TreeNode(4);
    n.left.right = new TreeNode(2);

    assertThat(this.kthLargest(n,1)).isEqualTo(4);
    assertThat(this.kthLargest(n,4)).isEqualTo(1);
  }
}
