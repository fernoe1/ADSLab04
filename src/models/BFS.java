package models;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V> {
    public BFS(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
        bfs(graph, graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
    }

    public void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        super.visited.add(source);
        super.path.put(source, null);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> popped = queue.poll();
            for (Vertex<V> vertex : popped.getAdjacentVertices().keySet()) {
                if (!super.visited.contains(vertex)) {
                    super.visited.add(vertex);
                    super.path.put(vertex, popped);
                    queue.add(vertex);
                }
            }
        }
    }
}
