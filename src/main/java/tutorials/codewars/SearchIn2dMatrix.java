package tutorials.codewars;

public class SearchIn2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
         Solution solution = new Solution();
         solution.searchMatrix(matrix,13);

    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int length = matrix.length;
            for (int[] array : matrix) {
                for (int values : array) {
                    if (target == values) return true;
                }
            }
            return false;
        }
    }
}


