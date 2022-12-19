import javax.swing.tree.TreeNode;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }

    }
    public void createBinaryTree(String stringEquation){

    }


    public static void main(String[] args){
        //debug equation
        String equation = "((x+5)+ 3) - (3x + 8)";
        createBinaryTree(equation);
    }
}