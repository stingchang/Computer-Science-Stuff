package com.sting.practice.algorithmds.array;

import java.util.HashMap;
import java.util.Map;

/*
	Find subarray with given sum | Set 1 (Nonnegative Numbers)
	Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
	
	Examples:
	
	Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Ouptut: Sum found between indexes 2 and 4
	
	Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
	Ouptut: Sum found between indexes 1 and 4
	
	Input: arr[] = {1, 4}, sum = 0
	Output: No subarray found
	There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
 
 	http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * */

public class SubArraySum {
	public void subArraySum(int[] array, int value) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				System.out.println("Position " + i + " is " + value);
				return;
			}
			int diff = value - array[i];
			if (map.containsKey(diff)) {
				System.out.println("Position " + i + " to " + (map.get(diff) + 1) + " sum up to " + value);
				return;
			}
			map.put(array[i], i);
		}
	}
}
