import java.util.Scanner;

public class Dhash 
{
    int prob[];
    int Max;

    public Dhash(int m)
    {
        prob = new int[m];
        Max = m;
    }

    int hash(int k)
    {
        int i = k%Max;
        return i;
    }
    int hash2(int k)
    {
        int i = 1+(k%(Max-1));
        return i;
    }

    int insert(int k)
    {
        int pb = 0;
        if(prob[hash(k)]==0)
        {
            prob[hash(k)]=k;
            pb = 0;
        }
        else
        {
            int i=hash(k);
            int f = i;
            int c = 1;
    		while(prob[i]!=0&&c<Max) 
    		{
    			int l = hash2(k);
                i = (f + c*l)%Max;
                c++;
                pb++;
    		}
    		prob[i]=k;
		}
		return pb;
    }

    int search(int k)
    {
        int res = 0;
        int i = hash(k);
        int j =i;
		if(prob[i]==k){
            return i;
        }
		else{
			while(prob[j]!=k)
			{
				j = (j+1)%Max;
                if(j==i)
                {
                    System.out.println("Element not in hash table");
                    break;
                }
			}
            res = j;

		}
        return res;
    }

    public static void main(String args[]) {
        Scanner A = new Scanner(System.in);
        System.out.println("Enter the size of the dictionary: ");
        Dhash dH = new Dhash(A.nextInt());
        int ch = 0;
        do
        {
            System.out.println("1. Insert\n 2. Search \n 3. Display\n 4. Exit");
            ch = A.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter the value to insert : ");
				int p = dH.insert(A.nextInt());
				System.out.println("The number of probes = "+p);
				break;
                case 2:
				System.out.println("Enter the value to Search : ");
				int i = dH.search(A.nextInt());
				System.out.println("Search result : "+i);
				break;
                case 3:
				System.out.println("Displaying elements ......");
				for(int j = 0;j<dH.Max;j++)
				{
                    System.out.println("bracket "+j+" Value = "+dH.prob[j]);
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
		A.close();
    }
}