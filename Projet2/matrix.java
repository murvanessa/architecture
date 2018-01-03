import java.util.*;

public class Matrix {
	
	int num = 1;
	int matrix[][];
	
	public Matrix() 
	{
		int k;
		Scanner sc = new Scanner(System.in);
		System.out.printf("entrer le row : ");
		k = sc.nextInt();
		matrix=new int[k][k];
			for(int i =0 ; i<k; i++) 
			{
				for(int j = 0; j<k; j++) 
				{
					
					matrix[i][j] = num;
					num+=1;
				}
			}
		}
	
	public void imprimerMatrix() {
		for(int i =0 ; i<matrix.length; i++) {
			for(int j = 0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
	public int getSize() {
		return matrix.length;
	}
}
