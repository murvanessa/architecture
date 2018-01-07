
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.w3c.dom.Element;

public class KnockKnockClient 
{
	static String V=new String();
	public static void affiche(String line)
	{
	String [] elements = line.split("/");
	int [][] Result;
	Result = new int[elements.length][elements.length];
	for(int i = 0; i < elements.length; i++)
	{
		String[] ligne = elements[i].split(" ");
		for(int j =0; j< elements.length; j++) 
		{
			System.out.println("*** "+ elements.length+"****");
			Result[i][j] = Integer.parseInt(ligne[j]);
			System.out.print(ligne[j]+ " ");
		}
		System.out.println(" ");
	}
	}
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        
        if (args.length != 2)
        {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);


        try (
        		Socket kkSocket = new Socket(hostName, portNumber);
        		PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
        		BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        	) 
        {
        	BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            
          /* while ((fromServer = in.readLine()) != null) 
            {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                
            }*/
                
                
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
    			System.out.println("la matrice saisie est :"+V);
    			//Scanner sc1 = new Scanner(System.in);
    			
    			for(int i=0;i<11;i++)
    			{
    				//System.out.printf("entrer la puissancppe : ");
    				puissance = (int)(Math.random() * ((5 - 2) + 1) + 2);
    				System.out.println("la puiis  "+puissance);
    				V+=puissance;
    				//System.out.println("mooom  v  est   "+V);
    				if (V != null) 
                    {
                       System.out.println("");
                       System.out.println("");
    					System.out.println("Client envoi: " + V);
                        out.println(V);
                        Thread.sleep(100);
                        System.out.println("recu from server  :"+(fromServer = in.readLine()));
                        Thread.sleep(100);
                    }
    				V=V.substring(0, V.length()-1);
    				
    			}
    			System.out.println("recu from server  :"+(fromServer = in.readLine()));
            }
        
        catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}

