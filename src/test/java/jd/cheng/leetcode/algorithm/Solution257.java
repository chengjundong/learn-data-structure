package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">link</a>
 */
public class Solution257 {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new LinkedList<>();
    this.recur(root, "", result);
    return result;
  }

  private void recur(TreeNode node, String path, List<String> paths) {
    if (node == null) {
      return;
    }

    // append value
    path += String.valueOf(node.val);
    if (node.left == null && node.right == null) {
      // node is leaf
      paths.add(path);
    } else {
      // recursion
      path += "->";
      this.recur(node.left, path, paths);
      this.recur(node.right, path, paths);
    }
  }

  @Test
  public void test() throws Exception {
    assertThat(this.binaryTreePaths(null)).isEmpty();

    TreeNode n = new TreeNode(1);
    n.left = new TreeNode(2);
    n.right = new TreeNode(3);
    n.left.right = new TreeNode(5);

    assertThat(this.binaryTreePaths(n)).containsExactly("1->2->5", "1->3");
  }
}
