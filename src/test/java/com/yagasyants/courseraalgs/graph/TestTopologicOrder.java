package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestTopologicOrder {
	@Test
	public void testTopoOrderSimple() {
		Digraph graph = new Digraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		
		TopologicOrder algo = new TopologicOrder(graph); 
		
		List<Integer> listVertices = algo.runSearch();

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
		assertEquals(2, listVertices.get(2).intValue());
	}

	@Test
	public void testTopoOrderWithJumps() {
		Digraph graph = new Digraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		
		TopologicOrder algo = new TopologicOrder(graph); 
		
		List<Integer> listVertices = algo.runSearch();

		assertEquals(2, listVertices.get(0).intValue());
		assertEquals(3, listVertices.get(1).intValue());
		assertEquals(0, listVertices.get(2).intValue());
		assertEquals(1, listVertices.get(3).intValue());
	}

	@Test
	public void testTopoOrderFromLecture() {
		Digraph graph = new Digraph(7);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 4);
		graph.addEdge(3, 6);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(3, 4);
		graph.addEdge(5, 2);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);

		TopologicOrder algo = new TopologicOrder(graph); 
		
		List<Integer> listVertices = algo.runSearch();

		assertEquals(3, listVertices.get(0).intValue());
		assertEquals(6, listVertices.get(1).intValue());
		assertEquals(0, listVertices.get(2).intValue());
		assertEquals(1, listVertices.get(3).intValue());
		assertEquals(4, listVertices.get(4).intValue());
		assertEquals(5, listVertices.get(5).intValue());
		assertEquals(2, listVertices.get(6).intValue());
	}

}
