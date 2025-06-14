public class Knapsack01 {

    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = { 5, 4, 2, 3 };
        System.out.println(knapsack(80, val, wt));
    }

    static int knapsack(int W, int val[], int wt[]) {
        int[] maxProfit = { 0 };
        move(val, wt, maxProfit, 0, 0, W, 0);
        return maxProfit[0];
    }

    static void move(int[] value, int wt[], int[] maxProfit, int currIndex, int currWeight, int maxWeight, int currProfit) {
        if(currIndex == value.length) return;
        if(currWeight > maxWeight) {
            maxProfit[0] = Math.max(currProfit, maxProfit[0]);
            return;
        }

        if(currWeight + wt[currIndex] <= maxWeight) {
            move(value, wt, maxProfit, currIndex + 1, currWeight + wt[currIndex], maxWeight, currProfit + value[currIndex]);
        }
        move(value, wt, maxProfit, currIndex + 1, currWeight, maxWeight, currProfit);
    }

    

}
