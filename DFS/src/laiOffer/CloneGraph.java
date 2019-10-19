package laiOffer;
import java.util.*;

public class CloneGraph {
	public List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) return null;
		List<GraphNode> copyGraph = new ArrayList<>();
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			copyGraph.add(copy(node, map));      
		}
		return copyGraph;
	}

	private GraphNode copy(GraphNode node, Map<GraphNode, GraphNode> map) {
		if (map.containsKey(node)) {
			return map.get(node);
		}
		GraphNode newNode = new GraphNode(node.key);
		map.put(node, newNode);
		for (GraphNode i : node.neighbors) {
			newNode.neighbors.add(copy(i, map));
		}
		return newNode;
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
