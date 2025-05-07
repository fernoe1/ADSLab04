package models;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addEdge(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Vertex otherVertex = (Vertex) o;
        return this.data.equals(otherVertex.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
