//Boyer-Moore substring search using both bad-character and good-suffix heuristics simultaneously
import java.util.Arrays;
import java.util.Scanner;
public class boyerMoore
{
	public static void strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return ;
		} else if (needle.isEmpty()) {
			return ;
		}
		
		char[] text = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
		
		int[] borderPosition = new int[pattern.length+1]; /* referred as f in academic literatures;
		f[i] contains the starting position of the widest border of the suffix of the pattern beginning at position i */
		int[] shift = new int[pattern.length+1]; /* referred as s in academic literatures; 
		Each entry s[i] contains the shift distance of the pattern if a mismatch at position i – 1 occurs, 
		i.e. if the suffix of the pattern starting at position i has matched */
		for(int i=0; i<pattern.length+1; i++)
			shift[i]=0;
		int alphabetSize = 256;
		
		int[] lastOccurence = preprocessBadCharacters(pattern, alphabetSize); // bad characters heuristic
		preprocessStrongSuffix(pattern, borderPosition, shift); //good suffix heuristic case 1
		preprocessPartialSuffix(borderPosition, shift, pattern.length); //good suffix heuristic case 2
		
		int i=0, j; // i is start index of current window in text 
		while(i<=text.length-pattern.length) {
			j = pattern.length-1; // we process pattern from right to left backwards
			while(j>=0 && pattern[j]==text[i+j]) { // go left backwards till characters are matching in current window
				j--;
			}
			if(j<0) { // will be true only when there was a complete match found for pattern in text
				System.out.println("Pattern found at index : "+i);
				i+=shift[0];
				 //report match found
				//use i=i+shift[0] if we want to find starting indices for all multiple matches
			} else { // mismatch found in current window comparison
				/*  After a mismatch the pattern is shifted by the maximum of the values 
				    given by the good-suffix and the bad-character heuristics */
				i = i + Math.max(shift[j+1], j-lastOccurence[text[i+j]]);
			}
		}
		
		return ;
	}
	
	public static int[] preprocessBadCharacters(char[] pattern, int alphabetSize) {
		int[] lastOccurence = new int[alphabetSize]; //contains last occurrence index of each character in pattern
		Arrays.fill(lastOccurence, -1);

		for (int i = 0; i < pattern.length; i++) {
			lastOccurence[pattern[i]] = i;
		}

		return lastOccurence;
	}
	
	public static int[] preprocessStrongSuffix(char[] pattern, int[] borderPosition, int[] shift) {
		int m = pattern.length;
		
		int i = m, j = m + 1;
		borderPosition[i] = j; // The suffix ε beginning at position m has no border, therefore f[m] is set to m+1
		while (i > 0) {
			/* at this line, we know f[i], f[i+1], ... f[m]; If character at position i-1 is not  
               equal to character at j-1, then continue searching to right of the pattern for border */
			while (j <= m && pattern[i - 1] != pattern[j - 1]) {
				/* the character preceding the occurrence of t in pattern P is different than the mismatching  
	               character in P, we stop skipping the occurrences and shift the pattern from i to j */
				if (shift[j] == 0) {
					shift[j] = j - i;
				}
				j = borderPosition[j]; // get the start position of the border of suffix pattern[j] ... pattern[m-1]
			}
			
			// pattern[i-1] matched with pattern[j-1], border is found. store the beginning position of border 
			i--;
			j--;
			borderPosition[i] = j;
		}
		return shift;
	}
	
	public static void preprocessPartialSuffix(int[] borderPosition, int[] shift, int m) {
		int i, j;
		j = borderPosition[0];
		for (i = 0; i <= m; i++) {
			/* set the border position of the first character of the pattern to all indices 
			   in array shift having shift[i] = 0 */
			if (shift[i] == 0) {
				shift[i] = j;
			}
			
			/* suffix becomes shorter than borderPosition[0], use the position of next widest border as value of j */
			if (i == j) {
				j = borderPosition[j];
			}
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter text : ");
		String txt = S.nextLine();
		System.out.println("Enter pattern : ");
		String pat = S.nextLine();
		strStr(txt,pat);
	}
}
