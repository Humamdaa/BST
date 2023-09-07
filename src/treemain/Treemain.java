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
public class Treemain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       bstTree t = new bstTree();
       bstTree t1 = new bstTree();
       
       int arr[] = {1,2,3,4,5};
       t1.sortedArrayTobst(arr);

//      *************************      
//       insertino function :
       t.insert(10);
       t.insert(7);
       t.insert(15);
       t.insert(14);
       t.insert(8);
       t.insert(5);
       t.insert(4);
       t.insert(20);
       t.insert(6);
//    algorithms traversal :   
//       print tree by preorder
       t.preoderAlgorithm();
//       print tree by inorder
       t.inoderAlgorithm();
//       print tree by postorder
       t.postorderAlgorithm();

//       t.printTree();
       
//       t.printTree1();  

//       print first tree
//       t.printTree2();

//       print second tree
//       t1.printTree2();

//       *****************************
//       search function :
//       System.out.println(t1.search(2) + ".");       
//       System.out.println(t.search(0));
 

//     ******************************* delete
//     deletion function :
//       t1.deleteKey(1); 
//       t.deleteKey(100);
       
//          print tree after deletion :
//       t1.printTree2();
//       t.printTree2();

//    ******************************** min and max      
//      min val : 
//       System.out.println("-min value in tree:");
//       System.out.println(t1.minValue(t1.get_root()));
//       System.out.println(t.minValue(t.get_root()));
       
//     max val :  
//        System.out.println("-max value in tree:");
//        System.out.println(t1.findMaxInTree(t1.get_root()));
//        System.out.println(t.findMaxInTree(t.get_root()));
    }  
    
//    The binary search tree experiment is finished
    
}


