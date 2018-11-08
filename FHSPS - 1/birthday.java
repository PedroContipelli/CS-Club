import java.util.*;
public class birthday {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int testcases = scan.nextInt();

for (int z = 1; z <= testcases; z++)
	{
	int n = scan.nextInt();
	int m = scan.nextInt();
	
	ArrayList<Integer> arr = new ArrayList<>();
	ArrayList<Integer> fav = new ArrayList<>();
	
	for (int i = 0; i < n; i++)
		arr.add(scan.nextInt());
	
	for (int i = 0; i < m; i++)
		fav.add(scan.nextInt());
	
	int sum = 0;
	
	for (int x : fav)
		sum += Collections.frequency(arr , x);
	
	System.out.printf("Birthday #%d: %d\n" , z , sum);
	}

scan.close();
	}
}