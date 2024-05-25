import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean isDirected;

    public WeightedGraph(boolean isDirected) {
        this.vertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        addVertex(source);
        addVertex(dest);

        vertices.get(source).addAdjacentVertex(vertices.get(dest), weight);

        if (!isDirected) {
            vertices.get(dest).addAdjacentVertex(vertices.get(source), weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
