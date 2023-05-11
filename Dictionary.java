import java.util.Scanner;
public class Dictionary
{
	int arr[];
	int m;
	public Dictionary(int max)
	{
		arr = new int[max];
		m = max; 
	}
	int hash(int k)
	{
		return k % m;
	}
	int insert(int k)
	{
		int probe = 0;
		if(arr[hash(k)]==0)
		{
			arr[hash(k)] = k;
			probe = 0;
		}
		else //linear probing
		{
			int i = hash(k);
			while(arr[i]!=0)
			{
				i = (i+1)%m;
				probe++;
			}
			arr[i] = k;
		}
		return probe;
	}
	int search(int k)
	{
		int res = 0;
		int i = hash(k);
		if(arr[i]==k)
		{
			return i;
		}
			
		else
		{
			while(arr[i]!=k)
			{
				i = (i+1)%m;
			}
			res = i;
		}
		return res;
	}

	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the max size of dictionary : ");
		Dictionary D = new Dictionary(S.nextInt());
		int ch = 0;
		do
		{
			System.out.println("1. Insert (linear probing) ");
			System.out.println("2. Search ");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			ch = S.nextInt();
			switch(ch)
			{
			case 1: 
				System.out.println("Enter the value to insert : ");
				int p = D.insert(S.nextInt());
				System.out.println("The number of probes = "+p);
				break;
			case 2:
				System.out.println("Enter the value to Search : ");
				int i = D.search(S.nextInt());
				System.out.println("Search result : "+i);
				break;
			case 3:
				System.out.println("Displaying elements ......");
				for(int i1 = 0;i1<D.m;i1++)
				{
					System.out.println("bracket "+i1+" Value = "+D.arr[i1]);
				}
				break;
			case 4:
				System.out.println("Exit prompt!");
				break;
				default: 
					System.out.println("Invalid Input!");
					break;
			}
		}
		while(ch!=4);
		S.close();

	}
}
