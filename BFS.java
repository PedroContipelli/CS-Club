import java.util.*;

public class BFS {

static int[] R = { 0 , 0 , -1 , 1 };
static int[] C = { 1 , -1 , 0 , 0 };

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int maps = scan.nextInt();

for (int z = 0; z < maps; z++)
{
	int cols = scan.nextInt();
	int rows = scan.nextInt();
	
	char[][] map = new char[rows][cols];
	int[][] dist = new  int[rows][cols];
	
	for (int i = 0; i < rows; i++)
	{
		map[i] = scan.next().toCharArray();
		Arrays.fill(dist[i] , -1);
	}
	
	Point start = new Point(-1 , -1);
	Point end   = new Point(-1 , -1);
	
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			if (map[i][j] == 'S')
				start = new Point(i , j);
			else if (map[i][j] == 'E')
				end = new Point(i , j);
	
	ArrayList<Point> queue = new ArrayList<>();
	queue.add(start);
	dist[start.r][start.c] = 0;
	
	while (!queue.isEmpty())
	{
		Point current = queue.remove(0);
		
		for (int i = 0; i < 4; i++)
		{
			int r = current.r + R[i];
			int c = current.c + C[i];
			
			if (r >= 0 && c >= 0 && r < rows && c < cols)
				if (dist[r][c] == -1 && (map[r][c] == '#' || map[r][c] == 'E'))
				{
					dist[r][c] = 1 + dist[current.r][current.c];
					queue.add(new Point(r , c));
				}
		}
	}
	
	System.out.println(dist[end.r][end.c]);
}

scan.close();
	}
}

class Point {
	
int r , c;

public Point(int r , int c) {
	this.r = r;
	this.c = c;
}

}