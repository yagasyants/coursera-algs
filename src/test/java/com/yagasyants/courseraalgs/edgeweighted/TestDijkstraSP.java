package com.yagasyants.courseraalgs.edgeweighted;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class TestDijkstraSP {
	@Test
	public void testInit() {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(4);

		graph.addEdge(new DirectedEdge(0, 1, 1));
		graph.addEdge(new DirectedEdge(1, 2, 2));
		graph.addEdge(new DirectedEdge(2, 3, 3));
		graph.addEdge(new DirectedEdge(0, 2, 1.1));
		graph.addEdge(new DirectedEdge(0, 3, 5));
		graph.addEdge(new DirectedEdge(1, 3, 7));

		DijkstraSP sp = new DijkstraSP(graph, 0);

		Iterable<DirectedEdge> pathToOne = sp.pathTo(1);
		DirectedEdge edgeToOne = pathToOne.iterator().next();

		Iterable<DirectedEdge> pathToThree = sp.pathTo(3);
		Iterator<DirectedEdge> pathToThreeIterator = pathToThree.iterator();
		DirectedEdge edgeToThree = pathToThreeIterator.next();
		DirectedEdge secondEdgeToThree = pathToThreeIterator.next();

		assertEquals(0, edgeToOne.from());
		assertEquals(1, edgeToOne.to());

		assertEquals(0, edgeToThree.from());
		assertEquals(2, edgeToThree.to());

		assertEquals(2, secondEdgeToThree.from());
		assertEquals(3, secondEdgeToThree.to());

		assertEquals(4.1, sp.distTo(3), 0);
	}

}
