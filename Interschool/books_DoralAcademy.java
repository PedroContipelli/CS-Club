/*
 * Author: Pedro Contipelli
 */

import java.util.*;
public class books_DoralAcademy {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int N = scan.nextInt();
int[] nums = new int[N + 1];
boolean[] checked = new boolean[N + 1];

for (int i = 1; i <= N; i++)
	nums[i] = scan.nextInt();

int swaps = 0;

for (int i = 0; i < nums.length; i++)
	if (!checked[i])
		{
		int x = nums[i];
		
		while (x != i)
			{
			checked[x] = true;
			swaps++;
			x = nums[x];
			}
		}

System.out.println(swaps);
scan.close();
	}
}
