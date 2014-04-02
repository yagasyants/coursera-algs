package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import com.yagasyants.courseraalgs.graph.BreadthFirstSearch;
import com.yagasyants.courseraalgs.graph.DepthFirstSearch;
import com.yagasyants.courseraalgs.graph.Graph;
import com.yagasyants.courseraalgs.graph.StringIntConverter;

public class Quiz1 {
	private static final String[] VERTICES = {"A", "B", "C", "D", "E", "F", "G", "H"};
	private static final StringIntConverter CONVERTER = new StringIntConverter(VERTICES);
	
	private static void runQuestion1() {
		String intGraph = CONVERTER.toIntGraphString(getQuestion1Data());
		Graph graph = new Graph(intGraph);
		DepthFirstSearch dfs = new DepthFirstSearch(graph); 

		List<Integer> vertices = dfs.runSearch();
		
		printListToAnswer(vertices);
	}
	
	private static void runQuestion2() {
		String intGraph = CONVERTER.toIntGraphString(getQuestion2Data());
		Graph graph = new Graph(intGraph);
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph); 

		List<Integer> vertices = bfs.runSearch();
		
		printListToAnswer(vertices);
	}
	
	private static final String getQuestion1Data(){
		return "A:  F B \n" + 
    "B:  A C G  \n" +
    "C:  H B D  \n" +
    "D:  H C  \n" +
    "E:  F  \n" +
    "F:  A E  \n" +
    "G:  H B  \n" +
    "H:  C D G ";
	}

	private static final String getQuestion2Data(){
		return "A:  E \n" + 
    "B:  F E C  \n" +
    "C:  G B  \n" +
    "D:  G H  \n" +
    "E:  F B A  \n" +
    "F:  B E G  \n" +
    "G:  C H D F  \n" +
    "H:  G D ";
	}
	
	private static void printListToAnswer(List<Integer> vertices){
		for(Integer vertex : vertices){
			System.out.print(CONVERTER.getVertex(vertex) + " ");
		}
		
	}
	
	public static void main(String[] args) {
		runQuestion1();
		System.out.println();
		runQuestion2();
	}

}
