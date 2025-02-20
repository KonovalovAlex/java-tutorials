package tutorials.leetcode;

import tutorials.TreeNode;

public class PrintCompany {
    public static void main(String[] args) {
        //5,2,10,8,6,70,6,0,1,4
        int[] list = {5, 2, 10, 8, 6, 70, 6, 0, 1, 4};
        TreeNode treeNode = null;
        for (int i = 0; i < list.length; i++) {
            if (treeNode == null) {
                treeNode = new TreeNode(list[i], null, null);
                continue;
            }
            setThreeNode(treeNode, list[i]);
        }

        System.out.printf(treeNode.toString());
    }

    public static void setThreeNode(TreeNode treeNode, int val) {

        if (treeNode.value != null && val > treeNode.value && treeNode.right != null) {
            setThreeNode(treeNode.right, val);
        }

        if (treeNode.value != null && val < treeNode.value && treeNode.left != null) {
            setThreeNode(treeNode.left, val);
        }

        if (val > treeNode.value && treeNode.right == null) {
            treeNode.right = new TreeNode(val, null, null);

        } else if (val <= treeNode.value && treeNode.left == null) {
            treeNode.left = new TreeNode(val, null, null);
        }
    }
}

