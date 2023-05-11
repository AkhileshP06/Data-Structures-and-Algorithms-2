import java.util.Scanner;
public class Tmain
{
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		BST b = new BST();
		int c = 0;
		do
		{
			System.out.println("1.Insert");
			System.out.println("2.PreOrder");
			System.out.println("3.PostOrder");
			System.out.println("4.In Order");
			System.out.println("5.Count leaf Nodes");
			System.out.println("6.Count Nodes");
			System.out.println("7.Smallest Node");
			System.out.println("8.Largest Node");
			System.out.println("9. Search");
			System.out.println("10.Exit");
			c = S.nextInt();
			switch (c)
			{
			case 1:
				System.out.println("Enter the value to insert : ");
				b.root = b.insert(S.nextInt(),b.root);
				break;
			case 2:
				b.preOrder(b.root);
				break;
			case 3:
				b.postOrder(b.root);
				break;
			case 4:
				b.inOrder(b.root);
				break;
			case 5:
				b.countLeaf(b.root);
				break;
			case 6:
				b.count(b.root);
				break;
			case 7:
				System.out.println("Smallest Node is : "+b.smallest(b.root));
				break;
			case 8:
				System.out.println("Largest Node is : "+b.largest(b.root));
				break;
			case 9:
				System.out.println("Enter the value to Search : ");
				System.out.println(b.Search(b.root,S.nextInt()));
				break;
			case 10:
				System.out.println("Exit Prompt!");
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}
		while (c != 10);
		S.close();
	}
}