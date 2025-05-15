package models;

import java.util.*;

public class Dijkstra<V> extends Search<V> {
    public Dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        super(graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
        dijkstra(graph, graph.getSet().stream().filter(v -> v.equals(source)).findFirst().get());
    }

    public void dijkstra(WeightedGraph<V> graph, Vertex<V> source) {
        PriorityQueue<Map.Entry<Vertex<V>, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        Map<Vertex<V>, Double> distances = new HashMap<>();

        for (Vertex<V> v : graph.getSet()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);
        queue.add(new AbstractMap.SimpleEntry<>(source, 0.0));

        while (!queue.isEmpty()) {
            Map.Entry<Vertex<V>, Double> popped = queue.poll();

            if (super.visited.contains(popped.getKey())) {
                continue;
            }

            super.visited.add(popped.getKey());

            for (Map.Entry<Vertex<V>, Double> entry : popped.getKey().getAdjacentVertices().entrySet()) {
                double newWeight = popped.getValue() + entry.getValue();

                if (newWeight < distances.get(entry.getKey())) {
                    distances.put(entry.getKey(), newWeight);
                    super.path.put(entry.getKey(), popped.getKey());
                    queue.add(new HashMap.SimpleEntry<>(entry.getKey(), newWeight));
                }
            }
        }
    }
}
