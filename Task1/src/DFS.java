
public final class DFS {
    private final BinaryTree tree;

    public DFS(BinaryTree tree) {
        this.tree = tree;
    }

    public void traversePreOrder(Node visitor) {
        traversePreOrder(tree.getRoot(), visitor);
    }

    public static void traversePreOrder(Node node,  Node visitor) {
        if (node == null) {
            return;
        }
        System.out.println(visitor.data.toString());
        traversePreOrder(node.left, visitor);
        traversePreOrder(node.right, visitor);
    }

    public void traversePostOrder(Node visitor) {
        traversePostOrder(tree.getRoot(), visitor);
    }
    public static void traversePostOrder(Node node, Node visitor) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left, visitor);
        traversePostOrder(node.right, visitor);
        System.out.println(visitor.data.toString());
    }



    public void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left);
        System.out.println(node.data.toString());
        traverseInOrder(node.right);
    }

    public void traverseReverseInOrder(Node visitor) {
        traverseReverseInOrder(tree.getRoot(), visitor);
    }

    public static void traverseReverseInOrder(Node node, Node visitor) {
        if (node == null) {
            return;
        }
        traverseReverseInOrder(node.right, visitor);
        System.out.println(visitor.data.toString());
        traverseReverseInOrder(node.left, visitor);
    }
}