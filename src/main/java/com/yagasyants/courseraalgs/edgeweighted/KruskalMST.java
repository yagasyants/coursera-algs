package com.yagasyants.courseraalgs.edgeweighted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class KruskalMST {
	private EdgeWeightedGraph graph;
	private List<Edge> mst;
	private double weight;
	private Map<Integer, List<Integer>> connectedComponents;

	public KruskalMST(EdgeWeightedGraph graph) {
		this.graph = graph;
		mst = new LinkedList<>();
		connectedComponents = new HashMap<>();
		searchMst();
	}

	private void searchMst() {
		Set<Edge> allEdges = getAllEdges();

		for (Edge edge : allEdges) {
			int v = edge.either();
			int w = edge.other(v);
			List<Integer> vComp = connectedComponents.get(v);
			List<Integer> wComp = connectedComponents.get(w);

			boolean isEdgeCreatesCycle = vComp != null && vComp == wComp;
			if (!isEdgeCreatesCycle) {
				mst.add(edge);
				weight += edge.weigth();

				addConnectedComponents(v, w, vComp, wComp);

				if (mst.size() == graph.V() - 1) {
					return;
				}
			}
		}
	}

	private void addConnectedComponents(int v, int w, List<Integer> vComp,
			List<Integer> wComp) {
		if (vComp == null) {
			handleVIsNotInComponent(v, w, wComp);
		} else {
			handleVInComponent(v, w, vComp, wComp);
		}
	}

	private void handleVInComponent(int v, int w, List<Integer> vComp,
			List<Integer> wComp) {
		if (wComp == null) {
			vComp.add(w);
			connectedComponents.put(w, vComp);
		} else if (vComp.size() > wComp.size()) {
			merge(wComp, vComp);
		} else {
			merge(vComp, wComp);
		}
	}
	
	private void merge(List<Integer> from, List<Integer> to){
		for(Integer vertex : from){
			to.add(vertex);
			connectedComponents.put(vertex, to);
		}
	}

	private void handleVIsNotInComponent(int v, int w, List<Integer> wComp) {
		if (wComp == null) {
			List<Integer> list = new ArrayList<>();
			list.add(v);
			list.add(w);
			connectedComponents.put(v, list);
			connectedComponents.put(w, list);
		} else {
			wComp.add(v);
			connectedComponents.put(v, wComp);
		}
	}

	private Set<Edge> getAllEdges() {
		Set<Edge> allEdges = new TreeSet<>();
		for (int i = 0; i < graph.V(); i++) {
			for (Edge edge : graph.adj(i)) {
				allEdges.add(edge);
			}

		}
		return allEdges;
	}

	public List<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

}
