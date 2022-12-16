/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BTtree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    // private int leftHeight = 0;
    // private int rightHeight = 0;

    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree() {
        root = null;
    }

    public void add(BinaryTree tree, String add){
        root = insert(tree, add).root;
    }

    private BinaryTree insert(BinaryTree tree, String aData) {

        if(tree == null){
            tree = new BinaryTree(aData);
            return tree;
        }
       if (tree.getNode() == null) {
            tree.root = new Node(aData);
            return tree;
        }
    
        int compare = tree.getNode().getData().compareToIgnoreCase(aData);
        if (compare > 0) {
            tree.setLeft(insert(tree.getNode().left(),aData));
        } else if (0 > compare) {
            tree.setRight(insert(tree.getNode().right(),aData));
        } else {
            // value already exists
            return tree;
        }
    
        return tree;
    }

    public BinaryTree find(BinaryTree noot, String aData) {
        if(noot == null || noot.root == null){
            return null;
        }
        if (noot.getNode().getData().contentEquals(aData)) {
            return this;
        }
        
        int comp = noot.getNode().getData().compareToIgnoreCase(aData);
        
        return comp > 0 ?
        find(noot.getNode().left(), aData) 
        : find(noot.getNode().right(), aData);
        
    }

    public void preOrder(Node noot) {
    
        if (noot != null) {
            
            if(noot.left() != null)
            preOrder(noot.left().root);

            System.out.print(" " + noot.getData());

            if(noot.right() != null)
            preOrder(noot.right().root);
        }

    }

    public void delete(BinaryTree tree, String value) {
        BinaryTree buu = deleteRecursive(tree, value);
        if(buu == null){
            
            root = null;
        }
        else{
            System.out.println("Poistettu onnistuneesti");
            root = buu.root;
        }
    }

    private BinaryTree deleteRecursive(BinaryTree current, String value) {
        if (current == null || current.root == null) {
            return null;
        }
    
        if (value.equals(current.getNode().getData())) {
            if (current.getNode().left() == null && current.getNode().right() == null) {
                return null;
            }

            if (current.getNode().right() == null) {
                return current.getNode().left();
            }
            
            if (current.getNode().left() == null) {
                return current.getNode().right();
            }

            String val = findSmallestValue(current.root);
            current.getNode().setData(val);
            return current;
        }

        int comp = current.getNode().getData().compareToIgnoreCase(value);
        if (comp > 0) {
            current.setLeft(deleteRecursive(current.getNode().left(), value));
            return current;
        }
        current.setRight(deleteRecursive(current.getNode().right(), value));
        return current;
    }

    private String findSmallestValue(Node root) {
        if(root.right().getNode().left() != null){
            String data = root.right().getNode().left().getNode().getData();
            root.right().getNode().left().setNode(null);;
            return data;
        }else if(root.right().getNode().right() != null){
            String data = root.right().getNode().getData();
            root.setRight(root.right().getNode().right());
            return data;
        }
        else{
            String data = root.right().getNode().getData();
            root.right().setNode(null);
            return data;
        }
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

    public Node getNode() {
        return this.root;
    }

    public void setNode(Node node) {
        root = node;
    }
}
