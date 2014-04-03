package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Graph {
	protected List<List<Integer>> adjList;

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
			extractVerticesFromLine(i, vString);
		}
	}

	private void extractVerticesFromLine(Integer vertexLine, String vString) {
		String vertices = vString.substring(vString.indexOf(":") + 1);
		String[] arrayVertices = vertices.split(" ");
		for (String vertexStr : arrayVertices) {
			String vertexStrTrim = vertexStr.trim();
			if (vertexStrTrim.length() > 0) {
				Integer anotherVertex = Integer.valueOf(vertexStrTrim);
				addEgde(vertexLine, anotherVertex);
			}
		}
	}

	public int getNumberOfVertices() {
		return adjList.size();
	}

	public abstract void addEgde(int left, int right);
	protected abstract String getStringVertexConnect();

	public Iterable<Integer> adj(int i) {
		return adjList.get(i);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int v = 0; v < adjList.size(); v++) {
			for (int w : adjList.get(v)) {
				stringBuilder.append(v + getStringVertexConnect() + w);
			}
		}
		return stringBuilder.toString();
	}
}
