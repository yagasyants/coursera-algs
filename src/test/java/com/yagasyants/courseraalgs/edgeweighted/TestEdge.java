package com.yagasyants.courseraalgs.edgeweighted;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yagasyants.courseraalgs.edgeweighted.Edge;

public class TestEdge {
	
	@Test
	public void testCompare(){
		Edge e1 = new Edge(1, 2, 1);
		Edge e2 = new Edge(2, 3, 2);
		
		assertEquals(-1, e1.compareTo(e2));
	}

}
