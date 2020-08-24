package graphs_algorithm;

import java.util.LinkedList;

public class test {

	public static void main(String[] args) {
		graph g = new graph();
		GNode v1 = new GNode(4);
		GNode v2 = new GNode(3);
		GNode v3 = new GNode(1);
		GNode v4 = new GNode(2);
		GNode v5 = new GNode(7);
		GNode v6 = new GNode(6);
		GNode v7 = new GNode(1);
		GNode v8 = new GNode(5);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
		g.addVertex(v8);
		g.addEdge(v1, v2);
		g.addEdge(v2, v1);
		g.addEdge(v1, v3);
		g.addEdge(v3, v1);
		g.addEdge(v2, v4);
		g.addEdge(v4, v2);
		g.addEdge(v3, v4);
		g.addEdge(v4, v3);
		g.addEdge(v3, v5);
		g.addEdge(v5, v3);
		g.addEdge(v4, v5);
		g.addEdge(v5, v4);
		g.addEdge(v4, v6);
		g.addEdge(v6, v4);
		g.addEdge(v5, v6);
		g.addEdge(v6, v5);
		g.addEdge(v6, v7);
		g.addEdge(v7, v6);
		g.addEdge(v6, v8);
		g.addEdge(v8, v6);
		g.addEdge(v7, v8);
		g.addEdge(v8, v7);
//		System.out.println(g.hasPathDFS(v1, v2));
//		System.out.println(g.hasPathDFS(v1, v3));
//		System.out.println(g.hasPathDFS(v1, v5));
//		System.out.println(g.hasPathDFS(v6, v4));
//		System.out.println(g.hasPathBFS(v1, v2));
//		System.out.println(g.hasPathBFS(v1, v3));
//		System.out.println(g.hasPathBFS(v1, v5));
//		System.out.println(g.hasPathBFS(v6, v4));
		
		g.Dijkstra(v1);
		
		LinkedList<GNode> v = new LinkedList<GNode>();
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		v.add(v5);
		v.add(v6);
		v.add(v7);
		v.add(v8);
		for (GNode i : v) {
				System.out.println("the ver: "+ i.getId()+"is: "+i.dijkstraDis);
			}			


	}

}
