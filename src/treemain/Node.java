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
public class Node {
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
    }
    public Node get_left(){
        return left;
    }
     public Node get_right(){
        return right;
    }
     public int get_element(){
        return data;
    }
}
