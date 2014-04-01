package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import com.yagasyants.courseraalgs.graph.Graph;
import com.yagasyants.courseraalgs.graph.TypeParser;

public class Quiz1 {
	private static final String[] VERTICES = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	private static void runQuestion1() {
		Graph<String> graph = new Graph<>(VERTICES, getQuestion1Data(), createStringParser());

		List<String> vertices = graph.depthFirst();
		
		printListToAnswer(vertices);

	}
	
	private static final String getQuestion1Data(){
		return "A:  E \n" + 
    "B:  F E C \n" +
    "C:  G B \n" +
    "D:  G H \n" +
    "E:  F B A \n" +
    "F:  B E G \n" +
    "G:  C H D F \n" +
    "H:  G D ";
	}

	private static TypeParser<String> createStringParser() {
		return new TypeParser<String>() {
			public String parse(String s) {
				return s;
			}
		};
	}
	
	private static void printListToAnswer(List<String> vertices){
		for(String vertex : vertices){
			System.out.print(vertex + " ");
		}
		
	}
	
	public static void main(String[] args) {
		runQuestion1();
	}

}
