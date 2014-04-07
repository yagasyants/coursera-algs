package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yagasyants.courseraalgs.graph.Digraph;

public class TestDigraph {

	@Test
	public void testInit() {
		Digraph graph = new Digraph(1);

		assertEquals(1, graph.V());
	}

	@Test
	public void testAddEdgeIsEdge() {
		Digraph graph = new Digraph(4);
		graph.addEdge(1, 2);

		Iterable<Integer> verts = graph.adj(1);
		assertEquals(2, verts.iterator().next().intValue());
		assertFalse(graph.adj(2).iterator().hasNext());
	}

	@Test
	public void testToString() {
		Digraph graph = new Digraph(4);
		graph.addEdge(1, 2);
		String str = graph.toString();

		assertTrue(str.contains("1->2"));
	}

	@Test
	public void testBuildFromString() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";

		Digraph graph = new Digraph(gStr);
		assertEquals(3, graph.V());
		assertEquals(1, graph.adj(0).iterator().next().intValue());
		assertEquals(0, graph.adj(1).iterator().next().intValue());
	}
	
	@Test
	public void testReverse() {
		Digraph graph = new Digraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);

		Digraph reversed = graph.reverse();
		
		assertFalse(reversed.adj(0).iterator().hasNext());
		assertEquals(0, reversed.adj(1).iterator().next().intValue());
		assertEquals(1, reversed.adj(2).iterator().next().intValue());
	}


}
