/** BST implementation for Dictionary ADT */
public class bst<K extends Comparable<? super K>, E> {
	private bstNode<K, E> root; // Root of BST
	int nodecount; // Size of BST

	/** Constructor */
	bst() {
		root = null;
		nodecount = 0;
	}

	/** Reinitialize tree */
	public void clear() {
		root = null;
		nodecount = 0;
	}

	/**
	 * Insert a record into the tree.
	 * 
	 * @param k Key value of the record.
	 * @param e The record to insert.
	 */
	public void insert(K k, E e) {
		root = inserthelp(root, k, e);
		nodecount++;
	}

	/**
	 * Remove a record from the tree.
	 * 
	 * @param k Key value of record to remove.
	 * @return Record removed, or null if there is none.
	 */
	public E remove(K k) {
		E temp = findhelp(root, k); // find it
		if (temp != null) {
			root = removehelp(root, k); // remove it
			nodecount--;
		}
		return temp;
	}

	/**
	 * Remove/return root node from dictionary.
	 * 
	 * @return The record removed, null if empty.
	 */
	public E removeAny() {
		if (root != null) {
			E temp = root.element();
			root = removehelp(root, root.key());
			nodecount--;
			return temp;
		} else
			return null;
	}

	/**
	 * @return Record with key k, null if none.
	 * @param k The key value to find.
	 */
	public E find(K k) {
		return findhelp(root, k);
	}

	/** @return Number of records in dictionary. */
	public int size() {
		return nodecount;
	}

	private E findhelp(bstNode<K, E> rt, K k) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(k) > 0)
			return findhelp(rt.left(), k);
		else if (rt.key().compareTo(k) == 0)
			return rt.element();
		else
			return findhelp(rt.right(), k);
	}

	private bstNode<K, E> inserthelp(bstNode<K, E> rt, K k, E e) {
		if (rt == null)
			return new bstNode<K, E>(k, e);
		if (rt.key().compareTo(k) > 0)
			rt.setLeft(inserthelp(rt.left(), k, e));
		else
			rt.setRight(inserthelp(rt.right(), k, e));
		return rt;
	}

	private bstNode<K, E> getmin(bstNode<K, E> rt) {
		if (rt.left() == null)
			return rt;
		else
			return getmin(rt.left());
	}

	private bstNode<K, E> deletemin(bstNode<K, E> rt) {
		if (rt.left() == null)
			return rt.right();
		else {
			rt.setLeft(deletemin(rt.left()));
			return rt;
		}
	}

	/**
	 * Remove a node with key value k
	 * 
	 * @return The tree with the node removed
	 */
	private bstNode<K, E> removehelp(bstNode<K, E> rt, K k) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(k) > 0)
			rt.setLeft(removehelp(rt.left(), k));
		else if (rt.key().compareTo(k) < 0)
			rt.setRight(removehelp(rt.right(), k));
		else { // Found it, remove it
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else { // Two children
				bstNode<K, E> temp = getmin(rt.right());
				rt.setElement(temp.element());
				rt.setKey(temp.key());
				rt.setRight(deletemin(rt.right()));
			}
		}
		return rt;
	}
}