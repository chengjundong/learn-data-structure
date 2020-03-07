package jd.cheng.sort;

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
			spliteAndMerge(input, 0, input.length-1);
			return input;
		}
	}

	// optimization, we could use insertion sort when the length is very low
	private void spliteAndMerge(int[] input, int start, int end) {
		// end recursion
		if(start >= end) {
			return;
		}
		
		int mid = start + (end-start)/2;
		
		// recursion
		// split into two parts: left and right
		spliteAndMerge(input, start, mid);
		spliteAndMerge(input, mid+1, end);
		
		// merge
		// it is an optimization, when the max of left is smaller than the min of right
		// we don't need to do merge because it is already sorted
		if(input[mid] > input[mid+1]) {			
			merge(input, start, mid, end);
		}
	}
	
	private void merge(int[] input, int start, int mid, int end) {
		// merge
		int[] result = new int[end-start+1];
		for(int i = start,j = mid+1,k = 0; k < result.length; k++) {
			if(i > mid && j > end) {
				break;
			} else if(i > mid) {
				result[k] = input[j];
				j++;
			} else if(j > end) {
				result[k] = input[i];
				i++;
			} else {
				if(input[i] > input[j]) {
					result[k] = input[j];
					j++;
				} else {
					result[k] = input[i];
					i++;
				}
			}
		}
		// copy to original array
		for(int x=0, y=start; x<result.length; x++, y++) {
			input[y] = result[x];
		}
	}
}
