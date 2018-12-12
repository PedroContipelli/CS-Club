import java.util.*;
public class shuriken {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	double n = scan.nextInt();
	double s = scan.nextInt();
	double h = scan.nextInt();
	double d = scan.nextInt();
	double PI = 3.14159265359;
	
	double polygon = n * (s / 2) * (s / 2) / Math.tan(Math.toRadians(180 / n));
	double isoceles = s * h * n / 2;
	double circle = PI * (d / 2) * (d / 2);
	
	System.out.printf("Shuriken #%d: %.2f%n" , z , polygon + isoceles - circle);
	}

scan.close();
	}
}