package com.yagasyants.courseraalgs.graph;

import java.util.LinkedList;
import java.util.List;

public class StrongComponents {
	private Digraph graph;

	public StrongComponents(Digraph graph) {
		this.graph = graph;
	}

	public Integer[] runSearch() {
		List<Integer> reversedPostOrder = reversedPostOrder();
		
		Integer[] comps = new Integer[graph.V()];
		DepthFirstSearch dfs = new DepthFirstSearch(graph);

		int component = 0;
		for (Integer i : reversedPostOrder) {
			if (comps[i] == null) {
				List<Integer> vertexInComponent = dfs.runSearch(i);
				for (Integer vertex : vertexInComponent) {
					comps[vertex] = component;
				}
				component++;
			}
		}
		return comps;
	}
	
	private List<Integer> reversedPostOrder(){
		Digraph reversed = graph.reverse();
		List<Integer> listReversedPO = new LinkedList<>();
		boolean[] visited = new boolean[reversed.V()];
		for (int i = 0; i < reversed.V(); i++) {
			if (!visited[i]) {
				depthFirstVisit(i, visited, listReversedPO, reversed);
			}
		}

		return listReversedPO;
	}

	private void depthFirstVisit(Integer visit, boolean[] visited, List<Integer> list, Digraph reversed) {
		if (!visited[visit]) {
			visited[visit] = true;
			Iterable<Integer> neighbors = reversed.adj(visit);
			for (Integer next : neighbors) {
				depthFirstVisit(next, visited, list, reversed);
			}
			list.add(0, visit);
		}
	}

}
