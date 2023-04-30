
public class Node {

    // also called "value" in a binary tree
    // also called "key" in a binary search tree
    Data data;

    Node left;
    Node right;
    Node parent; // used in SimpleBinaryTree + red-black tree

    boolean color; // used in red-black tree

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to store in the node
     */
    public Node(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}
