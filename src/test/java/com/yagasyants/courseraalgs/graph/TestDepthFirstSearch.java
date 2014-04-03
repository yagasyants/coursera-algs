package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestDepthFirstSearch {
	@Test
	public void testDFS() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";

		UndirGraph graph = new UndirGraph(gStr);
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph); 
		
		List<Integer> listVertices = dfs.runSearch(0);

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
		assertEquals(2, listVertices.get(2).intValue());
	}

	@Test
	public void testDFSWithCycle() {
		String gStr = "0: 1 \n 1: 0 ";

		UndirGraph graph = new UndirGraph(gStr);
		DepthFirstSearch dfs = new DepthFirstSearch(graph); 
		
		List<Integer> listVertices = dfs.runSearch(0);

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
	}


}
