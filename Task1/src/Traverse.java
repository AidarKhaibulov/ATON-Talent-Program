
public final class Traverse {
    private final BinaryTree tree;

    public Traverse(BinaryTree tree) {
        this.tree = tree;
    }

    public void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left);
        System.out.println(node.data.toString());
        traverseInOrder(node.right);
    }
    public void findByName(Node node,String name){
        if (node == null) {
            return;
        }
        findByName(node.left,name);
        if(node.data.name.equals(name))
            System.out.println(node.data);
        findByName(node.right,name);
    }
    public void findByValue(Node node,double value){
        if (node == null) {
            return;
        }
        findByValue(node.left,value);
        if(node.data.value == value)
            System.out.println(node.data);
        findByValue(node.right,value);
    }

}