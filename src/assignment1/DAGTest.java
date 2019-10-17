package assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
		tester.addEdge(5,6);
		assertEquals("Number of edges should be 6",6,tester.V());
	}
	
	@Test
	void testHasCycle() {
		DAG CycleDAG = new DAG(10);
		DAG NoCycleDAG = new DAG(10);
		
		CycleDAG.addEdge(1,2);
		CycleDAG.addEdge(2,3);
		CycleDAG.addEdge(3,1);
		
		NoCycleDAG.addEdge(1,2);	
		NoCycleDAG.addEdge(2,3);	
		NoCycleDAG.addEdge(2,4);
		
		CycleDAG.findCycle(1);
		assertTrue(CycleDAG.hasCycle());
		NoCycleDAG.findCycle(1);		
		assertFalse(NoCycleDAG.hasCycle());
	}
	
	@Test
	void testLCA() {
		DAG tester = new DAG(10);
		tester.addEdge(1,2);	
		tester.addEdge(2,3);	
		tester.addEdge(2,4);
		tester.addEdge(4,5);
		tester.addEdge(5,6);
		tester.addEdge(5,7);
		tester.addEdge(3,6);
		
		assertEquals("The LCA for 4 and 6 is 2.",2,tester.LCA(4,6));
		assertEquals("The LCA for 7 and 6 is 5.",5,tester.LCA(7,6));
		assertEquals("The LCA for 1 and 2 is 1.",1,tester.LCA(1,2));
		assertEquals("The LCA for 2 and 5 is 2.",2,tester.LCA(2,5));
	}	
	
	@Test
	void testEmptyDAG() {
		DAG tester = new DAG(10);
		assertEquals("The LCA for 4 and 6 is null.",-1,tester.LCA(4,6));
	}
	@Test
	void testInputsDAG() {
		DAG tester = new DAG(10);
		tester.addEdge(1,2);	
		tester.addEdge(2,3);	
		tester.addEdge(2,4);
		tester.addEdge(4,5);
		assertEquals("The LCA for 11 and 4 is null.",-1,tester.LCA(11,4));
		assertEquals("The LCA for 11 and 12 is null.",-1,tester.LCA(11,12));
	}
	@Test
	public void testIfNotADAG() {
		DAG nonDAG = new DAG(8);
		nonDAG.addEdge(0,1);
		nonDAG.addEdge(1,2);
		nonDAG.addEdge(2,3);
		nonDAG.addEdge(3,1);
				
		assertEquals("",-1,nonDAG.LCA(2,3));
		assertEquals("",-1,nonDAG.LCA(1,3));
		assertEquals("",-1,nonDAG.LCA(3,1));
	}
}