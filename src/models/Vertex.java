package models;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V>  {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> v, double weight) {
        adjacentVertices.put(v, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex)) {
            return false;
        }

        if (o == this) {
            return true;
        }

        Vertex<V> otherVertex = (Vertex<V>) o;
        return this.data.equals(otherVertex.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
