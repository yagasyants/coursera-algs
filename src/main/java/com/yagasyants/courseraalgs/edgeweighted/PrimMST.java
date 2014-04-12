package com.yagasyants.courseraalgs.edgeweighted;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PrimMST {
	private EdgeWeightedGraph graph;
	private List<Edge> mst;
	private double weight;

	public PrimMST(EdgeWeightedGraph graph) {
		this.graph = graph;
		mst = new LinkedList<>();
		searchMst();
	}

	private void searchMst() {
		Set<Integer> verticesInMst = new HashSet<>();
		Set<Edge> sortedEdges = new TreeSet<>();

		addVertexEdges(0, sortedEdges, verticesInMst);

		while (mst.size() < graph.V() - 1) {
			Edge edge = pullMinEdgeToOut(sortedEdges, verticesInMst);

			addEdge(edge, verticesInMst, sortedEdges);
		}
	}

	private void addEdge(Edge edge, Set<Integer> verticesInMst,
			Set<Edge> sortedEdges) {
		mst.add(edge);
		weight += edge.weigth();
		int v = edge.either();
		int w = edge.other(v);

		if (verticesInMst.contains(v)) {
			addVertexEdges(w, sortedEdges, verticesInMst);
		} else {
			addVertexEdges(v, sortedEdges, verticesInMst);
		}

	}

	private Edge pullMinEdgeToOut(Set<Edge> sortedEdges,
			Set<Integer> verticesInMst) {
		Iterator<Edge> iterator = sortedEdges.iterator();
		while (iterator.hasNext()) {
			Edge edge = iterator.next();
			iterator.remove();
			if(!isEdgeInMst(verticesInMst, edge)){
				return edge;
			}
		}
		throw new RuntimeException("Cannot find next edge to outer");
	}

	private void addVertexEdges(int vertex, Set<Edge> sortedEdges,
			Set<Integer> verticesInMst) {
		verticesInMst.add(vertex);
		Iterable<Edge> edges = graph.adj(vertex);
		for (Edge e : edges) {
			boolean isEdgeInMst = isEdgeInMst(verticesInMst, e);
			if (!isEdgeInMst) {
				sortedEdges.add(e);
			}
		}

	}

	private boolean isEdgeInMst(Set<Integer> verticesInMst, Edge e) {
		int v = e.either();
		int w = e.other(v);
		return (verticesInMst.contains(v) && verticesInMst.contains(w));
	}

	public List<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}
}