import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
	public void testingEmptyForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		assertEquals("The tree is empty, thus it will return null",null,tree.lowestCommonAncestor("Cow","Dog"));
		tree.put("Cow");
		assertEquals("The tree has one node, thus it will return null",null,tree.lowestCommonAncestor("Cow","Dog"));
		tree.put("Dog");
		tree.put("Cat");
		assertEquals("The root will be returned, as it is the LCA","Cow",tree.lowestCommonAncestor("Cat","Dog"));
	}
	@Test
	public void testingNonExistentNodesForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(10);
		tree.put(6);
		tree.put(11);
		tree.put(13);
		tree.put(9);
		
		assertEquals("One input is null, thus it will return null",null,tree.lowestCommonAncestor(null,6));
		assertEquals("Two input is null, thus it will return null",null,tree.lowestCommonAncestor(null, null));
		assertEquals("One input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestor(7,10));
		assertEquals("Two input is a node not in the tree, thus it will return null",null,tree.lowestCommonAncestor(7,100));
	}
	@Test
	public void testingNonExistentNodesForString() {
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
		assertEquals("The LCA of 5 and 6 is 6.",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("The LCA of 8 and 11 is 10.",(Integer)10,tree.lowestCommonAncestor(8,11));
		assertEquals("The LCA of 1 and 5 is 3.",(Integer)3,tree.lowestCommonAncestor(1,5));
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

		assertEquals("The LCA of ant and monkey is cow.","cow",tree.lowestCommonAncestor("ant","monkey"));
		assertEquals("The LCA of fish and pig is monkey.","monkey",tree.lowestCommonAncestor("fish","pig"));
		assertEquals("The LCA of monkey and dog is dog.","dog",tree.lowestCommonAncestor("monkey","dog"));
		tree.put("");
		assertEquals("The LCA of blank and dog is cow.","cow",tree.lowestCommonAncestor("","dog"));
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
		assertEquals("The LCA of 5 and 6 is 6.",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("The LCA of 7 and 9 is 9.",(Integer)9,tree.lowestCommonAncestor(7,9));
		assertEquals("The LCA of 5 and 10 is 10.",(Integer)10,tree.lowestCommonAncestor(5,10));	
	}
	
	@Test
	public void testingPutForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		tree.put(null);
		assertEquals("The tree has 0 nodes.","()",tree.printKeysInOrder());
		tree.put(10);	
		assertEquals("The tree has 1 nodes.","(()10())",tree.printKeysInOrder());
		tree.put(8);	
		tree.put(11);	
		assertEquals("The tree has 3 nodes.","((()8())10(()11()))",tree.printKeysInOrder());
		tree.put(6);							
		tree.put(9);	
		assertEquals("The tree has 5 nodes.","(((()6())8(()9()))10(()11()))",tree.printKeysInOrder());
		tree.put(7);	
		assertEquals("The tree has 6 nodes.","(((()6(()7()))8(()9()))10(()11()))",tree.printKeysInOrder());
		tree.put(8);	
		assertEquals("The tree has 7 nodes.","(((()6(()7()))8(()9()))10(()11()))",tree.printKeysInOrder());
	}
	
	@Test
	public void testingPutForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		tree.put(null);
		assertEquals("The tree has 0 nodes.","()",tree.printKeysInOrder());
		tree.put("Bríd");	
		assertEquals("The tree has 1 nodes.","(()Bríd())",tree.printKeysInOrder());
		tree.put("Marie");	
		tree.put("Philip");	
		assertEquals("The tree has 3 nodes.","(()Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("");	
		assertEquals("The tree has 4 nodes.","((()())Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("Marie");	
		assertEquals("The tree has 5 nodes.","((()())Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
	}
	
	@Test
	public void testingIsEmpty() {
		lowestCommonAncestor<String> treeString = new lowestCommonAncestor<String>();
		lowestCommonAncestor<Integer> treeInteger = new lowestCommonAncestor<Integer>();
		
		assertTrue("The tree is empty.",treeString.isEmpty());
		assertTrue("The tree is empty.",treeInteger.isEmpty());
		
		treeString.put("Hello");
		assertFalse("The tree is not empty.",treeString.isEmpty());
		
		treeInteger.put(1);
		assertFalse("The tree is not empty.",treeInteger.isEmpty());
	}
	
	@Test
	public void testingSizeForString() {
		lowestCommonAncestor<String> tree = new lowestCommonAncestor<String>();
		
		tree.put(null);
		assertEquals("The tree has no nodes.",0,tree.size());
		
		tree.put("Hello");
		assertEquals("The tree has 1 nodes.",1,tree.size());
		
		tree.put("Bríd");
		tree.put("Marie");
		tree.put("Philip");
		tree.put("Margaret");
		tree.put("Thomas");
		tree.put("Lily");
		tree.put("Phil");
		
		assertEquals("The tree has 8 nodes.",8,tree.size());
	}
	
	@Test
	public void testingSizeForInteger() {
		lowestCommonAncestor<Integer> tree = new lowestCommonAncestor<Integer>();
		
		tree.put(null);
		assertEquals("The tree has no nodes.",0,tree.size());
		
		tree.put(11);
		assertEquals("The tree has 1 nodes.",1,tree.size());
		
		tree.put(10);	
		tree.put(9);	  
		tree.put(8);		   
		tree.put(7);							
		tree.put(6);		
		tree.put(5);
		
		assertEquals("The tree has 7 nodes.",7,tree.size());
	}
}