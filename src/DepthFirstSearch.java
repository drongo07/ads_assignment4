import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    private MyGraph<V> graph;

    public DepthFirstSearch(MyGraph<V> graph, V source) {
        super(null, source); 
        this.graph = graph;
        for (V vertex : graph.getVertices()) {
            marked.put(vertex, false);
        }
        dfs(source);
    }

    private void dfs(V v) {
        marked.put(v, true);
        for (V w : graph.getAdjVertices(v)) {
            if (!marked.get(w)) {
                edgeTo.put(w, v);
                dfs(w);
            }
        }
    }

    @Override
    public List<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != source; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}
