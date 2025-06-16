public class RodCutting {

    public static void main(String[] args) {
        int[] in = { 3, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(in));
    }

    public static int cutRod(int[] price) {
        int[] max = new int[1];
        max[0] = price[price.length - 1];
        rec(price, 0, price.length, max, 0);
        return max[0];
    }

    static void rec(int[] prices, int index, int length, int[] max, int currSum) {
        if(index >= prices.length) return;
        if(length <= 0 || (length - index - 1) < 0) return;

        int rem = 0;
        if(length - index - 2 > -1) {
            rem = prices[length - index - 2];
        }
        int profit = currSum + prices[index] + rem;
        max[0] = Math.max(max[0], profit);
        rec(prices, index, length - (index + 1), max, profit);
        rec(prices, index + 1, length, max, profit);
    }

}
