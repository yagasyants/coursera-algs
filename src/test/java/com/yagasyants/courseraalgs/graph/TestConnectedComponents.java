package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestConnectedComponents {
	@Test
	public void testDFS() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1\n 3: 4 5\n 4: 3 5\n 5: 3 4";

		UndirGraph graph = new UndirGraph(gStr);
		ConnectedComponents cc = new ConnectedComponents(graph); 
		
		Integer[] comps = cc.runSearch();

		assertEquals(0, comps[0].intValue());
		assertEquals(0, comps[1].intValue());
		assertEquals(0, comps[2].intValue());
		assertEquals(1, comps[3].intValue());
		assertEquals(1, comps[4].intValue());
		assertEquals(1, comps[5].intValue());
		
	}

}
