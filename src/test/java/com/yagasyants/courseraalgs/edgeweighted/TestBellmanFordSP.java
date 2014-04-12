package com.yagasyants.courseraalgs.edgeweighted;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class TestBellmanFordSP {
	@Test
	public void testInit() {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(4);

		graph.addEdge(new DirectedEdge(0, 1, 1));
		graph.addEdge(new DirectedEdge(1, 2, 2));
		graph.addEdge(new DirectedEdge(1, 3, 3));
		graph.addEdge(new DirectedEdge(3, 2, -3));

		BellmanFordSP sp = new BellmanFordSP(graph, 0);

		Iterable<DirectedEdge> pathToOne = sp.pathTo(1);
		DirectedEdge edgeToOne = pathToOne.iterator().next();

		Iterable<DirectedEdge> pathToTwo = sp.pathTo(2);
		Iterator<DirectedEdge> pathToTwoIterator = pathToTwo.iterator();
		DirectedEdge firstEdgeToTwo = pathToTwoIterator.next();
		DirectedEdge secondEdgeToTwo = pathToTwoIterator.next();
		DirectedEdge thirdEdgeToTwo = pathToTwoIterator.next();

		assertEquals(0, edgeToOne.from());
		assertEquals(1, edgeToOne.to());

		assertEquals(0, firstEdgeToTwo.from());
		assertEquals(1, firstEdgeToTwo.to());

		assertEquals(1, secondEdgeToTwo.from());
		assertEquals(3, secondEdgeToTwo.to());

		assertEquals(3, thirdEdgeToTwo.from());
		assertEquals(2, thirdEdgeToTwo.to());

		assertEquals(1, sp.distTo(2), 0);
	}
}
