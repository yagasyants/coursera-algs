package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	private List<List<Integer>> adjList;

	private T[] arrayVertices;
	private Map<T, Integer> mapIntToVertix;

	public Graph(T[] arrayVertices) {
		this.arrayVertices = arrayVertices;
		fillMapIntToVertix();

		adjList = new ArrayList<>();

		for (int i = 0; i < arrayVertices.length; i++) {
			adjList.add(new LinkedList<Integer>());
		}
	}

	private void fillMapIntToVertix() {
		mapIntToVertix = new HashMap<>();
		for (int i = 0; i < arrayVertices.length; i++) {
			mapIntToVertix.put(arrayVertices[i], i);
		}
	}

	public Graph(T[] arrayVertices, String gStr, TypeParser<T> parser) {
		this(arrayVertices);
		String[] adjStrList = gStr.split("\n");

		for (int i = 0; i < adjStrList.length; i++) {
			String vString = adjStrList[i];
			List<Integer> vList = adjList.get(i);
			extractVerticesFromLine(vList, vString, parser);
		}
	}

	private void extractVerticesFromLine(List<Integer> vList, String vString, TypeParser<T> parser) {
		String vertices = vString.substring(vString.indexOf(":") + 1);
		String[] arrayVertices = vertices.split(" ");
		for (String vertex : arrayVertices) {
			String vertexTrim = vertex.trim();
			if (vertexTrim.length() > 0) {
				T vertexType = parser.parse(vertexTrim);
				vList.add(mapIntToVertix.get(vertexType));
			}
		}
	}

	public int getNumberOfVertices() {
		return adjList.size();
	}

	public void addEgde(T left, T right) {
		int leftIndex = mapIntToVertix.get(left);
		int rightIndex = mapIntToVertix.get(right);

		adjList.get(leftIndex).add(rightIndex);
		adjList.get(rightIndex).add(leftIndex);
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

	public List<T> depthFirst() {
		boolean[] visited = new boolean[adjList.size()];
		List<Integer> listVisits = new ArrayList<>();
		depthFirstVisit(0, visited, listVisits);

		return convert(listVisits);
	}
	
	private List<T> convert(List<Integer> listVisits){
		List<T> listT = new ArrayList<>();
		for(Integer index : listVisits){
			listT.add(arrayVertices[index]);
		}
		return listT;
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
