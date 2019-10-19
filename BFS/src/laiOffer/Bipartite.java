package laiOffer;
import java.util.*;

public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		if (graph.size() == 0) {
			return false;
		}
		Map<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!visited.containsKey(node)) {
				if (!BFS(node, visited)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean BFS(GraphNode start, Map<GraphNode, Integer> visited) {
		visited.put(start, 0);
		Queue<GraphNode> queue = new ArrayDeque<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int group = visited.get(cur);
			int nei = group == 0 ? 1 : 0;
			for (GraphNode node : cur.neighbors) {
				if (!visited.containsKey(node)) {
					visited.put(node, nei);
					queue.offer(node);
				} else {
					if (visited.get(node) != nei) {
						return false;
					} else {
						queue.offer(node);
					}
				}
			}
		}
		return true;
	}
}

class GraphNode {
	public int key;
	public List<GraphNode> neighbors;
	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}
}
