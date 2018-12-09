class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int[] minV = new int[col];
        for (int i = row - 1; i>=0; i--) {
            for (int j = 0; j<i+1; j++) {
                if(i == row-1) {  
                    minV[j] = triangle.get(i).get(j);  
                    continue;  
                }  
                minV[j] = Math.min(minV[j], minV[j+1]) + triangle.get(i).get(j);  
            }
        }
        return minV[0];
    }
}