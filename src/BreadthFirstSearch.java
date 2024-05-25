import java.util.*;


public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        Bfs(graph, source);
    }

    private void Bfs(MyGraph<V> graph, V current) {
        Queue<V> queue = new LinkedList<>();
        queue.add(current);
        marked.add(current);

        while (!queue.isEmpty()) {
            V v = queue.poll();

            for (Vertex<V> vertex : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (!marked.contains(vertex.getData())) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), v);
                    queue.add(vertex.getData());
                }
            }
        }
    }
}

