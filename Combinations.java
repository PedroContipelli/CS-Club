import java.util.*;
import java.math.*;
public class Combinations {

static BigInteger[][] PascalsTriangle = new BigInteger[101][101];

public static BigInteger factorial(int n) {
	
	BigInteger ans = BigInteger.ONE;
	
	for (int i = 1; i <= n; i++)
		ans = ans.multiply(BigInteger.valueOf(i));
	
	return ans;
}

public static BigInteger ExplicitChoose(int n , int r) {
	return factorial(n).divide(factorial(n - r).multiply(factorial(r)));
}

public static BigInteger RecursiveChoose(int n , int r) {

	if (r == 0 || n == r)
		return BigInteger.ONE;
	
	return RecursiveChoose(n - 1 , r - 1).add(RecursiveChoose(n - 1 , r));
}

public static void DynamicChoose() {

	for (int i = 0; i <= 100; i++)
		for (int j = 0; j <= i; j++)
			{
			if (j == 0 || i == j)
				PascalsTriangle[i][j] = BigInteger.ONE;
			else
				PascalsTriangle[i][j] = PascalsTriangle[i - 1][j - 1].add(PascalsTriangle[i - 1][j]);
			}
	
}

public static void main(String[] args) throws InterruptedException {
Scanner scan = new Scanner(System.in);

System.out.println("How many cases?");
int cases = scan.nextInt();

System.out.println("Print out? (Y/N)");
boolean printing = scan.next().toLowerCase().equals("y");

System.out.println("\nStarting...\n");
long start , end;
double time;

int[] N = new int[cases];
int[] R = new int[cases];
BigInteger[] ans = new BigInteger[cases];

for (int i = 0; i < N.length; i++)
	{
	N[i] = (int)(Math.random() * 101);
	R[i] = (int)(Math.random() * (N[i] + 1));
	}

// -----------------------------------------------


start = System.nanoTime();

for (int i = 0; i < cases; i++)
	ans[i] = ExplicitChoose(N[i] , R[i]);

end =  System.nanoTime();
time = (end - start) / 1000000000.0;

System.out.println(printing ? Arrays.toString(ans) : "");
System.out.println("Explicit Choose | Calculated in " + time + " seconds\n");


//-----------------------------------------------


start = System.nanoTime();

for (int i = 0; i < cases; i++)
	ans[i] = RecursiveChoose(N[i] , R[i]);

end =  System.nanoTime();
time = (end - start) / 1000000000.0;

System.out.println(printing ? Arrays.toString(ans) : "");
System.out.println("Recursive Choose | Calculated in " + time + " seconds\n");


//-----------------------------------------------


start = System.nanoTime();

DynamicChoose();

for (int i = 0; i < cases; i++)
	ans[i] = PascalsTriangle[N[i]][R[i]];

end =  System.nanoTime();
time = (end - start) / 1000000000.0;

System.out.println(printing ? Arrays.toString(ans) : "");
System.out.println("Dynamic Choose | Calculated in " + time + " seconds");


//-----------------------------------------------

scan.close();
	}
}