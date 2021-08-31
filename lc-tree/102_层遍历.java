import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.deleteCharAt(0);
        builder.reverse().toString();
        
        Comparator<TreeNode> comparator = new Comparator<TreeNode>() {

            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        };
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size ; i++){
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public void dfs(TreeNode root, int deep){
        if(root == null) return;
        if(resList.size() < deep){
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }
        resList.get(deep - 1).add(root.val);
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}

