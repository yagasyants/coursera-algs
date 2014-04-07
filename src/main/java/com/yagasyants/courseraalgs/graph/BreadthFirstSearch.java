package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	private Graph graph;

	public BreadthFirstSearch(Graph graph) {
		this.graph = graph;
	}

	public List<Integer> runSearch() {
		boolean[] visited = new boolean[graph.V()];
		List<Integer> listVisits = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		runQueueSearch(queue, visited, listVisits);

		return listVisits;
	}

	private void runQueueSearch(Queue<Integer> queue, boolean[] visited, List<Integer> listVisits) {
		while (queue.size() > 0) {
			Integer visit = queue.poll();
			if (!visited[visit]) {
				listVisits.add(visit);
				visited[visit] = true;
				Iterable<Integer> neighbors = graph.adj(visit);
				for (Integer next : neighbors) {
					queue.add(next);
				}
			}
		}
	}

}
