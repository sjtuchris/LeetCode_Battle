class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] dp = new int[n+1];
        for (int j=0; j<n+1; j++) {
            dp[j] = j;
        }
        int prev = 0;
        for (int i=1; i<=m; i++) {
            prev = i;
            for (int j=1; j<=n; j++) {
                int cur;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur = dp[j-1];
                } else {
                    int mn = Math.min(dp[j], prev);
                    cur = Math.min(dp[j-1], mn) + 1;
                }
                dp[j-1] = prev;
                prev = cur;
            }
            dp[n] = prev;
        }
        return dp[n];
    }
}