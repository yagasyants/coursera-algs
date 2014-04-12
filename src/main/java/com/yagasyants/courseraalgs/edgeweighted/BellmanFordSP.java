package com.yagasyants.courseraalgs.edgeweighted;

import java.util.LinkedList;
import java.util.List;

import com.yagasyants.courseraalgs.graph.TopologicOrder;

public class BellmanFordSP {
	private static final double INFINITY = Double.POSITIVE_INFINITY;

	private EdgeWeightedDigraph graph;
	private int source;

	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public BellmanFordSP(EdgeWeightedDigraph graph, int source) {
		this.graph = graph;
		this.source = source;

		search(graph);
	}

	private void search(EdgeWeightedDigraph graph) {
		initEdgeToDistTo(graph);

		distTo[source] = 0;

		for (int i = 0; i < graph.V(); i++) {
			for (int v = 0; v < graph.V(); v++) {
				for (DirectedEdge edge : graph.adj(v)) {
					relax(edge);
				}
			}
			printAfterPass(i);
		}
	}

	private void printAfterPass(Integer passNumber) {
		System.out.println("Just passed " + passNumber);
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