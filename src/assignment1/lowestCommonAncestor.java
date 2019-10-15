package assignment1;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


// Note: 
public class lowestCommonAncestor<Key extends Comparable<Key>>
{
/* Standard BST code */
	
	class Node {
		private Node left;             
		private Node right;
		private Key data;
		private int N;
		ArrayList <Node> ancestors;
		

		public Node(Key value) {
			this.data = value;         // associated data
			left = right = null;	// left and right subtrees
			ancestors = null;
		}
	}
	
	private Node root;
	
	public void add(Node node) {
		node.ancestors = new ArrayList <Node> ();
		node.ancestors.add(node);
	}
	public void addAncestors(Node node1, Node node2) {
		for (int i=0; i<node1.ancestors.size();i++) {
			if(!node2.ancestors.contains(node1.ancestors.get(i))) {
				node2.ancestors.add(node1.ancestors.get(i));
			}
		}
	}

	public boolean isEmpty() { 
		return size() == 0; 
	}
	
	public int size() { 
		return size(root); 
	}	
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}
	
	public String printKeysInOrder() {
		if (isEmpty()) {
			return "()";
		}
		else {
			return  printKeysInOrder(root);
		}
	}
	private String printKeysInOrder(Node node)
	{
		if (node == null)
			return "()";

		else
			return "("+printKeysInOrder(node.left)+ node.data.toString() + printKeysInOrder(node.right)+")";
	}

/* lowest Common Ancestor functions below*/
	
	private List<Key> nodePath1 = new ArrayList<>();
	private List<Key> nodePath2 = new ArrayList<>();
	//will use lists as a method to track the nodes
	
	public Key lowestCommonAncestorBST(Key node1, Key node2) {
		nodePath1.clear();
		nodePath2.clear();
		return findLowestCommonAncestorBST(root, node1, node2);
	}
	
	private Key findLowestCommonAncestorBST(Node root, Key n1, Key n2) {

		if (!findPath(root, n1, nodePath1) || !findPath(root, n2, nodePath2)) {
			if (nodePath1.size() == 0 && nodePath2.size() == 0) {
				if (!nodePath2.contains(n1)&&!nodePath2.contains(n2)) {
					System.out.println("These nodes does not exist in the tree.");
				}
				else {
					System.out.println("Tree is empty.");
				}
			}
			if (nodePath1.size() > 0 && nodePath2.size() == 0) {
				System.out.println("Node A is present but Node B is not.");
			}
			if (nodePath1.size() == 0 && nodePath2.size() > 0) {
				System.out.println("Node B is present but Node A is not.");
			}
			return null;
		}
		int i;
		
		for (i = 0; i < nodePath1.size() && i < nodePath2.size(); i++) {
			if (!nodePath1.get(i).equals(nodePath2.get(i)))
				break;
		}
		
		return nodePath1.get(i-1);
	}
	
	public Key lowestCommonAncestorDAG(Node node1, Node node2) {
		return findLowestCommonAncestorDAG(root, node1, node2);
	}
	private Key findLowestCommonAncestorDAG(Node root, Node n1, Node n2) {
		if (n1 != null && n2 != null) {
			if (n1.ancestors != null && n2.ancestors !=null) {
				for (int i=0; i< n1.ancestors.size();i++) {
					for(int j=0; j< n2.ancestors.size();j++) {
						if (n2.ancestors.get(i) == n1.ancestors.get(j)) {
							return n2.ancestors.get(i).data;
						}
						else {
							return root.data;
						}
					}
				}
			}
			else {
				return root.data;
			}
		}
		return null;
	}
	
	
	
	//findPath() function is okay
	private boolean findPath(Node root, Key n, List<Key> path)
	{
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size()-1);

		return false;
	}
}