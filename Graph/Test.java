/*
 * Author: Sting Chang
 * Date: 07/06/2016
 * */

package com.sting.algorithm.graph;

public class Test {
	public static void main(String[] args) {
		BasicGraph graph = new BasicGraph();
		String[] edges = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q" };

		for (int i = 0; i <= 6; i++) {
			graph.addEdge(edges[i]);
		}

		graph.addVertex("A", "B");
		graph.addVertex("A", "C");
		graph.addVertex("B", "C");
		graph.addVertex("B", "F");
		graph.addVertex("B", "E");
		graph.addVertex("C", "E");
		graph.addVertex("C", "D");
		graph.addVertex("D", "G");
		graph.addVertex("D", "E");
		graph.addVertex("F", "G");
		
		graph.addEdge("K");
		graph.addEdge("L");
		graph.addEdge("M");
		graph.addVertex("L", "M");
		graph.addVertex("L", "K");
		graph.printGraph();
		
		System.out.println();
		
		boolean isConnected = graph.hasPathBFS("A", "G");
		System.out.println("BFS: A and G has a path: "+isConnected);
		isConnected = graph.hasPathBFS("A", "M");
		System.out.println("BFS: A and M has a path: "+isConnected);
	
		isConnected = graph.hasPathDFS("A", "D");
		System.out.println("DFS: A and D has a path: "+isConnected);
		isConnected = graph.hasPathDFS("A", "M");
		System.out.println("DFS: A and M has a path: "+isConnected);
		
		
		System.out.println("\n\nTest find path algorithm using Dijkstra");
		graph.shortestPath("A", "G");
	}
}
