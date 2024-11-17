import java.util.*;

class Dijkstra {
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        private final List<List<Edge>> adjList;
        public Graph(int vertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }
        
        void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Edge(dest, weight));
        }

        void dijkstra(int src) {
            int V = adjList.size();
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{src, 0});
            
            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0];
                int d = node[1];

                if (d > dist[u])
                 continue;

                for (Edge e : adjList.get(u)) {
                    int v = e.dest;
                    int weight = e.weight;

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                System.out.println("Distance from " + src + " to " + i + " is " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);

        graph.dijkstra(0);
    }
}