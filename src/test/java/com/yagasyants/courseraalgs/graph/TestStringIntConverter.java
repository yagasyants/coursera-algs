package com.yagasyants.courseraalgs.graph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStringIntConverter {
	private StringIntConverter converter;
	
	@Test
	public void testConvert() {
		int bIndex = converter.getIndex("b");
		String secondVertex = converter.getVertex(2);
		
		assertEquals(1, bIndex);
		assertEquals("c", secondVertex);
	}

	@Test
	public void testConvertList() {
		List<String> listVertices = converter.convert(Arrays.asList(2, 1));
		
		assertEquals(2, listVertices.size());
		assertEquals("c", listVertices.get(0));
	}

	@Test
	public void testToIntGraphString() {
		String strGraph = "a: b \n b: a c \n c: b";
		String intGraph = "0: 1 \n 1: 0 2 \n 2: 1";


		String createdIntGraph = converter.toIntGraphString(strGraph);
		
		assertEquals(intGraph, createdIntGraph);
	}

	@Before
	public void setUp(){
		converter = new StringIntConverter("a", "b", "c" );
	}


}
