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
		if (validVertex(v)==true && validVertex(w)==true) {
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
	private boolean validVertex(int v){// this function makes sure that a given vertex is possible 
        if (v < 0 || v >= V) {
        	return false;
        }
        else {
        	return true;
        }
	}
	public int indegree(int v){
		if(validVertex(v)==false){
			return -1;
		}
		else{
			return indegree[v];
		}
	}
	
	public int outdegree(int v){
		if(validVertex(v)==false){
			return -1;
		}
		else{
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
	public int LCA(int v, int w) {
		return v;
	}
}
