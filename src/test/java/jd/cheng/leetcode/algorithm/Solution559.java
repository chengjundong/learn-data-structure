package jd.cheng.leetcode.algorithm;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree">link</a>
 */
public class Solution559 {

    public int maxDepth(Node root) {
        return depth(root, 0);
    }

    private int depth(Node n, int depth) {
        if (n == null) return depth;
        int ans = depth+1;
        if(n.children != null) {
            for(Node c : n.children) {
                ans = Math.max(depth(c, depth+1), ans);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Node n = new Node(1);
        n.children = ImmutableList.of(new Node(1), new Node(1), new Node(1));
        n.children.get(0).children = ImmutableList.of(new Node(1), new Node(1), new Node(1));
        assertThat(this.maxDepth(n)).isEqualTo(3);
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
