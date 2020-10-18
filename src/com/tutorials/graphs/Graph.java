package com.tutorials.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be nonnegative");			
		}
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	/**
	 * Initializes a new graph that is a deep copy of <tt>G</tt>.
	 * 
	 * @param G the graph to copy
	 */
	public Graph(Graph G) {
		this(G.V());
		this.E = G.E();
		for (int v = 0; v < G.V(); v++) {
			// reverse so that adjacency list is in same order as original
			LinkedList<Integer> reverse = new LinkedList<Integer>();
			for (int w : G.adj[v]) {
				reverse.add(w);
			}
			for (int w : reverse) {
				adj[v].add(w);
			}
		}
	}

	/**
	 * Returns the number of vertices in the graph.
	 * 
	 * @return the number of vertices in the graph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in the graph.
	 * 
	 * @return the number of edges in the graph
	 */
	public int E() {
		return E;
	}

	/**
	 * Adds the undirected edge v-w to the graph.
	 * 
	 * @param v one vertex in the edge
	 * @param w the other vertex in the edge
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w
	 *                                             < V
	 */
	public void addEdge(int v, int w) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException();
		if (w < 0 || w >= V)
			throw new IndexOutOfBoundsException();
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * Returns the vertices adjacent to vertex <tt>v</tt>.
	 * 
	 * @return the vertices adjacent to vertex <tt>v</tt> as an Iterable
	 * @param v the vertex
	 * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Iterable<Integer> adj(int v) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException();
		return adj[v];
	}

	/**
	 * Returns a string representation of the graph. This method takes time
	 * proportional to <em>E</em> + <em>V</em>.
	 * 
	 * @return the number of vertices <em>V</em>, followed by the number of edges
	 *         <em>E</em>, followed by the <em>V</em> adjacency lists
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	/**
	 * Unit tests the <tt>Graph</tt> data type.
	 */
	public static void main(String[] args) {

		Graph G = new Graph(13);
		G.addEdge(0, 5);
		G.addEdge(4, 3);
		G.addEdge(0, 1);
		G.addEdge(9, 12);
		G.addEdge(6, 4);
		G.addEdge(5, 4);
		G.addEdge(0, 2);
		G.addEdge(9, 10);
		G.addEdge(11, 12);
		G.addEdge(0, 6);
		G.addEdge(7, 8);
		G.addEdge(9, 11);
		G.addEdge(5, 3);
		Graph newGraph = new Graph(G);
		System.out.println(G.toString());
		System.out.println(newGraph.toString());
		// StdOut.println(G);
	}

}
