import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }

    public void afterorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        inorder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> preorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

    public List<Integer> inorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.empty()){
            if(curNode != null){
                stack.add(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                res.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return res;
    }
    // 前序：中左右 后序：左右中    所以改一下前序 中右左遍历后再转一下
    public List<Integer> afterorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
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

