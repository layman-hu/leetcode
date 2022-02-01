package TreeNode;



public class Solution0226 {
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
    static int depth = 0;
    static int count = -1;//打印递归的计数器

    public void printRecursion(int val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+val+" depth:"+depth);
    }

    //226. 翻转二叉树
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

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public static void main(String[] args){
        Solution0226 solution = new Solution0226();
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;


        System.out.println(solution.maxDepth(node4));

        depth = 0;
        count = -1;

        System.out.println(solution.maxDepth(invertTree(node4)));;
    }
}