package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import com.yagasyants.courseraalgs.graph.BreadthFirstSearch;
import com.yagasyants.courseraalgs.graph.ConnectedComponents;
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

		List<Integer> vertices = dfs.runSearch(0);
		
		printListToAnswer(vertices);
	}
	
	private static void runQuestion2() {
		String intGraph = CONVERTER.toIntGraphString(getQuestion2Data());
		Graph graph = new Graph(intGraph);
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph); 

		List<Integer> vertices = bfs.runSearch();
		
		printListToAnswer(vertices);
	}
	
	private static void runQuestion3() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		String intGraph = converter.toIntGraphString(getQuestion3Data());
		Graph graph = new Graph(intGraph);
		ConnectedComponents cc = new ConnectedComponents(graph); 

		Integer[] components = cc.runSearch();
		
		for(Integer i : components){
			System.out.print(i + " ");
		}
		System.out.println();
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
	
	private static final String getQuestion3Data(){
		return "A:  F B \n" + 
    "B:  C G A F \n" +
    "C:  B G \n" +
    "D:  H I \n" +
    "E:  J \n" +
    "F:  A G B \n" +
    "G:  C B F \n" +
    "H:  D I \n" +
    "I:  D H \n" +
    "J:  E ";
	}
	
	private static void printListToAnswer(List<Integer> vertices){
		for(Integer vertex : vertices){
			System.out.print(CONVERTER.getVertex(vertex) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		runQuestion1();
		runQuestion2();
		runQuestion3();
	}

}
