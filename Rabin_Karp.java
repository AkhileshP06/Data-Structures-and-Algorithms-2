import java.util.Scanner;

public class Rabin_Karp 
{
	static void Search(String txt, String pat) 
	{
		int n = pat.length();
		double h = computeHash(pat);
		for (int i = 0; i < txt.length(); i++)
		{
			if (i + n <= txt.length())
			{
				if (computeHash(txt.substring(i, i + n)) != h) 
				{
					continue;
				}
				else 
				{
					if (txt.substring(i, i + n).equals(pat)) 
					{
						System.out.println("Pattern found at index " + i);
					} 
					else
						continue;
				}
			}
		}
	}

	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the text : ");
		String txt = S.nextLine();
		System.out.println("Enter the pattern : ");
		Search(txt, S.nextLine());
		S.close();
	}

	static double computeHash(String S)
	{
		double h = 0;
		int n = S.length();
		for (int i = 0; i < n; i++) {
			char c = S.charAt(i);
			h = h + (((int) c - 96) * Math.pow(10, n - 1 - i));
		}
		return h;

	}
}