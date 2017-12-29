import java.io.*;
import java.net.*;

public class MatrixServer {
	
	protected Matrix matrix;
	
	protected Socket socket;
	int mult[][];
	int resultat =0;
	int[][] temp;
	
	public void setMatriz(Matrix matrix) {
		this.matrix = matrix;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void execute()  {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("test");
			String line = reader.readLine();
			System.out.println(line);
			int[][] result = parseExecution(line);
			
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

	private int[][] parseExecution(String line) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		int[][] Result ;
		String [] elements = line.split("/");
		Result = new int[elements.length-1][elements.length-1];
		int puissance=Integer.parseInt(elements[elements.length-1]);
		System.out.println(puissance);
		for(int i = 0; i < elements.length-1; i++) {
			String[] ligne = elements[i].split(" ");
			for(int j =0; j< elements.length-1; j++) {
				Result[i][j] = Integer.parseInt(ligne[j]);
				System.out.print(ligne[j]+ " ");
			}
			System.out.println(" ");
		}
		temp = new int[elements.length-1][elements.length-1];
		mult = new int[elements.length-1][elements.length-1];
		
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
		
		System.out.println("apres multi");
		for(int i = 0; i < elements.length-1; i++) 
		{
			for(int j =0; j<elements.length-1; j++) 
			{
				
				System.out.print(mult[i][j]+" ");
		
			}
			System.out.println(" ");
		}
		
		
		return mult;
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
		System.out.println("Math Server is closed...");
		}

}
