class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) return result;
        int[] indexes = new int[n];
        dfs(result, indexes, 0);
        return result;
    }
    
    private void dfs(List<List<String>> result, int[] indexes, int row) {
        if (row == indexes.length) {
            collectSolution(result, indexes);
        } else {
            for (int j = 0; j < indexes.length; j++) {
                indexes[row] = j;
                if (isValid(indexes, row)) {
                    dfs(result, indexes, row + 1);
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

    private void collectSolution(List<List<String>> res, int[] indexes) {
        List<String> sol = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            sb.setLength(0);
            for(int j = 0; j<indexes.length; j++) {
                if (j!=indexes[i]) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            sol.add(sb.toString());
        }
        res.add(sol);
    }
}