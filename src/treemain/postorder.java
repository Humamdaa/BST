/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treemain;

/**
 *
 * @author humam.daas
 */
public class postorder {
//    Left Right Root
    public postorder(Node root){
        PostorderTr(root);
    }
    private void PostorderTr(Node node){
        if (node == null)
            return;
 
        // First recur on left subtree
        PostorderTr(node.left);
 
        // Then recur on right subtree
        PostorderTr(node.right);
 
        // Now deal with the node
        System.out.print(node.data + ", ");
    }
}

