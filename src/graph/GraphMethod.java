package graph;

import java.util.*;

public class GraphMethod<T> implements graph.Graph<T>{

    // Hashmap (sommet, list d'arc)
    protected final Map<T, List<Graph.Arc<T>>> adj = new HashMap<>();

    @Override
    public List<Graph.Arc<T>> getSucc(T s) {
        return adj.getOrDefault(s, List.of());
    }


}