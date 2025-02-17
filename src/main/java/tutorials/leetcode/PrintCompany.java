package tutorials.leetcode;

public class PrintCompany {
    public static void main(String[] args) {
        //5,2,10,8,6,70,6,0,1,4
        int[] list = {5, 2, 10, 8, 6, 70, 6, 0, 1, 4};
        ThreeNode threeNode = null;
        for (int i = 0; i < list.length; i++) {
            if (threeNode == null) {
                threeNode = new ThreeNode(list[i], null, null);
                continue;
            }
            setThreeNode(threeNode, list[i]);
        }

        System.out.printf(threeNode.toString());
    }

    public static void setThreeNode(ThreeNode threeNode, int val) {

        if (threeNode.value != null && val > threeNode.value && threeNode.right != null) {
            setThreeNode(threeNode.right, val);
        }

        if (threeNode.value != null && val < threeNode.value && threeNode.left != null) {
            setThreeNode(threeNode.left, val);
        }

        if (val > threeNode.value && threeNode.right == null) {
            threeNode.right = new ThreeNode(val, null, null);

        } else if (val <= threeNode.value && threeNode.left == null) {
            threeNode.left = new ThreeNode(val, null, null);
        }
    }
}

