package binary.trees;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.setUp();

        String IN_ORDER_TRAVERSAL = binaryTree.printInOrderTraversal(root);
        System.out.println(IN_ORDER_TRAVERSAL);

        System.out.println("Left most value: " + binaryTree.subtreeFirst(root).getValue());

        System.out.println("Right most value: " + binaryTree.subtreeLast(root).getValue());

        System.out.println("Successor of 13: " + binaryTree.inOrderSuccessor(root.getRight().getRight().getLeft()).getValue());

        System.out.println("Predecessor of 10: " + binaryTree.inOrderPredecessor(root.getRight()).getValue());

        System.out.println("Let's add 24 after 3");
        binaryTree.subtreeInsertAfter(root.getLeft(), 24);
        System.out.println(binaryTree.printInOrderTraversal(root));

        System.out.println("Let's delete the root note");
        binaryTree.deleteNode(root);
        System.out.println(binaryTree.printInOrderTraversal(root));
    }
}
