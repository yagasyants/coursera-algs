package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStrongComponents {
	@Test
	public void testTopoOrderSimple() {
		Digraph graph = new Digraph(3);
		graph.addEgde(0, 1);
		graph.addEgde(1, 0);
		
		StrongComponents algo = new StrongComponents(graph); 
		
		Integer[] listComponents = algo.runSearch();

		assertEquals(1, listComponents[0].intValue());
		assertEquals(1, listComponents[1].intValue());
		assertEquals(0, listComponents[2].intValue());
	}


	@Test
	public void testTopoOrderFromExample() {
		Digraph graph = new Digraph(13);
		graph.addEgde(0, 1);
		graph.addEgde(0, 5);
		graph.addEgde(2, 0);
		graph.addEgde(2, 3);
		graph.addEgde(3, 2);
		graph.addEgde(3, 5);
		graph.addEgde(4, 2);
		graph.addEgde(4, 3);
		graph.addEgde(5, 4);
		graph.addEgde(6, 0);
		graph.addEgde(6, 4);
		graph.addEgde(6, 8);
		graph.addEgde(6, 9);
		graph.addEgde(7, 6);
		graph.addEgde(7, 9);
		graph.addEgde(8, 6);
		graph.addEgde(9, 10);
		graph.addEgde(9, 11);
		graph.addEgde(10, 12);
		graph.addEgde(11, 4);
		graph.addEgde(11, 12);
		graph.addEgde(12, 9);
		
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
