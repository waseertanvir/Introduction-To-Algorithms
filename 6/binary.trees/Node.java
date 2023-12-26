package binary.trees;

public class Node {
    private Node parent;
    private int value;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Node parent, int value, Node left, Node right) {
        this.parent = parent;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
