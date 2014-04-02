package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestBreadthFirstSearch {
	@Test
	public void testDFS() {
		String gStr = "0: 2 3 \n 1: 2 \n 2: 0 1\n 3: 0";

		Graph graph = new Graph(gStr);
		BreadthFirstSearch dfs = new BreadthFirstSearch(graph); 
		
		List<Integer> listVertices = dfs.runSearch();

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(2, listVertices.get(1).intValue());
		assertEquals(3, listVertices.get(2).intValue());
		assertEquals(1, listVertices.get(3).intValue());
		
	}
}
