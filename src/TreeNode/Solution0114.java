package TreeNode;



public class Solution0114 {
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

    public void printRecursion(int val, int depth, int count){
        for(int i=0; i<count; i++){
            System.out.print("\t");
        }
        System.out.println("val:"+val+" depth:"+depth);
    }


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

    //114. 二叉树展开为链表
    public static void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        //将根节点左节点置空，右节点的值设置为左节点的值，然后将原来右节点的值接续再后面
        root.left = null;
        root.right = left;

        TreeNode temp = root;
        while (temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }


    public static void main(String[] args){
        Solution0114 solution = new Solution0114();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        System.out.println(solution.maxDepth(node1));
        flatten(node1);
        System.out.println(solution.maxDepth(node1));

    }
}