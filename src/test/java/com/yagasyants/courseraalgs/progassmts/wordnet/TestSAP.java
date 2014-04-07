package com.yagasyants.courseraalgs.progassmts.wordnet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.yagasyants.courseraalgs.graph.Digraph;

public class TestSAP {

	@Test
	public void testLengthSingleNormal(){
		Digraph digraph = createDigraph2();
		
		SAP sap = new SAP(digraph);
		int anc = sap.ancestor(1, 5);
		int lengthSap = sap.length(1, 5);
		
		assertEquals(0, anc);
		assertEquals(2, lengthSap);
	}

	@Test
	public void testLengthMultipleNormal(){
		Digraph digraph = createDigraph2();
		
		SAP sap = new SAP(digraph);
		int anc = sap.ancestor(Arrays.asList(1, 2), Arrays.asList(3, 4));
		int lengthSap = sap.length(Arrays.asList(1, 2), Arrays.asList(3, 4));
		
		assertEquals(3, anc);
		assertEquals(1, lengthSap);
	}

	@Test
	public void testLengthMultipleIntersect(){
		Digraph digraph = createDigraph2();
		
		SAP sap = new SAP(digraph);
		int anc = sap.ancestor(Arrays.asList(1, 3), Arrays.asList(3, 4));
		int lengthSap = sap.length(Arrays.asList(1, 3), Arrays.asList(3, 4));
		
		assertEquals(3, anc);
		assertEquals(0, lengthSap);
	}

	@Test
	public void testDigrapg1SingleNormal(){
		Digraph digraph = createDigraph1();
		
		SAP sap = new SAP(digraph);
		int anc = sap.ancestor(3, 11);
		int lengthSap = sap.length(3, 11);
		
		assertEquals(1, anc);
		assertEquals(4, lengthSap);
	}

	@Test
	public void testDigrapg1MultipleNormal(){
		Digraph digraph = createDigraph1();
		
		SAP sap = new SAP(digraph);
		int anc = sap.ancestor(Arrays.asList(9), Arrays.asList(7, 12));
		int lengthSap = sap.length(Arrays.asList(9), Arrays.asList(7, 12));
		
		assertEquals(5, anc);
		assertEquals(3, lengthSap);
	}

	
	
	private Digraph createDigraph1() {
		Digraph digraph = new Digraph(13);
		digraph.addEgde(1, 0);
		digraph.addEgde(2, 0);
		digraph.addEgde(3, 1);
		digraph.addEgde(4, 1);
		digraph.addEgde(5, 1);
		digraph.addEgde(6, 1);
		digraph.addEgde(7, 3);
		digraph.addEgde(8, 3);
		digraph.addEgde(9, 5);
		digraph.addEgde(10, 5);
		digraph.addEgde(11, 10);
		digraph.addEgde(12, 10);
		return digraph;
	}

	
	private Digraph createDigraph2() {
		Digraph digraph = new Digraph(6);
		digraph.addEgde(1, 0);
		digraph.addEgde(1, 2);
		digraph.addEgde(2, 3);
		digraph.addEgde(3, 4);
		digraph.addEgde(4, 5);
		digraph.addEgde(5, 0);
		return digraph;
	}

}
