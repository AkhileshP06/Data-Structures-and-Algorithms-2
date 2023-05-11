import java.util.Scanner;
public class multStk 
{
	int S[];
	int top[];
	int n,k;
	public multStk(int n1, int k1)
	{
		n = n1;
		k = k1;
		S = new int[n];
		top = new int[k];
		top[0] = -1;
		for(int i=0;i<k;i+=n/k)
		{
			top[i] = i;
		}
	}
	boolean isFull(int sn)
	{
		if(top[k-1]==sn*n/k)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	boolean isEmpty(int sn)
	{
		if(top[k-1]==(k-1)*n/3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void push(int x, int sn)
	{
		if(sn>k || sn<0)
		{
			System.out.println("Stack Does not exist");
			return;
		}
		if(!isFull(sn))
		{
			top[sn]++;
			S[top[sn]] = x;
		}
		else
		{
			System.out.println("Stack Overflow");
		}
	}
	int pop(int sn)
	{
		if(sn>k || sn<0)
		{
			System.out.println("Stack Does not exist");
			return -1;
		}
		if(isEmpty(sn))
		{
			System.out.println("Stack Underflow! No elements to pop");
			return Integer.MIN_VALUE;
		}
		else
		{
			int temp = S[top[sn]];
			top[sn]--;
			return temp;
		}
	}
	int peek(int sn)
	{
		if(sn>k || sn<0)
		{
			System.out.println("Stack Does not exist");
			return -1;
		}
		if(isEmpty(sn))
		{
			System.out.println("Stack Underflow! No elements to pop");
			return Integer.MIN_VALUE;
		}
		else
		{
			return S[top[sn]];
		}
	}
	void display()
	{
		for(int i=0;i<k;i++)
		{
			System.out.println("Printing Stack no "+i+1);
			for(int j=(i-1)*n/k;i<=((i*n)/k)-1;j++)
			{
				System.out.println(S[j]);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner (System.in);
		int ch = 0;
		System.out.println("Enter the max size of the array : ");
		int n = S.nextInt();
		System.out.println("Enter the number of Stacks : ");
		multStk Stk = new multStk(n,S.nextInt());
		do
		{
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display");
			System.out.println("5. Exit");
			ch = S.nextInt();
			switch (ch)
			{
			case 1:
				System.out.println("Enter the value to push : ");
				int x=S.nextInt();
				System.out.println("Enter the Stack number to push : ");
				Stk.push(x,S.nextInt());
				break;
			case 2:
				System.out.println("Enter which stack to pop : ");
				System.out.println("Poped Value is : "+Stk.pop(S.nextInt()));
				break;
			case 3:
				System.out.println("Enter which stack to peek : ");
				System.out.println("Value at top : "+Stk.peek(S.nextInt()));
				break;
			case 4:
				Stk.display();
				break;
			case 5:
				System.out.println("Exit Prompt");
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}while(ch!=5);
		S.close();
	}
}