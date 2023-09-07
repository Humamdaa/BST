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
public class inorder {
//    Left root Right
    public inorder(Node root){
        InorderTr(root);
    }
    void InorderTr(Node node)
    {
        if (node == null)
            return;
 
        // First recur on left child
        InorderTr(node.left);
 
        // Then print the data of node
        System.out.print(node.data + ", ");
 
        // Now recur on right child
        InorderTr(node.right);
    }
}
