import java.util.Scanner;
public class dualStk 
{
	int S[];
	int t1,t2;
	int max = 20;
	public dualStk(int m)
	{
		max = m;
		S = new int[max];
		t1 = -1;
		t2 = max;
	}
	void push(int x,int s)
	{
		if(t1+1==t2)
		{
			System.out.println("Array is full ! Can't push any more elements!");
			return;
		}
		else
		{
			if(s==1)
			{
				t1++;
				S[t1] = x;
			}
			else if(s==2)
			{
				t2--;
				S[t2] = x;
			}
			else
			{
				System.out.println("Error only two stacks available...");
			}
		}
	}
	int pop(int s)
	{
		if(s==1)
		{
			if(t1==-1)
			{
				System.out.println("No value to pop in Stack 1 igonre returned value");
				return -1;
			}
			else
			{
				int temp = S[t1];
				t1--;
				return temp;
			}
		}
		else if(s==2)
		{
			if(t2==max+1)
			{
				System.out.println("No value to pop in Stack 1 igonre returned value");
				return -1;
			}
			else
			{
				int temp = S[t2];
				t2++;
				return temp;
			}
		}
		else
		{
			System.out.println("Error only two stacks available!");
			return -1;
		}
	}
	int peek(int s)
	{
		if(s==1)
		{
			return S[t1];
		}
		else if(s==2)
		{
			return S[t2];
		}
		else
		{
			System.out.println("Wrong Stack number....");
			return -1;
		}
	}
	void display()
	{
		System.out.println("Displaying Stack 1 values ....");
		for(int i=0;i<=t1;i++)
		{
			System.out.println(S[t1]);
		}
		System.out.println("Displaying Stack 2 values......");
		for(int i=max-1;i>=t2;i--)
		{
			System.out.println(S[t2]);
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		int ch = 0;
		System.out.println("Enter the max size of array : ");
		dualStk Stk = new dualStk(S.nextInt());
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
				System.out.println("Enter 1 to push to stack 1 or 2 to push to stack 2 : ");
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
			case 5:
				System.out.println("Exit Prompt");
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}while(ch!=5);
	}
}
