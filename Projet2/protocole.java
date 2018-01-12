import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class protocole implements Runnable 
{
    BufferedReader is;
    PrintStream os;
    Socket clientSocket;
    int id;
    Server server;
    protected Socket socket;
	long mult[][];
	long resultat =0;
	long[][] temp;
	private static final int waiting=0;
	private static final int run=1;
	private int state=waiting;
    
    public String processInput(String theInput) 
    {
    	
    	String V=new String();
    	while(true) {
    	if(theInput==null)
    	{
    		System.out.println("server is running ......");
    		try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	else 
    	{	    	
	    	long[][] result = parseExecution(theInput);
			for(int i=0; i < result.length; i++) 
			{
				for(int j=0; j < result.length; j++)
				{
					V+= String.valueOf(result[i][j]);
					V+=" ";
				}
				V+="/";
			}
		}
		
		return V;}
      
    }
    private long[][] parseExecution(String line) throws IllegalArgumentException
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
				Result[i][j] = Integer.parseInt(ligne[j]);
				System.out.print(ligne[j]+"    ");

			}
			System.out.println(" ");
		}
		temp = new long[elements.length-1][elements.length-1];
		mult = new long[elements.length-1][elements.length-1];
		
		for(int i = 0; i < elements.length-1; i++) 
		{
			for(int j =0; j<elements.length-1; j++) 
			{
				temp[i][j]=Result[i][j];
		
			}
			
		}
		for(int n= 1; n< puissance; n++) 
		{
			
			for(int i = 0; i < elements.length-1; i++) 
			{
				for(int j =0; j<elements.length-1; j++) 
				{
					for(int k = 0; k< elements.length-1; k++)
					{
						resultat+=Result[i][k]*temp[k][j];
					}
					mult[i][j]=resultat;
					resultat=0;
				}
			}
			for(int i = 0; i < elements.length-1; i++) 
			{
				for(int j =0; j<elements.length-1; j++) 
				{	
					temp[i][j] = mult[i][j];
				}
			}
			
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Le serveur renvoit au client"+id );
		for(int i=0;i<mult.length;i++)
		{
			for(int j=0;j<mult.length;j++)
			{
				System.out.print(mult[i][j]+"       ");
			}
			System.out.println();
		}
		
		System.out.println(" ");
		System.out.println(" ");
		
		return mult;
	}
    public protocole(Socket clientSocket, int id, Server server) 
    {
	this.clientSocket = clientSocket;
	this.id = id;
	this.server = server;
	System.out.println("");
	System.out.println( "Connection " + id + " established with: " + clientSocket );
	System.out.println("");
	System.out.println("");
	try {
	    is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    os = new PrintStream(clientSocket.getOutputStream());
	} catch (IOException e) {
	    System.out.println(e);
	}
    }

    public void run() 
    {
    	String s1=new String();
    	String s2=new String();
    	 s1=Integer.toString(0);
         s2=Integer.toString(-1);
        String line;
        String  outputLine;
	try {
	    boolean serverStop = false;

            while (true) 
            {
                line = is.readLine();
                if(line==null)
                {
                	break;
                }
				System.out.println( "Received from Connection " + id + "..."+line );
				
				if(line==s1 )
				{
					server.stopServer();
				    break;
					
				}
				else if (line ==s2)
				{
					break;
				}
				else
				{
				outputLine = processInput(line);
				os.println(outputLine); 
				//break;
		            
				}}
			
			    System.out.println( "Connection " + id + " closed." );
		            is.close();
		            os.close();
		            clientSocket.close();
		            serverStop=true;
		
			   
			 }
		catch (IOException e) {
	    System.out.println(e);
	}
    }
}
