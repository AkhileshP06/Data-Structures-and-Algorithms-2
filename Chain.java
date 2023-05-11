import java.util.Scanner;
class Node
{
	Node next;
	int data;
	public Node(int x)
	{
		this.data = x;
		next = null;
	}
}
public class Chain 
{
	Node lh[];
	int m;
	public Chain(int max)
	{
		lh = new Node[max];
		m = max;
	}
	int hash(int k)
	{
		return k%this.m;
	}
	void insert(int k)
	{
		
		int pos = hash(k);
		Node n = lh[pos];
		if(lh[pos]==null)
		{
			lh[pos] = new Node(k);
		}
		
		else
		{
			while(lh[pos].next!=null)
			{
				n = n.next;
			

			}
			Node N1 = new Node(k);
			n.next = N1;
			
		}
	}
	int search(int k)
	{
		int pos = hash(k);
		Node n = lh[pos];
		if(lh[pos].data==k)
		{
			return pos;
		}
		else
		{
			while(lh[pos].next!=null)
			{
				if(n.data==k)
				{
					return pos;
				}
				n = n.next;
			}
			return 0;
			
		}
	}
	void display()
	{
		System.out.println();
		for (int i = 0; i < this.m; i++) 
		{
			System.out.print("At " + i + ": ");

			Node start = this.lh[i];

			while (start != null) 
			{
				System.out.print(start.data + " ");
				start = start.next;
			}

			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the max size of hash table : ");
		Chain ch = new Chain(S.nextInt());
		int c = 0;
		do
		{
			System.out.println("1. Insert ");
			System.out.println("2. Search ");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			c = S.nextInt();
			switch(c)
			{
			case 1: 
				System.out.println("Enter the value to insert : ");
				ch.insert(S.nextInt());
				break;
			case 2:
				System.out.println("Enter the value to Search : ");
				int i = ch.search(S.nextInt());
				System.out.println("Search result : "+i);
				break;
			case 3:
				ch.display();
				break;
			case 4:
				System.out.println("Exit prompt!");
				break;
				default: 
					System.out.println("Invalid Input!");
					break;
			}

		}
		while(c!=4);
		S.close();
	}
	
}
