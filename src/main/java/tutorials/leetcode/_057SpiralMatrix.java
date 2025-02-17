package tutorials.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _057SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int width = matrix[0].length;
        int high = matrix.length;
        Cursor cursor = new Cursor(width, high, width, high);

        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            int lastInt = array[array.length - 1];
        }
        rightIterate(matrix, cursor, new ArrayList<>());
        System.out.println(cursor);
        return new ArrayList<>();
    }

    private static void rightIterate(int[][] matrix, Cursor cursor, List<Integer> result){
        for (int i = 0; i < cursor.right; i++) {
            cursor.down = 9;
           // result.add(Integer.valueOf(matrix[i]));
        }
    }
}
class Cursor{
    int right;
    int down;
    int left;
    int up;

    public Cursor(int right, int down, int left, int up) {
        this.right = right;
        this.down = down;
        this.left = left;
        this.up = up;
    }
}
