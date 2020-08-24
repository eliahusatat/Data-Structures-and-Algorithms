package graphs_algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * this class represent a graph vertex 
 * with id , list of all the other vertexes he have edge to (adjacent)
 * and those edge weight(weight)
 * @author Eliahu Satat
 */

public class GNode implements Comparator<GNode>{
	private int id;
	private LinkedList <GNode> adjacent;
    int dijkstraDis;
    int cost ;
	HashMap <GNode ,Integer> weight;
	
	
	/**
	 * constructor
	 */
	public GNode() {
		this.cost = 1;
		this.id = 0;
		adjacent = new LinkedList <GNode>();
		weight = new HashMap<GNode ,Integer>();
		dijkstraDis = Integer.MAX_VALUE;
	}
	
	public GNode(int cost) {
		this.cost = cost;
		this.id = 0;
		adjacent = new LinkedList <GNode>();
		weight = new HashMap<GNode ,Integer>();
		dijkstraDis = Integer.MAX_VALUE;
	}
	
	/**
	 * getters and setters
	 */
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		 this.id = id;
	}
	public LinkedList <GNode> getAdjacent() {
		return this.adjacent;
	}
	
	/**
	 * this function add edge form this vertex to anther vertex
	 * @param node - the vertex to connect
	 * @param w the weight of the new edge
	 */
	public void addAdj(GNode node, int w) {
		adjacent.add(node);
		weight.put(node, w);
	}

	@Override
	public int compare(GNode n1, GNode n2) {
		if(n1.dijkstraDis < n2.dijkstraDis)
			return -1;
		if(n1.dijkstraDis > n2.dijkstraDis)
			return 1;
		return 0;
	}

}
