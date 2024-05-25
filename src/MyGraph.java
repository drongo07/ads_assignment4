import java.util.*;

public class MyGraph<V> {
    private Map<V, List<V>> adjVertices;
    private boolean isDirected;

    public MyGraph(boolean isDirected) {
        this.adjVertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(V v) {
        adjVertices.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(V source, V dest) {
        addVertex(source);
        addVertex(dest);
        adjVertices.get(source).add(dest);
        if (!isDirected) {
            adjVertices.get(dest).add(source);
        }
    }

    public List<V> getAdjVertices(V v) {
        return adjVertices.get(v);
    }

    public Set<V> getVertices() {
        return adjVertices.keySet();
    }
}
