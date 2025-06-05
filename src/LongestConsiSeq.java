import java.util.HashMap;
import java.util.Objects;

public class LongestConsiSeq {

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 100;
        arr[1] = 4;
        arr[2] = 200;
        arr[3] = 1;
        arr[4] = 3;
        arr[5] = 2;
        System.out.print(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        for (int j : nums) {
            cache.put(j, true);
        }
        int max = 1;
        for (int num : nums) {
            int value = num;
            if (cache.get(value - 1) == null) {
                int localMax = 1;
                while (true) {
                    Object nextValue = cache.getOrDefault(value + 1, null);
                    if (nextValue != null) {
                        localMax++;
                        value++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, localMax);
            }
        }
        return max;
    }
}
