package com.yagasyants.courseraalgs.progassmts.wordnet;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.yagasyants.courseraalgs.graph.Digraph;

public class WordNet {
	private static final Integer UNKNOWN_ROOT = Integer.MIN_VALUE;

	private Map<String, Integer> nounToVertex = new HashMap<>();
	private int root = UNKNOWN_ROOT;
	private Digraph digraph;

	public WordNet(String synFile, String hypFile) {
		try {
			processFile(synFile, new SynFileProcessor());
			processFile(hypFile, new HypFileProcessor());
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		validatGraphIsRootedDAG();
	}

	private void processFile(String synFile, FileProcessor fileProcessor) throws IOException {
		FileInputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = new FileInputStream(new File(synFile));
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);

			String strLine;
			int lineNumber = 0;
			while ((strLine = bufferedReader.readLine()) != null) {
				fileProcessor.processLine(strLine, lineNumber);

				lineNumber++;
			}
			fileProcessor.postLineProcess(lineNumber);
		} finally {
			close(bufferedReader);
			close(inputStreamReader);
			close(inputStream);
		}
	}

	private void close(Closeable closable) throws IOException {
		if (closable != null) {
			closable.close();
		}
	}

	private interface FileProcessor {
		void processLine(String strLine, int lineNumber);

		void postLineProcess(int processedLines);
	}

	private class SynFileProcessor implements FileProcessor {

		@Override
		public void processLine(String strLine, int lineNumber) {
			String[] parts = strLine.split(",");
			validateParts(strLine, parts, 2);
			String idStr = parts[0];
			String nounsStr = parts[1];
			validate(idStr, strLine, lineNumber);

			addNouns(lineNumber, nounsStr);
		}

		@Override
		public void postLineProcess(int processedLines) {
			digraph = new Digraph(processedLines);
		}
	}

	private class HypFileProcessor implements FileProcessor {
		@Override
		public void processLine(String strLine, int lineNumber) {
			String[] arrayIds = strLine.split(",");
			validateParts(strLine, arrayIds, 1);
			Integer syn = Integer.valueOf(arrayIds[0]);

			for (int i = 1; i < arrayIds.length; i++) {
				Integer hyp = Integer.parseInt(arrayIds[i]);
				digraph.addEgde(syn, hyp);
			}
		}

		@Override
		public void postLineProcess(int processedLines) {
		}
	}

	private void validateParts(String strLine, String[] parts, int minSize) {
		if (parts == null || parts.length < minSize) {
			throw new IllegalArgumentException("Line " + strLine + " does not have the expected format");
		}
	}

	private void validate(String idStr, String strLine, int vertexCounter) {
		if (!idStr.trim().equalsIgnoreCase(String.valueOf(vertexCounter))) {
			throw new IllegalArgumentException("Line " + strLine + " does not have the expected format: expected id " + vertexCounter
					+ " but was: " + idStr);
		}
	}

	private void addNouns(Integer id, String nounsStr) {
		String[] nouns = nounsStr.trim().split(" ");

		for (String noun : nouns) {
			nounToVertex.put(noun, id);
		}
	}

	private void validatGraphIsRootedDAG() {
		boolean[] visited = new boolean[digraph.getNumberOfVertices()];
		Set<Integer> inPath = new HashSet<>();
		for (int i = 0; i < digraph.getNumberOfVertices(); i++) {
			if (!visited[i]) {
				validationDfs(i, visited, inPath);
			}
		}
	}

	private void validationDfs(Integer visit, boolean[] visited, Set<Integer> inPath) {
		if (!visited[visit]) {
			checkRoot(visit);
			checkCycle(visit, inPath);
			
			visited[visit] = true;
			inPath.add(visit);

			Iterable<Integer> neighbors = digraph.adj(visit);
			if (neighbors.iterator().hasNext()) {
				validationDfs(visit, visited, inPath);
			}
			inPath.remove(visit);
		}
	}

	private void checkCycle(Integer visit, Set<Integer> inPath) {
		if (inPath.contains(visit)) {
			throw new IllegalArgumentException("The has cycle: " + inPath + ", " + visit);
		}
	}

	private void checkRoot(Integer visit) {
		Iterable<Integer> neighbors = digraph.adj(visit);
		boolean isRoot = !neighbors.iterator().hasNext();
		if(isRoot){
			if (root == UNKNOWN_ROOT) {
				root = visit;
			} else {
				throw new IllegalArgumentException("The graph is not rooted: there are two vertex with no connection: " + root + " and "
						+ visit);
			}
		}

	}

	public Iterable<String> nouns() {
		return nounToVertex.keySet();
	}

	public boolean isNoun(String string) {
		return nounToVertex.containsKey(string);
	}

}
