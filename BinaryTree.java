
class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
class BinaryTree
{ 
    Node root; 
    
    void printkdistanceNodeDown(Node node, int m)  
    { 
        
        if (node == null || m < 0) 
            return; 
   
        if (m == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
   
        
        printkdistanceNodeDown(node.left, m - 1); 
        printkdistanceNodeDown(node.right, m - 1); 
    } 
   
    int printkdistanceNode(Node node, Node target, int m)  
    { 
        if (node == null) 
            return -1; 
   
        if (node == target)  
        { 
            printkdistanceNodeDown(node, m); 
            return 0; 
        } 
   
        int dleft = printkdistanceNode(node.left, target, m); 
   
        if (dleft != -1)  
        { 
               
            if (dleft + 1 == m)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            } 
            else
                printkdistanceNodeDown(node.right, m - dleft - 2); 
   
			return 1 + dleft; 
        } 
        int dright = printkdistanceNode(node.right, target, m); 
        if (dright != -1)  
        { 
            if (dright + 1 == m)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                printkdistanceNodeDown(node.left, m - dright - 2); 
            return 1 + dright; 
        } 
   
        return -1; 
    } 
   
    public static void main(String args[])  
    { 
        BinaryTree tree = new BinaryTree(); 
   
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        Node target = tree.root.left.right; 
        tree.printkdistanceNode(tree.root, target, 2); 
    } 
}