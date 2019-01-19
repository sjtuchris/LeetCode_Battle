class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = 0;
        
        for (int i = 1; i < m; i++) {
            dp[i] = Integer.MAX_VALUE;     
        }
        
        for (int i = 0; i< n; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j-1], dp[j])+grid[i][j];
            }
        }
        return dp[m-1];
    }
}