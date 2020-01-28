package jd.cheng.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class JaredArrayTest {

	@Test
	public void test() throws Exception {
		JaredArray arr = new JaredArray(3);
		
		assertThat(arr.isEmpty()).isTrue();
		
		arr.addFirst(0);
		arr.add(1, 1);
		arr.addLast(2);
		
		assertThat(catchThrowable(() -> arr.get(100))).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("input index is invalid");
		assertThat(arr.get(0)).isEqualTo(0);
		assertThat(arr.get(1)).isEqualTo(1);
		assertThat(arr.get(2)).isEqualTo(2);
		assertThat(catchThrowable(() -> arr.addLast(3))).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("fail to add because array is full!");
	}
}
