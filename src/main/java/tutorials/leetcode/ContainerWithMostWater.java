package tutorials.leetcode;

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 11, 6, 2, 5, 4, 8, 3, 10};
        solution(height);
    }

    public static int solution(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int i1 = height[i];

            for (int j = 0; j < height.length; j++) {
                if (j == i) continue;
                int i2 = height[j];
                int min = Math.min(i1, i2);
                int l0ng = Math.max(i,j) - Math.min(i,j);
                if (min * l0ng > result) {
                    result = min * l0ng;
                }
            }
        }
        return 1;
    }
}
