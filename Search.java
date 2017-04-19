import java.io.*;
import java.util.*;
public class Search {

static BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
static int[] R = {-1 , 1 , 0 , 0};
static int[] C = {0 , 0 , -1 , 1};
static int rows , cols , format;
static String zeroes , dashes , skip = "";

public static boolean inBounds(int a , int b) {
	return a >= 0 && a < rows && b >= 0 && b < cols;
}

public static void print(char[][] map , int[][] dist) throws IOException {
	
	write.write(skip);
	
	for (int i = 0; i < map.length; i++)
		{
		write.write(new String(map[i]) + "\t");
		
		for (int j = 0; j < map[i].length; j++)
			{
			String node = dist[i][j] == -1 ? dashes : zeroes + dist[i][j];
			write.write(node.substring(node.length() - format) + " ");
			}
			
		write.newLine();
		}
	
	write.flush();
}

public static void main(String[] args) throws InterruptedException , IOException {
Scanner scan = new Scanner(System.in);

System.out.print("Enter rows: "); rows = scan.nextInt();
System.out.print("Enter cols: "); cols = scan.nextInt();
System.out.print("Speed (1 - 10): "); int speed = 300 - 25*scan.nextInt();
System.out.print("Enter BFS or DFS: "); boolean BFS = scan.next().toUpperCase().equals("BFS");

format = (int)Math.log10(rows*cols);
char[][] map = new char[rows][cols];
int[][] dist = new int[rows][cols];

zeroes = "000000".substring(0 , format);
dashes = "------".substring(0 , format);

for (int i = 0; i < rows; i++)
	{
	Arrays.fill(dist[i] , -1);
	skip += "\n\n";
	
	for (int j = 0; j < cols; j++)
		map[i][j] = Math.random() > 0.7 ? '#' : '.';
	}

int startRow = (int)(Math.random()*rows);
int startCol = (int)(Math.random()*cols);

Point start = new Point(startRow , startCol);
map[startRow][startCol] = 'S';
dist[startRow][startCol] = 0;

ArrayDeque<Point> queue = new ArrayDeque<>();
queue.add(start);

while (!queue.isEmpty())
	{
	print(map , dist);
	Thread.sleep(speed);
	Point current = BFS ? queue.pollFirst() : queue.pollLast();
	
	int r = current.r;
	int c = current.c;
	
	for (int i = 0; i < 4; i++)
		{
		int newR = r + R[i];
		int newC = c + C[i];
		
		if (inBounds(newR , newC) && map[newR][newC] == '.' && dist[newR][newC] == -1)
			{
			queue.add(new Point(newR , newC));
			dist[newR][newC] = dist[r][c] + 1;
			}
		}
	
	Thread.sleep(10);
	}

print(map , dist);

scan.close();
	}
}

class Point {
	
int r , c;

public Point(int a , int b) {

r = a;
c = b;

}

}