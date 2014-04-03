package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import com.yagasyants.courseraalgs.graph.BreadthFirstSearch;
import com.yagasyants.courseraalgs.graph.Digraph;
import com.yagasyants.courseraalgs.graph.StringIntConverter;
import com.yagasyants.courseraalgs.graph.StrongComponents;
import com.yagasyants.courseraalgs.graph.TopologicOrder;

public class Quiz2 {
	private static void runQuestion1() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H");
		String intGraph = converter.toIntGraphString(getQuestion1Data());
		Digraph graph = new Digraph(intGraph);
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);

		List<Integer> vertices = bfs.runSearch();

		converter.printListToAnswer(vertices);
	}

	private static void runQuestion2() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H");
		String intGraph = converter.toIntGraphString(getQuestion2Data());
		Digraph graph = new Digraph(intGraph);
		TopologicOrder search = new TopologicOrder(graph);

		List<Integer> vertices = search.runSearch();

		converter.printListToAnswer(vertices);
	}

	private static void runQuestion3() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		String intGraph = converter.toIntGraphString(getQuestion3Data());
		Digraph graph = new Digraph(intGraph);
		StrongComponents algo = new StrongComponents(graph);

		Integer[] components = algo.runSearch();
		for(Integer i : components){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static final String getQuestion1Data(){
		return "A:  B E \n"+ 
    "B:  C  \n"+
    "C:  G F  \n"+
    "D:  C H G  \n"+
    "E:  F B  \n"+
    "F:  B  \n"+
    "G:  H F  \n"+
    "H:  ";
	}
	
	private static final String getQuestion2Data(){
		return "A:  B  \n"+
    "B:  G  \n"+
    "C:  G B  \n"+
    "D:  H C G  \n"+
    "E:  A B F  \n"+
    "F:  B G  \n"+
    "G:  H  \n"+
    "H:";
	}
	
	private static final String getQuestion3Data(){
		return "A:  F  \n"+ 
    "B:  H G A C   \n"+
    "C:  H   \n"+
    "D:  C   \n"+
    "E:  I D   \n"+
    "F:  G   \n"+
    "G:  A   \n"+
    "H:  I D G   \n"+
    "I:  D J   \n"+
    "J:  E ";
	}
	
	public static void main(String[] args) {
		runQuestion1();
		runQuestion2();
		runQuestion3();
	}
}
