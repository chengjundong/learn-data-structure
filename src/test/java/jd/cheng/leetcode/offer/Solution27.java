package jd.cheng.leetcode.offer;

import jd.cheng.leetcode.TreeNode;

/**
 * @author jucheng
 */
public class Solution27 {

  public TreeNode mirrorTree(TreeNode root) {

    if(root == null) {
      return null;
    }

    TreeNode n = root.left;
    root.left = root.right;
    root.right = n;

    mirrorTree(root.left);
    mirrorTree(root.right);

    return root;
  }
}
