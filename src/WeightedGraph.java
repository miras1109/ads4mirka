import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<V, Vertex<V>> verticesMap = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(V data) {
        verticesMap.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, Double weight) {
        if (!verticesMap.containsKey(source)) {
            addVertex(source);
        }

        if (!verticesMap.containsKey(dest)) {
            addVertex(dest);
        }

        verticesMap.get(source).addAdjacentVertex(verticesMap.get(dest), weight);

        if (!directed) {
            verticesMap.get(dest).addAdjacentVertex(verticesMap.get(source), weight);
        }
    }

    public boolean hasVertex(V data) {
        return verticesMap.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return verticesMap.get(data);
    }

    public Iterable<V> getVertices() {
        return verticesMap.keySet();
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) {
            return false;
        }

        return verticesMap.get(source).getAdjacentVertices().containsKey(verticesMap.get(dest));
    }

    public Double getWeight(V source, V dest) {
        if (!hasEdge(source, dest)) {
            return Double.POSITIVE_INFINITY;
        }

        return verticesMap.get(source).getAdjacentVertices().get(verticesMap.get(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return verticesMap.keySet();
    }
}
