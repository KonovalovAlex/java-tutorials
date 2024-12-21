package tutorials.leetcode;

public class _135Candy {
    public static void main(String[] args) {
        int [] rating = {1,0,2};
        candy(rating);

    }
    public static int candy(int[] ratings) {
        int[] resultArray = new int[ratings.length];
        int resultInt = 0;

        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i] > ratings[i+1]){
                resultArray[i]++;
            }
        }
        for (int i = ratings.length-1; i > 0; i--) {
            if (ratings[i] > ratings[i-1]){
                resultArray[i]++;
            }
        }
        int tmp = 0;
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultArray[i]+1;
            tmp += resultArray[i];
        }

        return tmp;
    }
}
