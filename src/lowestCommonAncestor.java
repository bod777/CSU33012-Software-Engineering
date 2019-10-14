import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


// Note: 
public class lowestCommonAncestor<Key extends Comparable<Key>>
{
	class Node {
		private Node left;             
		private Node right;
		private Key data;
		private int N;             // number of nodes in subtree

		public Node(Key value, int N) {
			this.data = value;         // associated data
			left = right = null;	  // left and right subtrees
			this.N = N;
		}
	}
	private Node root;
	/**
	 *  Insert node into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	public void put(Key key) {
		if (key == null) {  return; }
		root = put(root, key);
	}

	private Node put(Node x, Key key) {
		if (x == null) return new Node(key, 1);
		int cmp = key.compareTo(x.data);
		if      (cmp < 0) x.left  = put(x.left,  key);
		else if (cmp > 0) x.right = put(x.right, key);
		else              x.data   = key;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	// is the tree empty?
	public boolean isEmpty() { return size() == 0; }

	// return number of nodes in the tree
	public int size() { return size(root); }

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	private List<Key> nodePath1 = new ArrayList<>();
	private List<Key> nodePath2 = new ArrayList<>();
	//will use lists as a method to track the nodes tha


	/**
	 *  Search BST for given key.
	 *  Does there exist a key-value pair with given key?
	 *
	 *  @param key the search key
	 *  @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}
	/**
	 *  Search BST for given key.
	 *  What is the value associated with given key?
	 *
	 *  @param key the search key
	 *  @return value associated with the given key if found, or null if no such key exists.
	 */
	public Key get(Key key) { return get(root, key); }

	private Key get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.data);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.data;
	}

	public String printKeysInOrder() {
		if (isEmpty()) return "()";
		return  printKeysInOrder(root);
	}
	private String printKeysInOrder(Node node)
	{
		if (node == null)
			return "()";

		else
			return "("+printKeysInOrder(node.left)+ node.data.toString() + printKeysInOrder(node.right)+")";
	}

	public Key lowestCommonAncestor(Key node1, Key node2) {
		nodePath1.clear();
		nodePath2.clear();
		return findLowestCommonAncestor(root, node1, node2);
	}

	private Key findLowestCommonAncestor(Node root, Key n1, Key n2) {

		if (!findPath(root, n1, nodePath1) || !findPath(root, n2, nodePath2)) {
			return null;
		}

		int i;
		for (i = 0; i < nodePath1.size() && i < nodePath2.size(); i++) {
			if (!nodePath1.get(i).equals(nodePath2.get(i)))
				break;
		}

		return nodePath1.get(i-1);
	}

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

	/**
	 * Deletes a key from a tree (if the key is in the tree).
	 * Note that this method works symmetrically from the Hibbard deletion:
	 * If the node to be deleted has two child nodes, then it needs to be
	 * replaced with its predecessor (not its successor) node.
	 *
	 * @param key the key to delete
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}
	private Node delete(Node x, Key key) {                                  
		if (x == null) return null;
		int cmp = key.compareTo(x.data);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else { 
			if (x.right == null) return x.left;
			if (x.left  == null) return x.right;
			Node t = x;
			x = max(t.left);                              
			x.left = deleteMax(t.left);                 
			x.right = t.right;                                             
		} 
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	} 

	private Node deleteMax(Node x) 
	{
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;                              
		return x;
	}

	public Node max(Node node)   
	{
		if(node.right!=null)
			return max(node.right);
		return node;
	}

}