//package encryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

//Sockets : Connects two systems
//Stream: Sequence of data...... Data bet 2 computers is passed through stream
//        A system can read or write via a Stream
//Buffered Reader: Rather than reading one character at a time with the help of
//        buffered reader we can read bunch of characters at once
		  

public class client {
	

	public static void main(String[] args) {
        //Setting up the objects
	Socket socket=null;
	InputStreamReader isr=null;
	OutputStreamWriter osw=null;
	BufferedReader bf=null;
	BufferedWriter bw=null;
	
	
	try {
		socket = new Socket("host",4321);
		
		isr=new InputStreamReader(socket.getInputStream());
		osw=new OutputStreamWriter(socket.getOutputStream());
		
		bf=new BufferedReader(isr);
		bw=new BufferedWriter(osw);
		
		
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			
			String msgtosend=sc.nextLine();
			bw.write(msgtosend);
			bw.newLine();
			bw.flush();
			
			
			System.out.println("Server:"+bf.readLine());
			
			
			if(msgtosend.equalsIgnoreCase("Bye"))
				break;
			
			
		}
		
		
	}catch(IOException e){
        e.printStackTrace();
    }finally{
        {
            try{
                if(socket!=null)
                socket.close();
                if(isr!=null)
                isr.close();
                if(osw!=null)
                osw.close();
                if(bf!=null)
                bf.close();
                if(bw!=null)
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
		
		
		
		
		
	}

}
