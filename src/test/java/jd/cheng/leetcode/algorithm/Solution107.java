package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">Level order traversal</a>
 */
public class Solution107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<_TreeNode> t = new LinkedList<>();

    if(root == null) return result;

    for(t.add(new _TreeNode(0, root));!t.isEmpty();) {
      // dequeue
      _TreeNode n = t.removeFirst();
      // add value
      if(result.size() == n.depth) {
        result.add(0, new ArrayList<>());
      }
      List<Integer> list = result.getFirst();
      list.add(n.node.val);
      // next
      if(n.node.left != null) {
        t.add(new _TreeNode(n.depth+1, n.node.left));
      }
      if(n.node.right != null) {
        t.add(new _TreeNode(n.depth+1, n.node.right));
      }
    }

    return result;
  }

  @Test
  public void test() throws Exception {
      TreeNode t1 = new TreeNode(1);
      t1.left = new TreeNode(2);
      t1.right = new TreeNode(3);
      t1.left.right = new TreeNode(4);

      assertThat(levelOrderBottom(t1)).hasSize(3);
      assertThat(levelOrderBottom(t1).get(0)).containsSequence(4);
      assertThat(levelOrderBottom(t1).get(1)).containsSequence(2,3);
      assertThat(levelOrderBottom(t1).get(2)).containsSequence(1);

      TreeNode t2 = new TreeNode(3);
      t2.left = new TreeNode(9);
      t2.right = new TreeNode(20);
      t2.right.left = new TreeNode(15);
      t2.right.right = new TreeNode(7);

      assertThat(levelOrderBottom(t2)).hasSize(3);
      assertThat(levelOrderBottom(t2).get(0)).containsSequence(15, 7);
      assertThat(levelOrderBottom(t2).get(1)).containsSequence(9, 20);
      assertThat(levelOrderBottom(t2).get(2)).containsSequence(3);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      this.val = x;
    }
  }

  private static class _TreeNode {
    int depth;
    TreeNode node;

    _TreeNode(int depth, TreeNode node) {
      this.depth = depth;
      this.node = node;
    }
  }
}
