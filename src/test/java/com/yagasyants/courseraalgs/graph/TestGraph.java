package com.yagasyants.courseraalgs.graph;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestGraph {

	@Test
	public void testInit(){
		Graph graph = new Graph(1);
		
		assertEquals(1, graph.getNumberOfVertices());
	}

	@Test
	public void testAddEdgeIsEdge(){
		Graph graph = new Graph(10);
		graph.addEgde(1, 2);
		
		Iterable<Integer> verts = graph.adj(1);
		assertEquals(2, verts.iterator().next().intValue());
	}

	@Test
	public void testToString(){
		Graph graph = new Graph(10);
		graph.addEgde(1, 2);
		String str = graph.toString();
		
		assertTrue(str.contains("1-2"));
	}

	@Test
	public void testBuildFromString(){
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";
		
		Graph graph = new Graph(gStr);
		assertEquals(3, graph.getNumberOfVertices());
		assertEquals(1, graph.adj(0).iterator().next().intValue());
		assertEquals(0, graph.adj(1).iterator().next().intValue());
	}
	
	@Test
	public void testDFS(){
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";
		
		Graph graph = new Graph(gStr);
		List<Integer> listVertices = graph.depthFirst();
		
		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
		assertEquals(2, listVertices.get(2).intValue());
	}

	@Test
	public void testDFSWithCycle(){
		String gStr = "0: 1 \n 1: 0 ";
		
		Graph graph = new Graph(gStr);
		List<Integer> listVertices = graph.depthFirst();
		
		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
	}

}
