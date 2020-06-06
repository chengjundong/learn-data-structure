package jd.cheng.leetcode.offer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution04 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// validation
		if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		} else if(target < matrix[0][0]) {
			return false;
		}
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		// find the possible lines
		List<Integer> lines = new ArrayList<>(n);
		for(int i=0; i < n; i++) {
			if(matrix[i][0] == target || matrix[i][m-1] == target) {
				return true;
			}
			
			if(matrix[i][0] < target && matrix[i][m-1] > target) {
				lines.add(i);
			}
		}
		
		// no candidates
		if(lines.isEmpty()) {
			return false;
		}
		
		int start = lines.get(0);
		int end = lines.get(lines.size()-1);
		for(int i = start; i <= end; i++) {
			boolean result = _find(matrix[i], target, 0, m-1);
			if(result) {
				return true;
			}
		}
		
		return false;
    }
	
	// binary search
	public boolean _find(int[] arr, int target, int start, int end) {
		if(start > end) {
			return false;
		}
		
		int mid = start + (end-start)/2;
		
		if(target == arr[mid]) {
			return true;
		} else if(target > arr[mid]) {
			return _find(arr, target, mid+1, end);
		} else {
			return _find(arr, target, start, mid-1);
		}
	}
	
	@Test
	public void test() {
		/**
		 * 
		 * [
			  [1,   4,  7, 11, 15],
			  [2,   5,  8, 12, 19],
			  [3,   6,  9, 16, 22],
			  [10, 13, 14, 17, 24],
			  [18, 21, 23, 26, 30]
			]
		 * 
		 */
		int[][] data = new int[][] {
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30},
		};
		
		assertTrue(this.findNumberIn2DArray(data, 5));
		assertFalse(this.findNumberIn2DArray(data, 20));
		assertFalse(this.findNumberIn2DArray(new int[][] {}, 0));
	}
}
