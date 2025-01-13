import java.util.*;

class Node{
    //Each node has data
    //Each node has a left and right now associated with it
    int data;
    Node left, right;

    Node(int d){
        data = d;
        left = null; //Left and right nodes start with nothing in them
        right = null;
    }


}



public class binaryTree {


    //This will traverse left -> root -> right
    public static void inOrderDFS(Node node){
        if(node == null){
            return; //Check if node has data. If not, you're at end of branch
        }
        //However, since were doing Depth First, We must go all way down the left branch before we print data
        inOrderDFS(node.left);
        System.out.println(node.data);
        inOrderDFS(node.right);

    }


    //Root -> Left -> Right
    public static void preOrderDFS(Node node){

        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderDFS(node.left);
        preOrderDFS(node.right);

    }
    //Prints all on the same level first
    public static void levelOrderDFS(Node root){

        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll(); //Pulls head of queue out and saves as variable
            System.out.print(node.data + " ");
            // Now you must check if this node has any children

            if(node.left != null){
                queue.add(node.left); //Add that to the queue
            }
            if(node.right != null){
                queue.add(node.right); 
            }



            // Now that we have added the children to the queue, the process repeats for both of those nodes

        }

    }

    
    public static boolean BFSsearch(Node root, int value){
        //First check if root is the value
        if(root == null){
            return false;
        }

        if(root.data == value){ 
            return true;
        }
            boolean leftSide = BFSsearch(root.left, value);
            boolean rightSide = BFSsearch(root.right, value);

        if(rightSide || leftSide == true){
            return true;
        } else {
            return false;
        }


        
    }



    public static Node insert(Node root, int key){
        //If root node is null, the node we are inserting is the root node
        if(root == null){
            return new Node(key);
        }
        //Now I need to check if the new node has a left and right child
        //If it doesn't, add a new Node

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.left == null){
                temp.left = new Node(key);
                break;
            } else {
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(key);
                break;
            } else {
                q.add(temp.right);
            }
            

        }
        return root;

    }


    public static void main(String[] args) {

        

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        //node3.right = new Node(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;




        System.out.println("In Order Depth First Search");
        inOrderDFS(node1);
        System.out.println("Pre-Order Depth First Search");
        preOrderDFS(node1);
        System.out.println("Level-Order Traversal");
        levelOrderDFS(node1);
        System.out.println("\nInserting a node");
        insert(node1, 6);
        levelOrderDFS(node1);
        System.out.println("\nSearching for a 8");
        System.out.println(BFSsearch(node1, 8));
        System.out.println("Searching for a 6");
        System.out.println(BFSsearch(node1, 6));
        BFSsearch(node1, 6);



    }
    
}
