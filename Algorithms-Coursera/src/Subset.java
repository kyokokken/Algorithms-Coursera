import java.util.ArrayList;

/**
 * Subset client. Write a client program Subset.java that takes a command-line integer k, reads in a sequence of N strings from standard input using StdIn.readString(), and prints out exactly k of them, uniformly at random. Each item from the sequence can be printed out at most once. You may assume that k ≥ 0 and no greater than the number of string on standard input.

% echo A B C D E F G H I | java Subset 3       % echo AA BB BB BB BB BB CC CC | java Subset 8
C                                              BB
G                                              AA
A                                              BB
                                               CC
% echo A B C D E F G H I | java Subset 3       BB
E                                              BB
F                                              CC
G                                              BB
Your client should use only constant space plus one object either of type Deque or of type RandomizedQueue; use generics properly to avoid casting and compiler warnings. It should also use time and space proportional to at most N in the worst case, where N is the number of strings on standard input. (For an extra challenge, use space proportional to k.) It should have the following API.
public class Subset {
   public static void main(String[] args)
}
 
 *
 */
public class Subset {
	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);
		String input = StdIn.readString();
		ArrayList<String> strings = new ArrayList<String>();
		String[] split = input.split("\\s+");
		System.out.println(split.length);
		for (String s : split)
			strings.add(s);
		
		for (String s : strings)
			System.out.println(s);
		
		System.out.println("-");
		while(k > 0)
		{
			int uniform = StdRandom.uniform(strings.size());
			System.out.println(strings.remove(uniform));
			k--;
		}
	}

}
