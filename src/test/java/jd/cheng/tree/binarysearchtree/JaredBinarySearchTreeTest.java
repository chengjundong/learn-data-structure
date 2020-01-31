package jd.cheng.tree.binarysearchtree;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredBinarySearchTreeTest {

	@Test
	public void test() {
		JaredBinarySearchTree<Integer> tree = new JaredBinarySearchTree<>();
		
		assertThat(tree)
			.extracting(JaredBinarySearchTree::size, JaredBinarySearchTree::isEmpty)
			.containsExactly(0, true);
		
		tree.add(50).add(30).add(60).add(10).add(40).add(60).add(70).add(100);
		assertThat(tree)
			.extracting(JaredBinarySearchTree::size, JaredBinarySearchTree::isEmpty, JaredBinarySearchTree::depth)
			.containsExactly(7, false, 3);
		
		assertThat(tree.contains(110)).isFalse();
		assertThat(tree.contains(10)).isTrue();
		assertThat(tree.contains(50)).isTrue();
		
		// traverse the tree
		tree.preOrder().preOrderByStack().inOrder().postOrder().levelOrder();
	}
}
