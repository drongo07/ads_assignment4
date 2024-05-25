import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(graph, source);
        bfs(source);
    }

    private void bfs(V source) {
        Queue<V> queue = new LinkedList<>();
        marked.put(source, true);
        queue.add(source);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Vertex<V> w : vertices.get(v).getAdjacentVertices().keySet()) {
                if (!marked.get(w.getData())) {
                    edgeTo.put(w.getData(), v);
                    marked.put(w.getData(), true);
                    queue.add(w.getData());
                }
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
