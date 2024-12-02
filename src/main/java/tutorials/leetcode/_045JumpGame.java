package tutorials.leetcode;

public class _045JumpGame {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4};
        jump(array);
    }

    private static int jump(int[] nums) {
        int jumps = 0; // Количество прыжков
        int currentEnd = 0; // Текущая граница прыжка
        int farthest = 0; // Максимальная достижимая позиция

        for (int i = 0; i < nums.length - 1; i++) {
            // Обновляем дальнюю точку, куда можно прыгнуть
            farthest = Math.max(farthest, i + nums[i]);

            // Если мы достигли конца текущего прыжка
            if (i == currentEnd) {
                jumps++; // Увеличиваем количество прыжков
                currentEnd = farthest; // Обновляем текущую границу

                // Если мы уже можем достичь конца массива, выходим из цикла
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
