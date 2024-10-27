class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;

        // Traverse the matrix and fill the dp table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Only consider cells that contain '1'
                if (matrix[i][j] == 1) {
                    // For the first row or first column, the largest square is just the cell itself
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Update dp[i][j] to be the size of the largest square ending at (i, j)
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    // Add the number of squares ending at (i, j) to the total count
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }
}
