package com.bmc.practice.datastructures;

import java.util.LinkedList;
import java.util.Stack;

import com.bmc.practice.datastructures.LinkList.Node;

public class BST {
	
	BNode root = null;
	
	Node llRoot = null; // this LL root node is just for link list to bst conversion method

	class BNode {

		int data;
		BNode leftChild;
		BNode rightChild;

		//constructor
		public BNode (int data) {

			this.data = data;
			this.leftChild = null;
			this.rightChild = null;			
		}
	}

	public BNode addNodeToBST( BNode rootNode, int data ) {
		
		//if tree empty or end of particular branch has arrived then return the node
		if (null == rootNode) {
			BNode newNode = new BNode(data); //create new node
			
			if (this.root == null) //if root not yet populated
				this.root = newNode;
			
			rootNode = newNode; //assign root node
		}
		else {
			
			/* Otherwise, recur down the tree */
	        if (data < rootNode.data) 
	        	rootNode.leftChild = addNodeToBST(rootNode.leftChild, data); 
	        else if (data > rootNode.data) 
	        	rootNode.rightChild = addNodeToBST(rootNode.rightChild, data); 
		}
		return rootNode; //return traversed node.
	}
	
	/* This function counts the number of nodes in Linked List 
    and then calls sortedListToBSTRecur() to construct BST */
	 BNode sortedListToBST(LinkList list) 
	 {
	     /*Count the number of nodes in Linked List */
	     int n = list.countNodes(list.root);
	     this.llRoot = list.root;
	     /* Construct BST now recursively */
	     return sortedListToBSTRecur(n); 
	 } 
	
	 /* The main function that constructs balanced BST and returns root of it. 
	    n  --> No. of node in Linked List */
	 BNode sortedListToBSTRecur(int n)  
	 { 
	     /* Base Case to terminate */
	     if (n <= 0)  
	         return null; 
	
	     /* Recursively construct the left subtree */
	     BNode left = sortedListToBSTRecur(n / 2); 
	
	     /* head_ref now refers to middle node, make middle node as root of BST*/
	     BNode root = new BNode(this.llRoot.data); 
	
	     // Set pointer to left subtree 
	     root.leftChild = left; 
	
	     /* Change head pointer of Linked List for parent recursive calls */
	     this.llRoot = this.llRoot.next;  //move to next node
	
	     /* Recursively construct the right subtree and link it with root. The number of nodes in right subtree  is  
	        total nodes - nodes in left subtree - 1 (for root) */
	     root.rightChild = sortedListToBSTRecur(n - n / 2 - 1); 
	
	     return root; 
	 } 
	
	
	 // A utility function to do in-order traversal of BST , also increasing order
    void inorderTraversalRec(BNode root) { 

        if (root != null) { 
        	inorderTraversalRec(root.leftChild); 
            System.out.print(root.data+" "); 
            inorderTraversalRec(root.rightChild); 
        }
    }
    
	 // A utility function to do in-order traversal of BST 
    void preorderTraversalRec(BNode root) { 

        if (root != null) { 
        	System.out.print(root.data+" ");
        	preorderTraversalRec(root.leftChild);  
        	preorderTraversalRec(root.rightChild); 
        } 
    }
    
    // A utility function to do in-order traversal of BST 
    void postorderTraversalRec(BNode root) { 

        if (root != null) { 

        	postorderTraversalRec(root.leftChild);  
        	postorderTraversalRec(root.rightChild); 
            System.out.print(root.data+" ");
        } 
    }
    
    int heightOfBST(BNode root ) {
    	
    	int h;
    	if (null == root) 
    		return 0;
    	
    	int left = heightOfBST(root.leftChild);
    	int right = heightOfBST(root.rightChild);
    	
    	if (left < right)
    		h = 1 + left;
    	else
    		h = 1 + right;    	
    	
    	return h;
    }
    
    int sizeOfBst(BNode node) 
    { 
        if (node == null) 
            return 0; 
        else
            return(sizeOfBst(node.leftChild) + 1 + sizeOfBst(node.rightChild)); 
    } 

    //bfs makes use of queue
    /*Algo
     * enqueue root
     * while queue not empty
     * dequeue and print node
     * enqueue left child
     * enqueue right child 
     */
    void bfsTraversal () {
    	
    	// Create a queue for BFS which can hold BST nodes
        LinkedList<BNode> queue = new LinkedList<>();
        BNode root = this.root;
        
        //base condition
        if (root == null)
        	return;
        
        queue.add(root); //first enqueue
        
        //now while Q not empty
        while(!queue.isEmpty()) {
        	
        	//dequeue and print
        	root = queue.poll(); // this will keep giving us updated position down the BST
        	System.out.print(root.data+" ");
        	
        	//visit left and right child at the same time
        	if (null != root.leftChild)
        		queue.add(root.leftChild);
        	
        	if (null != root.rightChild)
        		queue.add(root.rightChild);       	
        }
    }
    
    //DFS also pre order traversal of BST
    /*algo:
     * For each node:
     *  print node
     *  visit left
     *  visit right
     */
    void dfsTraversal () {
    	
    	preorderTraversalRec(this.root);
    	
    }
    
    //iterative method of pre-order traversal
    void iterativePreorder() { 
        
        // Base Case 
        if (root == null) { 
            return; 
        } 
  
        // Create an empty stack and push root to it 
        Stack<BNode> nodeStack = new Stack<>(); 
        nodeStack.push(root); 
  
        /* Pop all items one by one. Do following for every popped item 
         a) print it 
         b) push its right child 
         c) push its left child 
         Note that right child is pushed first so that left is processed first */
        while (!nodeStack.empty()) {  //while stack is NOT empty
              
            // Pop the top item from stack and print it 
            BNode mynode = nodeStack.pop(); 
            System.out.print(mynode.data + " ");  
  
            // Push right and left children of the popped node to stack 
            if (mynode.rightChild != null) { 
                nodeStack.push(mynode.rightChild); 
            } 
            if (mynode.leftChild != null) { 
                nodeStack.push(mynode.leftChild); 
            } 
        } 
    } 
	
	public static void main(String[] args) {
		
		BST bst = new BST(); 
		  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80
         				\
         				 90 */
		bst.addNodeToBST(bst.root, 50); //pass the root node as well
        bst.addNodeToBST(bst.root, 30); 
        bst.addNodeToBST(bst.root, 20); 
        bst.addNodeToBST(bst.root, 40); 
        bst.addNodeToBST(bst.root, 70); 
        bst.addNodeToBST(bst.root, 60); 
        bst.addNodeToBST(bst.root, 80);
        bst.addNodeToBST(bst.root, 90);
  
        // print all traversal of the BST 
        System.out.println("BST Inorder ");
        bst.inorderTraversalRec(bst.root); //also increasing order
        System.out.println(" ");
        System.out.println("BST Pre order ");
        bst.preorderTraversalRec(bst.root);
        System.out.println(" ");
        System.out.println("BST Post order ");
        bst.postorderTraversalRec(bst.root);
        
        //get the height of BST
        System.out.println("\nHeight of this BST is "+bst.heightOfBST(bst.root));
        //size of bst
        System.out.println("\nSize of this BST is "+bst.sizeOfBst(bst.root)); 
        
        //print dfs traversal, same as pre order
        System.out.println("DFS traversal: ");
        bst.dfsTraversal();  //50 30 20 40 70 60 80 90
        
        //print bfs traversal, with queue logic
        System.out.println("\nBFS traversal:");
        bst.bfsTraversal();  //50 30 70 20 40 60 80 90 
        
        //pre order traversal itarative
        System.out.println("\n DFS/ pre order traversal iterative:");
        bst.iterativePreorder();
        
        
        //convert sorted linked list to BST
        LinkList llist = new LinkList(); //create LL using link list class in this package only
        /* Let us create a sorted linked list = 7->6->5->4->3->2->1 */
		llist.addNode(7); 
		llist.addNode(6); 
		llist.addNode(5); 
		llist.addNode(4); 
		llist.addNode(3); 
		llist.addNode(2); 
		llist.addNode(1); 
		System.out.println("\n\nGiven Linked List "); 
		llist.printList();
		BNode newBstToot = bst.sortedListToBST(llist);  /* Convert List to BST */ 
		System.out.println("Pre-Order Traversal of constructed BST "); 
		bst.inorderTraversalRec(newBstToot);     

	}

}
