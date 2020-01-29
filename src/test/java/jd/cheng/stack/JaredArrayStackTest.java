package jd.cheng.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JaredArrayStackTest {

	@Test
	public void test() throws Exception {
		JaredArrayStack stack = new JaredArrayStack(4);
		
		assertThat(stack.isEmpty()).isTrue();
		assertThat(stack.showCapacity()).isEqualTo(4);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack);
		
		assertThat(stack.peek()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.peek()).isEqualTo(2);
		
		System.out.println(stack);
	}
}
