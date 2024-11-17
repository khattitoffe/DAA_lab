public class BacktrackingKnapsack {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;

        int result = knapsack(weights, values, weights.length, W);
        System.out.println("Backtracking approach max value: " + result);
    }
    
    public static int knapsack(int[] weights, int[] values, int n, int W) {
        return knapsackHelper(weights, values, n, W, 0, 0);
    }

    private static int knapsackHelper(int[] weights, int[] values, int n, int W, int index, int currentValue) {
        if (index == n) {
            return currentValue;
        }

        int exclude = knapsackHelper(weights, values, n, W, index + 1, currentValue);

        int include = 0;
        if (weights[index] <= W) {
            include = knapsackHelper(weights, values, n, W - weights[index], index + 1, currentValue + values[index]);
        }

        return Math.max(exclude, include);
    }
}
