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
		assertEquals("The root will be returned, as it is the LCA",(Integer)1,tree.lowestCommonAncestor(2,3));
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

	
	
}
