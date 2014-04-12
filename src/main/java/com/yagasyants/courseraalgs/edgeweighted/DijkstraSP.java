package com.yagasyants.courseraalgs.edgeweighted;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class DijkstraSP {
	private static final double INFINITY = Double.MAX_VALUE;

	private EdgeWeightedDigraph graph;
	private int source;

	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public DijkstraSP(EdgeWeightedDigraph graph, int source) {
		this.graph = graph;
		this.source = source;

		search(graph);
	}

	private void search(EdgeWeightedDigraph graph) {
		initEdgeToDistTo(graph);

		distTo[source] = 0;
		Map<Double, List<Integer>> mapDistToVertices = new TreeMap<>();
		mapDistToVertices.put(0d, Arrays.asList(source));
		Set<Integer> visited = new HashSet<>();

		while (visited.size() < graph.V()) {
			Integer vertex = pullVertexWithSmallestDist(mapDistToVertices);

			if (!visited.contains(vertex)) {
				visited.add(vertex);

				for (DirectedEdge edge : graph.adj(vertex)) {
					relax(edge, mapDistToVertices);
				}
				printAfterRelaxed(vertex);
			}
		}
	}

	private void printAfterRelaxed(Integer vertex) {
		System.out.println("Just relaxed " + vertex);
		System.out.println("DistTo:");
		for(double d : distTo){
			System.out.print((int)d + " ");
		}
		System.out.println("");

	}

	private Integer pullVertexWithSmallestDist(
			Map<Double, List<Integer>> mapDistToVertices) {
		double nextSmallWeight = mapDistToVertices.keySet().iterator().next();
		List<Integer> associatedVertices = mapDistToVertices
				.get(nextSmallWeight);

		Integer vertex = associatedVertices.get(0);
		if (associatedVertices.size() == 1) {
			mapDistToVertices.remove(nextSmallWeight);
		} else {
			associatedVertices.remove(vertex);
		}
		return vertex;
	}

	private void relax(DirectedEdge edge,
			Map<Double, List<Integer>> mapDistToVertices) {
		int v = edge.from();
		int w = edge.to();

		double newDist = distTo[v] + edge.weight();
		double oldDist = distTo[w];
		if (newDist < oldDist) {
			distTo[w] = newDist;
			edgeTo[w] = edge;

			addNewDistance(mapDistToVertices, w, newDist);
		}

	}

	private void addNewDistance(Map<Double, List<Integer>> mapDistToVertices,
			int w, double newDist) {
		List<Integer> listForDist = mapDistToVertices.get(newDist);
		if (listForDist == null) {
			listForDist = new LinkedList<>();
			mapDistToVertices.put(newDist, listForDist);
		}
		listForDist.add(w);
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
