import java.net.*;
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
			
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
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
			Scanner sc1 = new Scanner(System.in);
			System.out.printf("entrer la puissance : ");
			puissance = sc1.nextInt();
			V+=puissance;
	
			writer.write(V);
			writer.newLine();
			writer.flush();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			System.out.println(reader.readLine());
			reader.close();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
}
