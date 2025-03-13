/**
 * The Node class represents a node in a red-black tree.
 */
public class Node {

    public enum Color {
        RED, BLACK
    }

    private Color color;
    private int data;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int data, Color color) {
        left = null;
        right = null;
        parent = null;
        this.color = color;
        this.data = data;
    }

    public Node(int data, Color color,
                Node left, Node right, Node parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
        this.data = data;
    }

    public Color getColor() {
        return color;
    }

    public static Color flipColor(Color c) {
        if (c == Color.RED)
            return Color.BLACK;
        return Color.RED;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
