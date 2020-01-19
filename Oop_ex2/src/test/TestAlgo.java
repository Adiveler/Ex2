package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;

class TestAlgo {
	
	private graph g1() {
		Node n1 = new Node (1);
		Node n2 = new Node (2);
		Node n3 = new Node (3);
		Node n4 = new Node (4);
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.connect(1, 2, 2);
		g.connect(2, 3, 3);
		g.connect(2, 4, 4);
		return g;
	}

	@Test
	void testgenerategraph() {
		graph g = g1();
		Graph_Algo a = new Graph_Algo(g);
		double l = a.shortestPathDist(1,3);
		assertEquals(5.0, l);
	}

}
