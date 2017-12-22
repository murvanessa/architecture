import java.io.*;
import java.net.*;

public class MatrixServer {
	
	protected Socket socket;
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void execute()  {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			int result = parseExecution(line);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(""+result);
			writer.newLine();
			writer.flush();
			// close the stream
			reader.close();
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
			}
	}

	private int parseExecution(String line) {
		// TODO Auto-generated method stub
		int Result = Integer.MAX_VALUE;
		String [] elements = line.split(",");
		if (elements.length != 2)
			throw new IllegalArgumentException("parsing error!");
		return 0;
	}
	
	public static void main(String [] args)throws Exception{
		int port = 7859;
		if (args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);
				}catch(Exception e){
					
				}
			}
		System.out.println("Matrix Server is running...");
		// create a server socket and wait for client’s connection
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		// run a math server that talks to the client
		MatrixServer matrixserver = new MatrixServer();
		matrixserver.setSocket(socket);
		matrixserver.execute();
		System.out.println("Matrix Server is closed...");
		}

}
