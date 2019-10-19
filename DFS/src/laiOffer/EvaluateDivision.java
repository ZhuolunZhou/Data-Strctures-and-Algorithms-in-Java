package laiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = buildGraph(equations, values);
		double[] result = new double[queries.size()];
		for (int i = 0; i < result.length; i++) {
			List<String> query = queries.get(i);
			String start = query.get(0), end = query.get(1);
			if (!graph.containsKey(start) || !graph.containsKey(end)) {
				result[i] = -1.0;
				continue;
			} else if (start.equals(end)) {
				result[i] = 1.0;
				continue;
			}
			Set<String> visited = new HashSet<>();
			double val = dfs(start, end, visited, graph, 1.0);
			result[i] = val == 0.0 ? -1.0 : val;
		}
		return result;
	}

	private double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph, double val) {
		if (graph.get(start).containsKey(end)) 
			return val * graph.get(start).get(end);
		double tmp = 0.0;
		for (String neighbor : graph.get(start).keySet()) {
			if (!visited.contains(neighbor)) {
				visited.add(neighbor);
				tmp = dfs(neighbor, end, visited, graph, val * graph.get(start).get(neighbor));
				if (tmp != 0.0) break;
			}
		}
		return tmp;        
	}


	private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String a = equations.get(i).get(0);
			String b = equations.get(i).get(1);
			double val = values[i];
			Map<String, Double> edge = graph.get(a);
			if (edge == null) edge = new HashMap<>();
			edge.put(b, val);
			graph.put(a, edge);
			if (val != 0) {
				Map<String, Double> edgeR = graph.get(b);
				if (edgeR == null) edgeR = new HashMap<>();
				edgeR.put(a, 1 / val);
				graph.put(b, edgeR);
			}
		}
		return graph;
	}
}
