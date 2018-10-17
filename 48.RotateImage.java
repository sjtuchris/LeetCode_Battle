class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n-i; j++) {
                swap(matrix, i, j, n-j-1, n-i-1);
            }
        }
        for (int i = 0; i<n/2; i++) {
            for (int j = 0; j<n; j++) {
                swap(matrix, i, j, n-i-1, j);
            }
        }
    }
    
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}