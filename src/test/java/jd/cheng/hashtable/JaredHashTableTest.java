package jd.cheng.hashtable;

import static org.assertj.core.api.Assertions.*;

import java.util.UUID;

import org.junit.Test;

public class JaredHashTableTest {

	@Test
	public void test() throws Exception {
		JaredHashTable<String,Integer> hashTable = new JaredHashTable<>(1);
		
		assertThat(hashTable).extracting(JaredHashTable::size).isEqualTo(0);
		
		hashTable.put("hello", 1);
		assertThat(hashTable).extracting(JaredHashTable::size, t -> t.get("hello"))
			.containsExactly(1, 1);
		hashTable.put("hello", 2);
		assertThat(hashTable).extracting(JaredHashTable::size, t -> t.get("hello"))
			.containsExactly(1, 2);
		hashTable.put("world", 1);
		assertThat(hashTable).extracting(JaredHashTable::size, 
				t -> t.get("hello"),
				t -> t.contains("world"))
			.containsExactly(2, 2, true);
		hashTable.remove("world");
		assertThat(hashTable).extracting(JaredHashTable::size, 
				t -> t.get("hello"),
				t -> t.contains("world"))
			.containsExactly(1, 2, false);
		
		for(int i=0; i<100; i++) {
			hashTable.put(UUID.randomUUID().toString(), i);
		}
	}
}
