package tutorials.leetcode;

public class ThreeNode {
    public Integer value;
    public ThreeNode left;
    public ThreeNode right;

    ThreeNode(int value){
        this.value = value;
    }
    ThreeNode(int value, ThreeNode left, ThreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
