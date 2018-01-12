import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client 
{
	static String V=new String();
	
	private static void parse(String line)
	{
		long[][] Result ;
		String [] elements = line.split("/");		
		Result = new long[elements.length-1][elements.length-1];
		int puissance=Integer.parseInt(elements[elements.length-1]);
		for(int i = 0; i < elements.length-1; i++) 
		{
			String[] ligne = elements[i].split(" ");
			for(int j =0; j< elements.length-1; j++) 
			{
				Result[i][j] = Long.parseLong(ligne[j]);
				System.out.print(ligne[j]+"    ");

			}
			System.out.println(" ");
		}}
	private static void parse2(String line)
	{
		long[][] Result ;
		String [] elements = line.split("/");		
		Result = new long[elements.length][elements.length];
		for(int i = 0; i < elements.length; i++) 
		{
			String[] ligne = elements[i].split(" ");
			for(int j =0; j< elements.length; j++) 
			{
				Result[i][j] = Long.parseLong(ligne[j]);
				System.out.print(ligne[j]+"    ");

			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) 
    {
			long tempsdepart=0;
	    	long tempsarrivee=0;
	    	long duree=0;
		
			String hostname = "localhost";
			int port = 6789;
		
			try (
		    		Socket kkSocket = new Socket(hostname, port);
		    		PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		    		BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		    	) 
	    {
		    while ( true ) 
		    {
		
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	        String fromServer;
	        String fromUser;
			
	        int [][] A;
			int k;
			int num=1;
			int puissance=0;
			Scanner sc = new Scanner(System.in);
			System.out.printf("entrer le row : ");
			k = 3;
			if(k==-1 ||k==0)
			{
				V=Integer.toString(k);
				out.println(V);
				break;
				
			}
			else
			{
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
			System.out.println("la matrice saisie est :"+V);
			
			for(int i=0;i<200;i++)
			{
				puissance = (int)(Math.random() * ((15 - 10) + 1) + 10);
				
				V+=puissance;
				if (V != null) 
	            {
	               System.out.println("");
	               System.out.println("");
					System.out.println("Client envoi la matrice en dessous à la puissance " + puissance);
					parse(V);
					tempsdepart=System.currentTimeMillis();
					out.println(V);
	                fromServer = in.readLine();
	                tempsarrivee=System.currentTimeMillis();
	                duree=tempsarrivee-tempsdepart;
	                System.out.println();
	                System.out.println();
	                System.out.println("Recu du serveur  :");
	                parse2(fromServer);
	                System.out.println("");
	                System.out.println("");
	                System.out.println("la duree de l'operation :  "+duree+"   ms");
	                System.out.println("*****************************************************");
	            }
				V=V.substring(0, V.length()-2);
			}
			in.close();
			out.close();
			kkSocket.close();
		   
		}
			break;
			
		}V="";
		    
	    
	    
	} catch (UnknownHostException e) {
	    System.err.println("Trying to connect to unknown host: " + e);
	} catch (IOException e) {
	    System.err.println("IOException:  " + e);
	}
	            
}}
