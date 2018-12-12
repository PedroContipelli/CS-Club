import java.util.*;
public class dance {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	int N = scan.nextInt();
	String str = scan.next();
	int count = 0;
	
	for (int i = 0; i < N - 1; i++)
		{
		char a = str.charAt(i);
		char b = str.charAt(i + 1);
		
		if (a == b)
			count++;
		}
	
	System.out.printf("Dance #%d: %d%n" , z , count);
	}

scan.close();
	}
}