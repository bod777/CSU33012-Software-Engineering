package assignment1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* NEED TO ADD IN assertEquals comments */


class lowestCommonAncestorTest {

	@Test
	public void testingEmpty() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorBST(1,2));
		tree.put(1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorBST(1,2));
		tree.put(2);
		tree.put(3);
		assertEquals("The root will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestorBST(1,2));
	}
	@Test
	public void testingEmptyForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorBST("Cow","Dog"));
		tree.put("Cow");
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorBST("Cow","Dog"));
		tree.put("Dog");
		tree.put("Cat");
		assertEquals("The root will be returned, as it is the LCA","Cow",tree.lowestCommonAncestorBST("Cat","Dog"));
	}
	@Test
	public void testingNonExistentNodesForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);
		tree.put(6);
		tree.put(11);
		tree.put(13);
		tree.put(9);
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorBST(null,6));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorBST(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorBST(7,10));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorBST(7,100));
	}
	@Test
	public void testingNonExistentNodesForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put("Br�d");
		tree.put("Marie");
		tree.put("Philip");
		tree.put("Margaret");
		tree.put("Thomas");
		tree.put("Lily");
		tree.put("Phil");
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorBST(null, "Clare"));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorBST(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorBST("Christoper", "Philip"));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorBST("Christoper", "Clare"));
	}
	@Test
	public void testingTreeForInteger() {
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
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestorBST(5,6));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestorBST(8,11));
		assertEquals("[]",(Integer)3,tree.lowestCommonAncestorBST(1,5));
	}
	
	@Test
	public void testingTreeForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put("cow");	
		tree.put("cat");	
		tree.put("dog");	
		tree.put("monkey");									
		tree.put("ant");	
		tree.put("pig");	
		tree.put("fish");	

		assertEquals("[]","cow",tree.lowestCommonAncestorBST("ant","monkey"));
		assertEquals("[]","monkey",tree.lowestCommonAncestorBST("fish","pig"));
		assertEquals("[]","dog",tree.lowestCommonAncestorBST("monkey","dog"));
		tree.put("");
		assertEquals("[]","cow",tree.lowestCommonAncestorBST("","dog"));
	}
	
	@Test
	public void testingOnesidedTreeForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);	
		tree.put(9);	  
		tree.put(8);		   
		tree.put(7);							
		tree.put(6);		
		tree.put(5);		
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestorBST(5,6));
		assertEquals("[]",(Integer)9,tree.lowestCommonAncestorBST(7,9));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestorBST(5,10));	
	}
	
	@Test
	public void testingPutForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(null);
		assertEquals("[]","()",tree.printKeysInOrder());
		tree.put(10);	
		assertEquals("[]","(()10())",tree.printKeysInOrder());
		tree.put(8);	
		tree.put(11);	
		assertEquals("[]","((()8())10(()11()))",tree.printKeysInOrder());
		tree.put(6);							
		tree.put(9);	
		assertEquals("[]","(((()6())8(()9()))10(()11()))",tree.printKeysInOrder());
		tree.put(7);	
		assertEquals("[]","(((()6(()7()))8(()9()))10(()11()))",tree.printKeysInOrder());
		tree.put(8);	
		assertEquals("[]","(((()6(()7()))8(()9()))10(()11()))",tree.printKeysInOrder());
	}
	
	@Test
	public void testingPutForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put(null);
		assertEquals("[]","()",tree.printKeysInOrder());
		tree.put("Br�d");	
		assertEquals("[]","(()Br�d())",tree.printKeysInOrder());
		tree.put("Marie");	
		tree.put("Philip");	
		assertEquals("[]","(()Br�d(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("");	
		assertEquals("[]","((()())Br�d(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("Marie");	
		assertEquals("[]","((()())Br�d(()Marie(()Philip())))",tree.printKeysInOrder());
	}
	
	@Test
	public void testingIsEmpty() {
		lowestCommonAncestor<String> treeString = new lowestCommonAncestor<String>();
		lowestCommonAncestor<Integer> treeInteger = new lowestCommonAncestor<Integer>();
		
		assertTrue("[]",treeString.isEmpty());
		assertTrue("[]",treeInteger.isEmpty());
		
		treeString.put("Hello");
		assertFalse("[]",treeString.isEmpty());
		
		treeInteger.put(1);
		assertFalse("[]",treeInteger.isEmpty());
	}
	
	@Test
	public void testingSizeForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		tree.put(null);
		assertEquals("[]",0,tree.size());
		
		tree.put("Hello");
		assertEquals("[]",1,tree.size());
		
		tree.put("Br�d");
		tree.put("Marie");
		tree.put("Philip");
		tree.put("Margaret");
		tree.put("Thomas");
		tree.put("Lily");
		tree.put("Phil");
		
		assertEquals("[]",8,tree.size());
	}
	
	@Test
	public void testingSizeForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		tree.put(null);
		assertEquals("[]",0,tree.size());
		
		tree.put(11);
		assertEquals("[]",1,tree.size());
		
		tree.put(10);	
		tree.put(9);	  
		tree.put(8);		   
		tree.put(7);							
		tree.put(6);		
		tree.put(5);
		
		assertEquals("[]",7,tree.size());
	}
		
	@Test
	public void testingEmptyDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorDAG(1,2));
		tree.put(1);
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorDAG(1,2));
		tree.put(2);
		tree.put(3);
		assertEquals("The root will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestorDAG(1,2));
	}
	@Test
	public void testingEmptyForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestorDAG("Cow","Dog"));
		tree.put("Cow");
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestorDAG("Cow","Dog"));
		tree.put("Dog");
		tree.put("Cat");
		assertEquals("The root will be returned, as it is the LCA","Cow",tree.lowestCommonAncestorDAG("Cat","Dog"));
	}
	@Test
	public void testingNonExistentNodesForIntegerDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);
		tree.put(6);
		tree.put(11);
		tree.put(13);
		tree.put(9);
			
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null,6));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(7,10));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG(7,100));
	}
	@Test
	public void testingNonExistentNodesForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put("Br�d");
		tree.put("Marie");
		tree.put("Philip");
		tree.put("Margaret");
		tree.put("Thomas");
		tree.put("Lily");
		tree.put("Phil");
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, "Clare"));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestorDAG(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG("Christoper", "Philip"));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestorDAG("Christoper", "Clare"));
	}
	@Test
	public void testingTreeForIntegerDAG() {
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
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestorDAG(5,6));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestorDAG(8,11));
		assertEquals("[]",(Integer)3,tree.lowestCommonAncestorDAG(1,5));
	}
		
	@Test
	public void testingTreeForStringDAG() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put("cow");	
		tree.put("cat");	
		tree.put("dog");	
		tree.put("monkey");									
		tree.put("ant");	
		tree.put("pig");	
		tree.put("fish");	
		assertEquals("[]","cow",tree.lowestCommonAncestorDAG("ant","monkey"));
		assertEquals("[]","monkey",tree.lowestCommonAncestorDAG("fish","pig"));
		assertEquals("[]","dog",tree.lowestCommonAncestorDAG("monkey","dog"));
		tree.put("");
		assertEquals("[]","cow",tree.lowestCommonAncestorDAG("","dog"));
	}
		
	@Test
	public void testingOnesidedTreeForIntegerDAG() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);	
		tree.put(9);	  
		tree.put(8);		   
		tree.put(7);							
		tree.put(6);		
		tree.put(5);		
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestorDAG(5,6));
		assertEquals("[]",(Integer)9,tree.lowestCommonAncestorDAG(7,9));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestorDAG(5,10));	
	}		
}