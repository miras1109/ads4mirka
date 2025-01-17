public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(MyGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, V current) {
        marked.add(current);

        for (V v : graph.getVertex(current).getAdjacentVerticesData()){
            if (!marked.contains(v)) {
                edgeTo.put(v, source);
                dfs(graph, v);
            }
        }
    }
}


