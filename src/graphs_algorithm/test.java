package graphs_algorithm;

import java.util.LinkedList;

public class test {

	public static void main(String[] args) {
		graph g = new graph();
		GNode v1 = new GNode();
		GNode v2 = new GNode();
		GNode v3 = new GNode();
		GNode v4 = new GNode();
		GNode v5 = new GNode();
		GNode v6 = new GNode();
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addEdge(v1, v2);
		g.addEdge(v1, v3);
		g.addEdge(v2, v5);
		g.addEdge(v6, v4);
		System.out.println(g.hasPathDFS(v1, v2));
		System.out.println(g.hasPathDFS(v1, v3));
		System.out.println(g.hasPathDFS(v1, v5));
		System.out.println(g.hasPathDFS(v6, v4));
		System.out.println(g.hasPathBFS(v1, v2));
		System.out.println(g.hasPathBFS(v1, v3));
		System.out.println(g.hasPathBFS(v1, v5));
		System.out.println(g.hasPathBFS(v6, v4));
		
		
		
		LinkedList<GNode> v = new LinkedList<GNode>();
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		v.add(v5);
		v.add(v6);
		for (GNode i : v) {
			for (GNode j : v) {
				if(g.hasPathBFS(i, j) != g.hasPathDFS(i, j)) {
					System.out.println("problem! with" +i.getId()+","+j.getId());
				}
				
			}			
		}

	}

}
