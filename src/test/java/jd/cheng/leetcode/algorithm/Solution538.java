package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">link</a>
 */
public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        this.inTravel(root, list);
        for(int i=list.size()-1; i>=1; i--) {
            list.get(i-1).val += list.get(i).val;
        }

        return root;
    }

    private void inTravel(TreeNode node, List<TreeNode> list) {
        if(node == null) return;
        inTravel(node.left, list);
        list.add(node);
        inTravel(node.right, list);
    }

    @Test
    public void test() throws Exception {
        TreeNode n = new TreeNode(5);
        n.right = new TreeNode(13);
        n.left = new TreeNode(2);

        TreeNode result = this.convertBST(n);

        assertThat(result).extracting("val", "left.val", "right.val")
            .containsExactly(18, 20, 13);

        n = new TreeNode(5);
        n.right = new TreeNode(13);
        n.right.left = new TreeNode(10);
        n.right.right = new TreeNode(20);
        n.left = new TreeNode(3);
        n.left.right = new TreeNode(4);
        n.left.left = new TreeNode(1);

        result = this.convertBST(n);

        assertThat(result).extracting(
                "val", "left.val", "left.left.val", "left.right.val",
                "right.val", "right.left.val", "right.right.val")
                .containsExactly(48, 55, 56, 52, 33, 43, 20);
    }
}
