/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treemain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author humam.daas
 */
public class bstTree{
   Node root; 
   public Node get_root(){
       return root;
   }
//   Algorithms travesal :
//    1-preorder :
//    Root Left Right
   public void preoderAlgorithm(){
       System.out.println("preorder is :");
       preorder pre = new preorder(root);
       System.out.println();
   }

//    2-Inorder :
//    Left Root Right
    public void inoderAlgorithm(){
        System.out.println("inorder is :");
        inorder in = new inorder(root);
        System.out.println();
    } 
//    3-postorder
//    Left Right Root
    public void postorderAlgorithm(){
        System.out.println("postorder is");
        postorder post = new postorder(root);
        System.out.println();
    }

//     insert function 
   void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
   
    //// *** print tree *** : 
    // Function to print a binary tree in level order
    public void printTree() {
        // If the tree is empty, return
        if (root == null) {
          return;
        }

        // Create a queue to store the nodes of each level
        Queue<Node> queue = new LinkedList<>();
        // Enqueue the root node
        queue.add(root);
        System.out.println("root data " + root.data);
        // Loop until the queue is empty
        while (!queue.isEmpty()) {
          // Get the size of the current level
          int size = queue.size();
          // Print the nodes of the current level
          for (int i = 0; i < size; i++) {
            // Dequeue a node and print its data
            Node node = queue.poll();
            System.out.print(node.data + " ");
            // Enqueue the left and right children if they exist
            if (node.left != null) {
              queue.add(node.left);
            }
            if (node.right != null) {
              queue.add(node.right);
            }
        }
        // Print a new line after each level
        System.out.println();
  }
}


  // Method to print the tree in a hierarchical order *without edges*
    public void printTree1() {
        printTree(root, 0);
    }

    // Recursive helper method to print the tree in a hierarchical order
    private void printTree(Node node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        printTree(node.left, level + 1);
    }

   
//    to print tree 
//    like this 
//    5
//   / \
//  1   7 
    public void printTree2() {
        if (root == null) {
            return;
        }
        int maxLevel = maxLevel(root);
        printNode(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNode(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println();
        }

        printNode(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
//        isAllElementsNull and maxLevel for functio printTree2
    private boolean isAllElementsNull(List<?> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

    private int maxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }


    
    
    
////////////////// from array to bst:         is work
    public void sortedArrayTobst(int [] a ){
        
        root = bstTreeFromArray(a, 0, a.length - 1);
    }
    
    private Node bstTreeFromArray(int []a, int left, int right){
        if(left > right)
            return null;
        int mid = left + (right - left)  / 2;
        Node node = new Node(a[mid]);
        node.left = bstTreeFromArray(a, left, mid - 1);
        node.right = bstTreeFromArray(a, mid + 1, right);
        return node;
        
    }
    
    
    //////////////// search tree in bst :  is work
    public boolean search(int key)  { 
        Node root = search_Recursive(get_root(), key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insert function
    private Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.data==key) 
            return root; 
        // val is greater than root's key 
        if (root.data > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 

    
    void deleteKey(int key) { 
        root = delete_Recursive(root, key);
    } 
   
    //recursive delete function
    Node delete_Recursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.data)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.data)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.data = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.data); 
        } 
        return root; 
    } 
    
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.data; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.data; 
            root = root.left; 
        }
        return minval; 
    } 
    
    /////////// inorder function : 
//    left- root- right
    public void inorder(){
        inorderTr(root);
    }
     private void inorderTr(Node node)
    {
        if(node == null)
            return;
//        first recur left node
        inorderTr(node.left);
        System.out.println(node.data + " ");
        inorderTr(node.right);
    }
     
     /////to get max value in tree :
     public int findMaxInTree(Node root) {
        int max = Integer.MIN_VALUE;     //set a default max value
        if (root == null)
            return max;                 //if root is null
        else {
//            get left side max 
            int left_max = findMaxInTree(root.get_left());           
//            get right side max
            int right_max = findMaxInTree(root.get_right());         
            if (left_max > right_max)                               
                max = left_max;                                     
            else
                max=right_max;                                      

            if (root.get_element() > max)                          
                max = root.get_element();                          
        }
        return max;                                                
    }
}