#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void enterDate(int firstmatrix[][100], int secondmatrix[][100], int rowfirst, int columnfirst, int rowsecond, int columnsecond);
void multiply(int firstmatrix[][100], int secondmatrix[][100], int multresult[][100], int rowfirst, int columnfirst, int rowsecond, int columnsecond);
void display(int mult[][100], int rowfirst, int columnsecond);

int main(){
    int firstmatrix[100][100], secondmatrix[100][100], mult[100][100], rowfirst, columnfirst, rowsecond, columnsecond, i,j,k;
	rowfirst = 20;
    	columnfirst = 20;
    	rowsecond = 20;
    	columnsecond = 20;
	
        enterDate(firstmatrix, secondmatrix, rowfirst, columnfirst, rowsecond, columnsecond);
        multiply(firstmatrix, secondmatrix, mult, rowfirst, columnfirst, rowsecond, columnsecond);
        display(mult, rowfirst, columnfirst);
    }


}

void enterDate(int firstmatrix[][100], int secondmatrix[][100], int rowfirst, int columnfirst, int rowsecond, int columnsecond){
    srand(time(NULL));
    int i, j;

    printf("generate the second matrix => \n");
    for (i = 0; i < rowsecond; i++){
        for(j = 0; j < columnsecond; j++){
            secondmatrix[i][j] = rand()%100 + 1;
        }
    }
    for(i = 0; i < rowsecond; i++){
        for(j = 0; j < columnsecond; j++){
                printf("Element #%d %d: %d\n", i, j, secondmatrix[i][j]);
        }
    }

    printf("generate the first matrix => \n");
    for (i = 0; i < rowfirst; i++){
        for(j = 0; j < columnfirst; j++){
            firstmatrix[i][j] = rand()%100 + 1;
        }
    }
    for(i = 0; i < rowfirst; i++){
        for(j = 0; j < columnfirst; j++){
                printf("Element #%d%d: %d\n", i, j, firstmatrix[i][j]);
        }
    }


    //return(0);

}

void multiply(int firstmatrix[][100], int secondmatrix[][100], int mult[][100], int rowfirst, int columnfirst, int rowsecond, int columnsecond)
{
	int i, j, k;

	for(i=0; i < rowfirst; i++){
         for(j=0;j< columnsecond; j++){
            mult[i][j] = 0;
            for(k = 0; k < columnfirst; k++){
                mult[i][j] += firstmatrix[i][k]*secondmatrix[k][j];
            }
         }
	}
}

void display(int mult[][100], int rowfirst, int columnsecond)
{
    int i, j;
    printf("\nResult matrix is \n");
    for (i = 0; i<rowfirst; i++)
    {
        for (j = 0; j < columnsecond; j++)
           printf("%d ", mult[i][j]);
        printf("\n");
    }
}
