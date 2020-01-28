package jd.cheng.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class JaredArrayTest {

	@Test
	public void test() throws Exception {
		JaredArray arr = new JaredArray(3);

		assertThat(arr.isEmpty()).isTrue();

		// test add
		arr.addFirst(0);
		arr.add(1, 1);
		arr.addLast(2);

		assertThat(catchThrowable(() -> arr.get(100))).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("input index is invalid");
		assertThat(arr).extracting(JaredArray::size).isEqualTo(3);
		System.out.println(arr);

		// test enlarge
		arr.addLast(4);
		assertThat(arr).extracting(JaredArray::size, JaredArray::showCapacity).containsExactly(4, 6);
		System.out.println(arr);

		// test remove & shrink
		assertThat(arr.remove(1)).isEqualTo(1);
		assertThat(arr).extracting(JaredArray::size, JaredArray::showCapacity).containsExactly(3, 6);
		System.out.println(arr);
	}
}
