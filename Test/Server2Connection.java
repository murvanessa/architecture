import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class Server2Connection implements Runnable {
    BufferedReader is;
    PrintStream os;
    Socket clientSocket;
    int id;
    Server2 server;

    public Server2Connection(Socket clientSocket, int id, Server2 server) {
	this.clientSocket = clientSocket;
	this.id = id;
	this.server = server;
	System.out.println( "Connection " + id + " established with: " + clientSocket );
	try {
	    is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    os = new PrintStream(clientSocket.getOutputStream());
	} catch (IOException e) {
	    System.out.println(e);
	}
    }

    public void run() {
        String line;
	try {
	    boolean serverStop = false;

            while (true) {
                line = is.readLine();
		System.out.println( "Received " + line + " from Connection " + id + "." );
                int n = Integer.parseInt(line);
		if ( n == -1 ) {
		    serverStop = true;
		    break;
		}
		if ( n == 0 ) break;
                os.println("" + n*n ); 
            }

	    System.out.println( "Connection " + id + " closed." );
            is.close();
            os.close();
            clientSocket.close();

	    if ( serverStop ) server.stopServer();
	} catch (IOException e) {
	    System.out.println(e);
	}
    }
}
