package binary.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    void deleteNode(Node node) {
        while (node.getLeft() != null && node.getRight() != null) {
            Integer nodeCurrentValue = node.getValue();
            Node predecessor = inOrderPredecessor(node);
            node.setValue(predecessor.getValue());

            predecessor.setValue(nodeCurrentValue);
            node = predecessor;
        }

        Node parentNode = node.getParent();
        if (parentNode.getLeft() == node) {
            parentNode.setLeft(null);
        } else {
            parentNode.setRight(null);
        }
    }

    private void subtreeInsertBefore(Node currentNode, Integer value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (currentNode.getLeft() == null) {
            currentNode.setLeft(newNode);
        } else {
            subtreeFirst(currentNode).setLeft(newNode);
        }
    }

    void subtreeInsertAfter(Node currentNode, Integer value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (currentNode.getRight() == null) {
            currentNode.setRight(newNode);
        } else {
            subtreeFirst(currentNode.getRight()).setLeft(newNode);
        }
    }

    Node inOrderPredecessor(Node node) {
        if (node.getLeft() != null) {
            return subtreeLast(node.getLeft());
        } else {
            while (node != node.getParent().getRight()) {
                node = node.getParent();
            }
            node = node.getParent();
            return node;
        }
    }

    Node inOrderSuccessor(Node node) {
        if (node.getRight() != null) {
            return subtreeFirst(node.getRight());
        } else {
            while (node != node.getParent().getLeft()) {
                node = node.getParent();
            }
            node = node.getParent();
            return node;
        }
    }

    /**
     * TODO(Tanvir Waseer): Implement this method
     *
     * @param node
     */
    private void preOrderSuccessor(Node node) {

    }

    Node subtreeLast(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    Node subtreeFirst(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Should output [8, 3, 1, 6, 10, 14, 13] if the node is generated using setup function
     *
     * @param node
     * @return
     */
    String printInOrderTraversal(Node node) {
        List<Integer> list = new ArrayList<>();
        printInOrderTraversalHelper(node, list);
        return list.toString();
    }

    void printInOrderTraversalHelper(Node root, List<Integer> list) {
        if (root.getLeft() != null) {
            printInOrderTraversalHelper(root.getLeft(), list);
        }

        list.add(root.getValue());

        if (root.getRight() != null) {
            printInOrderTraversalHelper(root.getRight(), list);
        }
    }

    Node setUp() {
        Node root = new Node();
        root.setValue(8);

        Node leftNode = new Node();
        leftNode.setParent(root);
        leftNode.setValue(3);
        root.setLeft(leftNode);

        Node rightNode = new Node();
        rightNode.setParent(root);
        rightNode.setValue(10);
        root.setRight(rightNode);

        Node leftLeftNode = new Node();
        leftLeftNode.setParent(leftNode);
        leftLeftNode.setValue(1);
        root.getLeft().setLeft(leftLeftNode);

        Node leftRightNode = new Node();
        leftRightNode.setParent(leftNode);
        leftRightNode.setValue(6);
        root.getLeft().setRight(leftRightNode);

        Node rightRightNode = new Node();
        rightRightNode.setParent(rightNode);
        rightRightNode.setValue(14);
        root.getRight().setRight(rightRightNode);

        Node rightRightLeftNode = new Node();
        rightRightLeftNode.setParent(rightRightNode);
        rightRightLeftNode.setValue(13);
        root.getRight().getRight().setLeft(rightRightLeftNode);

        return root;
    }
}
