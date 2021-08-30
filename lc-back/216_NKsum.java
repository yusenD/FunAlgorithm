class Solution {
	List<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		backTracking(n, k, 1, 0);
		return result;
	}

	private void backTracking(int targetSum, int k, int startIndex, int sum) {
		// 减枝
		if (sum > targetSum) {
			return;
		}

		if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
			return;
		}
		
		// 减枝 9 - (k - path.size()) + 1 这里需要考虑，如果还剩path里面还有两个位置，那么倒数第二个必然不能抢了倒数第一的数字
		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			path.add(i);
			sum += i;
			backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            
			//回溯
			sum -= i;
		}
	}
}