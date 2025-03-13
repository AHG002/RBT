/**
 * RBT
 * Red-Black Tree Insert
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
    / ************************************************************************
    // * INSERT INTO RED-BLACK TREE
    // ************************************************************************

    public void insert(int x) {
        root = nodeInsertData(root, x);
        root.setColor(Node.Color.BLACK);
    }

    private Node nodeInsertData(Node r, int x) {
        if (r == null) {
            return new Node(x, Node.Color.RED);
        }

        if(x < r.getData()){
            Node leftChild = nodeInsertData(r.getLeft(), x);
            r.setLeft(leftChild);
        }
        if( x > r.getData()){
            Node rightChild = nodeInsertData(r.getRight(), x);
            r.setRight(rightChild);}

        if( x == r.getData()){
            return r;}

        if (isRed(r.getLeft()) && isRed(r.getLeft().getLeft())){
            r = rotateRight(r);}

        if(isRed(r.getRight()) && !isRed(r.getLeft())){
            r = rotateLeft(r);}

        if(isRed(r.getRight()) && isRed( r.getLeft())){
            flipColors(r);}

        return r;
    }

    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.getLeft());
        Node a = h.getLeft();
        h.setLeft(a.getRight());
        if(a.getRight() != null){
            a.getRight().setParent(h);}

        if(h.getParent() == null ){
            root = a;}

        else if(h == h.getParent().getLeft()){
            h.getParent().setLeft(a);}

        else{
            h.getParent().setRight(a);}

        a.setParent(h.getParent());
        a.setRight(h);
        h.setParent(a);
        a.setColor(h.getColor());
        h.setColor((Node.Color.RED));


        return a;

    }
 
    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.getRight());
        Node b = h.getRight();
        h.setRight(b.getLeft());
        if(b.getLeft() != null){
            b.getLeft().setParent(h);}

        if(h.getParent() == null){
            root = b;}

        else if(h == h.getParent().getLeft()){
            h.getParent().setLeft(b);}

        else{
            h.getParent().setRight(b);}

        b.setParent(h.getParent());
        h.setParent(b);
        b.setLeft(h);
        b.setColor(h.getColor());
        h.setColor((Node.Color.RED));

        return b;

    }


    private void flipColors(Node h) {
        assert (h != null) && (h.getRight() != null) && (h.getLeft() != null);

        h.setColor(Node.flipColor(h.getColor()));
        h.getRight().setColor(Node.flipColor(h.getRight().getColor()));
        h.getLeft().setColor(Node.flipColor(h.getLeft().getColor()));

    }
}
