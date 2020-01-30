package jd.cheng.linkedlist;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredLinkedListStackTest {

	@Test
	public void test() throws Exception {
		JaredLinkedListStack stack = new JaredLinkedListStack();
		
		assertThat(stack)
			.extracting(JaredLinkedListStack::size,JaredLinkedListStack::isEmpty)
			.containsExactly(0, true);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// 3 -> 2 -> 1
		stack.print();
		assertThat(stack.peek()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.peek()).isEqualTo(1);
		assertThat(stack)
			.extracting(JaredLinkedListStack::size,JaredLinkedListStack::isEmpty)
			.containsExactly(1, false);
	}
}
