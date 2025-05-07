package models;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<Vertex<V>>{
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        super.visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> popped = queue.remove();
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
