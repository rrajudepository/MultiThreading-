package DSAPractice.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

    public static Node insertNode(Node root, int val){
        Node currNode = new Node(val);
        if(root == null){
           root = currNode;
           return root;
        }else if(root.data>val){
            root.left = insertNode(root.left, val);
        }else{
            root.right = insertNode(root.right, val);
        }
        return root;
        
    }

    public static Node buildBST(List<Integer> value){
        Node root=null;
        for(int val : value){
            root = insertNode(root, val); 
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            if(currNode==null){
                if(q.isEmpty()) break;
                q.add(null);
                System.out.println();
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
        }
    }

     /*
       ✅ When deleting a BST node with 2 children

      We must replace it with a node that maintains BST rules:

       Left subtree < root < Right subtree


       For a node with both left & right children, there are two valid choices:

       1. Leftmost of right subtree (Inorder Successor)

        Smallest value greater than the deleted node.

        2. Rightmost of left subtree (Inorder Predecessor)

    Largest value smaller than the deleted node.

     Both choices keep BST property valid.

     ⭐ So why do most books/tutorials use “leftmost of right subtree”?

    Because it's:

     simpler to explain

      easier to code

     cleaner to remove (successor node always has at most one child)

         consistent with inorder traversal logic
     */

    public static Node inorderSuccessorNode(Node root){
        if(root.left == null && root.right==null) return root;
        return inorderSuccessorNode(root.left);

    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            System.out.println("Node "+ val+ " isn't available in BST");
            return null;
        }
        if(root.data>val){
            root.left = deleteNode(root.left, val);
        }else if(root.data<val){
            root.right = deleteNode(root.right, val);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                Node successor = inorderSuccessorNode(root.right);
                root.data = successor.data;
                root.right = deleteNode(root.right, successor.data);
            } 

        }
        return root;
    }

    public static int maxHeight(Node root){
        if(root==null) return 0;
        int leftHeight= maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int findDiameter(Node root){
        if(root == null) return 0;
        int leftHeight=maxHeight(root.left);
        int rightHeight=maxHeight(root.right);
        int leftDiameter = findDiameter(root.left);
        int  rightDiameter = findDiameter(root.right);
        int rootDiameter = 1 + leftHeight + rightHeight;
        return Math.max(rootDiameter, Math.max(rightDiameter, leftDiameter));
    }

    public static int sumNodes(Node root){
        if(root == null) return 0;
        return root.data+ sumNodes(root.left)+sumNodes(root.right);
    }

    public static int noOfNodes(Node root){
        if(root == null) return 0;
        return 1+noOfNodes(root.left)+noOfNodes(root.right);
    }



    public static void main(String[] args) {
        List<Integer> value = new ArrayList<>();
        //Collections.addAll(value, 7,6,2,8,1,4,3,5,12,11,10,9);
        Collections.addAll(value, 9,4,13,2,1,3,7,6,8,5,14,11,10,12,15,16,20,18,17,19);

        System.out.println("Building BST");
        Node root = buildBST(value);

        System.out.println("Inorder traversal is: ");
        inorder(root);
        System.out.println("\n_______________________________________");
        System.out.println("Level Order traversal: ");
        levelOrder(root);
        
        /* 
        System.out.println("\n_______________________________________");
        System.out.println("Level Order traversal after deleting node 4: ");
        deleteNode(root, 4);
        levelOrder(root);
        */

        System.out.println("\n____________________________________");
        System.out.println("Max height of BST: "+ maxHeight(root));

        System.out.println("_______________________________________");
        System.out.println("Diameter of BST is: "+ findDiameter(root));

        System.out.println("\n_____________________________________");
        System.out.println("Sum of all nodes: "+ sumNodes(root));
        System.out.println("\n_______________________________________");
        System.out.println("Number of nodes: "+ noOfNodes(root));




    }
}
