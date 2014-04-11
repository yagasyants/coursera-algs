package com.yagasyants.courseraalgs.mst;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class TestPrimMST {
	@Test
	public void testInit() {
		EdgeWeightedGraph graph = new EdgeWeightedGraph(4);

		graph.addEdge(new Edge(0, 1, 1));
		graph.addEdge(new Edge(1, 2, 2));
		graph.addEdge(new Edge(2, 3, 3));
		graph.addEdge(new Edge(0, 2, 1.1));
		graph.addEdge(new Edge(0, 3, 5));
		graph.addEdge(new Edge(1, 3, 7));

		PrimMST mst = new PrimMST(graph);

		Iterable<Edge> edges = mst.edges();
		Iterator<Edge> iterator = edges.iterator();
		Edge first = iterator.next();
		Edge second = iterator.next();
		Edge third = iterator.next();

		assertEquals(0, first.either());
		assertEquals(1, first.other(first.either()));

		assertEquals(0, second.either());
		assertEquals(2, second.other(second.either()));

		assertEquals(2, third.either());
		assertEquals(3, third.other(third.either()));

		assertEquals(5.1, mst.weight(), 0);
	}
}
