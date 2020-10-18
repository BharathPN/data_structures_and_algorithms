package com.tutorials.graphs;

import java.util.Stack;

public class BreadthFirstPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges shortest s-v path

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);

		assert check(G, s);
	}

	public BreadthFirstPaths(Graph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		bfs(G, sources);
	}

	// breadth-first search from a single source
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		distTo[s] = 0;
		marked[s] = true;
		q.enqueue(s);

		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}

	// breadth-first search from multiple sources
	private void bfs(Graph G, Iterable<Integer> sources) {
		Queue<Integer> q = new Queue<Integer>();
		for (int s : sources) {
			marked[s] = true;
			distTo[s] = 0;
			q.enqueue(s);
		}
		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public int distTo(int v) {
		return distTo[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}

	// check optimality conditions for single source
	private boolean check(Graph G, int s) {

		// check that the distance of s = 0
		if (distTo[s] != 0) {
			System.out.println("distance of source " + s + " to itself = " + distTo[s]);
			return false;
		}

		// check that for each edge v-w dist[w] <= dist[v] + 1
		// provided v is reachable from s
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (hasPathTo(v) != hasPathTo(w)) {
					System.out.println("edge " + v + "-" + w);
					System.out.println("hasPathTo(" + v + ") = " + hasPathTo(v));
					System.out.println("hasPathTo(" + w + ") = " + hasPathTo(w));
					return false;
				}
				if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
					System.out.println("edge " + v + "-" + w);
					System.out.println("distTo[" + v + "] = " + distTo[v]);
					System.out.println("distTo[" + w + "] = " + distTo[w]);
					return false;
				}
			}
		}

		// check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
		// provided v is reachable from s
		for (int w = 0; w < G.V(); w++) {
			if (!hasPathTo(w) || w == s)
				continue;
			int v = edgeTo[w];
			if (distTo[w] != distTo[v] + 1) {
				System.out.println("shortest path edge " + v + "-" + w);
				System.out.println("distTo[" + v + "] = " + distTo[v]);
				System.out.println("distTo[" + w + "] = " + distTo[w]);
				return false;
			}
		}

		return true;
	}

	/**
	 * Unit tests the <tt>BreadthFirstPaths</tt> data type.
	 */
	public static void main(String[] args) {

		Graph G = new Graph(6);
		G.addEdge(0, 5);
		G.addEdge(2, 4);
		G.addEdge(2, 3);
		G.addEdge(1, 2);
		G.addEdge(0, 1);
		G.addEdge(3, 4);
		G.addEdge(3, 5);
		G.addEdge(0, 2);
		// StdOut.println(G);

		int s = 0;
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);

		for (int v = 0; v < G.V(); v++) {
			if (bfs.hasPathTo(v)) {
				System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
				for (int x : bfs.pathTo(v)) {
					if (x == s)
						System.out.print("-" + x);
					else
						System.out.print("-" + x);
				}
				System.out.println();
			}

			else {
				System.out.printf("%d to %d (-):  not connected\n", s, v);
			}

		}
	}

}
