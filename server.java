

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;

// Server Socket: Waits for request to come over the network


public class server{

	public static void main(String args[]) throws IOException{
		Socket socket=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader bf=null;
		BufferedWriter bw=null;

		ServerSocket serverSocket=null;


		serverSocket = new ServerSocket(4321);


		while(true){

			try {
				socket = serverSocket.accept();

				isr=new InputStreamReader(socket.getInputStream());
				osw=new OutputStreamWriter(socket.getOutputStream());

				bf=new BufferedReader(isr);
				bw=new BufferedWriter(osw);


				while(true){
					String msgFromclient = bf.readLine();


					System.out.println("Client:"+msgFromclient);

					bw.write("MSG Recieved");
					bw.newLine();
					bw.flush();


					if(msgFromclient.equalsIgnoreCase("Bye"))
						break;

				}


				socket.close();
				isr.close();
				osw.close();
				bf.close();
				bw.close();


			} catch (Exception e) {
				e.printStackTrace();
			}


		}

	}






}