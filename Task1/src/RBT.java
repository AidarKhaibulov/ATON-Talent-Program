

public class RBT extends BaseBinaryTree implements BinarySearchTree {

    static final boolean RED = false;
    static final boolean BLACK = true;

    @Override
    public  Node searchNode(long key) {
            Node node = root;
            while (node != null) {
                if (key == node.data.account) {
                    return node;
                } else if (key < node.data.account) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        return null;
    }
    public  Node searchNode(String name) {
        Node node = root;
        while (node != null) {
            if (name.equals(node.data.name)) {
                return node;
            } else if (name.compareTo(node.data.name)<0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }


    public void insertNode(long account,String name, double value) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (account < node.data.account) {
                node = node.left;
            } else if (account > node.data.account) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + account);
            }
        }

        Node newNode = new Node(new Data(account,name,value));
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (account < parent.data.account) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;
        if (parent == null) {
            return;
        }

        if (parent.color == BLACK) {
            return;
        }
        Node grandparent = parent.parent;

        if (grandparent == null) {

            parent.color = BLACK;
            return;
        }


        Node uncle = getUncle(parent);

        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;


            fixRedBlackPropertiesAfterInsert(grandparent);
        }


        else if (parent == grandparent.left) {

            if (node == parent.right) {
                rotateLeft(parent);

                parent = node;
            }

            rotateRight(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }

        else {
            if (node == parent.left) {
                rotateRight(parent);

                parent = node;
            }


            rotateLeft(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    private Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    public void deleteNode(long key) {
        Node node = root;

        // Find the node to be deleted
        while (node != null && node.data.account != key) {
            if (key < node.data.account) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // Node not found?
        if (node == null) {
            return;
        }

        Node movedUpNode;
        boolean deletedNodeColor;

        // Node has zero or one child
        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }

        else {

            Node inOrderSuccessor = findMinimum(node.right);

            node.data = inOrderSuccessor.data;

            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);

            if (movedUpNode.getClass() == NilNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }
    }

    private Node deleteNodeWithZeroOrOneChild(Node node) {
        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left);
            return node.left; // moved-up node
        }

        else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right);
            return node.right; // moved-up node
        }

        else {
            Node newChild = node.color == BLACK ? new NilNode() : null;
            replaceParentsChild(node.parent, node, newChild);
            return newChild;
        }
    }

    private Node findMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void fixRedBlackPropertiesAfterDelete(Node node) {
        if (node == root) {
            return;
        }

        Node sibling = getSibling(node);

        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = getSibling(node);
        }

        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = RED;

            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }

            else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }

        else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    private void handleRedSibling(Node node, Node sibling) {

        sibling.color = BLACK;
        node.parent.color = RED;


        if (node == node.parent.left) {
            rotateLeft(node.parent);
        } else {
            rotateRight(node.parent);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(Node node, Node sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        if (nodeIsLeftChild && isBlack(sibling.right)) {
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = node.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }

        sibling.color = node.parent.color;
        node.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private Node getSibling(Node node) {
        Node parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        } else if (node == parent.right) {
            return parent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    private static class NilNode extends Node {
        private NilNode() {
            super(new Data(0,"",0));
            this.color = BLACK;
        }
    }



    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }


    @Override
    protected void appendNodeToString(Node node, StringBuilder builder) {
        builder.append(node.data).append(node.color == RED ? "[R]" : "[B]");
    }
}