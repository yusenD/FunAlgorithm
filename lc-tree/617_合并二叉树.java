class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        int rootValue = 0;
        if(root1 != null){
            rootValue += root1.val;
        }
        if(root2 != null) {
            rootValue += root2.val;
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = merge(root1 == null ?  null : root1.left, root2 == null ? null : root2.left);
        root.right = merge(root1 == null ?  null : root1.right, root2 == null ? null : root2.right);
        return root;


    }

    public class TreeNode {
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