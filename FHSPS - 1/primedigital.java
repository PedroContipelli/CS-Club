import java.util.*;
public class primedigital {
	
static long[] pow4 = new long[20];

public static boolean isPrime(int a) {
	return a == 2 || a == 3 || a == 5 || a == 7;
}

public static String next(String a) {
	int len = a.length();
	String next = a.substring(0 , 1) + "99999999999999999999";
	return next.substring(0 , len);
}

public static String before(String b) {
	int len = b.length();
	String next = b.substring(0 , 1) + "00000000000000000000";
	return next.substring(0 , len);
}

public static long oneDigitCount(int a , int b) {
	int count = 0;
	
	for (long i = a; i <= b; i++)
		if (i == 2 || i == 3 || i == 5 || i == 7)
			count++;

	return count;
}

public static long count(String a , String b , boolean leadingZero) {

	int firstDigitA = Integer.parseInt(a.substring(0 , 1));
	int firstDigitB = Integer.parseInt(b.substring(0 , 1));
	
	if (a.length() == 1 && b.length() == 1)
		return oneDigitCount(firstDigitA , firstDigitB);
	
	if (firstDigitA == firstDigitB)
		{
		if (isPrime(firstDigitA) || (firstDigitA == 0 && leadingZero))
			return count(a.substring(1) , b.substring(1) , firstDigitA == 0);
		else
			return 0;
		}
	
	long[] sum = new long[3];
	
	if (firstDigitA < firstDigitB)
		{
		sum[0] = count(a , next(a) , leadingZero);
		sum[1] = oneDigitCount(firstDigitA + 1 , firstDigitB - 1) * pow4[a.length() - 1];
		sum[2] = count(before(b) , b , leadingZero);
		
		return sum[0] + sum[1] + sum[2];
		}
	
	// ERROR
	return -9999;
}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

pow4[0] = 1;

for (int i = 1; i < pow4.length; i++)
	pow4[i] = 4 * pow4[i - 1];

int testcases = scan.nextInt();

for (int z = 1; z <= testcases; z++)
	{
	String a = "00000000000000000000" + scan.nextLong();
	String b = "" + scan.nextLong();
	
	a = a.substring(a.length() - b.length());
	
	System.out.printf("Range #%d: %d\n" , z , count(a , b , true));
	}

scan.close();
	}
}

/*

4
1 4
1 10
222 235
500 502

*/