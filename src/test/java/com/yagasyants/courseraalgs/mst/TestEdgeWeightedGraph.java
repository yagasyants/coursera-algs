package com.yagasyants.courseraalgs.mst;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEdgeWeightedGraph {
	
	@Test
	public void testInit(){
		EdgeWeightedGraph graph = new EdgeWeightedGraph(2);
		graph.addEdge(new Edge(0, 1, 1));
		Edge e = graph.adj(0).iterator().next();
		
		assertEquals(0, e.either());
 		assertEquals(2, graph.V());
	}

}
