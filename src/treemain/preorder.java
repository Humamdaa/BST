/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treemain;


public class preorder {
//  root left right
    public preorder(Node root){
        preorderTr(root);
    }
    private void preorderTr(Node node)
    {
        if (node == null)
            return;
    //    first print root
        System.out.print(node.data + ", ");
        /* first recur on left child */
        preorderTr(node.left);

        /* now recur on right child */
        preorderTr(node.right);
    }
}
