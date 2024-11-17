import java.util.*;

public class BranchAndBoundKnapsack {
    static class Node {
        int level, profit, weight;
        float bound;
        public Node(int level, int profit, int weight) 
        {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
            this.bound = 0;
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;

        int result = knapsack(weights, values, W, weights.length);
        System.out.println("Branch & Bound max value: " + result);
    }
    
    private static float bound(Node u, int[] weights, int[] values, int n, int W) 
    {
        if (u.weight >= W) {
            return 0;
        }

        int profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;
       
        while (j < n && totalWeight + weights[j] <= W) {
            totalWeight += weights[j];
            profitBound += values[j];
            j++;
        }

        if (j < n) {
            profitBound += (W - totalWeight) * values[j] / (float) weights[j];
        }

        return profitBound;
    }
    public static int knapsack(int[] weights, int[] values, int W, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(n1 -> n1.bound));
        Node root = new Node(-1, 0, 0);
        queue.add(root);

        int maxProfit = 0;
        while (!queue.isEmpty()) {
            Node u = queue.poll();

          
            if (u.bound > maxProfit) {
            
                Node v = new Node(u.level + 1, u.profit + values[u.level + 1], u.weight + weights[u.level + 1]);
                if (v.weight <= W && v.profit > maxProfit) {
                    maxProfit = v.profit;
                }
                if (bound(v, weights, values, n, W) > maxProfit) {
                    queue.add(v);
                }
                v = new Node(u.level + 1, u.profit, u.weight);
                if (bound(v, weights, values, n, W) > maxProfit) {
                    queue.add(v);
                }
            }
        }
        return maxProfit;
    }
}
