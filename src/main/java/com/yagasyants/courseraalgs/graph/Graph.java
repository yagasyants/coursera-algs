package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	private List<List<Integer>> adjList;

	public Graph(int numberOfVertices) {
		adjList = new ArrayList<>();

		for (int i = 0; i < numberOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	public Graph(String gStr) {
		String[] adjStrList = gStr.split("\n");
		adjList = new ArrayList<>();

		for (int i = 0; i < adjStrList.length; i++) {
			String vString = adjStrList[i];
			ArrayList<Integer> vList = extractVerticesFromLine(vString);
			adjList.add(vList);
		}
	}

	private ArrayList<Integer> extractVerticesFromLine(String vString) {
		ArrayList<Integer> vList = new ArrayList<Integer>();
		String vertices = vString.substring(vString.indexOf(":") + 1);
		String[] arrayVertices = vertices.split(" ");
		for (String vertex : arrayVertices) {
			String vertexTrim = vertex.trim();
			if (vertex.length() > 0) {
				vList.add(Integer.valueOf(vertexTrim));
			}
		}
		return vList;
	}

	public int getNumberOfVertices() {
		return adjList.size();
	}

	public void addEgde(Integer i, Integer j) {
		adjList.get(i).add(j);
		adjList.get(j).add(i);
	}

	public Iterable<Integer> adj(int i) {
		return adjList.get(i);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int v = 0; v < adjList.size(); v++) {
			for (int w : adjList.get(v)) {
				stringBuilder.append(v + "-" + w);
			}
		}
		return stringBuilder.toString();
	}

	public List<Integer> depthFirst() {
		boolean[] visited = new boolean[adjList.size()];
		List<Integer> listVisits = new ArrayList<>();
		depthFirstVisit(0, visited, listVisits);
		
		return listVisits;
	}

	private void depthFirstVisit(Integer visit, boolean[] visited, List<Integer> listVisits) {
		if (!visited[visit]) {
			listVisits.add(visit);
			visited[visit] = true;
			List<Integer> neighbors = adjList.get(visit);
			for (Integer next : neighbors) {
				depthFirstVisit(next, visited, listVisits);
			}
		}
	}

}
