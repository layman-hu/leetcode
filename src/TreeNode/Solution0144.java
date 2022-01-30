package TreeNode;


import java.util.ArrayList;
import java.util.List;

public class Solution0144 {
    public static class TreeNode {
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
    int depth = 0;
    int count = 0;//打印递归的计数器
    List<Integer> preamble_nums = new ArrayList<>();

    public void printRecursion(int val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+val+" depth:"+depth);
    }

    //144. 二叉树的前序遍历
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        count++;
        printRecursion(root.val,depth,count);

        /*
        前序遍历
         */
        preamble_nums.add(root.val);

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        //后序遍历
        depth = (left_depth>right_depth)?left_depth+1:right_depth+1;

        printRecursion(root.val,depth,count);
        count--;
        return depth;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        maxDepth(root);
        return preamble_nums;
    }

    public static void main(String[] args){
        Solution0144 solution = new Solution0144();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(solution.preorderTraversal(node1));
    }
}