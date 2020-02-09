package jd.cheng.tree.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JaredTrieTest {

	@Test
	public void test() throws Exception {
		JaredTrie trie = new JaredTrie();
		
		trie.add("jared");
		assertThat(trie.size()).isEqualTo(1);
		trie.add("jared");
		assertThat(trie.size()).isEqualTo(1);
		assertThat(trie.contains("jared")).isTrue();
		assertThat(trie.contains("jare")).isFalse();
		assertThat(trie.containsPrefix("jare")).isTrue();
		assertThat(trie.containsPrefix("jae")).isFalse();
	}
}
