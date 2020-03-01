package jd.cheng.sort;

/**
 * selection sort, O(n^2)
 * 
 * @author jucheng
 *
 */
@TimeComplexity("O(n^2)")
public class JaredSelectionSort implements JaredSort {

	@Override
	public int[] sort(int[] input) {
		if(null == input || input.length <= 1) {
			// no need sort
			return input;
		} else {
			this.selectAndExchange(input, 0);
			return input;
		}
	}
	
	/**
	 * select the smallest one start from index in input array, and exchange it with the number at index
	 * 
	 * @param input
	 * @param index
	 */
	private void selectAndExchange(int[] input, int index) {
		// recursion end
		if(index >= input.length) {
			return;
		}
		
		// find the smallest one
		int indexOfSmallest = index;
		for(int i=input.length - 1, smallest = input[index]; i > index; i--) {
			if(input[i] < smallest) {
				indexOfSmallest = i;
				smallest = input[i];
			}
		}
		
		// if the smallest one is not at index, do exchange
		if(indexOfSmallest != index) {
			swap(input, index, indexOfSmallest);
		}
		
		// recursion
		selectAndExchange(input, index+1);
	}
}
