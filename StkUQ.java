import java.util.PriorityQueue;
public class StkUQ
{
	PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
	PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
	
	void push(int x)
	{
		q1.add(x);
	}
	
	//since not nested loops it takes O(n) time .
	int pop() 
	{
		while(q1.size()>1) 
		{
			q2.add(q1.remove());
		}
		int r;
		if(!q1.isEmpty()) 
		{
			r = q1.remove();
		}
		else
		{
			r=-1;
		}
		
		while(!q2.isEmpty())
		{
			q1.add(q2.remove());
		}
		
		return r;
		
	}
}