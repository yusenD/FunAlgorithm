import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(MyTreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(MyTreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public void preorder(MyTreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }

    public void afterorder(MyTreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        inorder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> preorderStack(MyTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            MyTreeNode node = stack.pop();
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

}

public class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;
    MyTreeNode() {}
    MyTreeNode(int val) { this.val = val; }
    MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}