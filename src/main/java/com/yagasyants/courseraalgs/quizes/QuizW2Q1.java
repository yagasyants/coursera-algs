package com.yagasyants.courseraalgs.quizes;

import java.util.List;

import org.mockito.internal.util.Primitives;

import com.yagasyants.courseraalgs.edgeweighted.Edge;
import com.yagasyants.courseraalgs.edgeweighted.EdgeWeightedGraph;
import com.yagasyants.courseraalgs.edgeweighted.KruskalMST;
import com.yagasyants.courseraalgs.edgeweighted.PrimMST;
import com.yagasyants.courseraalgs.graph.StringIntConverter;

public class QuizW2Q1 {
	private static void runQuestion1() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		String strGraph = getQuestion1Data();
		EdgeWeightedGraph edgeWeightedGraph = createGraph(converter, strGraph);
		KruskalMST mst = new KruskalMST(edgeWeightedGraph);

		List<Edge> edges = mst.edges();

		printListToAnswer(edges);
	}
	
	private static void runQuestion2() {
		StringIntConverter converter = new StringIntConverter("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		String strGraph = getQuestion2Data();
		EdgeWeightedGraph edgeWeightedGraph = createGraph(converter, strGraph);
		PrimMST mst = new PrimMST(edgeWeightedGraph);

		List<Edge> edges = mst.edges();

		printListToAnswer(edges);
	}
	
	private static void printListToAnswer(List<Edge> list){
		for(Edge e : list){
			System.out.print((int)e.weigth() + " ");
		}
		System.out.println();
	}

	
	private static EdgeWeightedGraph createGraph(StringIntConverter converter, String strGraph){
		EdgeWeightedGraph graph = new EdgeWeightedGraph(converter.size());
		
		String[] adjStrList = strGraph.split("\n");

		for (int i = 0; i < adjStrList.length; i++) {
			String vString = adjStrList[i];
			int left = converter.getIndex(vString.substring(0, 1));
			int right = converter.getIndex(vString.substring(2, 3));
			int weight = Integer.parseInt(vString.substring(4).trim());
			
			graph.addEdge(new Edge(left, right, weight));
		}
		
		return graph;
	}
	
	private static final String getQuestion1Data(){
		return "B-A     3 \n" +
    "A-F     1 \n" +
    "B-C     7 \n" +
    "B-F     6 \n" +
    "B-G     5 \n" +
    "C-H    13 \n" +
    "D-C    10 \n" +
    "C-G     9 \n" +
    "D-J    17 \n" +
    "D-E    16 \n" +
    "H-D    14 \n" +
    "I-D     2 \n" +
    "J-E    15 \n" +
    "F-G     4 \n" +
    "H-G    11 \n" +
    "I-H    12 \n" +
    "I-J     8";
	}
	
	private static final String getQuestion2Data(){
		return "A-B      17 \n" +
    "G-A      14 \n" +
    "A-F      11 \n" +
    "B-G       4 \n" +
    "B-C       3 \n" +
    "H-B       2 \n" +
    "C-D      16 \n" +
    "H-C       5 \n" +
    "D-E       8 \n" +
    "D-H       7 \n" +
    "D-I       6 \n" +
    "I-E       9 \n" +
    "E-J       1 \n" +
    "G-F      13 \n" +
    "H-G      12 \n" +
    "H-I      10 \n" +
    "J-I      15";
	}
	
	public static void main(String[] args) {
		runQuestion1();
		runQuestion2();
//		runQuestion3();
	}



}
