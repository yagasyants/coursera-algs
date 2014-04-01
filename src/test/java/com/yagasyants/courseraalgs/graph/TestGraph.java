package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGraph {
	private TypeParser<Integer> intParser;
	private TypeParser<String> stringParser;

	@Test
	public void testInit() {
		Graph<Integer> graph = new Graph<>(new Integer[] { 0 });

		assertEquals(1, graph.getNumberOfVertices());
	}

	@Test
	public void testAddEdgeIsEdge() {
		Graph<Integer> graph = new Graph<>(new Integer[] { 0, 1, 2, 3 });
		graph.addEgde(1, 2);

		Iterable<Integer> verts = graph.adj(1);
		assertEquals(2, verts.iterator().next().intValue());
	}

	@Test
	public void testToString() {
		Graph<Integer> graph = new Graph<>(new Integer[] { 0, 1, 2, 3 });
		graph.addEgde(1, 2);
		String str = graph.toString();

		assertTrue(str.contains("1-2"));
	}

	@Test
	public void testBuildFromString() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";

		Graph<Integer> graph = new Graph<>(new Integer[] { 0, 1, 2 }, gStr, intParser);
		assertEquals(3, graph.getNumberOfVertices());
		assertEquals(1, graph.adj(0).iterator().next().intValue());
		assertEquals(0, graph.adj(1).iterator().next().intValue());
	}

	@Test
	public void testDFS() {
		String gStr = "0: 1 \n 1: 0 2 \n 2: 1";

		Graph<Integer> graph = new Graph<>(new Integer[] { 0, 1, 2 }, gStr, intParser);
		List<Integer> listVertices = graph.depthFirst();

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
		assertEquals(2, listVertices.get(2).intValue());
	}

	@Test
	public void testDFSWithCycle() {
		String gStr = "0: 1 \n 1: 0 ";

		Graph<Integer> graph = new Graph<>(new Integer[] { 0, 1 }, gStr, intParser);
		List<Integer> listVertices = graph.depthFirst();

		assertEquals(0, listVertices.get(0).intValue());
		assertEquals(1, listVertices.get(1).intValue());
	}

	@Test
	public void testDFSTypes() {
		String gStr = "a: b \n b: a c \n c: b";

		Graph<String> graph = new Graph<>(new String[] { "a", "b", "c" }, gStr, stringParser);
		List<String> listVertices = graph.depthFirst();

		assertEquals("a", listVertices.get(0));
		assertEquals("b", listVertices.get(1));
		assertEquals("c", listVertices.get(2));
	}


	@Before
	public void setUp(){
		intParser = new TypeParser<Integer>() {
			public Integer parse(String s) {
				return Integer.valueOf(s);
			}
		};
		
		stringParser = new TypeParser<String>() {
			public String parse(String s) {
				return s;
			}
		};
	}

}
