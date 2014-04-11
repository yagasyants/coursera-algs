package com.yagasyants.courseraalgs.mst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
	private List<List<Edge>> adjList;
	
	public EdgeWeightedGraph(int amountOfVertices){
		adjList = new ArrayList<>();
		for(int i=0; i<amountOfVertices; i++){
			adjList.add(new LinkedList<Edge>());
		}
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adjList.get(v).add(e);
		adjList.get(w).add(e);
	}

	public Iterable<Edge> adj(int i) {
		return adjList.get(i);
	}
	
	public int V() {
		return adjList.size();
	}

}
