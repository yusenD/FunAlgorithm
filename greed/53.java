class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(dp[i] > res) res = dp[i];
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
            if(nums.length <= 0){
                return 0;
            }
            int[] f = new int[nums.length];
            int res = nums[0];
            f[0] = nums[0];
            for (int i = 1; i < nums.length; i++){
                if(f[i-1] < 0){
                    f[i] = nums[i];
                }else{
                    f[i] = f[i - 1] + nums[i];
                }
                if(f[i] > res){
                    res = f[i];
                }
            }
            return res;
    }
}