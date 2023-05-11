import java.util.Scanner;
class sparse
{
	int row;
	int col;
	int val;
	sparse next;
	static sparse head;
	public sparse(int r,int c,int v)
	{
		this.row = r;
		this.col = c;
		this.val = v;
		next = null;
	}
}
public class sparseMatrix 
{
	int arr[][];
	int n,non;
	sparse res[];
	static Scanner S = new Scanner(System.in);
	public sparseMatrix(int N)
	{
		arr = new int[N][N];
		n = N;
	}
	void insert()
	{
		for(int i = 0;i<this.n;i++)
		{
			for(int j = 0;j<this.n;j++)
			{
				System.out.println("Enter the value : ");
				arr[i][j] = S.nextInt();
			}
		}
	}
	void display(int arr[][])
	{
		System.out.println("displaying matrix values ....");
		for(int i = 0;i<this.n;i++)
		{
			for(int j = 0;j<this.n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Memory utilization : "+this.n*this.n*4+" bytes");
	}
	void display(sparse head)
	{
		System.out.println("1d array representation....");
		sparse t = head;
		int i = 1;
		while(t.next!=null)
		{
			System.out.println("Row : "+t.row+" Column : "+t.col+" Value : "+t.val);
			t = t.next;
			i++;
		}
		this.non = i;
		System.out.println("Row : "+t.row+" Column : "+t.col+" Value : "+t.val);
		System.out.println("Memory utilization : "+i*3*4+" bytes");
	}
	void convert() // converts 2 d array to array of linked list
	{
		for(int i = 0;i<this.n;i++)
		{
			for(int j = 0;j<this.n;j++)
			{
				if(arr[i][j]!=0)
				{
					if(sparse.head==null)
					{
						sparse.head = new sparse(i,j,arr[i][j]);
					}
					else
					{
						sparse t = sparse.head;
						while(t.next!=null)
						{
							t = t.next;
						}
						sparse temp = new sparse(i,j,arr[i][j]);
						t.next = temp;
					}
				}
			}
		}
		display(sparse.head);
		
	}
	void transpose()
	{
		sparse t = sparse.head;
		while(t.next!=null)
		{
			int temp = t.col;
			t.col = t.row;
			t.row = temp;
			t = t.next;
		}
		int trans[][] = new int [this.n][this.n];
		t = sparse.head;
		while(t!=null)
		{
			for(int i = 0;i<this.n;i++)
			{
				for(int j = 0;j<this.n;j++)
				{
					if(t.row==i && t.col==j)
					{
						trans[i][j] = t.val;
					}
					else
					{
						continue;
					}
				}
			}
			t = t.next;
		}
		System.out.println("Transpose Matrix ....");
		display(trans);
	}
	public static void main(String args[])
	{
		System.out.println("Enter the size of the matrix : ");
		sparseMatrix sm = new sparseMatrix(S.nextInt());
		sm.insert();
		sm.display(sm.arr);
		sm.convert();
		sm.transpose();
		S.close();
	}
}
