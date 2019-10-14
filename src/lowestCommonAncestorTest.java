import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* NEED TO ADD IN assertEquals comments */


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
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestor(8,11));
		assertEquals("[]",(Integer)3,tree.lowestCommonAncestor(1,5));
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

		assertEquals("[]","cow",tree.lowestCommonAncestor("ant","monkey"));
		assertEquals("[]","monkey",tree.lowestCommonAncestor("fish","pig"));
		assertEquals("[]","dog",tree.lowestCommonAncestor("monkey","dog"));
		tree.put("");
		assertEquals("[]","cow",tree.lowestCommonAncestor("","dog"));
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
		assertEquals("[]",(Integer)6,tree.lowestCommonAncestor(5,6));
		assertEquals("[]",(Integer)9,tree.lowestCommonAncestor(7,9));
		assertEquals("[]",(Integer)10,tree.lowestCommonAncestor(5,10));	
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
		tree.put("Bríd");	
		assertEquals("[]","(()Bríd())",tree.printKeysInOrder());
		tree.put("Marie");	
		tree.put("Philip");	
		assertEquals("[]","(()Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("");	
		assertEquals("[]","((()())Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
		tree.put("Marie");	
		assertEquals("[]","((()())Bríd(()Marie(()Philip())))",tree.printKeysInOrder());
	}
}