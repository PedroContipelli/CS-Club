import java.util.Scanner;
public class flipper {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	long N = scan.nextLong() % 10;
	
	int count = 0;
	
	while (N % 10 != 7)
		{
		if (N % 2 == 0)
			N += 1;
		else
			N += 2;
		
		count++;
		}
			
	System.out.printf("Input #%d: %d%n" , z , count);
	}

scan.close();
	}
}