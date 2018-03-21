import java.util.*;
public class Kruskals {

static int[] parent;

public static int find(int n) {
	return parent[n] == n ? n : ( parent[n] = find(parent[n]) );
	
	/*
	 * if (parent[n] == n)
	 * 		return n;
	 * else
	 * 		return find(parent[n]);
	 */
}

public static void merge(int n1 , int n2) {
	parent[find(n1)] = parent[find(n2)];
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int numNodes = scan.nextInt();
parent = new int[numNodes];

for (int i = 0; i < numNodes; i++)
	parent[i] = i;

int numEdges = scan.nextInt();
ArrayList<Edge> edges = new ArrayList<>(numEdges);

for (int line = 1; line <= numEdges; line++)
	{
	int n1 = scan.nextInt();
	int n2 = scan.nextInt();
	int length = scan.nextInt();
	
	Edge e = new Edge(n1 , n2 , length);
	edges.add(e);
	}

Collections.sort(edges);
int total = 0;

for (int i = 0; i < numNodes - 1; i++)
	{
	Edge e = edges.remove(0);
	
	if (find(e.n1) == find(e.n2))
		i--;
	else
		{
		total += e.length;
		merge(e.n1 , e.n2);
		}
	}

System.out.println("Minimum total length: " + total);

scan.close();
	}
}

class Edge implements Comparable<Edge> {
	
int n1 , n2 , length;

public Edge(int n1 , int n2 , int length) {
	this.n1 = n1;
	this.n2 = n2;
	this.length = length;
}

public int compareTo(Edge other) {
	return this.length - other.length;
}

}

/*

Sample Data
===========

9 14

0 1 4
0 7 8
1 7 11
1 2 8
7 8 7
7 6 1
2 8 2
6 8 6
6 5 2
2 5 4
2 3 7
3 5 14
3 4 9
5 4 10

*/
