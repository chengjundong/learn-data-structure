package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-tilt/">link</a>
 */
public class Solution563 {

    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        return nodeTilt(root) + findTilt(root.left) + findTilt(root.right);
    }

    private int nodeTilt(TreeNode node) {
        if(node == null) return 0;
        int lT = this.calculate(node.left);
        int rT = this.calculate(node.right);
        return Math.abs(lT-rT);
    }

    private int calculate(TreeNode node) {
        if(node == null) return 0;
        return node.val + calculate(node.left) + calculate(node.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        assertThat(this.findTilt(root)).isEqualTo(3);

        root.left = null;
        assertThat(this.findTilt(root)).isEqualTo(5);

        root.left = null;
        root.right = null;
        assertThat(this.findTilt(root)).isEqualTo(0);

        root = null;
        assertThat(this.findTilt(root)).isEqualTo(0);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        assertThat(this.findTilt(root)).isEqualTo(40);
    }
}
