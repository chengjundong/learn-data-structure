package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 */
public class Solution102 {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Element> queue = new LinkedList<>();
    // enqueue root
    if (root == null) {
      return result;
    } else {
      Element e = new Element(root.val, 0);
      queue.add(e);
      enqueue(root, queue, 1);
    }

    while(!queue.isEmpty()) {
      Element e = queue.poll();
      if(result.isEmpty() || result.size() == e.depth) {
        List<Integer> lx = new ArrayList<>();
        lx.add(e.val);
        result.add(lx);
      } else {
        result.get(e.depth).add(e.val);
      }
    }

    return result;
  }

  private void enqueue(TreeNode node, LinkedList<Element> queue, int depth) {
    if(node.left != null) {
      Element e = new Element(node.left.val, depth);
      queue.add(e);
    }

    if(node.right != null) {
      Element e = new Element(node.right.val, depth);
      queue.add(e);
    }

    if(node.left != null) {
      enqueue(node.left, queue, depth+1);
    }
    if(node.right != null) {
      enqueue(node.right, queue, depth+1);
    }
  }

  private static class Element {
    int val;
    int depth;

    public Element (int val, int depth) {
      this.val = val;
      this.depth = depth;
    }
  }

  @Test
  public void test() throws Exception {
    TreeNode n1 = new TreeNode(3);
    n1.left = new TreeNode(9);
    n1.right = new TreeNode(20);
    n1.right.left = new TreeNode(15);
    n1.right.right = new TreeNode(7);

    List<List<Integer>> result1 = this.levelOrder(n1);
    assertThat(result1).hasSize(3);
    assertThat(result1.get(0)).containsExactly(3);
    assertThat(result1.get(1)).containsExactly(9, 20);
    assertThat(result1.get(2)).containsExactly(15, 7);
  }
}
