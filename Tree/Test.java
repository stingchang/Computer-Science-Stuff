/*
 * Author: Sting Chang
 * Date: 07/07/2016
 * */

package com.sting.test.tree;

import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		TreeManager<Integer> m = new TreeManager<>();
		Random random = new Random();

		int size = random.nextInt(20);
		System.out.println("Build a tree with size " + size);
		for (int i = 0; i < size; i++) {
			int value = random.nextInt(40);
			System.out.print(value + " ");
			m.insert(value);
		}
		
		System.out.print("\n\n");
		List<Integer> list = null;
		list = m.bfsTraversal();
		System.out.print("BFS: "+list);

		System.out.print("\n\n");
		list = null;
		list = m.dfsTraversal();
		System.out.print("DFS: "+list);
		
		System.out.print("\n\n");
		list = null;
		list = m.inorderTraversal();
		System.out.print("In Order: "+list);

		System.out.print("\n\n");
		list = null;
		list = m.preorderTraversal();
		System.out.print("Pre Order: "+list);
		
		System.out.print("\n\n");
		list = null;
		list = m.postorderTraversal();
		System.out.print("Post Order: "+list);
	
	}
}
