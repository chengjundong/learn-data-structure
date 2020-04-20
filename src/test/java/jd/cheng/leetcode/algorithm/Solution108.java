package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution108 {

  public TreeNode sortedArrayToBST(int[] nums) {

    if(null == nums || 0 == nums.length) {
      return null;
    }

    int mid = nums.length / 2;

    TreeNode root = new TreeNode(nums[mid]);
    root.left = _gen(nums, 0, mid-1);
    root.right = _gen(nums, mid+1, nums.length-1);

    return root;
  }

  private TreeNode _gen(int[] nums, int start, int end) {
    if(start > end) {
      return null;
    }

    int mid = start + (end-start) / 2;
    TreeNode result = new TreeNode(nums[mid]);
    result.left = _gen(nums, start, mid-1);
    result.right = _gen(nums, mid+1, end);

    return result;
  }

  @Test
  public void test() {
      TreeNode t1 = this.sortedArrayToBST(new int[]{1,2,3});
      assertThat(t1).isNotNull()
          .extracting("val","left.val","right.val")
          .containsExactly(2,1,3);

      TreeNode t2 = this.sortedArrayToBST(new int[]{1,2,3,4});
      assertThat(t2).isNotNull()
        .extracting("val","left.val","left.right.val","right.val")
        .containsExactly(3,1,2,4);

      TreeNode t3 = this.sortedArrayToBST(new int[]{-10,-3,0,5,9});
      assertThat(t3).isNotNull()
        .extracting("val","left.val","left.right.val","right.val","right.right.val")
        .containsExactly(0,-10,-3,5,9);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      this.val = x;
    }
  }
}
