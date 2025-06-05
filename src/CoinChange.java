public class CoinChange {

    public static void main(String[] args) {
        int[] in = new int[1];
        in[0] = 2;
        System.out.print(coinChange(in, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++) {
            int minCoins = Integer.MAX_VALUE;
            int localMin = 0;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] < i) {
                    if(dp[i - coins[j]] == Integer.MAX_VALUE) {
                        localMin = Integer.MAX_VALUE;
                    } else {
                        localMin = 1;
                        localMin += dp[i - coins[j]];
                    }
                } else if(coins[j] == i) {
                    localMin = 1;
                } else {
                    localMin = Integer.MAX_VALUE;
                }
                if(localMin < minCoins) {
                    minCoins = localMin;
                }
            }
            dp[i] = minCoins;
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }

}
