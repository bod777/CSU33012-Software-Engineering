package assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	@Test
	void testDAGContructor() {
		DAG tester = new DAG(10);
		tester.addEdge(1,2);	
		tester.addEdge(2,3);	
		tester.addEdge(2,4);
		tester.addEdge(4,5);
		tester.addEdge(5,6);
		tester.addEdge(5,7);
		
		assertEquals("Number of edges should be 10",10,tester.E());
		assertEquals("Number of edges should be 6",6,tester.V());
		assertEquals("Number of indegree of the 4 vertex should be 1",1,tester.indegree(4));
		assertEquals("Number of outdegree of the 4 vertex should be 1",1,tester.outdegree(4));
	}
	
	@Test
	void testAddEdge() {
		DAG tester = new DAG(10);
		tester.addEdge(1,2);
		assertEquals("Number of edges should be 1",1,tester.V());
		tester.addEdge(2,3);
		tester.addEdge(2,4);
		assertEquals("Number of edges should be 3",3,tester.V());
		tester.addEdge(4,5);
		tester.addEdge(5,3);
		tester.addEdge(8,9);
		assertEquals("Number of edges should be 6",6,tester.V());
	}
	
	@Test
	void testEmptyDAG() {
		DAG tester = new DAG(10);
	}
	

	
	@Test
	void testLCA() {
		DAG tester = new DAG(10);
		
	}

	@Test
	void testHasCycle() {
		
	}
}
