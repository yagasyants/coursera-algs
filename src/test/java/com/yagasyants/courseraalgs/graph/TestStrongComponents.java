package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStrongComponents {
	@Test
	public void testTopoOrderSimple() {
		Digraph graph = new Digraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		
		StrongComponents algo = new StrongComponents(graph); 
		
		Integer[] listComponents = algo.runSearch();

		assertEquals(1, listComponents[0].intValue());
		assertEquals(1, listComponents[1].intValue());
		assertEquals(0, listComponents[2].intValue());
	}


	@Test
	public void testTopoOrderFromExample() {
		Digraph graph = new Digraph(13);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(4, 2);
		graph.addEdge(4, 3);
		graph.addEdge(5, 4);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
		graph.addEdge(7, 9);
		graph.addEdge(8, 6);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		graph.addEdge(11, 12);
		graph.addEdge(12, 9);
		
		StrongComponents algo = new StrongComponents(graph); 
		
		Integer[] listComponents = algo.runSearch();

		assertEquals(1, listComponents[0].intValue());
		assertEquals(0, listComponents[1].intValue());
		assertEquals(1, listComponents[2].intValue());
		assertEquals(1, listComponents[3].intValue());
		assertEquals(1, listComponents[4].intValue());
		assertEquals(1, listComponents[5].intValue());
		assertEquals(3, listComponents[6].intValue());
		assertEquals(4, listComponents[7].intValue());
		assertEquals(3, listComponents[8].intValue());
		assertEquals(2, listComponents[9].intValue());
		assertEquals(2, listComponents[10].intValue());
		assertEquals(2, listComponents[11].intValue());
		assertEquals(2, listComponents[12].intValue());
	}
}
