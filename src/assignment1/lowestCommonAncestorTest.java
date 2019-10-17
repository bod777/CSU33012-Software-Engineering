package assignment1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment1.lowestCommonAncestor.Node;

class lowestCommonAncestorTest {

	@Test
	public void testingEmptyDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorDAG(node1, node2));
		tree.add(node1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorDAG(node1, null));
		tree.add(node2);
		tree.addAncestors(node1,node2);
		tree.add(node3);
		tree.addAncestors(node1,node3);
		assertEquals("The node1 will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestorDAG(node2,node3));
	}
	@Test
	public void testingEmptyForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
			
		Node node1 = new Node("Dog");
		Node node2 = new Node("Cat");
		Node node3 = new Node("Cow");
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorDAG(node1, node2));
		tree.add(node1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorDAG(node1, null));
		tree.add(node2);
		tree.addAncestors(node1,node2);
		tree.add(node3);
		tree.addAncestors(node1,node3);
		assertEquals("The node1 will be returned, as it is the LCA","Dog",tree.lowestCommonAncestorDAG(node2,node3));
	}
	@Test
	public void testingNonExistentNodesForIntegerDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		
		tree.addAncestors(node1,node2);
		tree.addAncestors(node1,node3);
		tree.addAncestors(node2,node4);
		tree.addAncestors(node3,node5);
				
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null,node3));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(node5,node6));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(node6,node7));
	}
	@Test
	public void testingNonExistentNodesForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		Node node1 = new Node("Bríd");
		Node node2 = new Node("Marie");
		Node node3 = new Node("Philip");
		Node node4 = new Node("Margaret");
		Node node5 = new Node("Thomas");
		Node node6 = new Node("Lily");
		Node node7 = new Node("Phil");
		
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		
		tree.addAncestors(node1,node2);
		tree.addAncestors(node1,node3);
		tree.addAncestors(node2,node4);
		tree.addAncestors(node3,node5);
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, node3));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(node5, node6));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(node6, node7));
	}
	@Test
	public void testingTreeForIntegerDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		
		tree.addAncestors(node1,node2);
		tree.addAncestors(node1,node3);
		tree.addAncestors(node2,node4);
		tree.addAncestors(node3,node5);
		tree.addAncestors(node5,node6);
		tree.addAncestors(node6,node7);
		tree.addAncestors(node4,node7);
		
		assertEquals("The LCA of node5 and node6 is node5.",(Integer)5,tree.lowestCommonAncestorDAG(node5,node6));
		assertEquals("The LCA of node2 and node3 is node1.",(Integer)1,tree.lowestCommonAncestorDAG(node2,node3));
		assertEquals("The LCA of node4 and node7 is node1.",(Integer)1,tree.lowestCommonAncestorDAG(node4,node7));
	}
		
	@Test
	public void testingTreeForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		Node node1 = new Node("cat");
		Node node2 = new Node("dog");
		Node node3 = new Node("cow");
		Node node4 = new Node("pig");
		Node node5 = new Node("bird");
		Node node6 = new Node("ant");
		Node node7 = new Node("snake");
		
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		
		tree.addAncestors(node1,node2);
		tree.addAncestors(node1,node3);
		tree.addAncestors(node2,node4);
		tree.addAncestors(node3,node5);
		tree.addAncestors(node5,node6);
		tree.addAncestors(node6,node7);
		tree.addAncestors(node4,node7);
		
		assertEquals("The LCA of pig and bird is cat.","cat",tree.lowestCommonAncestorDAG(node4,node5));
		assertEquals("The LCA of dog and pig is dog.","dog",tree.lowestCommonAncestorDAG(node2,node4));
		assertEquals("The LCA of pig and snake is pig.","pig",tree.lowestCommonAncestorDAG(node4,node7));
	}
		
	@Test
	public void testingOnesidedTreeForIntegerDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		
		tree.addAncestors(node1,node2);
		tree.addAncestors(node2,node3);
		tree.addAncestors(node3,node4);
		tree.addAncestors(node4,node5);
		tree.addAncestors(node5,node6);
		tree.addAncestors(node6,node7);
		
		assertEquals("The LCA of node 5 and node 6 is node 5.",(Integer)5,tree.lowestCommonAncestorDAG(node5,node6));
		assertEquals("The LCA of node 6 and node 2 is node 2.",(Integer)2,tree.lowestCommonAncestorDAG(node6,node2));
		assertEquals("The LCA of node 1 and node 7 is node 1.",(Integer)1,tree.lowestCommonAncestorDAG(node1,node7));	
	}		
}