package jd.cheng.sort;

import org.junit.Test;

/**
 * Merge sort: O(nlogn)
 * 
 * @author jucheng
 *
 */
@TimeComplexity("O(nlogn)")
public class JaredMergeSort implements JaredSort {

	@Override
	public int[] sort(int[] input) {
		if(null == input || input.length <= 1) {
			// no need sort
			return input;
		} else {
			return spliteAndMerge(input);
		}
	}

	@Test
	private int[] spliteAndMerge(int[] input) {
		// end recursion
		if(1 == input.length) {
			return input;
		}
		
		// split
		int lLength = input.length / 2;
		int rLength = input.length - lLength;
		int[] l = new int[lLength];
		int[] r = new int[rLength];
		
		for(int i=0; i<l.length; i++) {
			l[i] = input[i];
		}
		
		for(int i=lLength; i<input.length; i++) {
			r[i - lLength] = input[i];
		}
		
		// recursion
		l = spliteAndMerge(l);
		r = spliteAndMerge(r);
		
		// merge
		int[] result = new int[input.length];
		for(int i = 0,j = 0,k = 0; k < result.length; k++) {
			if(i >= l.length && j >= r.length) {
				break;
			} else if(i >= l.length) {
				result[k] = r[j];
				j++;
			} else if(j >= r.length) {
				result[k] = l[i];
				i++;
			} else {
				if(l[i] > r[j]) {
					result[k] = r[j];
					j++;
				} else {
					result[k] = l[i];
					i++;
				}
			}
		}
		
		return result;
	}
}
