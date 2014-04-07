
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SAP {
	private static final int UNKNOWN = -1;

	private Digraph digraph;

	public SAP(Digraph digraph) {
		this.digraph = digraph;
	}

	public int length(int v, int w) {
		return length(Arrays.asList(v), Arrays.asList(w));
	}

	public int ancestor(int v, int w) {
		return ancestor(Arrays.asList(v), Arrays.asList(w));
	}

	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return findSAP(v, w)[1];
	}

	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return findSAP(v, w)[0];
	}

	private int[] findSAP(Iterable<Integer> v, Iterable<Integer> w) {
		int[] distToV = createEmptyArray();
		bfs(v, distToV);

		int[] distToW = createEmptyArray();
		bfs(w, distToW);

		int[] sapAncLength = { UNKNOWN, UNKNOWN };

		for (int i = 0; i < digraph.V(); i++) {
			int distFromIToV = distToV[i];
			int distFromIToW = distToW[i];

			if (distFromIToV != UNKNOWN && distFromIToW != UNKNOWN) {
				int ancPathLength = distFromIToV + distFromIToW;
				if (sapAncLength[1] == UNKNOWN || ancPathLength < sapAncLength[1]) {
					sapAncLength[0] = i;
					sapAncLength[1] = ancPathLength;
				}

			}
		}

		return sapAncLength;
	}

	private int[] createEmptyArray() {
		int[] array = new int[digraph.V()];
		for (int i = 0; i < array.length; i++) {
			array[i] = UNKNOWN;
		}
		return array;
	}

	private void bfs(Iterable<Integer> source, int[] distTo) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[digraph.V()];

		for (Integer sourceVertex : source) {
			queue.add(sourceVertex);
			visited[sourceVertex] = true;

			distTo[sourceVertex] = 0;
		}

		while (queue.size() > 0) {
			Integer visit = queue.poll();
			visited[visit] = true;
			Iterable<Integer> neighbors = digraph.adj(visit);
			for (Integer next : neighbors) {
				if (!visited[next]) {
					queue.add(next);
					distTo[next] = distTo[visit] + 1;
				}
			}
		}
	}

}
