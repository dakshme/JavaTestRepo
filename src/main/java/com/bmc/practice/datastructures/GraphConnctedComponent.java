package com.bmc.practice.datastructures;

public class GraphConnctedComponent {

	void connectedComponents(Graph g) { 
        // Mark all the vertices as not visited 
        boolean[] visited = new boolean[g.V]; 
        for(int v = 0; v < g.V; ++v) { 
            if(!visited[v]) { 
                // print all reachable vertices from v 
                g.dfsTraverse(v,visited); 
                System.out.println(); 
            } 
        } 
    } 
	
	public static void main(String[] args) {
		
		//create a graph
		 Graph g = new Graph(5); // 5 vertices numbered from 0 to 4  
		 
		 GraphConnctedComponent cg = new GraphConnctedComponent();
         
	        g.addUndirectedEdge(1, 0);  
	        g.addUndirectedEdge(2, 3);
	 //       g.addEdge(2, 4);
	  //      g.addEdge(1, 3);
	        g.addUndirectedEdge(3, 4);
	        
	        System.out.println("Following are connected components"); 
	        cg.connectedComponents(g); 

	}

}
