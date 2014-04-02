package com.yagasyants.courseraalgs.graph;

import java.util.List;

public class ConnectedComponents {
	private Graph graph;

	public ConnectedComponents(Graph graph) {
		this.graph = graph;
	}

	public Integer[] runSearch() {
		Integer[] comps = new Integer[graph.getNumberOfVertices()];

		int component = 0;
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			if (comps[i] == null) {
				DepthFirstSearch dfs = new DepthFirstSearch(graph);
				List<Integer> vertexInComponent = dfs.runSearch(i);
				for (Integer vertex : vertexInComponent) {
					comps[vertex] = component;
				}
				component++;
			}
		}
		return comps;
	}

}