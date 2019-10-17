package assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {

	private int V;
	private int E;
	private ArrayList<Integer>[] adj;
	private int[]indegree; // gives the indegree of a vertex
	private int[] outdegree; // gives outdegree
	private boolean hasCycle; //Returns true if there is a cycle in the graph
	private boolean marked[];
	private boolean stack[];
	
	public DAG(int V) {
		if(V>=0) {
			this.V = V;
			this.E = 0;
			indegree = new int[V];
			marked = new boolean[V];
		    stack = new boolean[V];
			adj = (ArrayList<Integer>[]) new ArrayList[V];

		    for (int v = 0; v < V; v++) {

		        adj[v] = new ArrayList<Integer>();

		    }              
		}
		else {
			System.out.println("Number of vertices must be a positive number");
		}			
	}
	
	public void addEdge(int v, int w) {
		if (validateVertex(v)==true && validateVertex(w)==true) {
			adj[v].add(w);
			indegree[w]++;
			E++;
		}
		else {
			System.out.println("Please input valid vertex.");
		}
	}
	
	public boolean isEmpty() {
		return false;
	}
	public int size() {
		return 0;
	}
	public int V() {
		return this.E;
	}
	public int E() {
		return this.V;
	}
	public boolean hasCycle() {
		return hasCycle;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
		//finds vertics that are adjacent
	}
	
	private boolean validateVertex(int v) { // this function makes sure that a given vertex is possible 
		 if (v < 0 || v >= V) {
	        	return false;
		 }
	        else {

	        	return true;
	        }
	}
	
	public int indegree(int v) {
		if(validateVertex(v)==false) {
			return -1;
		}
		else {
			return indegree[v];
		}
	}
	
	public int outdegree(int v) {
		if(validateVertex(v)==true) {
			return -1;
		}
		else {
			return adj[v].size();
		}
	}
	
	public void findCycle(int v) {
        marked[v] = true;
        stack[v] = true;
        for (int w : adj(v)) {
            if(!marked[w]) {

                findCycle(w);

            } else if (stack[w]) {

                hasCycle = true;
                return;
            }
        }
        stack[v] = false;		
	}
	
	public DAG reverse() { // returns DAG in reverse order
		DAG reverse = new DAG(V);
		for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v); 
            }
        }
        return reverse;		
	}
	
	public int LCA(int v, int w) {
		findCycle(0);
		
		if(hasCycle) {
			return -1; 
		}
		
		DAG reverse = reverse();

		ArrayList<Integer> pathofV = reverse.BFS(v);
		ArrayList<Integer> pathofW = reverse.BFS(w);
		ArrayList<Integer> mutuals = new ArrayList<Integer>();
		boolean found = false;
		for(int i = 0; i<pathofV.size(); i++){

			for(int j = 0; j<pathofW.size(); j++){
				if(pathofV.get(i)==pathofW.get(j)) {
					mutuals.add(pathofV.get(i));
					found=true;
				}
			}
		}
		if(found) {
			
			return mutuals.get(0);
		}
		else {
			return -1;
		}
	}
	
	public ArrayList<Integer> BFS(int x) { // got this code from algorithms & data structures from last year
		boolean visited[] = new boolean[V];
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    ArrayList<Integer> order= new ArrayList<Integer>();
	    visited[x]=true;
	    queue.add(x);
	    while (queue.size() != 0) {
            x = queue.poll();           
            order.add(x);
            Iterator<Integer> i = adj[x].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return order;
	}
}
