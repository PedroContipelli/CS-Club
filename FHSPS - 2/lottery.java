import java.util.*;
public class lottery {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int cases = scan.nextInt();

for (int z = 1; z <= cases; z++)
	{
	System.out.printf("Lottery #%d:%n" , z);
	int operations = scan.nextInt();
	
	ArrayList<String> names = new ArrayList<>();
	ArrayList<String> rever = new ArrayList<>();
	boolean[] reversed = new boolean[1000000];
	
	for (int op = 0; op < operations; op++)
		{
		int q = scan.nextInt();
		
		if (q == 1)
			{
			String name = scan.next();
			String eman = new String(new StringBuilder(name).reverse());
			names.add(name);
			rever.add(eman);
			}
		else if (q == 2)
			{
			String prefix = scan.next();
			int count = 0;
			
			for (int i = 0; i < names.size(); i++)
				if (!reversed[i])
					count += names.get(i).startsWith(prefix) ? 1 : 0;
				else
					count += rever.get(i).startsWith(prefix) ? 1 : 0;
			
			System.out.println(count);
			}
		else if (q == 3)
			{
			for (int i = 0; i < names.size(); i++)
				reversed[i] = !reversed[i];
			}
		}
			
	System.out.println();
	}

scan.close();
	}
}