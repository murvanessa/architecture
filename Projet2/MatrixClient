import java.util.Random;
import java.net.*;
import java.io.*;

public class MatrixClient {
	
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
			Matriz m = new Matriz();
			m.llnearMatriz();
			
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			writer.write("m.imprimerMatrix();,2");
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
