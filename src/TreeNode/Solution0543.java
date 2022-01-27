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
    int depth = 0;
    int count = -1;//打印递归的计数器
    int max_diameter = 0;//二叉树最大直径

    public void printRecursion(int node_val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+node_val+" depth:"+depth);
    }

    //543. 二叉树的直径
    /*
    二叉树的直径长度
    等价于
    1.寻找某一个节点，这个节点的左子树深度+右子树深度
    2.在若干节点中，筛选出最大的值即可
     */
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        count++;
        printRecursion(root.val,depth,count);

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        //后序遍历

        int temp_diameter = left_depth + right_depth;
        max_diameter = max_diameter>temp_diameter?max_diameter:temp_diameter;

        depth = (left_depth>right_depth)?left_depth+1:right_depth+1;

        printRecursion(root.val,depth,count);
        count--;
        return depth;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
//        System.out.println(max_diameter);

        return max_diameter;
    }


    public static void main(String[] args){
        Solution0543 solution = new Solution0543();


        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        TreeNode node9 = new TreeNode(9);
        node9.left = null;
        node9.right = node1;

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = null;


//        System.out.println(solution.diameterOfBinaryTree(node1));
        System.out.println(solution.diameterOfBinaryTree(node9));
    }
}