package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/diameter-of-binary-tree/">link</a>
 */
public class Solution543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        int max1 = this.diameter(root);
        int max2 = Math.max(this.diameterOfBinaryTree(root.left), this.diameterOfBinaryTree(root.right));
        return Math.max(max1, max2);
    }

    private int diameter(TreeNode n) {
        if(n == null) return 0;
        int ld = this.depth(0, n.left);
        int rd = this.depth(0, n.right);
        return ld+rd;
    }

    private int depth(int _depth, TreeNode node) {
        if(node == null) return _depth;
        _depth++;
        return Math.max(this.depth(_depth, node.left), this.depth(_depth, node.right));
    }

    @Test
    public void test() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);

        assertThat(this.diameterOfBinaryTree(n)).isEqualTo(3);
    }
}
