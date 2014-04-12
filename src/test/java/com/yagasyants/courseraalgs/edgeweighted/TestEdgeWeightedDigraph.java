package com.yagasyants.courseraalgs.edgeweighted;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEdgeWeightedDigraph {
	@Test
	public void testInit(){
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(2);
		graph.addEdge(new DirectedEdge(0, 1, 1));
		DirectedEdge e = graph.adj(0).iterator().next();
		
		assertEquals(0, e.from());
		assertEquals(1, e.to());
 		assertEquals(2, graph.V());
	}

}
