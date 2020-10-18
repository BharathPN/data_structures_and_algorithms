package com.tutorials.graphs;

import java.util.Stack;

public class DepthFirstPaths {

	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s; // source vertex

	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	public static void main(String[] args) {

		Graph G = new Graph(8);
		G.addEdge(0, 5);
		G.addEdge(2, 4);
		G.addEdge(2, 3);
		G.addEdge(1, 2);
		G.addEdge(0, 1);
		G.addEdge(3, 4);
		G.addEdge(3, 5);
		G.addEdge(0, 2);
		G.addEdge(6, 7);
		DepthFirstPaths dfs = new DepthFirstPaths(G, 0);

		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				System.out.printf("%d to %d:  ", 0, v);
				for (int x : dfs.pathTo(v)) {
					if (x == 0)
						System.out.print("-" + x);
					else
						System.out.print("-" + x);
				}
				System.out.println();
			}

			else {
				System.out.printf("%d to %d:  not connected\n", 0, v);
			}

		}
	}

}
