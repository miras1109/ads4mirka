import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distanceMap = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V startVertex) {
        super(startVertex);

        for (V vertex : graph.getVertices()) {
            distanceMap.put(vertex, Double.POSITIVE_INFINITY);
        }

        distanceMap.put(startVertex, 0.0);

        performDijkstra(graph);
    }

    private void performDijkstra(WeightedGraph<V> graph) {

        while (true) {
            V closestVertex = null;
            double smallestDist = Double.POSITIVE_INFINITY;

            for (V vertex : distanceMap.keySet()) {
                if (!marked.contains(vertex) && distanceMap.get(vertex) < smallestDist) {
                    closestVertex = vertex;
                    smallestDist = distanceMap.get(vertex);
                }
            }

            if (closestVertex == null) {
                break;
            }

            marked.add(closestVertex);

            for (V neighbor : graph.getAdjacentVertices(closestVertex)) {
                if (!marked.contains(neighbor)) {
                    double potentialDist = distanceMap.get(closestVertex) + graph.getWeight(closestVertex, neighbor);
                    if (potentialDist < distanceMap.get(neighbor)) {
                        distanceMap.put(neighbor, potentialDist);
                        edgeTo.put(neighbor, closestVertex);
                    }
                }
            }
        }
    }
}
