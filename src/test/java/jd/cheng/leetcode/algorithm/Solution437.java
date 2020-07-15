package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/path-sum-iii/">link</a>
 */
public class Solution437 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;

        int currentPath = this.countPath(root, sum);
        int leftPath = this.pathSum(root.left, sum);
        int rightPath = this.pathSum(root.right, sum);

        return currentPath + leftPath + rightPath;
    }

    public int countPath(TreeNode node, int sum) {
        if (node == null) return 0;
        int result = sum - node.val == 0 ? 1 : 0;
        return result + countPath(node.left, sum - node.val) + countPath(node.right, sum - node.val);
    }

    @Test
    public void test() throws Exception {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(5);
        n.left.left = new TreeNode(3);
        n.left.left.right = new TreeNode(9);
        n.left.right = new TreeNode(2);
        n.left.right.left = new TreeNode(1);
        n.right = new TreeNode(-2);

        assertThat(this.pathSum(n, 8)).isEqualTo(3);
    }
}
