/**
 * RBT
 * Red-Black Tree Insert
 * @author INSERT_YOUR_USERNAME_HERE
 */
import java.util.*;
public class RBT {
    private Node root;

    public RBT() {}

    public boolean isRed(Node x) {
        if (x == null) return false;
        return x.getColor() == Node.Color.RED;
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int x) {
        return nodeContainsData(root, x);
    }

    private boolean nodeContainsData(Node r, int x) {
        while (r != null) {
            if (r.getData() - x < 0) {
                r = r.getLeft();
            } else if (r.getData() - x > 0) {
                r = r.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    public List<Integer> serializeTree() {
        return serializeTree(root);
    }

    private List<Integer> serializeTree(Node r) {
        if (r == null) return new LinkedList<>();
        int data = r.getData();
        List<Integer> left = serializeTree(r.getLeft());
        List<Integer> right = serializeTree(r.getRight());
        left.add(data);
        left.addAll(right);
        return left;
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(Node r) {
        if (r==null) return 0;        
        return 1 + Math.max(maxHeight(r.getLeft()), maxHeight(r.getRight()));
    }




    // ************************************************************************
    // * INSERT INTO RED-BLACK TREE
    // ************************************************************************

    public void insert(int x) {
        root = nodeInsertData(root, x);
        root.setColor(Node.Color.BLACK);
    }

    private Node nodeInsertData(Node r, int x) {
        if (r == null) return new Node(x, Node.Color.RED);
        else 

        // TODO: Write this method!
        throw new UnsupportedOperationException("You need to code this part yourself!");
    }

    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.getLeft());

        // TODO: Write this method!
        throw new UnsupportedOperationException("You need to code this part yourself!");
    }
 
    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.getRight());

        // TODO: Write this method!
        throw new UnsupportedOperationException("You need to code this part yourself!");
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        // TODO: Write this method!
        throw new UnsupportedOperationException("You need to code this part yourself!");
    }
}
