class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            res.add(new ArrayList<>(tempList));   
            return;
        }
        else {
            for (int i = start; i<candidates.length; i++) {
                tempList.add(candidates[i]);
                dfs(res, tempList, candidates, remain-candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
        
    }
}