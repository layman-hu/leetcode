package TreeNode;



public class Solution0104 {
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

    public void printRecursion(int val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+val+" depth:"+depth);
    }

    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        count++;
        printRecursion(root.val,depth,count);

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        //后序遍历
        depth = (left_depth>right_depth)?left_depth+1:right_depth+1;

        printRecursion(root.val,depth,count);
        count--;
        return depth;
    }


    public static void main(String[] args){
        Solution0104 solution = new Solution0104();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node9.left = null;
        node9.right = null;
        node20.left = node15;
        node20.right = node7;



        System.out.println(solution.maxDepth(node3));
    }
}