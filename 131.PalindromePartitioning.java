class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        boolean[][] isPalindrome = isPalindrome(s);
        getPartitions(res, new ArrayList(), s, isPalindrome);
        return res;
    }
    
    private void getPartitions(List<List<String>> res, List<String> caseList, String s, boolean[][] isPalindrome) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(caseList));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                caseList.add(s.substring(0, i+1));
                getPartitions(res, caseList, s.substring(i+1), isPalindrome);
                caseList.remove(caseList.size() - 1);
            }
        }
    }
    
    private boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (((j - i <= 2) || res[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    res[i][j] = true;
                }
            }
        }
        return res;
    }
}