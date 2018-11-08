import java.util.*;
public class pyramid {
	
public static int volume(int[] row) {
	return row[0] * row[1] * row[2];
}

public static boolean proper(int[][] pyramid) {

	if (pyramid.length == 1)
		return true;
	
	for (int r = 1; r < pyramid.length; r++)
		{
		int[] row1 = pyramid[r - 1];
		int[] row2 = pyramid[r];
		
		int V1 = volume(row1);
		int V2 = volume(row2);
		
		if (V1 >= V2 || row1[0] >= row2[0] || row1[2] >= row2[2])
			return false;
		}
	
	return true;
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int testcases = scan.nextInt();

for (int z = 1; z <= testcases; z++)
	{
	int blocks = scan.nextInt();
	
	// width , length , height
	int[][] pyramid = new int[blocks][3];
	
	for (int r = 0; r < blocks; r++)
		for (int c = 0; c < 3; c++)
			pyramid[r][c] = scan.nextInt();
	
	if (proper(pyramid))
		System.out.printf("Pyramid #%d: Proper Pyramid\n" , z);
	else
		System.out.printf("Pyramid #%d: Improper Pyramid\n" , z);
	}

scan.close();
	}
}