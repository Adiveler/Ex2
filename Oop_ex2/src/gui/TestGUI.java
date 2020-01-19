package gui;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import utils.Point3D;

public class TestGUI {

	public static void main(String[] args) throws InterruptedException {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.setLocation(new Point3D (0.2, 0.2, 0));
		n2.setLocation(new Point3D (0.5, 0.5, 0));
		n3.setLocation(new Point3D (0.7, 0.3, 0));
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(1, 2, 8);
		g.connect(2, 3, 5);
		
		
		MyGUI gui = new MyGUI(g);
		gui.draw();
		gui.inputkeyboard();
	}

}
