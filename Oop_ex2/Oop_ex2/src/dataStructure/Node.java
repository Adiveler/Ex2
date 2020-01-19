package dataStructure;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import utils.Point3D;

public class Node implements node_data, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int key;
	private Point3D Location;
	private double weight;
	private String info;
	private int tag;
	public HashMap<Integer, edge_data> edges = new HashMap<>();//Integer is the key for the destinations ID
	
	public Node (int key) {
		this.key = key;
	}
	public Node() {
		key = 0;
	}

	@Override
	public int getKey() {
		return key;
	}

	@Override
	public Point3D getLocation() {
		return Location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.Location = p;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight = w;
	}

	@Override
	public String getInfo() {
		return info;
	}

	@Override
	public void setInfo(String s) {
		this.info = s;
	}

	@Override
	public int getTag() {
		return tag;
	}

	@Override
	public void setTag(int t) {
		this.tag = t;
	}
	/**
	 * Clone an existing node
	 */
	public Node clone() {
		Node clone = new Node (this.key);
		clone.setLocation(this.getLocation());
		clone.setWeight(this.getWeight());
		clone.setInfo(this.getInfo());
		clone.setTag(this.getTag());
		HashMap<Integer, edge_data> e = new HashMap<>();
		for (Entry<Integer, edge_data> p : this.edges.entrySet() ) {
			Integer g = p.getKey();
			edge_data d = p.getValue();
			e.put(g, d);
		}
		clone.edges = e;
		return clone;
	}
	@Override
	public String toString() {
		return "Node [key=" + key + ", Location=" + Location + ", weight=" + weight + ", info=" + info + ", tag=" + tag
				+ ", edges=" + edges + "]";
	}
	
}
