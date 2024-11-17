import java.util.*;

class BellmanFord {
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        private final List<Edge> edges;
        private final int V;    
        public Graph(int V) {
            this.V = V;
            edges = new ArrayList<>();
        }

        void addEdge(int src, int dest, int weight) {
            edges.add(new Edge(src, dest, weight));
        }

        void bellmanFord(int src) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            for (int i = 1; i <= V - 1; i++) {
                for (Edge edge : edges) {
                    if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                        dist[edge.dest] = dist[edge.src] + edge.weight;
                    }
                }
            }

            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }

            for (int i = 0; i < V; i++) {
                System.out.println("Distance from " + src + " to " + i + " is " + dist[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.bellmanFord(0);
    }
}
