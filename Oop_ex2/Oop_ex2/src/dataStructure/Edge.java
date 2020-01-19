package dataStructure;

import java.io.Serializable;

public class Edge implements edge_data, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int src;
	private int dest;
	private double weight;
	private String info;
	private int tag;

	/**
	 * Edge constructor
	 * @param src
	 * @param dest
	 * @param weight
	 */
	public Edge(int src, int dest, double weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int getSrc() {
		return src;
	}

	@Override
	public int getDest() {
		return dest;
	}

	@Override
	public double getWeight() {
		return weight;
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
	
	public Edge clone() {
		Edge clone = new Edge (this.src, this.dest, this.weight);
		clone.setInfo(this.getInfo());
		clone.setTag(this.getTag());
		return clone;
	}

	@Override
	public String toString() {
		return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + ", info=" + info + ", tag=" + tag + "]";
	}
}
