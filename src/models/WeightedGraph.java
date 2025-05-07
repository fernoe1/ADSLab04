package models;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> graph;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        graph = new HashSet<>();
    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(Vertex<V> vertex) {
        graph.add(vertex);
    }

    public void addEdge(Vertex<V> src, Vertex<V> dst, double weight) {
        for (Vertex<V> vertex : graph) {
            if (vertex.equals(src)) {
                vertex.addEdge(dst, weight);
                return;
            }
        }
    }
}
