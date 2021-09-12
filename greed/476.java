class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int res = 1;
        int prediff = 0;
        int curdiff = 0;
        for(int i = 1; i < nums.length; i++){
            curdiff = nums[i] - nums[i-1];
            if(curdiff > 0 && prediff <= 0){
                res++;
                prediff = curdiff;
            }
            if(curdiff < 0 && prediff >= 0){
                res++;
                prediff = curdiff;
            }
        }
        return res;
    }
}