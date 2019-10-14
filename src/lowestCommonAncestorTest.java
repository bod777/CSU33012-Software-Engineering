import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lowestCommonAncestorTest {

	@Test
	public void testingTree() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestor(1,2));
		tree.put(1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestor(1,2));
		tree.put(2);
		tree.put(3);
		assertEquals("The root will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestor(1,2));
	}
	@Test
	public void testingInputs() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put("Bríd");
		tree.put("Marie");
		tree.put("Philip");
		tree.put("Margaret");
		tree.put("Thomas");
		tree.put("Lily");
		tree.put("Phil");
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestor(null, "Clare"));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestor(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestor("Christoper", "Philip"));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestor("Christoper", "Clare"));
	}
	@Test
	public void testingBiggerTree() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);	//				10
		tree.put(8);	//			   /  \
		tree.put(11);	//			  8	   11
		tree.put(6);	//			 / \								
		tree.put(3);	//			6	9
		tree.put(4);	//		   / \
		tree.put(7);	//		  3	  7
		tree.put(9);	//		 / \
		tree.put(2);	//		2	4
		tree.put(5);	//	   /	 \
		tree.put(1);	//	  1		  5
		assertEquals("The tree is empty, thus it will return null",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("The tree has one node, thus it will return null",(Integer)10,tree.lowestCommonAncestor(8,11));
		assertEquals("The root will be returned, as it is the LCA",(Integer)3,tree.lowestCommonAncestor(1,5));
	}
	
	
}