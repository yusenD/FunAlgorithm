class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int curSum = 0;
        int sum = 0;
        for(int i = 0; i < cost.length; i++){
            int sub = gas[i] - cost[i];
            sum += sub;
            curSum += sub;
            if(curSum < 0){
                res = i + 1;
                curSum = 0;
            }
        }
        if(sum < 0 ) return -1;
        return res;
    }
}