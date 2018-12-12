import java.util.*;
public class trolley {
	
public static long sum(long[] nums , int fromIndex , int toIndex) {
	long[] only = Arrays.copyOfRange(nums , fromIndex, toIndex + 1);
	return Arrays.stream(only).sum();
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	int N = scan.nextInt();
	int games = (int)Math.pow(2 , N);
	
	long[] nums = new long[games + 1];
	
	for (int i = 1; i < nums.length; i++)
		nums[i] = scan.nextLong();

	int low = 1;
	int high = games;
	int mid = (low + high) / 2;
	
	for (int i = 0; i < N; i++)
		{
		long up = sum(nums , low , mid);
		long down = sum(nums , mid + 1 , high);
		
		if (down > up)
			low = mid + 1;
		else
			high = mid;
		
		mid = (low + high) / 2;
		}
	
	System.out.printf("Trolley #%d: %d%n" , z , mid);
	}

scan.close();
	}
}