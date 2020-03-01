package jd.cheng.sort;


/**
 * insertion sort, O(n^2)
 * 
 * @author jucheng
 *
 */
@TimeComplexity("O(n^2)")
public class JaredInsertionSort implements JaredSort {

	@Override
	public int[] sort(int[] input) {
		if(null == input || input.length <= 1) {
			// no need sort
			return input;
		} else {
			// do sort
			this.compareAndMove(input, 1);
			return input;
		}
	}

	/**
	 * Two ways to do insert selection:
	 * 1. compare and exchange: 3-times value assignment
	 * 2. compare and move: 1-time value assignment
	 * 
	 * @param input
	 * @param index
	 */
	private void compareAndMove(int[] input, int index) {
		// recursion end
		if(index >= input.length) {
			return;
		}
		
		// do compare and move
		// get the anchor
		int anchor = input[index];
		int i=index;
		for(; i > 0; i--) {
			// if the prev is greater than anchor, then move the copy the prev to present position
			if(input[i-1] > anchor) {
				input[i] = input[i-1];
			} else {
				break;
			}
		}
		
		// find the final position of the indexed number, put it in
		input[i] = anchor;
		
		this.compareAndMove(input, index+1);
	}
}
