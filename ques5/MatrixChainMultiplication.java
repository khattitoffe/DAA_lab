class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int minCost = matrixChainOrder(p);
        System.out.println("\nMinimum number of multiplications: " + minCost);
     }
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1;  
        int[][] m = new int[n][n];  
        int[][] s = new int[n][n];  

       
        for (int len = 2; len <= n; len++)
        { 
            for (int i = 0; i < n - len + 1; i++) 
            {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        printOptimalParenthesis(s, 0, n - 1);
        return m[0][n - 1];
    }
    public static void printOptimalParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i][j]);
            printOptimalParenthesis(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
