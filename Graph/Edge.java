package com.sting.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

public class Edge {
	private Set<Edge> adjList;
	private String name;
	private State state;

	public Edge(String name) {
		adjList = new HashSet<>();
		this.name = name;
		setState(State.NOTVISITED);
	}

	public String getName() {
		return name;
	}

	public void addNeighbor(Edge edge) {
		adjList.add(edge);
	}

	public Set<Edge> getNeighbors() {
		return adjList;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
