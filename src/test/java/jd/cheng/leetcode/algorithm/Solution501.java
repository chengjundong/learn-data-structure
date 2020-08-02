package jd.cheng.leetcode.algorithm;

import jd.cheng.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/find-mode-in-binary-search-tree">link</a>
 */
public class Solution501 {

    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        this.inTravel(root, map);

        int maxCtn = 0;
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer val = e.getKey();
            Integer ctn = e.getValue();
            if(ctn > maxCtn) {
                maxCtn = ctn;
                list.clear();
                list.add(val);
            } else if(ctn < maxCtn) {
                continue;
            } else {
                list.add(val);
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void inTravel(TreeNode n, Map<Integer, Integer> map) {
        if(n == null) return;
        this.inTravel(n.left, map);
        map.put(n.val, map.getOrDefault(n.val, 0) + 1);
        this.inTravel(n.right, map);
    }

    @Test
    public void test() throws Exception {
        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(2);
        n.right.right = new TreeNode(2);
        n.right.right.left = new TreeNode(2);
        n.right.right.right = new TreeNode(3);
        n.right.right.right.left = new TreeNode(3);
        n.right.right.right.right = new TreeNode(3);

        assertThat(this.findMode(n)).containsExactly(2);

        n.right.right.left = null;
        assertThat(this.findMode(n)).containsExactly(2,3);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        assertThat(this.findMode(n)).containsExactly(1,2);

        n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.right = new TreeNode(2);
        assertThat(this.findMode(n)).containsExactly(2);
    }
}
