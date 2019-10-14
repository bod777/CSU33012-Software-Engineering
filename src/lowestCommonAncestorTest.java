import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lowestCommonAncestorTest {

	@Test
	public void testingEmpty() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestor(1,2));
		tree.put(1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestor(1,2));
		tree.put(2);
		tree.put(3);
		assertEquals("The root will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestor(1,2));
	}
	@Test
	public void testingNonExistentNodes() {
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
	public void testingTree() {
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
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestor(8,11));
		assertEquals("[]",(Integer)3,tree.lowestCommonAncestor(1,5));
	}
	
	@Test
	public void testingOnesidedTree() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);	//				10
		tree.put(9);	//			   /  
		tree.put(8);	//			  9	   
		tree.put(7);	//			 / 								
		tree.put(6);	//			8	
		tree.put(5);	//		   / 
						//		  7	 
						//		 / 
						//		6	
						//	   /	 
						//	  5		
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("[]",(Integer)9,tree.lowestCommonAncestor(7,9));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestor(5,10));	
	}
	
	@Test
	public void testingPut() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(null);
		assertEquals("[]","()",tree.printKeysInOrder());
		tree.put(10);	//				10
		assertEquals("[]","(()10())",tree.printKeysInOrder());
		tree.put(8);	//			   /  \
		tree.put(11);	//			  8	   11
		assertEquals("[]","((()8())10(()11()))",tree.printKeysInOrder());
		tree.put(6);	//			 / \								
		tree.put(9);	//			6	9
		assertEquals("[]","(((()6())8(()9()))10(()11()))",tree.printKeysInOrder());
		tree.put(7);	//			  \
						//			   7
		assertEquals("[]","(((()6(()7()))8(()9()))10(()11()))",tree.printKeysInOrder());
	}
}