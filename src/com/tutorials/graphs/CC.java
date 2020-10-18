package com.tutorials.graphs;

public class CC {

	private boolean[] marked; // marked[v] = has vertex v been marked?
	private int[] id; // id[v] = id of connected component containing v
	private int[] size; // size[id] = number of vertices in given component
	private int count; // number of connected components

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	// depth-first search
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public int id(int v) {
		return id[v];
	}

	public int size(int v) {
		return size[id[v]];
	}

	public int count() {
		return count;
	}

	public boolean areConnected(int v, int w) {
		return id(v) == id(w);
	}

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
		CC cc = new CC(G);

		// number of connected components
		int M = cc.count();
		System.out.println(M + " components");

		// compute list of vertices in each connected component
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
		for (int i = 0; i < M; i++) {
			components[i] = new Queue<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].enqueue(v);
		}

		// print results
		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
