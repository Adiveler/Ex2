package algorithms;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	
	private graph g;
	public Graph_Algo (graph g) {
		init(g);
	}
	public graph getGraph() {
		return g;
	}

	@Override
	public void init(graph g) {
		this.g = g;
		
	}

	@Override
	public void init(String file_name) {
		try {
			FileInputStream filein = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(filein);
			g = (DGraph) in.readObject();
			in.close();
			filein.close();
		}
		catch (Exception e) {
			System.out.println("Can't load the file.");
			e.printStackTrace();
		}
	}

	@Override
	public void save(String file_name) {
		if (g instanceof DGraph) {
			try {
				FileOutputStream fileout = new FileOutputStream (file_name);
				ObjectOutputStream out = new ObjectOutputStream (fileout);
				out.writeObject(g);
				out.close();
				fileout.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("Can only save DGraph type");
	}

	@Override
	public boolean isConnected() {
		Collection<node_data> n = g.getV();
		dijakstra (n.iterator().next());
		for (node_data v :g.getV()) {
			if (v.getWeight() == Double.POSITIVE_INFINITY) //if a Node's weight is infinite after using dijakstra function, it's mean that it's not connected to the rest
				return false;
		}
		return true;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		dijakstra(g.getNode(src));
		node_data n = g.getNode(dest);
		return n.getWeight();
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		node_data u = g.getNode(src);
		node_data v = g.getNode(dest);
		dijakstra(u);
		ArrayList<node_data> ans = new ArrayList<>();
		while(v.getKey() != u.getKey()) {
			ans.add(v);
			v = g.getNode(v.getTag());
		}
		ans.add(u);
		return ans;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		ArrayList<node_data> ans = new ArrayList<>();
		int firstn = targets.get(0);
		for (int i = 1; i < targets.size(); i++) {
			int currentn = targets.get(i);;
			List<node_data> path = shortestPath(firstn, currentn);
			ans.addAll(path);
			firstn = currentn;
		}
		return ans;
	}

	@Override
	public graph copy() {
		graph clone = new DGraph();
		Collection<node_data> v = this.g.getV();
		Collection<node_data> c = new ArrayList<node_data>();
		for(node_data i: v) {
			c.add(((Node) i).clone());
		}
		for(node_data a :c ) {
			clone.addNode(a);
		}
		return clone;
	}
	
	//Function for Dijkstra's Algorithm 
	public void dijakstra (node_data src) {
		ArrayList<node_data> q = new ArrayList<>();
		for (node_data v :g.getV()) {
			v.setWeight(Double.POSITIVE_INFINITY);
			v.setTag(-1);// -1 == UNDEFINED
			q.add(v);
		}
		src.setWeight(0);
		while (!q.isEmpty()) {
			node_data u = minWeight(q);
			q.remove(u);
			for (edge_data e : g.getE(u.getKey()) ) {
				double alt = u.getWeight() + e.getWeight();
				node_data v = g.getNode(e.getDest());
				if (alt < v.getWeight()) {
					v.setWeight(alt);
					v.setTag(u.getKey());
				}
			}
		}
	}
	
	// Sub-function for Dijkstra to get minimum weight
	public node_data minWeight(ArrayList<node_data> q) {
		node_data ans = q.get(0);
		for (int i = 1; i < q.size(); i++) {
			if (q.get(i).getWeight()<ans.getWeight())
				ans = q.get(i);
		}
		return ans;
	}
}

