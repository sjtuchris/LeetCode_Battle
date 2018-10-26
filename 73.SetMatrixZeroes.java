class Solution {
    public void setZeroes(int[][] matrix) {
        int rLength = matrix.length;
        int cLength = matrix[0].length;
        for (int i = 1; i<rLength; i++) {
            for (int j = 1; j < cLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i<rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}