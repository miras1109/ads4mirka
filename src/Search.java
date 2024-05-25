import java.util.*;

public class Search<V> {
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }
    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<V> path = new Stack<>();
        for (V x = v; x != null; x = edgeTo.get(x)) {
            path.push(x);
        }
        return path;
    }
}
