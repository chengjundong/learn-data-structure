package jd.cheng.recursion;

public class RecursionArraySum {

	public static int sum(int[] input) {
		return sum(0, input);
	}

	private static int sum(int index, int[] input) {
		return index == input.length ? 0 
				: input[index] + sum(index+1, input);
	}
}
