import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Kyle S. Dencker
FHSPS Contest 1
Gotta Get Outta Here
Advanced
October 7, 2015
 */

public class OuttaHere {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);

		int runs = scan.nextInt();

		for (int i=0; i<runs; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			scan.nextLine();

			char[][] map = new char[y][x];
			int[][] distance = new int[y][x];

			for (int j=0; j<y; j++) {
				map[j] = scan.nextLine().toCharArray();
			}

			// Find S and fiend E.
			Point start = new Point(-1, -1), end = new Point(-1, -1);
			for (int j=0; j<y; j++) {
				Arrays.fill(distance[j], -1);
				for (int k=0; k<x; k++) {
					if (map[j][k] == 'S') {
						start = new Point(k, j);
					}
					if (map[j][k] == 'E') {
						end = new Point(k, j);
						map[j][k] = '#';
					}
				}
			}
			
			ArrayList<Point> queue = new ArrayList<Point>();
			queue.add(start);
			distance[start.y][start.x] = 0;
			
			while (!queue.isEmpty()) {
				Point current = queue.remove(0);
				
				// checking moving left. 
				if (current.x - 1 >= 0 && (map[current.y][current.x - 1] == '#') && distance[current.y][current.x-1] == -1) {
					distance[current.y][current.x-1] = distance[current.y][current.x] + 1;
					queue.add(0 , new Point(current.x-1, current.y));
				}
				
				// checking moving right. 
				if (current.x + 1 < x && (map[current.y][current.x + 1] == '#') && distance[current.y][current.x+1] == -1) {
					distance[current.y][current.x+1] = distance[current.y][current.x] + 1;
					queue.add(0 , new Point(current.x+1, current.y));
				}
				
				// checking moving up. 
				if (current.y - 1 >= 0 && (map[current.y-1][current.x] == '#') && distance[current.y-1][current.x] == -1) {
					distance[current.y-1][current.x] = distance[current.y][current.x] + 1;
					queue.add(0 , new Point(current.x, current.y-1));
				}
				
				// checking moving down. 
				if (current.y + 1 < y && (map[current.y+1][current.x] == '#') && distance[current.y+1][current.x] == -1) {
					distance[current.y+1][current.x] = distance[current.y][current.x] + 1;
					queue.add(0 , new Point(current.x, current.y+1));
				}
				
				for (int z = 0; z < y; z++)
					{
					for (int a = 0; a < x; a++)
						System.out.print(map[z][a]);
					
						System.out.print("     ");
					
					for (int a = 0; a < x; a++)
						if (distance[z][a] != -1)
							System.out.print(("00" + distance[z][a]).substring(("00" + distance[z][a]).length() - 2) + " ");
						else
							System.out.print("-- ");
					
					System.out.println();
					}
				
				System.out.println("\n\n\n\n\n\n\n");
				
				Thread.sleep(400);
			}

	System.out.println(distance[end.x][end.y]);
		}
	
	scan.close();
	}
}

class Point {
	int x, y;
	public Point(int a, int b) {
		this.x = a;
		this.y = b;
	}
}