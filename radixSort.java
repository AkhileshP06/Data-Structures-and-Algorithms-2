import java.util.Scanner;
class radixSort
{
	int n,N;
	Node lh[];
	public radixSort(int noe, int m)
	{
		n = noe;
		N = m;
		lh = new Node[m];
	}
	int hash(int k)
	{
		return k%this.N;
	}
	void insert(int x)
	{
		int h = hash(x); //hash value of key to be inserted
		if(lh[h]==null) //checks if hash table is empty at hash(k)
		{
			lh[h] = new Node(x);
		}
		else
		{
			Node t = lh[h];
			while(t.next!=null)
			{
				t=t.next; //traversal till empty node
			}
			Node temp = new Node(x);
			t.next = temp;
		}
	}
	void search(int x)
	{
		int h = hash(x);
		if(lh[h]==null)//header node null
		{
			System.out.println("Key not found !");
			return;
		}
		else
		{
			Node t = lh[h];
			while(t.next!=null)//iterate till last node
			{
				int p = 0;//counter to keep track of no of probes;
				if(t.data==x)
				{
					System.out.println("Key found at "+h+" probe : "+p);
					return;
				}
				else
				{
					t = t.next;
					p++;
					continue;
				}
			}
		}
	}
	void display()
	{
		for(int i = 0;i<this.N;i++)
		{
			System.out.print("At "+i+" : ");
			Node t = lh[i];
			while(t!=null)
			{
				System.out.print(t.data+" ");
				t = t.next;
			}
			System.out.println();
		}
	}
	void sort()
	{
		//implementation of radix SORT
		radixSort rs2 = new radixSort(this.n,this.N);
		for(int i = 0;i<this.N;i++)
		{
			Node t = lh[i];
			while(t.next!=null)
			{
				int x = t.data;
				int v = (int) Math.round(x%Math.pow(this.N, i));
				if(lh[v]==null)
				{
					rs2.insert(x);
				}
				else
				{
					Node temp = lh[v];
					while(temp.next!=null)
					{
						temp = temp.next;
					}
					Node t1 = new Node(x);
					temp.next = t1;
					
				}
				t = t.next;
			}
		}
		System.out.println("Displaying sorted elements...");
		this.display();
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the number of elements to be stored : ");
		int noe = S.nextInt();
		System.out.println("Enter size of hash table : ");
		radixSort rs = new radixSort(noe,S.nextInt());
		int ch = 0;
		do
		{
			System.out.println("1/> Insert");
			System.out.println("2/> Search");
			System.out.println("3/> Display");
			System.out.println("4/> Radix Sort");
			System.out.println("5/> Exit");
			ch = S.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter value to insert : ");
				rs.insert(S.nextInt());
				break;
			case 2:
				System.out.println("Enter value to search : ");
				rs.search(S.nextInt());
				break;
			case 3:
				rs.display();
				break;
			case 4:
				rs.sort();
				break;
			case 5:
				System.out.println("Exit Prompt!");
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}
		while(ch!=5);
		S.close();
	}
}