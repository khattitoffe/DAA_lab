class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }
 
    public void insertRecursive(int value) {
        root = insertRecursiveHelper(root, value);
    }

    private Node insertRecursiveHelper(Node root, int value) {
       
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insertRecursiveHelper(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursiveHelper(root.right, value);
        }

        return root;
    }

    public void insertIterative(int value) {
        root = insertIterativeHelper(root, value);
    }

    private Node insertIterativeHelper(Node root, int value) {
        Node newNode = new Node(value);

        if (root == null) {
            return newNode; 
        }

        Node current = root;
        Node parent = null;

      
        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return root;
            }
        }

        
        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }
    public void inorderTraversal() {
        inorderTraversalHelper(root);
    }

    private void inorderTraversalHelper(Node root) {
        if (root != null) {
            inorderTraversalHelper(root.left);
            System.out.print(root.value + " ");
            inorderTraversalHelper(root.right);
        }
    }
}
