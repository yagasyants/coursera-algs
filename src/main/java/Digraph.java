import com.yagasyants.courseraalgs.graph.Graph;


public class Digraph extends Graph {
	public Digraph(long numOfVertices) {
		super(numOfVertices);
	}

	public Digraph(String gStr) {
		super(gStr);
	}

	@Override
	public void addEdge(int left, int right) {
		adjList.get(left).add(right);
	}

	public Iterable<Integer> adj(int i) {
		return adjList.get(i);
	}

	@Override
	protected String getStringVertexConnect() {
		return "->";
	}

	public Digraph reverse() {
		Digraph reversed = new Digraph(V());
		for (int i = 0; i < V(); i++) {
			Iterable<Integer> nextVertex = adj(i);
			for(Integer j : nextVertex){
				reversed.addEdge(j, i);
			}
		}
		return reversed;
	}
}