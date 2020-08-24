package graphs_algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * this class represent a graph with vertex and edges
 * and some graphs algorithm on it 
 * @author Eliahu Satat
 */
public class graph {
	HashMap <Integer ,GNode> vertex;
	private int numV ;


	/**
	 * constructor
	 */
	public graph() {
		vertex = new HashMap<Integer ,GNode>();
		numV = 0;
	}

	public GNode getNode(int id) {
		return vertex.get(id);
	}

	/**
	 * this function add a new edge to this graph from source to destination
	 * with default weight = 1
	 * @param source - the first vertex
	 * @param destination - the second vertex
	 */
	public void addEdge(GNode source , GNode destination) {
		source.addAdj(destination,1);
	}

	/**
	 * this function add a new edge to this graph from source to destination
	 * @param source - the first vertex
	 * @param destination - the second vertex
	 * @param weight - the weight of the new edge
	 */
	public void addEdge(GNode source , GNode destination, int weight) {
		source.addAdj(destination, weight);
	}

	/**
	 * add anther vertex to the graph
	 * @param source - the new vertex
	 */
	public void addVertex(GNode source) {
		this.numV++;
		source.setId(numV);
		this.vertex.put(source.getId(), source);
	}


	/**
	 * this function find if there is a path between two vertex in the graph
	 * using DFS algorithm
	 * @param source : the source vertex
	 * @param destination : destination vertex
	 * @return if there is a path between those two vertexes
	 */
	public boolean hasPathDFS(GNode source , GNode destination) {
		HashSet<Integer> visited = new HashSet <Integer>();
		return hasPathDFS(source,destination,visited);
	}

	private boolean hasPathDFS(GNode source , GNode destination ,HashSet<Integer> visited) {
		if(visited.contains(source.getId())) return false; // if we already visit in this vertex
		visited.add(source.getId());
		if(source == destination) return true; // if we find 
		else {
			for(GNode node : source.getAdjacent()) { // if one for this adjacent has path - he has path
				if(hasPathDFS(node,destination,visited)) return true;
			}
			return false;
		}
	}

	/**
	 * this function find if there is a path between two vertex in the graph
	 * using BFS algorithm
	 * @param source : the source vertex
	 * @param destination : destination vertex
	 * @return if there is a path between those two vertexes
	 */
	public boolean hasPathBFS(GNode source , GNode destination) {
		LinkedList<GNode> nextToVisit = new LinkedList<GNode>();
		HashSet<Integer> visited = new HashSet <Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			GNode node = nextToVisit.remove(); // get the next vertex to check 
			if(node == destination) return true;// if we find
			if(visited.contains(node.getId())) continue; // if we already been in this vertex don't do anything
			visited.add(source.getId());
			for (GNode n: node.getAdjacent()) { // put all his adjacent to search
				nextToVisit.add(n);
			}
		}
		return false;

	}

	public void Dijkstra(GNode source){
		int edgeDistance = -1;
		int newDistance = -1;
		//BFSInitDijkstra(source);
		Set<Integer> visited = new HashSet<Integer>();
		PriorityQueue<GNode> pq = new PriorityQueue<GNode>(this.numV,new GNode());
		source.dijkstraDis = 0 ;
		pq.add(source);
		while(visited.size() != this.numV-1) {
			GNode u = pq.remove();
			visited.add(u.getId());
			edgeDistance = -1;
			newDistance = -1;
			for (GNode v : u.getAdjacent()) {
				if(!visited.contains(v.getId())) {
					edgeDistance = v.cost;
					newDistance = u.dijkstraDis + edgeDistance;
					if(newDistance < v.dijkstraDis) {
						v.dijkstraDis = newDistance;
						pq.add(v);
					}
				}
			}
		}
		
	}


	public void BFSInitDijkstra(GNode source ) {
		LinkedList<GNode> nextToVisit = new LinkedList<GNode>();
		HashSet<Integer> visited = new HashSet <Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			GNode node = nextToVisit.remove(); // get the next vertex to check 
			if(visited.contains(node.getId())) continue; // if we already been in this vertex don't do anything
			visited.add(source.getId());
			node.dijkstraDis = Integer.MAX_VALUE;
			for (GNode n: node.getAdjacent()) { // put all his adjacent to search
				nextToVisit.add(n);
			}
		}

	}






}
