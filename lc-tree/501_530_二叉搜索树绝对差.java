import java.util.ArrayList;
import java.util.List;

class Solution {

    // 最小差  
    public int minValue;
    public TreeNode preNode;

    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        minValue = Integer.MAX_VALUE;
        getMin(root);
        return minValue;
    }

    public List<Integer> list = new ArrayList<>();

    public void getMin(TreeNode root){
        if(root == null) return;
        getMin(root.left);
        if(preNode != null){
            int sub = Math.abs(preNode.val - root.val);
            if(sub < minValue){
                minValue = sub;
            }
        }

        list.toArray();

        preNode = root;
        getMin(root.right);
    } 


    // 众数

    public TreeNode pre;
    public List<Integer> list = new ArrayList<>();
    public int count;
    public int maxCount;
    public int[] findMode(TreeNode root) {
        search(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void search(TreeNode cur){
        if(cur == null) return;
        search(cur.left);
        if(pre != null && pre.val == cur.val){
            count++;
        }else{
            count = 1;
        }
        pre = cur;
        if(count > maxCount){
            maxCount = count;
            list.clear();
            list.add(cur.val);
        }else if(count == maxCount){
            list.add(cur.val);
        }
        search(cur.right);
    }
}