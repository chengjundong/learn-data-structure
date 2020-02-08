package jd.cheng.tree.segmenttree;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredSegmentTreeTest {

	@Test
	public void test() throws Exception {
		Integer[] a = new Integer[] {1,2,3,4,5,6,7,8,9};
		JaredSegmentTree<Integer> tree = new JaredSegmentTree<>(a, (x, y) -> x+y);
		
		assertThat(tree.size()).isEqualTo(9);
		tree.print();
		
		assertThat(tree.query(0, 1)).isEqualTo(3);
		assertThat(tree.query(1, 4)).isEqualTo(14);
		
		tree.set(5, 10);
		tree.print();
	}
}
