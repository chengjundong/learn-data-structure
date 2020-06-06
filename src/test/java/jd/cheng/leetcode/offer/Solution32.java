package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/">link</a>
 */
public class Solution32 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if(root != null) queue.add(root);
    while(!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      for(int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        tmp.add(node.val);
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
      res.add(tmp);
    }
    return res;
  }

  @Test
  public void test() throws Exception {
    TreeNode n = new TreeNode(3);
    n.left = new TreeNode(9);
    n.right = new TreeNode(20);
    n.right.left = new TreeNode(7);
    n.right.right = new TreeNode(10);

    List<List<Integer>> result = this.levelOrder(n);

    assertThat(result).hasSize(3);
    assertThat(result.get(0)).containsExactly(3);
    assertThat(result.get(1)).containsExactly(9,20);
    assertThat(result.get(2)).containsExactly(7,10);
  }
}
