import java.util.*;
class Main {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int N = scan.nextInt();
Node[] graph = new Node[N];

for (int i = 0; i < N; i++)
  graph[i] = new Node();
  
int E = scan.nextInt();
  
for (int i = 0; i < E; i++)
  {
  Node n1 = graph[scan.nextInt()];
  Node n2 = graph[scan.nextInt()];
  int length = scan.nextInt();
  
  Edge e = new Edge(n2 , length);
  n1.edges.add(e);
      
  e = new Edge(n1 , length);
  n2.edges.add(e);
  }
  
PriorityQueue<Node> q = new PriorityQueue<>();
Node start = graph[0];
q.add(start);
start.shortestPath = 0;

while (!q.isEmpty())
  {
  Node current = q.remove();
  current.visited = true;
  
  for (Edge e : current.edges)
    if (!e.toNode.visited)
      {
      e.toNode.shortestPath = Math.min(e.toNode.shortestPath , current.shortestPath + e.length);
      q.remove(e.toNode);
      q.add(e.toNode);
      }
  }
  
for (int i = 0; i < graph.length; i++)
  System.out.println("Shortest path to Node " + i + " = " + graph[i].shortestPath);

scan.close();
  }
}

class Node implements Comparable<Node> {
  int shortestPath = Integer.MAX_VALUE;
  boolean visited = false;
  ArrayList<Edge> edges = new ArrayList<>();
  
  public int compareTo(Node other) {
    return shortestPath - other.shortestPath;
  }
}

class Edge {
  Node toNode;
  int length;
  
  public Edge(Node toNode , int length) {
    this.toNode = toNode;
    this.length = length;
  }
}












