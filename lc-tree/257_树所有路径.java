import java.util.*;

class Solution {
    
    public List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        System.out.println();
        return res;
    }

    public void dfs(TreeNode node, String path){
        if(node == null) return;
        if("".equals(path)){
            path += node.val;
        }else{
            path += "->" + node.val;
        }
        String originPath = path;
        if(node.left != null) dfs(node.left, path);
        if(node.right != null) dfs(node.right, originPath);
        if(node.left == null && node.right == null && path.length() > 0){
            res.add(path);
        }
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