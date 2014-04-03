package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
	private Graph graph;
	private boolean[] visited;

	public DepthFirstSearch(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.getNumberOfVertices()];
	}
	
	public List<Integer> runSearch(int vertex) {
		List<Integer> listVisits = new ArrayList<>();
		depthFirstVisit(vertex, visited, listVisits);

		return listVisits;
	}
	
	private void depthFirstVisit(Integer visit, boolean[] visited, List<Integer> listVisits) {
		if (!visited[visit]) {
			listVisits.add(visit);
			visited[visit] = true;
			Iterable<Integer> neighbors = graph.adj(visit);
			for (Integer next : neighbors) {
				depthFirstVisit(next, visited, listVisits);
			}
		}
	}

}
