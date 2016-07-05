package com.sting.practice.algorithmds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 19. How to find if there is a sub array with sum equal to zero?
 * There is whole set of array related questions which are based upon sub-array or only selective elements of array 
 * e.g. from some range, this is one of such problem. 
 * Here you are given an array of positive and negative numbers, find if there is a sub-array with 0 sum.
 * Examples:
 * Input: {4, 2, -3, 1, 6}
 * Output: true 
 * There is a sub-array with zero sum from index 1 to 3.
 * 
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * */

/*
 * Calculate sum form 0 to current position and put into map.
 * If current value is 0 or current sum is in map, return true.
 * (From map.get(sum)+1 to current is the sub array). 
 *  Ex:
 *  original =  [1, 4, 4, -6, 4, -2] 
 *  sum array = [1, 5, 9,  3, 7, 5]
 *  [4, -6, 4, -2]
 * */
public class SubSetZero {

	public void zeroSubArray(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		if (array[0] == 0) {
			System.out.println("0 at position " + 0);
			return;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] == 0) {
				System.out.println("0 at position " + i);
				return;
			}
			array[i] += array[i - 1];
			if (map.containsKey(array[i])) {
				System.out.println("0 sum from " + (map.get(array[i]) + 1) + " to " + i);
				return;
			}
			map.put(array[i], i);
		}
	}

}
