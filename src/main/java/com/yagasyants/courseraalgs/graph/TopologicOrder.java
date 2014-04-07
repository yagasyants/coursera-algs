package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicOrder {
	private Digraph graph;

	public TopologicOrder(Digraph graph) {
		this.graph = graph;
	}

	public List<Integer> runSearch() {
		boolean[] visited = new boolean[graph.V()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < graph.V(); i++) {
			if (!visited[i]) {
				depthFirstVisit(i, visited, stack);
			}
		}

		return toList(stack);
	}

	private List<Integer> toList(Stack<Integer> stack) {
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

	private void depthFirstVisit(Integer visit, boolean[] visited, Stack<Integer> stack) {
		if (!visited[visit]) {
			visited[visit] = true;
			Iterable<Integer> neighbors = graph.adj(visit);
			for (Integer next : neighbors) {
				depthFirstVisit(next, visited, stack);
			}
			stack.add(visit);
		}
	}

}
