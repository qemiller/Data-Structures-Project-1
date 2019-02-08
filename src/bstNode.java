public class bstNode<K, E>
{
	private K key;
	private E element;
	private bstNode<K, E> left;
	private bstNode<K, E> right;
	private bstNode<K, E> parent;
	
	public bstNode()
	{
		left = right = parent = null;
	}
	
	public bstNode(K k, E val)
	{
		left = right = parent = null;
		key = k;
		element = val;
	}
	
	public bstNode(K k, E val, bstNode<K, E> l, bstNode<K, E> r)
	{
		left = l;
		right = r;
		l.parent = this;
		r.parent = this;
		key = k;
		element = val;
	}
	
	public K key() 
	{
		return key;
	}
	
	public K setKey(K k)
	{
		return key = k;
	}
	
	public E element() 
	{
		return element;
	}
	
	public E setElement(E v)
	{
		return element = v;
	}
	
	public bstNode<K, E> left()
	{
		return left;
	}
	
	public bstNode<K, E> setLeft(bstNode<K, E> p) 
	{
		p.parent = this;
		return left = p;
	}
	
	public bstNode<K, E> right() 
	{
		return right;
	}
	
	public bstNode<K, E> setRight(bstNode<K, E> p)
	{
		p.parent = this;
		return right = p;
	}
		
	public bstNode<K, E> parent()
	{
		return parent;
	}
	
	public boolean isLeaf()
	{
		return (left == null) && (right == null);
	}
}