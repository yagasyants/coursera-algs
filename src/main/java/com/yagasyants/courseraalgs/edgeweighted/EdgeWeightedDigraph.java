package com.yagasyants.courseraalgs.edgeweighted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yagasyants.courseraalgs.graph.AbstractGraph;

public class EdgeWeightedDigraph implements AbstractGraph {
	private List<List<DirectedEdge>> adjList;

	public EdgeWeightedDigraph(int amountOfVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < amountOfVertices; i++) {
			adjList.add(new LinkedList<DirectedEdge>());
		}
	}

	public void addEdge(DirectedEdge e) {
		int v = e.from();
		adjList.get(v).add(e);
	}

	public Iterable<DirectedEdge> adj(int i) {
		return adjList.get(i);
	}

	public int V() {
		return adjList.size();
	}

	@Override
	public Iterable<Integer> adjVertices(int v) {
		Iterable<DirectedEdge> adjEdges = adj(v);
		List<Integer> adjVertices = new LinkedList<>();
		for(DirectedEdge edge : adjEdges){
			adjVertices.add(edge.to());
		}
		return adjVertices;
	}
}
