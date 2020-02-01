package jd.cheng.map;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class JaredMapTest {

	@Test
	public void testJaredLinkedListMap() throws Exception {
		JaredLinkedListMap<String, Integer> map = new JaredLinkedListMap<>();
		
		assertThat(map.isEmpty()).isTrue();
		assertThat(map.size()).isEqualTo(0);
		
		map.put("a", (int)'a');
		map.put("a", (int)'a');
		map.put("a", (int)'a');
		map.put("b", (int)'b');
		map.put("c", (int)'c');
		
		assertThat(map.size()).isEqualTo(3);
		assertThat(map.get("a")).isEqualTo((int)'a');
		assertThat(map.get("c")).isEqualTo((int)'c');
		map.set("c", 0);
		assertThat(map.get("c")).isEqualTo(0);
		assertThat(map.remove("b")).isEqualTo((int)'b');
		assertThat(map.contains("c")).isTrue();
		map.put("c", (int)'c');
		assertThat(map.size()).isEqualTo(2);
	}
	
	@Test
	public void testJaredTreeMap() throws Exception {
		JaredTreeMap<String, Integer> map = new JaredTreeMap<>();
		
		assertThat(map.isEmpty()).isTrue();
		assertThat(map.size()).isEqualTo(0);
		
		map.put("a", (int)'a');
		map.put("a", (int)'a');
		map.put("a", (int)'a');
		map.put("b", (int)'b');
		map.put("c", (int)'c');
		
		assertThat(map.size()).isEqualTo(3);
		assertThat(map.get("a")).isEqualTo((int)'a');
		assertThat(map.get("c")).isEqualTo((int)'c');
		map.set("c", 0);
		assertThat(map.get("c")).isEqualTo(0);
		assertThat(map.remove("b")).isEqualTo((int)'b');
		assertThat(map.contains("c")).isTrue();
		map.put("c", (int)'c');
		assertThat(map.size()).isEqualTo(2);
	}
}
