import models.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillGraph(graph);

        System.out.println("Dijkstra search");
        Search<String> djk = new Dijkstra<>(graph, new Vertex<>("Almaty"));
        outputPath(djk, new Vertex<>("Kyzylorda"));

        System.out.println("--------------------------------------------------");

        System.out.println("Breadth first search");
        Search<String> bfs = new BFS<>(graph, new Vertex<>("Almaty"));
        outputPath(bfs, new Vertex<>("Kyzylorda"));
    }

    public static void fillGraph(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 2.1);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 7.8);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 7.1);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 7.2);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 3.9);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 3.5);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 5.4);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}