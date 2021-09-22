import java.util.List;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        List<Integer> list = new ArrayList<>(nums);
        Arrays.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= 0){
                res+=list.get(i);
            }
            if(list.get(i) < 0 && k > 0){
                k--;
                res-=list.get(i);
            }
        }
        int lastValue = list.get(list.size() - 1);
        if(k > 0){
            k = k % 2;
            lastValue = k == 1 ? -lastValue : lastValue;
        }
        if(lastValue > 0) res+=lastValue;
        return res;
    }
}