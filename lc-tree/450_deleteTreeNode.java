class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
    root = delete(root,key);
    return root;
}

public TreeNode delete(TreeNode node, int key){
    if(node == null) return null;
    if(node.val > key) {
        node.left = delete(node.left, key);
    }
    else if(node.val < key) {
        node.right = delete(node.right, key);
    }
    else {
        if(node.left == null) return node.right;
        if (node.right == null) return node.left;
        TreeNode curNode = node.right;
        while(curNode.left != null){
            curNode = curNode.left;
        }
        curNode.left = node.left;
        node = node.right;
    }

    return node;
}
}