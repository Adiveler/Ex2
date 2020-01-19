package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph, Serializable{
	
	/**
	 * Java forced me to use Version so I'm using only 1L
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, node_data> nodeMap = new HashMap<>();
	private int mc = 0;//mc stand for Mode Count

	@Override
	public node_data getNode(int key) {
		return nodeMap.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return ((Node)nodeMap.get(src)).edges.get(dest);//Do instance of later
	}

	@Override
	public void addNode(node_data n) {
		nodeMap.put(n.getKey(),n); 
		mc ++;
	}

	@Override
	public void connect(int src, int dest, double w) {
		Edge e = new Edge(src, dest, w);
		((Node)nodeMap.get(src)).edges.put(dest, e);
		mc ++;
	}

	@Override
	public Collection<node_data> getV() {
		Collection<node_data> clone = nodeMap.values();
		return clone;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		HashMap<Integer, edge_data> edges = ((Node)nodeMap.get(node_id)).edges;
		Collection<edge_data> clone = edges.values(); //convert manualy edges to clone
		return clone;
	}

	@Override
	public node_data removeNode(int key) {
		node_data n = getNode(key);
		nodeMap.remove(key);
		mc ++;
		return n;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data e = getEdge(src, dest);
		((Node)nodeMap.get(src)).edges.remove(dest);
		mc ++;
		return e;
	}

	@Override
	public int nodeSize() {
		return nodeMap.size();
	}

	@Override
	public int edgeSize() {
		return ((Node)nodeMap.keySet()).edges.size();
	}

	@Override
	public int getMC() {
		return mc;
	}

	@Override
	public String toString() {
		return "DGraph [nodeMap=" + nodeMap + "]";
	}
	
}
