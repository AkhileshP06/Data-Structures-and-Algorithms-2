import java.text.SimpleDateFormat;
import java.util.*;
class Train 
{
    String Box_Number;
    int Berth;
    String time;
    int total = 25;
    Train()
    {
        
    }
    // S - Sleeper
    // A - AC 
    // C - Chair Car
    
}

class Booking extends Train
{
    ArrayList<Customer> arr ;
    HashMap<Train,Customer> map;
    int SleeperCount;
    int ACCount;
    int CCcount;
    int i;

    Booking()
    {
        arr = new ArrayList<>();
        map = new HashMap<>();
        i = 0;
        SleeperCount = 1;
        ACCount = 1;
        CCcount = 1;
    }
    void cancelTicket(Train obj) {
        if(map.containsKey(obj)) {
            map.remove(obj);
            if(obj.Box_Number.equals("A"))
                ACCount--;
            if(obj.Box_Number.equals("S"))
                SleeperCount--;
            if(obj.Box_Number.equals("C"))
                CCcount--;
            System.out.println("Ticket has been successfully cancelled.");
        } else {
            System.out.println("Ticket not found.");
        }
    }


    void BookTickets(String type)
    {
        if(type.equals("A"))
        {
            
            Train AC = new Train();
            if(ACCount>AC.total)
            {
                System.out.println("No seats are Available in AC Class");
                return;
            }
            book(AC,type,ACCount);
            ACCount++;
        }

        else if(type.equals("S"))
        {
            
            Train sleeper = new Train();
        
            if(SleeperCount>sleeper.total)
            {
                System.out.println("No seats are Available in Sleeper");
                return;
            }
            book(sleeper,type,SleeperCount);
            SleeperCount++;
            
        }
        else if(type.equals("C"))
        {            
            Train ChairCar = new Train();
        
            if(CCcount>ChairCar.total)
            {
                System.out.println("No seats are Available in Sleeper");
                return;
            }
            book(ChairCar,type,CCcount);
            SleeperCount++;
        }
    }

    void book(Train obj,String type,int count)
    {

        int seat = count++;
        obj.Berth = seat;
        obj.Box_Number = type;
        obj.time = new SimpleDateFormat("yyyy/MM/dd_HH/mm/ss").format(Calendar.getInstance().getTime());
        Customer c = arr.get(i);
        map.put(obj,c);
        
        // c.history = c.history+("\nBerth : "+String.valueOf(obj.Berth)+"\nClass : "+String.valueOf(obj.Box_Number));
        i++;
        
    }

    
    void print()
    {
        
        Iterator<Customer> itr = map.values().iterator();
        while (itr.hasNext()) 
        {
            System.out.print("Name : "+itr.next().Name+"               ");
        }
        System.out.println();

        Iterator<Customer> itr2 = map.values().iterator();
        while (itr2.hasNext()) 
        {
            System.out.print("Age : "+itr2.next().age+"                       ");
        }
        System.out.println();
        Iterator<Train> itr3 = map.keySet().iterator();
        while (itr3.hasNext()) 
        {
            System.out.print("Berth : "+itr3.next().Berth+"                      ");
        }

        System.out.println();

        Iterator<Train> itr4 = map.keySet().iterator();

        while (itr4.hasNext()) 
        {
            System.out.print("Box Number : "+itr4.next().Box_Number+"                 ");
        }

        System.out.println();

        Iterator<Train> itr5 = map.keySet().iterator();
        while (itr5.hasNext()) 
        {
            System.out.print("Time : "+itr5.next().time+"    ");
        }
        System.out.println();

    }
    
}


class Customer extends Booking
{
    String Name;
    int age;
    String phNo;

    // String history;
    Customer()
    {

    }

    void add(String Name,int age,String Phone)
    {
        Customer my = new Customer();
        my.Name = Name;
        my.age = age;
        my.phNo = Phone;
        
        super.arr.add(my);
        
    }


}
public class project
{
    public static void main(String[] args) 
    {
        Booking obj3 = new Booking();
        Train obj2 = new Train();
        Customer obj1 = new Customer();
        Scanner sc = new Scanner(System.in);
        int age;
        String Name;
        String Phone;
        int ch = 0;
        do
        {
        	System.out.println("1.Book ticket : ");
        	System.out.println("2. Cancel ticket : ");
        	System.out.println("3. Exit");
        	ch = sc.nextInt();
        	switch (ch)
        	{
        	case 1:
        		System.out.println("Enter the Name : ");
                Name = sc.next();
                if(Name.equals("EXIT")) {
                	break;
                }

                System.out.println("Enter the Age : ");
                age = sc.nextInt();

                System.out.println("Enter the Phone Number : ");
                Phone = sc.next();

                obj1.add(Name, age, Phone);

                System.out.println("Sleeper - S");
                System.out.println("AC - A");
                System.out.println("Chair Car - C");
                System.out.println("Enter the Type Of Class : ");

                String c = sc.next();
                obj1.BookTickets(c);
                
                obj1.print();
                System.out.println("Hello");
                break;
        	case 2:
        		obj3.cancelTicket(obj1);
        		break;
        	case 3:
        		System.out.println("Exit prompt!");
        		break;
        		default :
        			System.out.println("Invalid input !");
        			break;
        	}
        	
        }
        while(ch!=3);
        
        
    }
}