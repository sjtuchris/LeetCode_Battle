class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int f = nums[0];
        for (int i = 1; i<nums.length; i++) {
            f = Math.max(f + nums[i], nums[i]);
            res = Math.max(res, f);
        }
        return res;
    }
}