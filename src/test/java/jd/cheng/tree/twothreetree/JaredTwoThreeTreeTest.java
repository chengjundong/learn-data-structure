package jd.cheng.tree.twothreetree;

import static org.assertj.core.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("unfinished implementation")
public class JaredTwoThreeTreeTest {

	@Test
	public void test() throws Exception {
		JaredTwoThreeTree _23tree = new JaredTwoThreeTree();
		
		assertThat(_23tree.size()).isEqualTo(0);
		assertThat(_23tree.isAbsoluteBalance()).isTrue();
		
		assertThat(_23tree.add(10).isAbsoluteBalance()).isTrue();
		assertThat(_23tree.add(11).isAbsoluteBalance()).isTrue();
		assertThat(_23tree.add(9).isAbsoluteBalance()).isTrue();
		
		System.out.println(_23tree);
	}
}
