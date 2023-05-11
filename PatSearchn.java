import java.util.Scanner;
public class PatSearchn
{
	static void search(String pat,String txt)
	{
		int m = pat.length();
		int n = txt.length();
		for(int i = 0;i<=n-m;i++)
		{
			for(int j = 0;j<m;j++)
			{
				if(txt.charAt(i+j)!=pat.charAt(j))
				{
					break;
				}
				if(j==m)
				{
					System.out.println("Pattern found at index : "+(j-i));
				}
			}
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String txt = S.nextLine();
		System.out.println("Enter the pattern : ");
		search(S.nextLine(),txt);
		S.close();
	}
}
