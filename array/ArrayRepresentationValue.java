package com.sting.practice.algorithmds.array;

import java.util.Set;
import java.util.TreeSet;

/*
 * Question: How to find the smallest positive integer value that cannot be represented as sum of any subset of a given array?
 * Solution should be O(n)
 * */
// Examples:
// Input:  arr[] = {1, 3, 6, 10, 11, 15};	Output: 2
// Input:  arr[] = {1, 1, 1, 1};			Output: 5
// Input:  arr[] = {1, 1, 3, 4};			Output: 10
// Input:  arr[] = {1, 2, 5, 10, 20, 40};	Output: 4
// Input:  arr[] = {1, 2, 3, 4, 5, 6};		Output: 22

/*
 * Thought: Create a set, put first value in it. 
 * For each rest value, put it into set then traverse the set and all all element with its own and put back to set
 * ex: [1 2 3]
 * set -> [1]
 * set -> [1, 2, 3]
 * set -> [1, 2, 3, 4, 5, 6]
 * */
public class ArrayRepresentationValue {
	public static int minValue(int[] arr) {
		if (arr == null || arr.length <= 1)
			return 1;

		Set<Integer> set = new TreeSet<>();
		for (int i : arr) {
			for (int v : set) {
				set.add(i + v);
			}
			set.add(i);
		}

		Object[] sumArr = set.toArray();
		for (int i = 0; i < sumArr.length - 1; i++) {
			if ((int) sumArr[i + 1] - (int) sumArr[i] > 1)
				return (int) sumArr[i] + 1;
		}

		return set.size() + 1;
	}
}
