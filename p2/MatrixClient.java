

import java.net.*;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class MatrixClient {
	
	static String V = new String();
	
	public static void main(String args[]) {
		String hostname = "localhost";
		int port = 7859;
		if(args.length !=2) {
			System.out.println("Use the default setting...");
		}
		else {
			hostname = args[0];
			port = Integer.parseInt(args[1]);
		}
		try {
			Socket socket = new Socket(hostname, port);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			int [][] A;
			int k;
			int num=1;
			int puissance=0;
			Scanner sc = new Scanner(System.in);
			System.out.printf("entrer le row : ");
			k = sc.nextInt();
			A=new int[k][k];
				for(int i =0 ; i<k; i++) 
				{
					for(int j = 0; j<k; j++) 
					{
						
						A[i][j] = num;
						num+=1;
					}
				}
				
				for(int i =0 ; i<A.length; i++) {
					for(int j = 0; j<A.length; j++) {
						System.out.print(A[i][j]+"\t");
					}
					System.out.println();
				}	
			for(int i=0; i < A.length; i++) 
			{
				for(int j=0; j < A.length; j++) 
				{
					V+= String.valueOf(A[i][j]);
					V+=" ";
				}
				V+="/";
			}
			
			String[] B= V.split("/");
			System.out.println(V);
			//Scanner sc1 = new Scanner(System.in);
			
			for(int i=0;i<10;i++)
			{
				System.out.printf("entrer la puissancppe : ");
				puissance = (int)(Math.random() * ((5 - 2) + 1) + 2);
				System.out.println("la puiis  "+puissance);
				V+=puissance;
				writer.write(V);
				writer.newLine();
				writer.flush();
				System.out.println("mooom  v  est   "+V);
				V=V.substring(0, V.length()-1);
			}
			
			while(socket.isConnected())
			{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			System.out.println(line);
			String [] elements = line.split("/");
			int [][] Result;
			Result = new int[elements.length][elements.length];
			for(int i = 0; i < elements.length; i++)
			{
				String[] ligne = elements[i].split(" ");
				for(int j =0; j< elements.length; j++) 
				{
					Result[i][j] = Integer.parseInt(ligne[j]);
					System.out.print(ligne[j]+ " ");
				}
				System.out.println(" ");
			}
			
			//reader.close();
			//writer.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
}
