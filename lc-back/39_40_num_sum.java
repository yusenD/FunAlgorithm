import java.util.Arrays;
import java.util.List;;


class Test{
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target == 0 || candidates.length == 0) return res;
        lookingBack1(candidates, 0, 0, target);
        path.sort(c);
        return res;
    }
    
    public void lookingBack1(int[] candidates, int startIndex, int sum, int target){
        if(sum > target){
            return;
        }else if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
    
        for(int i = startIndex; i < candidates.length; i++){
            int sumIndex = sum + candidates[i];
            if(sumIndex > target){
                continue;
            }
            path.add(candidates[i]);    
            if(sumIndex + candidates[i] > target){
                lookingBack(candidates, i + 1, sumIndex, target);
            }else{
                lookingBack(candidates, i, sumIndex, target);
            }
            // lookingBack(candidates, startIndex + 1, sum, target);
            int last = path.size() - 1;
            path.remove(last);
        }
    
    }

    class Solution {

        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private boolean[] visitor;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if(target == 0 || candidates.length == 0) return res;
            Arrays.sort(candidates);
            visitor = new boolean[candidates.length];
            backTracking2(candidates, 0, 0, target);
            return res;
        }
    
        public void backTracking2(int[] candidates, int startIndex, int sum, int target){
            if(sum == target){
                res.add(new ArrayList<>(path));
                return;
            }else if (sum > target){
                return;
            }
    
            for(int i = startIndex; i < candidates.length; i++){
    
                if(sum + candidates[i] > target){
                    continue;
                }
    
                if(i > 0 && candidates[i] == candidates[i - 1] && !visitor[i-1]){
                    continue;
                }
    
                visitor[i] = true;
                path.add(candidates[i]);
    
                backTracking(candidates, i + 1, sum + candidates[i], target);
    
                int last = path.size() - 1;
                path.remove(last);
                visitor[i] = false;
            }
    
        }
    }
}
