//package tutorials.leetcode;
//
//import tutorials.TreeNode;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static java.lang.Integer.valueOf;
//
//public class _199BinaryTreeRightSideView {
//    public static void main(String[] args) {
//        TreeNode left5Floor = new TreeNode(19, null, null);
//        TreeNode left4Floor = new TreeNode(12, left5Floor, null);
//        TreeNode left3Floor = new TreeNode(13, left4Floor, null);
//        TreeNode right4Floor = new TreeNode(6, null, null);
//        TreeNode right3Floor = new TreeNode(4, right4Floor, null);
//        TreeNode right2Floor = new TreeNode(2, left3Floor, right3Floor);
//        TreeNode node = new TreeNode(1, null, right2Floor);
//        rightSideView(node).forEach(System.out::println);
//    }
//
//    private static List<Integer> rightSideView(TreeNode node) {
//        Map<Integer, Integer> floorResultMap = new HashMap<>();
//        addRightValue(floorResultMap, node, 1);
//        return floorResultMap.values().stream().toList();
//    }
//
//    private static void addRightValue(Map<Integer, Integer> floorResultMap, TreeNode node, Integer floorNumber) {
//        if (node == null) {
//            return;
//        }
//        floorResultMap.putIfAbsent(floorNumber, node.value);
//
//        if (node.right == null && node.left == null) {
//            return;
//        }
//        if (node.right != null) {
//            Integer floorNumberStack = valueOf(floorNumber + 1);
//            addRightValue(floorResultMap, node.right, floorNumberStack);
//        }
//        if (node.left != null) {
//            Integer floorNumberStack = valueOf(floorNumber + 1);
//            addRightValue(floorResultMap, node.left, floorNumberStack);
//        }
//    }
//
//    public List<Integer> rightSideView(TreeNode root) {
//        Map<Integer, Integer> floorResultMap = new HashMap<>();
//        addRightValue(floorResultMap, root, 1);
//        return floorResultMap.values().stream().toList();
//    }
//
//    private void addRightValue(Map<Integer, Integer> floorResultMap, TreeNode node, Integer floorNumber) {
//        if (node == null) {
//            return;
//        }
//        floorResultMap.putIfAbsent(floorNumber, node.value);
//
//        if (node.right == null && node.left == null) {
//            return;
//        }
//        if (node.right != null) {
//            Integer floorNumberStack = valueOf(floorNumber + 1);
//            addRightValue(floorResultMap, node.right, floorNumberStack);
//        }
//        if (node.left != null) {
//            Integer floorNumberStack = valueOf(floorNumber + 1);
//            addRightValue(floorResultMap, node.left, floorNumberStack);
//        }
//    }
//}
