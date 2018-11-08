/*
 * Author: Pedro Contipelli
 */

import java.util.*;
public class tdp_DoralAcademy {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int N = scan.nextInt();
int[][] grid = new int[N + 1][N + 1];

int B = scan.nextInt();
boolean[][] boulders = new boolean[N + 1][N + 1];

grid[1][1] = 1;

while (B --> 0)
	boulders[scan.nextInt() + 1][scan.nextInt() + 1] = true;

if (boulders[1][1])
	grid[1][1] = 0;

for (int y = 1; y < grid[0].length; y++)
	for (int x = 1; x < grid.length; x++)
		{
		if (x == 1 && y == 1)
			continue;
		
		if (!boulders[x][y])
			grid[x][y] = grid[x - 1][y] + grid[x][y - 1];
		
		grid[x][y] %= 1000000007;
		}

System.out.println(grid[N][N]);
		
scan.close();
	}
}
