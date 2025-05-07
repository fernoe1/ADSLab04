package models;

import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> visited;
    protected Map<Vertex, Vertex> path;
    private final Vertex source;

    public Search(Vertex source) {
        visited = new HashSet<>();
        path = new HashMap<>();
        this.source = source;
    }

    public boolean hasPathTo(Vertex v) {
        return visited.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Vertex> stack = new Stack<>();
        while (v != source) {
            stack.push(v);
            v = path.get(v);
        }
        stack.push(source);

        return stack;
    }
}
