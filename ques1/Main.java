public class Main {
    public static void main(String[] args) {

        int[] values = {50, 30, 20, 40, 70, 60, 80}; 

        BinarySearchTree bstRecursive = new BinarySearchTree();
        BinarySearchTree bstIterative = new BinarySearchTree();

        long startTimeRecursive = System.nanoTime();
        for (int value : values) {
            bstRecursive.insertRecursive(value);
        }
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = endTimeRecursive - startTimeRecursive;
        System.out.println("Recursive insertion time: " + durationRecursive + " ns");

        long startTimeIterative = System.nanoTime();
        for (int value : values) {
            bstIterative.insertIterative(value);
        }
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;
        System.out.println("Iterative insertion time: " + durationIterative + " ns");

        System.out.print("Inorder traversal (Recursive): ");
        bstRecursive.inorderTraversal();
        System.out.println();

        System.out.print("Inorder traversal (Iterative): ");
        bstIterative.inorderTraversal();
        System.out.println();
    }
}
