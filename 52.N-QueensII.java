class Solution {
    private int counter = 0;
    public int totalNQueens(int n) {
        if (n==0) return 0;
        int[] indexes = new int[n];
        dfs(indexes, 0);
        return counter;
    }
    
    private void dfs(int[] indexes, int row) {
        if (row == indexes.length) {
            counter++;
        } else {
            for (int j = 0; j<indexes.length; j++) {
                indexes[row] = j;
                if (isValid(indexes, row)) {
                    dfs(indexes, row+1);
                }
            }
        }
    }
    
    private boolean isValid(int[] indexes, int row) {
        for (int i = 0; i<row; i++) {
            if (indexes[i] == indexes[row]) {
                return false;
            }
            if (Math.abs(indexes[i] - indexes[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}