package Trees;

public class TreeTester {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);

        System.out.println("\n\n\nIn Order DFS traversal");
        binaryTree.dfsInOrderTraversal(binaryTree.root);
        System.out.println("\nShould be: 3 4 5 6 7 8 9");

        System.out.println("\n\n\nIn Order DFS traversal with Stack");
        binaryTree.dfsInOrderTraversalWithStack();
        System.out.println("\nShould be: 3 4 5 6 7 8 9");

        System.out.println("\n\n\nPre-Order DFS traversal");
        binaryTree.dfsPreOrderTraversal(binaryTree.root);
        System.out.println("\nShould be: 6 4 3 5 8 7 9");

        System.out.println("\n\n\nPre-Order DFS traversal with Stack");
        binaryTree.dfsPreOrderTraversalWithStack();
        System.out.println("\nShould be: 6 4 3 5 8 7 9");

        System.out.println("\n\n\nPost-Order DFS traversal");
        binaryTree.dfsPostOrderTraversal(binaryTree.root);
        System.out.println("\nShould be: 3 5 4 7 9 8 6");

        System.out.println("\n\n\nPost-Order DFS traversal with Stack");
        binaryTree.dfsPostOrderTraversalWithStack(binaryTree.root);
        System.out.println("\nShould be: 3 5 4 7 9 8 6");

        System.out.println("\n\n\nBFS traversal");
        binaryTree.bfsTraversal();
        System.out.println("\nShould be: 6 4 8 3 5 7 9\n");

        System.out.println("Contains 6: " + binaryTree.containsWithQueue(6) + " (should return true)");
        System.out.println("Contains Recursively 6: " + binaryTree.containsRecursively(6, binaryTree.root) +  " (should return true)");
        System.out.println("Contains 18: " + binaryTree.containsWithQueue(18) + " (should return false)");
        System.out.println("Contains Recursively 18: " + binaryTree.containsRecursively(18, binaryTree.root) +  " (should return false)");

        System.out.println("\n\n\nDelete Recursively");
        binaryTree.deleteRecursively(6, binaryTree.root, null);
        binaryTree.bfsTraversal();
        System.out.println("\nShould be: 6 4 3 5 7 9\n");
    }
}
