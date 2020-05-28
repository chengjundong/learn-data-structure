package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution07 {

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    // store inorder -> hashmap
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndex.put(inorder[i], i);
    }

    return _build(preorder, 0, preorder.length - 1,
        inorder, 0, inorder.length - 1, inorderIndex);
  }

  private TreeNode _build(int[] preorder, int preStart, int preEnd,
      int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndex) {

    if (preStart <= preEnd) {
      return null;
    }

    TreeNode n = new TreeNode(preorder[preStart]);
    int index = inorderIndex.get(n.val);

    int leftLength = index - inStart;
    int rightLength = inEnd - index;

    n.left = _build(preorder, preStart + 1, preStart + leftLength,
        inorder, inStart, index - 1, inorderIndex);
    n.right = _build(preorder, preStart + leftLength + 1, preEnd,
        inorder, index + 1, inEnd, inorderIndex);

    return n;
  }

  @Test
  public void test() throws Exception {
    TreeNode n1 = this.buildTree(new int[]{2, 1, 3}, new int[]{1, 2, 3});
    assertThat(n1.val).isEqualTo(2);
    assertThat(n1.left.val).isEqualTo(1);
    assertThat(n1.right.val).isEqualTo(3);
  }
}
