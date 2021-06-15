package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/house-robber-iii/">house-robber-iii</a>
 */
public class Solution337 {

    public int rob(TreeNode root) {
        int[] result = recur(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recur(TreeNode n) {
        if(null == n) {
            return new int[]{0, 0};
        }

        int[] l = recur(n.left);
        int[] r = recur(n.right);
        int[] result = new int[2];
        result[0] = n.val + l[1] + r[1];
        result[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return result;
    }

    @Test
    public void test() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(2);
        n.left.right = new TreeNode(3);
        n.right = new TreeNode(3);
        n.right.right = new TreeNode(1);

        assertThat(rob(n)).isEqualTo(7);

        n = new TreeNode(3);
        assertThat(rob(n)).isEqualTo(3);

        assertThat(rob(null)).isEqualTo(0);

        n = new TreeNode(3);
        n.left = new TreeNode(4);
        n.left.left = new TreeNode(1);
        n.left.right = new TreeNode(3);
        n.right = new TreeNode(5);
        n.right.right = new TreeNode(1);
        assertThat(rob(n)).isEqualTo(9);

        n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        assertThat(rob(n)).isEqualTo(5);
    }
}
