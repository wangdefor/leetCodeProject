package org.example;

/**
 * @Classname Rob
 * @Description TODO
 * @Date 2021/3/17 16:49
 * @Created wangyong
 */
public class Rob {

    public int rob(TreeNode root) {
        //计算所有的可能性
        if(root == null){
            return 0;
        }
        Integer sum = 0;
        if(root.left == null && root.right == null){
            return root.val;
        }
        if(root.left != null && root.right == null){
            sum = root.left.val + rob(root);
        }
        if(root.left == null && root.right != null){

        }
        if(root.left != null && root.right != null){

        }
        return 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
