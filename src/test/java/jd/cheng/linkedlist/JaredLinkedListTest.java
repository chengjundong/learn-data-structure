package jd.cheng.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JaredLinkedListTest {

	@Test
	public void test() throws Exception {
		JaredLinkedList<Integer> list = new JaredLinkedList<>();
		
		assertThat(list.size()).isZero();
		list.addFirst(10);
		assertThat(list.size()).isEqualTo(1);
		
		// fill data
		list.addFirst(20);
		list.addFirst(30);
		// now, it should be 30 -> 20 -> 10
		// we want to insert 50 before 10
		// then, it should be 30 -> 20 -> 50 -> 10
		list.add(2, 50);
		// then, add 60 at tail
		// 30 -> 20 -> 50 -> 10 -> 60
		list.addLast(60);
		assertThat(list.getTail()).isEqualTo(60);
		list.print();
		
		assertThat(list.get(3)).isEqualTo(10);
		list.set(3, 70);
		assertThat(list.get(3)).isEqualTo(70);
		assertThat(list.contains(100)).isFalse();
		assertThat(list.contains(60)).isTrue();
		assertThat(list.size()).isEqualTo(5);
		
		assertThat(list.remove(1)).isEqualTo(20);
		assertThat(list.size()).isEqualTo(4);
		assertThat(list.removeLast()).isEqualTo(60);
		assertThat(list.size()).isEqualTo(3);
		// 30 -> 50 -> 70
		list.print();
		assertThat(list.getTail()).isEqualTo(70);
		assertThat(list.removeLast()).isEqualTo(70);
		assertThat(list.getTail()).isEqualTo(50);
	}
}
