import java.util.Arrays;
import java.util.Scanner;
public class playset {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	int N = scan.nextInt();
	int M = scan.nextInt();
	
	int[] students = new int[N];
	int[] satisfied = new int[M + 1];
	
	for (int i = 0; i < N; i++)
		students[i] = scan.nextInt();
	
	for (int num : students)
		for (int i = num; i < satisfied.length; i += num)
			satisfied[i] += 1;
	
	int max = Arrays.stream(satisfied).max().getAsInt();
	
	int count = 0;
	
	for (int i = 1; i < satisfied.length; i++)
		if (satisfied[i] == max)
			count++;
	
	System.out.printf("Week #%d: %d %d%n" , z , max , count);
	}

scan.close();
	}
}