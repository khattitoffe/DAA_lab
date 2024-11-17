import java.util.*;

class GreedyKnapsack {
    static class Item {
        int weight, value;
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        Item[] items = { new Item(2, 3), new Item(3, 4), new Item(4, 5), new Item(5, 6) };
        int W = 5;
        double maxValue = greedyKnapsack(items, W);
        System.out.println("Greedy approach maximum value: " + maxValue);
    }
    
    public static double greedyKnapsack(Item[] items, int W) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        int currentWeight = 0;
        double totalValue = 0.0;

        for (Item item : items) {
            if (currentWeight + item.weight <= W) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remainingWeight = W - currentWeight;
                totalValue += item.value * ((double) remainingWeight / item.weight);
                break;
            }
        }
        return totalValue;
    }
}
    