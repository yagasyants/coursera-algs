package com.yagasyants.courseraalgs.graph;

import java.util.List;

public class ConnectedComponents {
	private UndirGraph graph;

	public ConnectedComponents(UndirGraph graph) {
		this.graph = graph;
	}

	public Integer[] runSearch() {
		Integer[] comps = new Integer[graph.V()];

		int component = 0;
		for (int i = 0; i < graph.V(); i++) {
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
