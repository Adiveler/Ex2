package gui;

import java.util.Collection;
import java.util.Scanner;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class MyGUI {
	private graph g;
	public MyGUI (graph g) {
		this.g = g;
	}
	/**
	 * draw the graph, nodes in blue and edges in red
	 */
	public void draw () {
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.RED);
		for (node_data n : g.getV()) {
			Collection<edge_data> edges = g.getE(n.getKey());
			for (edge_data e : edges) {
				node_data u = g.getNode(e.getDest());
				Point3D pn = n.getLocation();
				Point3D pu = u.getLocation();
				StdDraw.line(pn.x(), pn.y(), pu.x(), pu.y());
			}
		}
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.BLUE);
		
		for (node_data n : g.getV()) {
			Point3D p = n.getLocation();
			StdDraw.point(p.x(), p.y());
		}
	}
	
	/**
	 * Get an input from user's keyboard: s for save, l for load, q for quit
	 * @throws InterruptedException
	 */
	public void inputkeyboard() throws InterruptedException {
		Graph_Algo ga = new Graph_Algo(g);
		Scanner sc = new Scanner(System.in);
		char c = 0;
		while (c != 'q') {
			
			if (StdDraw.hasNextKeyTyped()) {
				c = StdDraw.nextKeyTyped();
			} 
			
			switch (c) {
			case 's':
			    System.out.println("Enter file name");
			    String file_name = sc.nextLine();
				ga.save(file_name);
				System.out.println("save");
				break;

			case 'l':
			    System.out.println("Enter file name");
			    String fileload = sc.nextLine();
				ga.init(fileload);
				g = ga.getGraph();
				draw();
				System.out.println("load");
				break;
				
			case 'q':
				System.out.println("quit");
				break;
				
			default:
				break;
			}
			
			c = 0;
			Thread.sleep(15);
			
		}
		sc.close();
	}
}
