package TreeNode;



public class Solution0543 {
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
    int result = 0;
    int count = 0;//打印递归的计数器

    public void printRecursion(int val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+val+" depth:"+depth);
    }

    //543. 二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        count++;
        printRecursion(root.val,result,count);

        int left_depth = diameterOfBinaryTree(root.left);
        int right_depth = diameterOfBinaryTree(root.right);
        //后序遍历
        result = (left_depth>right_depth)?left_depth+1:right_depth+1;

        printRecursion(root.val,result,count);
        count--;
        return result;
    }


    public static void main(String[] args){
        Solution0543 solution = new Solution0543();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = null;


        System.out.println(solution.diameterOfBinaryTree(node1));
    }
}