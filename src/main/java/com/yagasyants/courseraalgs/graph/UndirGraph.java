package com.yagasyants.courseraalgs.graph;


public class UndirGraph extends Graph {

	public UndirGraph(long numOfVertices) {
		super(numOfVertices);
	}

	public UndirGraph(String gStr) {
		super(gStr);
	}

	public void addEdge(int left, int right) {
		adjList.get(left).add(right);
		adjList.get(right).add(left);
	}

	@Override
	protected String getStringVertexConnect() {
		return "-";
	}


}
