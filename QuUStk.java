import java.util.Stack;
public class QuUStk
{
	Stack <Integer> S1 = new Stack<Integer>();
	Stack <Integer> S2 = new Stack<Integer>();
	
	void enqueue(int x)
	{
		S1.push(x);
	}
	int dequeue()
	{
		if(S1.empty()) 
		{
			System.out.println("Queue is empty! ignore returned value");
			return -1;
		}
		while(!(S1.empty()))
		{
			S2.push(S1.pop());
		}
		int r=S2.pop();
		while(!S2.empty()) 
		{
			S1.push(S2.pop());
		}
		return r;
	}
}
