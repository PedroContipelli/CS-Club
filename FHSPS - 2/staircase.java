import java.util.*;
public class staircase {

static HashMap<Integer , HashSet<Integer>> graph = new HashMap<>();
static HashSet<Integer> visited = new HashSet<>();

public static void DFS(int current) {
	for (int check : graph.get(current))
		if (!visited.contains(check))
			{
			visited.add(check);
			DFS(check);
			}
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
	
int T = scan.nextInt();
	
for (int z = 1; z <= T; z++)
	{
	int N = scan.nextInt();
	int end = scan.nextInt();
	graph.clear();
	visited.clear();
	
	graph.put(0 , new HashSet<Integer>());
	
	for (int i = 0; i < N; i++)
		{
		int u = scan.nextInt();
		int v = scan.nextInt();
		
		if (!graph.containsKey(u))
			graph.put(u , new HashSet<Integer>());
		
		if (!graph.containsKey(v))
			graph.put(v , new HashSet<Integer>());
		
		graph.get(u).add(v);
		graph.get(v).add(u);
		}
	
	visited.add(0);
	DFS(0);
	
	System.out.print("Staircase #" + z + ": ");
	System.out.println(visited.contains(end) ? "Possible" : "Impossible");
	}

scan.close();
	}
}

/*

1
4 4
0 1
1 3
2 3
2 7

*/
