package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">link</a>
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        recur(root);
    }

    private TreeNode recur(TreeNode node) {
        if (node == null) return node;

        if (node.left == null) {
            node.right = this.recur(node.right);
            return node;
        }

        node.left = recur(node.left);
        node.right = recur(node.right);
        this.linkLeftToRight(node);

        return node;
    }

    private void linkLeftToRight(TreeNode node) {
        if(node == null) return;

        TreeNode l = node.left;
        while(l != null && l.right != null) {
            l = l.right;
        }
        l.right = node.right;
        node.right = node.left;

        node.left = null;
    }

    @Test
    public void test() throws Exception {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);

        this.flatten(n);

        assertThat(n.left).isNull();
        assertThat(n.right.val).isEqualTo(2);
        assertThat(n.right.right.val).isEqualTo(3);

        n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.left = new TreeNode(3);
        n.left.right = new TreeNode(4);
        n.right = new TreeNode(5);
        n.right.right = new TreeNode(6);

        this.flatten(n);
        int i = 1;
        while(n != null) {
            assertThat(n.val).isEqualTo(i++);
            assertThat(n.left).isNull();
            n = n.right;
        }

        n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.left = new TreeNode(3);
        this.flatten(n);
        i = 1;
        while(n != null) {
            assertThat(n.val).isEqualTo(i++);
            assertThat(n.left).isNull();
            n = n.right;
        }
    }
}
