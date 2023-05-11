import java.util.Scanner;
public class rka 
{
	static void Search(String txt, String pat)
	{
		int n = pat.length();
		int h = computeHash(pat);
		for(int i = 0;i<txt.length();i++)
		{
			if(i+n<=txt.length())
			{
				if(computeHash(txt.substring(i,i+n))!=h)
				{
					continue;
				}
				else
				{
					if(txt.substring(i,i+n).equals(pat))
					{
						System.out.println("Pattern found at index "+i);
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
		Search(txt,S.nextLine());
		S.close();
	}
	static int computeHash(String S)
	{
		int h = 0;
		for(int i = 0;i<S.length();i++)
		{
			char c = S.charAt(i);
			switch (c)
			{
			case 'a':
				h+=97;
				break;
			case 'b':
				h+=98;
				break;
			case 'c':
				h+=99;
				break;
			case 'd':
				h+=100;
				break;
			case 'e':
				h+=101;
				break;
			case 'f':
				h+=102;
				break;
			case 'g':
				h+=103;
				break;
			case 'h':
				h+=104;
				break;
			case 'i':
				h+=105;
				break;
			case 'j':
				h+=106;
				break;
			case 'k':
				h+=107;
				break;
			case 'l':
				h+=108;
				break;
			case 'm':
				h+=109;
				break;
			case 'n':
				h+=110;
				break;
			case 'o':
				h+=111;
				break;
			case 'p':
				h+=112;
				break;
			case 'q':
				h+=113;
				break;
			case 'r':
				h+=114;
				break;
			case 's':
				h+=115;
				break;
			case 't':
				h+=116;
				break;
			case 'u':
				h+=117;
				break;
			case 'v':
				h+=118;
				break;
			case 'w':
				h+=119;
				break;
			case 'x':
				h+=120;
				break;
			case 'y':
				h+=121;
				break;
			case 'z':
				h+=122;
				break;
			}
		}
		return h;
	}
}
