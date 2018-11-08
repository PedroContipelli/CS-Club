import java.util.*;
public class gyms {
	
static ArrayList<String> allPaths = new ArrayList<>();

public static String strFromPath(ArrayList<Type> path) {
	StringBuilder str = new StringBuilder();
	
	for (int i = path.size() - 1; i >= 0; i--)
		{
		str.append(path.get(i).type);
		str.append(" ");
		}
	
	return str.substring(0 , str.length() - 1);
}

public static void DFS(Type current , ArrayList<Type> path , int max) {

	if (path.size() == max)
		{
		allPaths.add(strFromPath(path));
		return;
		}
	
	for (Type toNode : current.toNode)
		{
		if (!path.contains(toNode))
			{
			path.add(toNode);
			DFS(toNode , path , max);
			path.remove(toNode);
			}
		}
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int testcases = scan.nextInt();

for (int z = 1; z <= testcases; z++)
	{
	int numTypes = scan.nextInt();
	
	Type[] types = new Type[numTypes];
	int[][] edges = new int[numTypes][numTypes];
	
	for (int i = 0; i < types.length; i++)
		{
		types[i] = new Type(scan.next());
		
		for (int j = 0; j < types.length; j++)
			edges[i][j] = scan.nextInt();
		}
	
	for (int i = 0; i < types.length; i++)
		for (int j = 0; j < types.length; j++)
			if (edges[i][j] == 1)
				types[i].add(types[j]);
	
	allPaths = new ArrayList<>();
	
	for (Type start : types)
		{
		ArrayList<Type> path = new ArrayList<>();
		path.add(start);
		DFS(start , path , types.length);
		}
	
	Collections.sort(allPaths);
	
	if (allPaths.isEmpty())
		System.out.printf("Type Chart #%d: %s\n" , z , "Impossible");
	else
		System.out.printf("Type Chart #%d: %s\n" , z , allPaths.get(0));
	}

scan.close();
	}
}

class Type implements Comparable<Type> {
	
String type;
ArrayList<Type> toNode = new ArrayList<>();

public Type(String str) {
	type = str;
}

public String toString() {
	return type;
}

public int compareTo(Type other) {
	return type.compareTo(other.type);
}

public void add(Type node) {
	toNode.add(node);
}

}