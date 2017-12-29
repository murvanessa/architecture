import java.util.*;

public class Matriz {
	int num=0;
	private int matrix[][];	
	public void llnearMatriz() 
	{
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				matrix[i][j]=num;
				num+=1;
			}
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
