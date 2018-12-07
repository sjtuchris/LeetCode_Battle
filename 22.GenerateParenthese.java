class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }
    
    private void dfs(List<String> res, String temp, int left, int right) {
        if (left > right) return;
        if (left > 0) {
            dfs(res, temp + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(res, temp + ")", left, right - 1);
        }
        if (left == 0 && right == 0) {
            res.add(temp);
        }
    }
}