package com.yagasyants.courseraalgs.edgeweighted;

import java.util.LinkedList;
import java.util.List;

import com.yagasyants.courseraalgs.graph.TopologicOrder;

public class TopoDagSP {
	private static final double INFINITY = Double.POSITIVE_INFINITY;

	private EdgeWeightedDigraph graph;
	private int source;

	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public TopoDagSP(EdgeWeightedDigraph graph, int source) {
		this.graph = graph;
		this.source = source;

		search(graph);
	}

	private void search(EdgeWeightedDigraph graph) {
		initEdgeToDistTo(graph);

		List<Integer> verticesInTopoOrder = new TopologicOrder(graph)
				.runSearch();

		distTo[source] = 0;

		for (int vertex : verticesInTopoOrder) {
			if (distTo[vertex] != INFINITY) {
				for (DirectedEdge edge : graph.adj(vertex)) {
					relax(edge);
				}
				printAfterRelaxed(vertex);
			}
		}
	}

	private void printAfterRelaxed(Integer vertex) {
		System.out.println("Just relaxed " + vertex);
		System.out.println("DistTo:");
		for (double d : distTo) {
			System.out.print((int) d + " ");
		}
		System.out.println("");

	}

	private void relax(DirectedEdge edge) {
		int v = edge.from();
		int w = edge.to();

		double newDist = distTo[v] + edge.weight();
		double oldDist = distTo[w];
		if (newDist < oldDist) {
			distTo[w] = newDist;
			edgeTo[w] = edge;
		}

	}

	private void initEdgeToDistTo(EdgeWeightedDigraph graph) {
		edgeTo = new DirectedEdge[graph.V()];
		distTo = new double[graph.V()];
		for (int i = 0; i < distTo.length; i++) {
			distTo[i] = INFINITY;
		}
	}

	public Iterable<DirectedEdge> pathTo(int vertex) {
		LinkedList<DirectedEdge> stack = new LinkedList<>();
		int currVertex = vertex;
		while (currVertex != source) {
			DirectedEdge edge = edgeTo[currVertex];
			stack.push(edge);
			currVertex = edge.from();
		}
		return stack;
	}

	public double distTo(int vertex) {
		return distTo[vertex];
	}
}
