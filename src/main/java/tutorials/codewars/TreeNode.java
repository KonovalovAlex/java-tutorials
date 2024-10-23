package tutorials.codewars;

public class TreeNode {
    //Сумма листовых элементов бинарного дерева
    private final int value;
    private final TreeNode left;
    private final TreeNode right;

    public static int calculateSumOfLeafElements(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.value;
        }

        int counter = 0;
        if (root.left != null) {
            counter += calculateSumOfLeafElements(root.left);
        }
        if (root.right != null) {

            counter += calculateSumOfLeafElements(root.right);
        }
        return counter;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}


/*           6
            / \
            7   5
            \
            8
            / \
            3   2

            3 + 2 + 5 = 10
            */
