import java.util.Scanner;
import java.lang.System;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class dnaSeq 
{
	static long sT;
	static long eT;
	public static void main(String args[]) throws IOException
	{
		Scanner S = new Scanner(System.in);
		FileReader fr = new FileReader("C:\\Users\\akhil\\Desktop\\DSA project\\Text.txt");
		int i;
		String txt = "";
		while((i = fr.read())!=-1)
			txt+=(char)i;
		fr = new FileReader("C:\\Users\\akhil\\Desktop\\DSA project\\Pat.txt");
		String pat = "";
		while((i = fr.read())!=-1)
			pat+=(char)i;
		int ch = 0;
		do
		{
			System.out.println("1...>KMP");
			System.out.println("2...>Rabin Karp");
			System.out.println("3...>Boyer Moore");
			System.out.println("4...>Z algorithm");
			System.out.println("5...>FiniteAutomata");
			System.out.println("6...>Exit");
			ch = S.nextInt();
			switch(ch)
			{
				case 1:
					sT = System.nanoTime();
					KMP kp = new KMP();
					kp.KMPSearch(pat, txt);
					eT = System.nanoTime();
					System.out.println("Took "+(eT-sT) + " ns");
					break;
				case 2:
					sT = System.nanoTime();
					rabinKarp.search(pat, txt, 101);
					eT = System.nanoTime();
					System.out.println("Took "+(eT-sT) + " ns");
					break;
				case 3:
					sT = System.nanoTime();
					boyerMoore.strStr(txt, pat);
					eT = System.nanoTime();
					System.out.println("Took "+(eT-sT)+" ns");
					break;
				case 4:
					sT = System.nanoTime();
					ZAlgorithm za = new ZAlgorithm(txt);
					za.search(pat);
					eT = System.nanoTime();
					System.out.println("Took "+(eT-sT)+" ns");
					break;
				case 5:
					sT = System.nanoTime();
					finiteAutomata.search(pat.toCharArray(),txt.toCharArray());
					eT = System.nanoTime();
					System.out.println("Took "+(eT-sT)+" ns");
					break;
				case 6:
					System.out.println("Exit prompt!");
					break;
				default:
					System.out.println("Invalid Input!");
					break;			
			}
		}
		while(ch!=6);
		fr.close();
		S.close();
	}
}
