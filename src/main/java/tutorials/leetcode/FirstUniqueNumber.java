package tutorials.leetcode;

public class FirstUniqueNumber {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{0, 0, -7, -7, -7, 1, 2, 5, 3, 1, 2};

        int n = getFirstUnique(arr);
        System.out.println("Найдено уникальное значение " + n);
    }

    private static int getFirstUnique(int arr[]) throws Exception {
        //положили в сет
        for (int i : arr) {
            int temp = 0;
            for (int i1 : arr) {
                if (i != i1) {
                    continue;
                } else {
                    temp++;
                }
            }
            if (temp == 1) {
                return i;
            }
        }
        throw new Exception("not unique elements");
    }
}
