class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 0) return false;
        int maxDistance = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i <= maxDistance){
                maxDistance = Math.max(i + nums[i], maxDistance);
            }
            if(maxDistance >= nums.length - 1) break;
        }
        return (maxDistance >= nums.length - 1);
    }
}