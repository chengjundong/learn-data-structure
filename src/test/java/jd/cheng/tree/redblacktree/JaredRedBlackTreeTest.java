package jd.cheng.tree.redblacktree;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.google.common.base.Stopwatch;

import jd.cheng.hashtable.JaredHashTable;
import jd.cheng.tree.avl.JaredAVL;
import jd.cheng.tree.avl.JaredAVLTest;

public class JaredRedBlackTreeTest {

	@Test
	public void test1() throws Exception {
		JaredRedBlackTree<Integer, String> rbtree = new JaredRedBlackTree<>();
		
		rbtree.add(37, "37");
		rbtree.add(42, "42");
		rbtree.add(52, "52");
		
		rbtree.preOrder();
	}
	
	@Test
	public void test2() throws Exception {
		JaredRedBlackTree<String, Integer> rbtree = new JaredRedBlackTree<>();
		
		// load a novel into AVL
		List<String> words = new ArrayList<>();
		try(InputStream is = JaredAVLTest.class.getResourceAsStream("/Grandet.txt")) {
			for(String word : IOUtils.toString(is, StandardCharsets.UTF_8).split(" ")) {
				words.add(word);
			}
		}
		
		// red-black tree
		Stopwatch sw = Stopwatch.createStarted();
		for(String word : words) {
			if(rbtree.contains(word)) {
				rbtree.set(word, rbtree.get(word)+1);
			} else {
				rbtree.add(word, 1);
			}
		}
		
		System.out.println(rbtree.size());
		System.out.println("red-black ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
	} 
	
	@Test
	public void testAVLAndRedBlackAndHashTable() throws Exception {
		JaredRedBlackTree<String, Integer> rbtree = new JaredRedBlackTree<>();
		JaredAVL<String, Integer> avl = new JaredAVL<>();
		JaredHashTable<String,Integer> hashTable = new JaredHashTable<>();
		
		// load a novel
		List<String> words = new ArrayList<>();
		try(InputStream is = JaredAVLTest.class.getResourceAsStream("/Grandet.txt")) {
			for(String word : IOUtils.toString(is, StandardCharsets.UTF_8).split(" ")) {
				words.add(word);
			}
		}
		
		// compare add
		// red-black tree
		Stopwatch sw = Stopwatch.createStarted();
		for(String word : words) {
			if(rbtree.contains(word)) {
				rbtree.set(word, rbtree.get(word)+1);
			} else {
				rbtree.add(word, 1);
			}
		}
		
		System.out.println("red-black ADD ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		// avl
		sw.reset().start();
		for(String word : words) {
			if(avl.contains(word)) {
				avl.set(word, avl.get(word)+1);
			} else {
				avl.add(word, 1);
			}
		}
		
		System.out.println("AVL ADD ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		// hashtable
		sw.reset().start();
		for(String word : words) {
			if(hashTable.contains(word)) {
				hashTable.put(word, hashTable.get(word)+1);
			} else {
				hashTable.put(word, 1);
			}
		}
		
		System.out.println("HashTable ADD ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		assertThat(rbtree.size()).isEqualTo(avl.size()).isEqualTo(hashTable.size());
		
		// compare query
		sw.reset().start();
		for(int i=10; i>0; i--) {
			for(String word : words) {
				rbtree.get(word);
			}
		}
		System.out.println("red-black FIND ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		sw.reset().start();
		for(int i=10; i>0; i--) {
			for(String word : words) {
				avl.get(word);
			}
		}
		System.out.println("AVL FIND ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
		
		sw.reset().start();
		for(int i=10; i>0; i--) {
			for(String word : words) {
				hashTable.get(word);
			}
		}
		System.out.println("HashTable FIND ms: " + sw.stop().elapsed(TimeUnit.MILLISECONDS));
	}
}
