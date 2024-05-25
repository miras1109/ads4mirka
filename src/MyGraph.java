import java.util.*;
public class MyGraph<V> extends WeightedGraph<V> {
    private static final double DEFAULT_WEIGHT = 7.0;
    public MyGraph(boolean directed) {
        super(directed);
    }

    public MyGraph() {
        super();
    }

    public void addEdge(V src, V dest) {
        super.addEdge(src, dest, 0.0);
    }
}
