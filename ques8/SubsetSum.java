public class SubsetSum{
    public static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;
        if (isSubsetSum(arr, target)) {
            System.out.println("Subset with the given sum exists.");
        } else {
            System.out.println("Subset with the given sum does not exist.");
        }
    }
}
