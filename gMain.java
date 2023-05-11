import java.util.Scanner;
public class gMain 
{

	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		
		System.out.println("Enter number of edges : ");
		Graph g = new Graph(S.nextInt());
		int c = 0;
		do
		{
			System.out.println("1.add Edge");
			System.out.println("2.BFS");
			System.out.println("3.DFS");
			System.out.println("4.Exit");
			c = S.nextInt();
			switch(c)
			{
			case 1:
				System.out.println("Enter the source node : ");
				int s = S.nextInt();
				System.out.println("Enter the destination node : ");
				int d = S.nextInt();
				g.addEdge(s,d);
				
				break;
			case 2:
				System.out.println("Enter source node : ");
				g.BFS(S.nextInt());
				break;
			case 3:
				System.out.println("Enter source node : ");
				g.DFS(S.nextInt());
				break;
			case 4:
				System.out.println("Exit prompt!");
				break;
			default:
				System.out.println("Invalid input!");
				break;
			}
		}
		while(c!=4);
		S.close();
	}
}