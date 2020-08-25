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

	
	/**
	 * this function find all the minimum distance of all the 
	 * vertexes from the source vertex - by Dijkstra algorithm and store if in 
	 * the "dijkstraDis" variable
	 * @param source - the source vertex for Dijkstra
	 * @note this Dijkstra implements is with weight on the vertex not on the edge
	 */
	public void Dijkstra(GNode source){
		int edgeDistance = -1;
		int newDistance = -1;
		this.BFSInitDijkstra(source); // init all the vertex distance to be finite
		Set<Integer> visited = new HashSet<Integer>();
		PriorityQueue<GNode> pq = new PriorityQueue<GNode>(this.numV,new GNode());
		source.dijkstraDis = 0 ; // the dis of the source is 0
		pq.add(source);
		while(visited.size() != this.numV) { // while we didn't visited in everyone
			GNode u = pq.remove(); // gets the minimum distance vertex 
			visited.add(u.getId());
			edgeDistance = -1;
			newDistance = -1;
			for (GNode v : u.getAdjacent()) { // and check if he can decrease the distance of all his neighbors 
				if(!visited.contains(v.getId())) {
					edgeDistance = v.cost;
					newDistance = u.dijkstraDis + edgeDistance;
					if(newDistance < v.dijkstraDis) { //If the distance through it is smaller than the existing distance
						v.dijkstraDis = newDistance;
						v.dijkstraFather = u;
						pq.add(v);
					}
				}
			}
		}
		
	}


	/**
	 * this function initial all the vertexes in the graph
	 * for Dijkstra algorithm - by BFS algorithm 
	 * @param source - the node BFS start 
	 */
	public void BFSInitDijkstra(GNode source) {
		LinkedList<GNode> nextToVisit = new LinkedList<GNode>();
		HashSet<Integer> visited = new HashSet <Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			GNode node = nextToVisit.remove(); // get the next vertex to check 
			if(visited.contains(node.getId())) continue; // if we already been in this vertex don't do anything
			visited.add(node.getId());
			node.dijkstraDis = Integer.MAX_VALUE;
			node.dijkstraFather = null;
			//System.out.println("init node num: " + node.getId());
			for (GNode n: node.getAdjacent()) { // put all his adjacent to search
				nextToVisit.add(n);
			}
		}

	}






}
