package jd.cheng.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Quick sort, O(nlogn)
 * 
 * @author jucheng
 *
 */
@TimeComplexity("O(nlogn)")
public class JaredQuickSort implements JaredSort {

	@Override
	public int[] sort(int[] input) {
		_sort3(input, 0, input.length-1);
		return input;
	}

	/**
	 * basic quick sort
	 * 
	 * @param input
	 * @param start
	 * @param end
	 */
	private void _sort(int[] input, int start, int end) {
		// recursion end
		if(1 > end-start) {
			return;
		}
		
		// get anchor
		int anchor = this.srand(input, start, end);
		int border = start;
		for(int i = start+1; i <= end; i++) {
			if(input[i] < anchor) {
				border++;
				if(i - border > 0) {					
					int t = input[i];
					input[i] = input[border];
					input[border] = t;
				}
			}
		}
		
		input[start] = input[border];
		input[border] = anchor;
		
		// continue
		_sort(input, start, border-1);
		_sort(input, border+1, end);
	}
	
	/**
	 * 2-ways quick sort
	 * 
	 * @param input
	 * @param start
	 * @param end
	 */
	private void _sort2(int[] input, int start, int end) {
		// recursion end
		if(1 > end-start) {
			return;
		}
		
		// get anchor
		int anchor = this.srand(input, start, end);
		int i=start+1, j=end;
		
		while(true) {
			while(i <= end && input[i] <= anchor) {
				i++;
			}
			while(j > start && input[j] >= anchor) {
				j--;
			}
			if(i > j) {
				break;
			}
			
			swap(input, i, j);
			i++;
			j--;
		}
		
		input[start] = input[j];
		input[j] = anchor;
		
		// continue
		_sort2(input, start, j-1);
		_sort2(input, j+1, end);
	}
	
	/**
	 * 3-ways quick sort
	 * 
	 * @param input
	 * @param start
	 * @param end
	 */
	private void _sort3(int[] input, int start, int end) {
		// recursion end
		if(1 > end-start) {
			return;
		}
		
		// get anchor
		int anchor = this.srand(input, start, end);
		int lt = start, gt = end+1;
		
		for(int i = start+1; i < gt; ) {
			if(anchor > input[i]) {
				swap(input, ++lt, i++);
			} else if(anchor < input[i]) {
				swap(input, --gt, i);
			} else {
				i++;
			}
		}
		
		swap(input, lt, start);
		
		// continue
		_sort3(input, start, --lt);
		_sort3(input, gt, end);
	}
	
	/**
	 * Randomly choose anchor
	 * 
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	private int srand(int[] input, int start, int end) {
		int index = ThreadLocalRandom.current().nextInt(start, end+1);
		swap(input, index, start);
		return input[start];
	}
}
