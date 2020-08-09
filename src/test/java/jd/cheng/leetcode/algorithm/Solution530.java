package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">link</a>
 */
public class Solution530 {

    private final List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        this.inorder(root);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++) {
            int delta = list.get(i+1) - list.get(i);
            if(delta < ans) ans = delta;
        }
        return ans;
    }

    private void inorder(TreeNode n) {
        if(n == null) return;
        inorder(n.left);
        list.add(n.val);
        inorder(n.right);
    }

    @Test
    public void test() throws Exception {
        TreeNode n = new TreeNode(50);
        n.left = new TreeNode(20);
        n.left.right = new TreeNode(23);
        n.left.left = new TreeNode(10);
        n.right = new TreeNode(100);

        assertThat(this.getMinimumDifference(n)).isEqualTo(3);
    }
}
