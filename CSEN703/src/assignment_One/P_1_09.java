package assignment_One;

import java.util.*;

public class P_1_9{

  public static class Edge {
    int cost, from, to, tax;
    
    // from -> current vertex
    // to -> connected to vertex
    // cost -> price of using this edge
    // tax -> taxes paid in vertex to
    
    public Edge(int from, int to, int cost,int tax) {
      this.to = to;
      this.from = from;
      this.cost = cost;
      this.tax = tax;
    }
  }

  // Create a graph with V vertices
  @SuppressWarnings("unchecked")
  public static List<Edge>[] createGraph(final int V) {
    List<Edge>[] graph = new List[V];
    for (int i = 0; i < V; i++) 
    	graph[i] = new ArrayList<>();
    return graph;
  }

  // add an edge to the graph
  public static void addEdge(List<Edge>[] graph, int from, int to, int cost,int tax) {
    graph[from].add(new Edge(from, to, cost, tax));
  }

  public static int shortestPathBFS(List<Edge>[] graph, int V, int start) {

	int[] dist = new int[V];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    for (int i = 0; i < V - 1; i++)
        for (List<Edge> edges : graph)
          for (Edge edge : edges)
            if (dist[edge.from] + edge.cost + edge.tax < dist[edge.to])
              dist[edge.to] = dist[edge.from] + edge.cost + edge.tax;
    return dist[V-1];
  }

  public static void main(String[] args) {

    int  V = 6, start = 0;
    List<Edge>[] graph = createGraph(V);
    // index 0 --> Cairo
    // index V-1 --> Aswan
    // index % 2 == 0 then oasis station, else river station
    addEdge(graph, 0, 1, 4, 1);
    addEdge(graph, 0, 2, 7, 1);
    addEdge(graph, 1, 3, 2, 1);
    addEdge(graph, 1, 4, 1, 1);
    addEdge(graph, 2, 3, 1, 1);
    addEdge(graph, 2, 4, 2, 1);
    addEdge(graph, 3, 5, 8, 1);
    addEdge(graph, 4, 5, 4, 1);
    System.out.println(shortestPathBFS(graph, V, start));

  }
}