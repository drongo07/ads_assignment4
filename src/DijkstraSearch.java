import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(graph, source);
        distTo = new HashMap<>();
        for (V vertex : vertices.keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        dijkstra(source);
    }

    private void dijkstra(V source) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo.get(v.getData())));
        pq.add(vertices.get(source));

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
                pq.add(entry.getKey());
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w, double weight) {
        if (distTo.get(w.getData()) > distTo.get(v.getData()) + weight) {
            distTo.put(w.getData(), distTo.get(v.getData()) + weight);
            edgeTo.put(w.getData(), v.getData());
            marked.put(w.getData(), true);
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
