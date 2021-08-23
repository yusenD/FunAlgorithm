class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // in && post
    public TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        // 根据rootIndex划分左右子树
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }
    
    // pre && in
    public TreeNode buildTree2(int[] preorder, int prebegin, int preend, 
                                int[] inorder, int inbegin, int inend){
        
        if (prebegin >= preend) return null;

        int rootValue = preorder[prebegin];
        TreeNode root = new TreeNode(rootValue);
        if(preend - prebegin == 1) return root;

        int rootIndex = 0;
        for(int i = inbegin; i < inend; i++){
            if(inorder[i] == rootValue) rootIndex = i;
        }

        root.left = buildTree1(preorder, prebegin + 1, prebegin + rootIndex - inbegin +1, inorder, inbegin, rootIndex);
        root.right = buildTree1(preorder, prebegin + rootIndex - inbegin + 1, preend, inorder, rootIndex + 1, inend);

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