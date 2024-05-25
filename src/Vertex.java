import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V> , Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public Vertex() {
        this(null);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<V> dest, Double weight) {
        adjacentVertices.put(dest, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public Iterable<V> getAdjacentVerticesData() {
        return adjacentVertices.keySet().stream().map(Vertex::getData)::iterator;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> otherVertex = (Vertex<?>) obj;
        return data.equals(otherVertex.data);
    }
}