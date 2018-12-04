class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String ip = "";
        dfs(s, 0, 0, ip, res);
        return res;
    }
    
    private void dfs(String s, int start, int step, String ip, List<String> res) {
        if (step > 4) {
            return;
        }
        if (start == s.length() && step == 4) {
            res.add(ip);
            return;
        }
        
        for (int i=1; i<4; i++) {
            if (start + i > s.length()) break;
            String temp = s.substring(start, start+i);
            if ((temp.startsWith("0") && temp.length() > 1) || Integer.parseInt(temp) > 255) continue;
            dfs(s, start+i, step+1, ip+temp+(step==3 ? "":"."), res);
        }
    }
}