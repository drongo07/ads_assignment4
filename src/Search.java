import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Map<V, Vertex<V>> vertices;
    protected Map<V, Boolean> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(WeightedGraph<V> graph, V source) {
        this.vertices = graph != null ? graph.getVertices() : new HashMap<>();
        this.source = source;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
        for (V vertex : vertices.keySet()) {
            marked.put(vertex, false);
        }
    }

    public boolean hasPathTo(V v) {
        return marked.get(v) != null && marked.get(v);
    }

    public abstract List<V> pathTo(V v);
}
