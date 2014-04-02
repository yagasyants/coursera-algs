package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private List<List<Integer>> adjList;

	public Graph(long numOfVertices) {
		init(numOfVertices);
	}

	private void init(long numOfVertices) {
		adjList = new ArrayList<>();

		for (int i = 0; i < numOfVertices; i++) {
			adjList.add(new LinkedList<Integer>());
		}
	}

	public Graph(String gStr) {
		String[] adjStrList = gStr.split("\n");
		init(adjStrList.length);

		for (int i = 0; i < adjStrList.length; i++) {
			String vString = adjStrList[i];
			List<Integer> vList = adjList.get(i);
			extractVerticesFromLine(vList, vString);
		}
	}

	private void extractVerticesFromLine(List<Integer> vList, String vString) {
		String vertices = vString.substring(vString.indexOf(":") + 1);
		String[] arrayVertices = vertices.split(" ");
		for (String vertex : arrayVertices) {
			String vertexTrim = vertex.trim();
			if (vertexTrim.length() > 0) {
				vList.add(Integer.valueOf(vertexTrim));
			}
		}
	}

	public int getNumberOfVertices() {
		return adjList.size();
	}

	public void addEgde(int left, int right) {
		adjList.get(left).add(right);
		adjList.get(right).add(left);
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


}
