/*
 * Author: Sting Chang
 * Date: 07/06/2016
 * */

package com.sting.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicGraph {
	// Edges and their adjacency list
	private Map<String, Edge> map;

	public BasicGraph() {
		map = new HashMap<>();
	}

	public void addEdge(String name) {
		if (!map.containsKey(name)) {
			Edge edge = new Edge(name);
			map.put(name, edge);
			System.out.println("Added " + name);
		}
	}

	public Edge getEdge(String name) {
		return map.get(name);
	}

	public void addVertex(String edge1, String edge2) {
		// for undirected graph, we add edge1 to edge2 and edge2 to edge1
		if (!map.containsKey(edge1)) {
			System.out.println("No such edge " + edge1);
			return;
		}
		if (!map.containsKey(edge2)) {
			System.out.println("No such edge " + edge2);
			return;
		}

		map.get(edge1).addNeighbor(map.get(edge2));
		map.get(edge2).addNeighbor(map.get(edge1));
	}

	public boolean hasPathBFS(String edge1, String edge2) {
		if (edge1 == edge2)
			return true;

		for (Edge e : map.values()) {
			e.setState(State.NOTVISITED);
		}
		Deque<Edge> queue = new ArrayDeque<>();
		Edge current = map.get(edge1);
		current.setState(State.VISITED);
		queue.addLast(current);

		Edge target = map.get(edge2);

		return bfsHelper(queue, target);
	}

	private boolean bfsHelper(Deque<Edge> queue, Edge target) {

		if (queue.isEmpty()) {
			return false;
		}
		Edge e = queue.removeFirst();
		if (e.getName() == target.getName()) {
			return true;
		}
		e.setState(State.VISITED);
		for (Edge neighbor : e.getNeighbors()) {
			if (neighbor.getState() == State.NOTVISITED)
				queue.addLast(neighbor);
		}
		return bfsHelper(queue, target);

	}

	public boolean hasPathDFS(String edge1, String edge2) {
		if (edge1 == edge2)
			return true;

		for (Edge e : map.values()) {
			e.setState(State.NOTVISITED);
		}

		Deque<Edge> stack = new ArrayDeque();
		Edge start = getEdge(edge1);
		Edge end = getEdge(edge1);
		stack.add(start);
		return dfsHeloper(stack, end);
	}

	private boolean dfsHeloper(Deque<Edge> stack, Edge end) {
		if (stack.isEmpty())
			return false;

		Edge edge = stack.removeFirst();
		if (edge == end) {
			return true;
		}
		for (Edge e : edge.getNeighbors()) {
			if (e.getState() == State.NOTVISITED) {
				stack.addFirst(e);
			}
		}
		edge.setState(State.VISITED);
		return dfsHeloper(stack, end);
	}

	// Use Dijkstra's algorithm with each vertex weights 1
	// 1. Use an array map to track distance from start to current edge
	// 2. For neighbors of start, set distance = 1, others set -1
	// 3. Add all edges other than start into a set notVisited
	// 4. Remove an edge e with min weight from notVisited, mark all its non
	// visited neighbors's
	// distance as e's distance + 1
	// 5. Repeat step 4 until notVisited
	public void shortestPath(String start, String end) {
		List<String> list = new ArrayList<String>();
		list.add(start);

		// step 1, use map instead of array
		Edge s = getEdge(start);
		// Edge endEdge = getEdge(start);
		Map<Edge, Integer> dist = new HashMap<>();
		Set<String> notVisited = new HashSet<>();
		Map<Edge, Edge> previous = new HashMap<>();
		// 2. 3. set distance from start to each edge and add them to
		// noVisitedMap
		System.out.println("Step 2");
		for (Edge e : map.values()) {
			if (e == s) {
				dist.put(e, 0);
			}
			if (s.getNeighbors().contains(e)) {
				notVisited.add(e.getName());

				dist.put(e, 1);
				previous.put(e, s);
			} else {
				dist.put(e, -1);
			}
		}
		dist.put(s, 0);
		shortestPathHelper(dist, notVisited, previous);

		Edge e = getEdge(end);
		if (!previous.containsKey(e)) {
			System.out.println("No path between " + s.getName() + " and " + e.getName());
		}
		while (previous.containsKey(e)) {
			System.out.print(e.getName() + "->");
			e = previous.get(e);
		}
		System.out.print(s.getName());
	}

	private void shortestPathHelper(Map<Edge, Integer> dist, Set<String> notVisited, Map<Edge, Edge> previous) {
		// 4.1. find a minDistance edge
		int minDist = Integer.MAX_VALUE;
		String edge = "";
		for (String e : notVisited) {
			if (dist.get(getEdge(e)) < minDist && dist.get(getEdge(e)) != -1) {
				minDist = dist.get(getEdge(e));
				edge = e;
			}
		}

		// all reachable edges were traversed
		if (edge == "") {
			return;
		}

		;

		// 4.2 traverse its neighbors
		Edge cur = getEdge(edge);
		for (Edge n : cur.getNeighbors()) {
			if (!notVisited.contains(n) && dist.get(n) < 0) {
				dist.put(n, dist.get(cur) + 1);
				previous.put(n, cur);
				notVisited.add(n.getName());
			}
		}

		notVisited.remove(edge);
		shortestPathHelper(dist, notVisited, previous);
	}

	public void printGraph() {
		for (Map.Entry<String, Edge> entry : map.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for (Edge e : entry.getValue().getNeighbors()) {
				System.out.print(e.getName() + " ");
			}
			System.out.println();
		}
	}

}
