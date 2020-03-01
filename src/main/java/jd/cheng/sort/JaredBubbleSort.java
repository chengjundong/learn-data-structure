package jd.cheng.sort;

/**
 * Bubble sort, O(n^2)
 * 
 * @author jucheng
 *
 */
@TimeComplexity("O(n^2)")
public class JaredBubbleSort implements JaredSort {

	@Override
	public int[] sort(int[] input) {
		if(null == input || input.length <= 1) {
			// no need sort
			return input;
		} else {
			compareAndExchange(input, 0);
			return input;
		}
	}

	/**
	 * use the present to compare to the prev, if prev gt present, then exchange
	 * 
	 * @param input
	 * @param index
	 */
	private void compareAndExchange(int[] input, int index) {
		// end recursion
		if(index >= input.length) {
			return;
		}
		
		int swapCount = 0;
		for(int i=input.length-1; i>index; i--) {
			if(input[i] < input[i-1]) {
				swap(input, i, i-1);
				swapCount++;
			}
		}
		
		if(swapCount > 0) {			
			this.compareAndExchange(input, index+1);
		}
	}
}
