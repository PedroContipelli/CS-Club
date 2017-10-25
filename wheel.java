import java.util.*;
import java.io.*;

class Word {
	
String word;
int inEdges = 0;
int path = 0;

public Word(String word) {
	this.word = word;
}

}

public class wheel {
	
public static void main(String[] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("wheel.in"));
PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));

int cases = Integer.parseInt(f.readLine());

for (int puzzle = 1; puzzle <= cases; puzzle++)
	{
	int phrases = Integer.parseInt(f.readLine());
	
	HashMap<String , HashSet<String>> graph = new HashMap<>();
	HashMap<String , Word> map = new HashMap<>();
	
	for (int i = 0; i < phrases; i++)
		{
		String phrase = f.readLine();
		
		String word1 = phrase.substring(0 , phrase.indexOf(" "));
		String word2  = phrase.substring(phrase.lastIndexOf(" ") + 1);
		
		if (!map.containsKey(word1))
			{
			graph.put(word1 , new HashSet<>());
			map.put(word1 , new Word(word1));
			}
		
		if (!map.containsKey(word2))
			{
			graph.put(word2 , new HashSet<>());
			map.put(word2 , new Word(word2));
			}
		
		graph.get(word1).add(word2);
		map.get(word2).inEdges += 1;
		}
	
	ArrayDeque<Word> queue = new ArrayDeque<>();
	int maxPath = 0;
	
	for (String word : graph.keySet())
		if (map.get(word).inEdges == 0)
			queue.add(map.get(word));
	
	while (!queue.isEmpty())
		{
		Word current = queue.remove();
		
		for (String x : graph.get(current.word))
			{
			Word check = map.get(x);
			
			check.path = Math.max(check.path , current.path + 1);
			maxPath = Math.max(maxPath , check.path);
			
			check.inEdges -= 1;
			
			if (check.inEdges == 0)
				queue.add(check);
			}
		}
	
	out.println("Puzzle #" + puzzle + ": " + maxPath);
	}

f.close();
out.close();
	}
}