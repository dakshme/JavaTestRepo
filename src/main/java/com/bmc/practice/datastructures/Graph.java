package com.bmc.practice.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	// A user define class to represent a graph. 
    // A graph is an array of adjacency lists. 
    // Size of array will be V (number of vertices in graph).
	
    protected int V; 
    protected LinkedList<Integer>[] adjListArray; //protected will be visible across package, array of linkedList
      
    // constructor 
    Graph(int V) {
    	
        this.V = V; 
        // define the size of array as number of vertices 
        adjListArray = new LinkedList[V]; 
  
        // Create a new list for each vertex such that adjacent nodes can be stored 
        for(int i = 0; i < V ; i++){ 
            adjListArray[i] = new LinkedList<Integer>(); 
        } 
    } 
    
    // Adds an edge to an undirected graph 
    void addUndirectedEdge( int src, int dest ) { 
    	
    	if (src >= V || dest >= V) {
    		System.out.println("This edge not added as out of range.");
    		return;
    	}
    	
        // Add an edge from src to dest. 
        adjListArray[src].add(dest); 
  
        // Since graph is undirected, add an edge from dest to src also 
        adjListArray[dest].add(src); 
    } 
    
    // Function to add an edge into the graph 
    void addDirectedEdge( int src, int dest ) 
    { 
    	adjListArray[src].add(dest); //only one direction, from src to dest
    } 
    
    //dfs traversal using recursion 
    void dfsTraverse(int v, boolean[] visited) { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
        // Recur for all the vertices adjacent to this vertex 
        for (int x : adjListArray[v]) {
            if(!visited[x])
            	dfsTraverse(x,visited); 
        }
    }
    
    // prints BFS traversal from a given source node s, using iteration
    void bpfTraversal(int s) { 
        // Mark all the vertices as not visited(By default set as false) 
        boolean[] visited = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it  visited and enqueue it 
            Iterator<Integer> i = adjListArray[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            }
        }
    }

	public static void main(String[] args) {
		
		// Create a graph given in the above diagram  
        Graph g = new Graph(5); // 5 vertices numbered from 0 to 4            
        g.addUndirectedEdge(1, 0);  
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(3, 4);
        
        System.out.println("Graph DFS Traversal: ");
        boolean[] visited = new boolean[g.V]; 
        g.dfsTraverse(g.V-1,visited); 
        
        System.out.println("\nFollowing is Breadth First Traversal (starting from vertex 2)"); 
        g.bpfTraversal(2);
	}
}
