package DSAPractice.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
     static int idx=-1;

     public static Node BuildTree(List<Integer> preorder){
        idx++;
        if(idx>=preorder.size() || preorder.get(idx)==-1){
            return null;
        }
        Node root = new Node(preorder.get(idx));
        root.left = BuildTree(preorder);
        root.right = BuildTree(preorder);

        return root;
     }

     public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
     }
     

     public static void helper(Node root, List<Integer> preorder){
        if(root == null) return;
        preorder.add(root.data);
        helper(root.left, preorder);
        helper(root.right, preorder);
        return; 
     }
    public static List<Integer> preorderTraversal(Node root){
        List<Integer> preorder = new ArrayList<>();
        helper(root, preorder);
        return preorder;
    }



     public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
     }

     public static void postorder(Node root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
     }
    

     public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null){
                if(q.isEmpty()) break;
                q.add(null);
                System.out.println();
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

        }
     }

     public static List<List<Integer>> levelWiseTraversal(Node root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null){
                if(q.isEmpty()) break;
                levelOrder.add(level);
                level = new ArrayList<>();
                q.add(null);
            }else{
                level.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }
        }
        levelOrder.add(level);
        return levelOrder;
     }

     
    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        Collections.addAll(preorder, 1,2,4,-1,-1,5,-1,-1,3,7,-1,8,-1,-1,
        6,9,-1,-1,10,11,-1,12,-1);

        System.out.println("Building Binary Tree: ");
        Node root = BuildTree(preorder);
        System.out.println("\n__________________________________________");

        List<Integer> preOrder = new ArrayList<>();
        preOrder = preorderTraversal(root);
        System.out.println("Preorder traversal: ");
        for(int val : preOrder){
            System.out.print(val+" ");
        }

        System.out.println("\n_____________________________________________");

        System.out.println("Level wise traversal: ");
        List<List<Integer>> levelwise = new ArrayList<>();
        levelwise = levelWiseTraversal(root);

        for(List<Integer> level: levelwise){
           System.out.println(level);
           /*for(int val : level){
            System.out.print(val+" ");
           }*/
           System.out.println();
        }
        System.out.println("\n________________________________________________");


        /*
        System.out.println("Inorder Traversal: ");
        inorder(root);
        System.out.println("\n__________________________________________");
        System.out.println("Preorder Traversal: ");
        preorder(root);
        System.out.println("\n___________________________________________");
        System.out.println("Postorder Traversal: ");
        postorder(root);
        System.out.println("\n_____________________________________________");
        System.out.println("Level order traversal: ");
        levelOrderTraversal(root);
        System.out.println("\n_______________________________________________");
        */

    }
}
