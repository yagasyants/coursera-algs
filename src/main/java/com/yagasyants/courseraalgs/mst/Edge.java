package com.yagasyants.courseraalgs.mst;

public class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
		return v;
	}

	public int other(int i) {
		return i == v ? w : v;
	}

	public double weigth() {
		return weight;
	}

	@Override
	public int compareTo(Edge o) {
		double otherWeight = o.weigth();
		if (weight > otherWeight) {
			return 1;
		} else if (weight < otherWeight) {
			return -1;
		} else {
			return 0;
		}
	}

}
