import java.util.*;

public class Matriz {
	
	private double matriz[][];
	private Random random;
	
	public Matriz() {
		matriz = new double [4][4];
		random = new Random();
	}
	
	public void llnearMatriz() {
		try{
			for(int i =0 ; i<matriz.length; i++) {
				for(int j = 0; j<matriz.length; j++) {
					matriz[i][j] = random.nextInt(20);
				}
			}
			}catch(Exception e) {
			System.out.println(e.getMessage());
			}
		}
	
	public void imprimerMatrix() {
		for(int i =0 ; i<matriz.length; i++) {
			for(int j = 0; j<matriz.length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
