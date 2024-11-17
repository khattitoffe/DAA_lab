import java.util.*;
class strassenMultiplication{
    int[][] result;
    int[][] result1;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter dimension for first array");
        int row1=sc.nextInt();
        int col1=sc.nextInt();
        System.out.println("Enter dimension for second array");
        int row2=sc.nextInt();
        int col2=sc.nextInt();
        int[][] matrixA=new int[row1][col1];
        int[][] matrixB=new int[row2][col2];
        
        System.out.println("Enter Element in Matrix A");
        for(int i=0;i<matrixA.length;i++)
        {
            for(int j=0;j<matrixA[0].length;j++)
            {
                matrixA[i][j]=sc.nextInt();
            }
        }
        
        System.out.println("Enter Element in Matrix B");
         for(int i=0;i<matrixB.length;i++)
        {
            for(int j=0;j<matrixB[0].length;j++)
            {
                matrixB[i][j]=sc.nextInt();
            }
        }
        
        sc.close();
        strassenMultiplication obj=new strassenMultiplication();
        obj.normalMultiplication(matrixA,matrixB);
        obj.strassen(matrixA,matrixB);
    }
    
     void normalMultiplication(int[][] A, int[][] B)
    {
        if(!(A[0].length==B.length))
        {
            System.out.println("Mutliplication not possible");
            return;
        }
        
        result=new int[A.length][B[0].length];
        
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<B[0].length;j++)
            {
                result[i][j]=0;
                for(int k=0;k<A[0].length;k++)
                {
                    result[i][j]+=(A[i][k]*B[k][j]);
                }
            }
        }
        System.out.println("Result after Normal Multiplication");
        print(result);
    }
    
    void strassen(int[][] A,int[][] B)
    {
        if(!(A[0].length==B.length))
        {
            System.out.println("Mutliplication not possible");
            return;
        }
        result1=new int[A.length][B[0].length];
        
        result1=multiply(A,B);
        System.out.println("Result after Strassen multiplication");
        print(result1);
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        if (n == 1) {
            int[][] result = new int[1][1];
            result[0][0] = A[0][0] * B[0][0];
            return result;
        }

      
        int half = n / 2;
        int[][] A11 = new int[half][half];
        int[][] A12 = new int[half][half];
        int[][] A21 = new int[half][half];
        int[][] A22 = new int[half][half];
        int[][] B11 = new int[half][half];
        int[][] B12 = new int[half][half];
        int[][] B21 = new int[half][half];
        int[][] B22 = new int[half][half];
        
 
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + half];
                A21[i][j] = A[i + half][j];
                A22[i][j] = A[i + half][j + half];
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + half];
                B21[i][j] = B[i + half][j];
                B22[i][j] = B[i + half][j + half];
            }
        }

        
        int[][] M1 = multiply(add(A11, A22), add(B11, B22));
        int[][] M2 = multiply(add(A21, A22), B11);            
        int[][] M3 = multiply(A11, subtract(B12, B22));      
        int[][] M4 = multiply(A22, subtract(B21, B11));      
        int[][] M5 = multiply(add(A11, A12), B22);            
        int[][] M6 = multiply(subtract(A21, A11), add(B11, B12));
        int[][] M7 = multiply(subtract(A12, A22), add(B21, B22)); 

        
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);   
        int[][] C12 = add(M3, M5);                          
        int[][] C21 = add(M2, M4);                           
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);    

      
        int[][] C = new int[n][n];
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                C[i][j] = C11[i][j];
                C[i][j + half] = C12[i][j];
                C[i + half][j] = C21[i][j];
                C[i + half][j + half] = C22[i][j];
            }
        }
        return C;
    }
    
    public int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }
    
    public int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }
     
     void print(int [][] matrix)
    {
        System.out.println();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }   
}