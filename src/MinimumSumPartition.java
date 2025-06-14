public class MinimumSumPartition {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr));
    }

    public static int minDifference(int arr[]) {
        int totalSum = 0;
        for(int i = 0; i<arr.length; i++) {
            totalSum += arr[i];
        }
        int[][] dp = new int[arr.length + 1][totalSum + 1];
        for(int i = 0; i< dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return minRec(arr, 0, 0, totalSum, Integer.MAX_VALUE, dp);
    }

    static int minRec(int[] arr, int index, int currSum, int totalSum, int currMin, int[][] dp) {
        int newMin = Math.abs(totalSum - (2 * currSum));
        if(newMin > currMin) return currMin;
        if(index >= arr.length) return newMin;

        if(dp[index + 1][currSum + arr[index]] == -1) {
            int left = minRec(arr, index + 1, currSum + arr[index], totalSum, newMin, dp);
            dp[index + 1][currSum + arr[index]] = left;
        }
        if(dp[index + 1][currSum] == -1) {
            int right = minRec(arr, index + 1, currSum, totalSum, newMin, dp);
            dp[index + 1][currSum] = right;
        }
        return Math.min(dp[index + 1][currSum], dp[index + 1][currSum + arr[index]]);
    }

}
