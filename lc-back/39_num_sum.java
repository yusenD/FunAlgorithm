private List<List<Integer>> res = new ArrayList<>();
private List<Integer> path = new ArrayList<>();

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(target == 0 || candidates.length == 0) return res;
    lookingBack(candidates, 0, 0, target);
    return res;
}

public void lookingBack(int[] candidates, int startIndex, int sum, int target){
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