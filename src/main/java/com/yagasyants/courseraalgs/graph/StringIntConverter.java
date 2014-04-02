package com.yagasyants.courseraalgs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringIntConverter {
	private String[] arrayVertices;
	private Map<String, Integer> mapIntToVertix;

	public StringIntConverter(String... vertices) {
		this.arrayVertices = vertices;
		fillMapIntToVertix();
	}

	private void fillMapIntToVertix() {
		mapIntToVertix = new HashMap<>();
		for (int i = 0; i < arrayVertices.length; i++) {
			mapIntToVertix.put(arrayVertices[i], i);
		}
	}

	public int getIndex(String vertex) {
		return mapIntToVertix.get(vertex);
	}

	public String getVertex(int index) {
		return arrayVertices[index];
	}

	public List<String> convert(List<Integer> listVisits) {
		List<String> listT = new ArrayList<>();
		for (Integer index : listVisits) {
			listT.add(arrayVertices[index]);
		}
		return listT;
	}

	public String toIntGraphString(String strGraph) {
		String intStr = strGraph;
		for(int i=0; i< arrayVertices.length; i++){
			String vertex = arrayVertices[i];
			intStr = intStr.replaceAll(vertex, String.valueOf(i));
		}
		return intStr;
	}

}
