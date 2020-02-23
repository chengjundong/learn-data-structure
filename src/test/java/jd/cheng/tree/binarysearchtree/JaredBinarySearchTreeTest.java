package jd.cheng.tree.binarysearchtree;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class JaredBinarySearchTreeTest {

	@Test
	public void test() {
		JaredBinarySearchTree<Integer, Integer> tree = new JaredBinarySearchTree<>();
		
		assertThat(tree)
			.extracting(JaredBinarySearchTree::size, JaredBinarySearchTree::isEmpty)
			.containsExactly(0, true);
		
		tree.add(50, 50).add(30, 30).add(60,60).add(10,10).add(40,40).add(60,60).add(70,70).add(100,100);
		assertThat(tree.isEmpty()).isFalse();
		assertThat(tree)
			.extracting(JaredBinarySearchTree::size, JaredBinarySearchTree::isEmpty)
			.containsExactly(7, false);
		
		assertThat(tree.contains(110)).isFalse();
		assertThat(tree.contains(10)).isTrue();
		assertThat(tree.contains(50)).isTrue();
		assertThat(tree.min()).isEqualTo(10);
		assertThat(tree.max()).isEqualTo(100);
		
		// traverse the tree
		tree.preOrder().preOrderByStack().inOrder().postOrder().levelOrder();
	}
	
	@Test
	public void testRemoveMin() throws Exception {
		JaredBinarySearchTree<Integer, Integer> tree = new JaredBinarySearchTree<>();
		Integer min = null;
		for(int i = 1000; i>0; i--) {
			int n = ThreadLocalRandom.current().nextInt(10000000);
			if(null == min) {
				min = n;
			} else if(min - n > 0) {
				min = n;
			}
			tree.add(n, n);
		}
		assertThat(tree.size()).isEqualTo(1000);
		assertThat(tree.removeMin()).isEqualTo(min);
		assertThat(tree.size()).isEqualTo(999);
	}
	
	@Test
	public void testRemoveMax() throws Exception {
		JaredBinarySearchTree<Integer, Integer> tree = new JaredBinarySearchTree<>();
		Integer max = null;
		for(int i = 1000; i>0; i--) {
			int n = ThreadLocalRandom.current().nextInt(10000000);
			if(null == max) {
				max = n;
			} else if(n - max > 0) {
				max = n;
			}
			tree.add(n, n);
		}
		assertThat(tree.size()).isEqualTo(1000);
		assertThat(tree.removeMax()).isEqualTo(max);
		assertThat(tree.size()).isEqualTo(999);
	}
	
	@Test
	public void testRemove() throws Exception {
		JaredBinarySearchTree<Integer, Integer> tree = new JaredBinarySearchTree<>();
		tree.add(0,0).add(5,5).add(4,4).add(2,2).add(1,1).add(3,3)
			.add(8,8).add(7,7).add(6,6).add(9,9).add(10,10);
		
		tree.remove(4);
		tree.inOrder();
	}
	
}
