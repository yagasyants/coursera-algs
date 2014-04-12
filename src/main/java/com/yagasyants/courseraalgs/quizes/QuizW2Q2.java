package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import com.yagasyants.courseraalgs.edgeweighted.BellmanFordSP;
import com.yagasyants.courseraalgs.edgeweighted.DijkstraSP;
import com.yagasyants.courseraalgs.edgeweighted.DirectedEdge;
import com.yagasyants.courseraalgs.edgeweighted.Edge;
import com.yagasyants.courseraalgs.edgeweighted.EdgeWeightedDigraph;
import com.yagasyants.courseraalgs.edgeweighted.TopoDagSP;
import com.yagasyants.courseraalgs.graph.StringIntConverter;

public class QuizW2Q2 {
	private static void runQuestion1() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H");
		String strGraph = getQuestion1Data();
		EdgeWeightedDigraph graph = createGraph(converter, strGraph);
		new DijkstraSP(graph, 2);
	}
	
	private static void runQuestion2() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H");
		String strGraph = getQuestion2Data();
		EdgeWeightedDigraph graph = createGraph(converter, strGraph);
		new TopoDagSP(graph, 6);
	}
	
	private static void runQuestion3() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H");
		String strGraph = getQuestion3Data();
		EdgeWeightedDigraph graph = createGraph(converter, strGraph);
		new BellmanFordSP(graph, 3);
	}
	
	
	private static EdgeWeightedDigraph createGraph(StringIntConverter converter, String strGraph){
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(converter.size());
		
		String[] adjStrList = strGraph.split("\n");

		for (int i = 0; i < adjStrList.length; i++) {
			String vString = adjStrList[i];
			int left = converter.getIndex(vString.substring(0, 1));
			String rightStr = vString.substring(3, 4);
			int right = converter.getIndex(rightStr);
			int weight = Integer.parseInt(vString.substring(5).trim());
			
			graph.addEdge(new DirectedEdge(left, right, weight));
		}
		
		return graph;
	}
	
	private static final String getQuestion1Data(){
		return "B->A     9 \n" +
    "C->B    80 \n" +
    "C->D    14 \n" +
    "C->F    65 \n" +
    "C->G    21 \n" +
    "C->H    58 \n" +
    "D->H    38 \n" +
    "E->A    19 \n" +
    "E->B     7 \n" +
    "F->B    21 \n" +
    "F->E    17 \n" +
    "G->F    37 \n" +
    "H->G     1";
	}
	
	private static final String getQuestion2Data(){
		return "A->E     0 \n" +
    "B->A    15 \n" +
    "B->E    19 \n" +
    "B->F     1 \n" +
    "C->B    32 \n" +
    "C->D    36 \n" +
    "C->H    50 \n" +
    "D->H     9 \n" +
    "F->E    53 \n" +
    "G->B    69 \n" +
    "G->C    27 \n" +
    "G->F    22 \n" +
    "G->H    78";
	}
	
	private static final String getQuestion3Data(){
		return "A->E    25 \n" +
    "B->A    34 \n" +
    "C->B    15 \n" +
    "D->G    10 \n" +
    "D->H    25 \n" +
    "D->C    30 \n" +
    "E->F     3 \n" +
    "F->B     6 \n" +
    "F->A    41 \n" +
    "G->C    18 \n" +
    "G->F    36 \n" +
    "G->B    40 \n" +
    "H->G     1";
	}	
	public static void main(String[] args) {
		runQuestion1();
		//runQuestion2();
		//runQuestion3();
	}
}
