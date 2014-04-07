package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestUndirGraph {

	@Test
	public void testInit() {
		UndirGraph graph = new UndirGraph(1);

		assertEquals(1, graph.V());
	}

	@Test
	public void testAddEdgeIsEdge() {
		UndirGraph graph = new UndirGraph(4);
		graph.addEdge(1, 2);

		assertEquals(2, graph.adj(1).iterator().next().intValue());
		assertEquals(1, graph.adj(2).iterator().next().intValue());
	}

	@Test
	public void testToString() {
		UndirGraph graph = new UndirGraph(4);
		graph.addEdge(1, 2);
		String str = graph.toString();

		assertTrue(str.contains("1-2"));
	}

	@Test
	public void testBuildFromString() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";

		UndirGraph graph = new UndirGraph(gStr);
		assertEquals(3, graph.V());
		assertEquals(1, graph.adj(0).iterator().next().intValue());
		assertEquals(0, graph.adj(1).iterator().next().intValue());
	}



}
