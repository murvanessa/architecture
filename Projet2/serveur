import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server 
{
	
	
    public static void main(String args[]) 
    {    	
		int port = 6789;
		Server server = new Server( port,10);
		server.startServer();
    }

	    ServerSocket echoServer = null;
	    Socket clientSocket = null;
	    int numConnections = 0;
	    int port;
	    ExecutorService pool;
	
    public Server( int port,int poolsize) 
    {
		this.port = port;
		pool = Executors.newFixedThreadPool(poolsize);
    }

    public void stopServer() 
    {
		System.out.println( "Server cleaning up." );
		System.exit(0);
    }

    public void startServer() 
    {
	
        try 
        {
        	echoServer = new ServerSocket(port);
        }
        catch (IOException e) 
        {
        	System.out.println(e);
        }   
	
	System.out.println( "Server is running ......" );
	
	while ( true ) 
	{
	    try
	    {
			clientSocket = echoServer.accept();
			pool.submit(new protocole(clientSocket, numConnections, this));
			numConnections ++;
	    }   
	    catch (IOException e) 
	    {
	    	pool.shutdown();
	    	System.out.println(e);
	    }
	}
    }
}
