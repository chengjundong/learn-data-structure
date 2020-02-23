package jd.cheng.tree.avl;

import static org.assertj.core.api.Assertions.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.google.common.base.Stopwatch;

public class JaredAVLTest {

	@Test
	public void test() throws Exception {
		JaredAVL<String, Integer> avl = new JaredAVL<>();
		
		// load a novel into AVL
		List<String> words = new ArrayList<>();
		try(InputStream is = JaredAVLTest.class.getResourceAsStream("/Grandet.txt")) {
			for(String word : IOUtils.toString(is, StandardCharsets.UTF_8).split(" ")) {
				words.add(word);
			}
		}
		
		// AVL
		Stopwatch sw = Stopwatch.createStarted();
		for(String word : words) {
			if(avl.contains(word)) {
				avl.set(word, avl.get(word)+1);
			} else {
				avl.add(word, 1);
			}
		}
		
		System.out.println(avl.size());
		System.out.println("AVL ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		// check AVL status after init
		assertThat(avl.isBinarySearchTree()).isTrue();
		assertThat(avl.isBalanced()).isTrue();
		
		// test remove
		Set<String> hWords = new HashSet<>(words);
		for(String word : hWords) {
			avl.remove(word);
			// each time after remove, we should check whether it is balanced
			assertThat(avl.isBinarySearchTree()).isTrue();
			assertThat(avl.isBalanced()).isTrue();
		}
		
		assertThat(avl.isEmpty()).isTrue();
	}
	
	@Test
	public void test2() {
		JaredAVL<Integer, String> avl = new JaredAVL<>();
		
		avl.add(10, "dybala");
		avl.add(7, "ronaldo");
		avl.add(1, "ccc");
		avl.add(11, "costa");
		avl.add(77, "buffon");
		avl.add(9, "");
		avl.add(8, "");
		
		assertThat(avl.isBinarySearchTree()).isTrue();
		assertThat(avl.isBalanced()).isTrue();
	}
}
