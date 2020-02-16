package jd.cheng.map;

import static org.assertj.core.api.Assertions.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.google.common.base.Stopwatch;

import jd.cheng.tree.avl.JaredAVLMap;
import jd.cheng.tree.avl.JaredAVLTest;

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
	
	@Test
	public void testPerformance() throws Exception {
		// load a novel into AVL
		List<String> words = new ArrayList<>();
		try(InputStream is = JaredAVLTest.class.getResourceAsStream("/Grandet.txt")) {
			for(String word : IOUtils.toString(is, StandardCharsets.UTF_8).split(" ")) {
				words.add(word);
			}
		}
		// sort
		Collections.sort(words);
		
		JaredLinkedListMap<String, Integer> lMap = new JaredLinkedListMap<>();
		Stopwatch sw = Stopwatch.createStarted();
		for(String word : words) {
			if(lMap.contains(word)) {
				lMap.set(word, lMap.get(word)+1);
			} else {
				lMap.put(word, 1);
			}
		}
		System.out.println("linked list map: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		JaredTreeMap<String, Integer> bstMap = new JaredTreeMap<>();
		sw.reset().start();
		for(String word : words) {
			if(bstMap.contains(word)) {
				bstMap.set(word, bstMap.get(word)+1);
			} else {
				bstMap.put(word, 1);
			}
		}
		System.out.println("BST map: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		JaredAVLMap<String, Integer> avlMap = new JaredAVLMap<>();
		sw.reset().start();
		for(String word : words) {
			if(avlMap.contains(word)) {
				avlMap.set(word, avlMap.get(word)+1);
			} else {
				avlMap.put(word, 1);
			}
		}
		System.out.println("AVL map: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		Map<String, Integer> javaMap = new HashMap<String, Integer>();
		sw.reset().start();
		for(String word : words) {
			if(javaMap.containsKey(word)) {
				javaMap.put(word, javaMap.get(word)+1);
			} else {
				javaMap.put(word, 1);
			}
		}
		System.out.println("JAVA hashmap: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
	}
}
