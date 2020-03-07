package jd.cheng.sort;

import java.util.StringJoiner;

public interface JaredSort {

	/**
	 * @param input 
	 * @return sorted array
	 */
	int[] sort(int[] input);
	
	/**
	 * swap the number at index X and index Y in input array
	 * 
	 * @param input
	 * @param x
	 * @param y
	 */
	default void swap(int[] input, int x, int y) {
		int temp = input[x];
		input[x] = input[y];
		input[y] = temp;
	}
	
	default void print(int[] arr) {
		StringJoiner sj = new StringJoiner(",");
		for(int i : arr) {
			sj.add(String.valueOf(i));
		}
		System.out.println(sj.toString());
	}
}
