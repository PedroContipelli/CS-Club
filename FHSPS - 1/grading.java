import java.util.*;
public class grading {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int testcases = scan.nextInt();

for (int z = 1; z <= testcases; z++)
	{
	int grade = scan.nextInt();
	
	if (0 <= grade && grade <= 100)
		System.out.printf("Grade #%d: No Change\n" , z);
	else
		System.out.printf("Grade #%d: Change\n" , z);
	}

scan.close();
	}
}