/**
 * @author Josh jrehm135
 * @author Quinton Miller qemiller
 *
 * @param <K>
 * @param <E>
 * @version 2-12-2019
 */
public class BstNode<K, E>
{
    private K key;
    private E element;
    private BstNode<K, E> left;
    private BstNode<K, E> right;
    private BstNode<K, E> parent;

    /**
     * Constructor
     */
    public BstNode()
    {
        left = null;
        right = null;
        parent = null;
    }
    
    /**
     * make a new Node with key k and value val
     * @param k key
     * @param val value at node
     */
    public BstNode(K k, E val)
    {
        left = null;
        right = null;
        parent = null;
        key = k;
        element = val;
    }

    /**
     * 
     * @param k key
     * @param val value at node
     * @param l left child
     * @param r right child
     */
    public BstNode(K k, E val, BstNode<K, E> l, BstNode<K, E> r)
    {
        left = l;
        right = r;
        l.parent = this;
        r.parent = this;
        key = k;
        element = val;
    }

    /**
     * key getter
     * @return key value
     */
    public K key()
    {
        return key;
    }

    /**
     * set key value
     * @param k what to set node key to
     * @return K value
     */
    public K setKey(K k)
    {
        key = k;
        return key;
    }

    /**
     * get element
     * @return element at node
     */
    public E element()
    {
        return element;
    }
    
    /**
     * set element at a node
     * @param v new element value
     * @return v value
     */
    public E setElement(E v)
    {
        element = v;
        return element;
    }

    /**
     * get left child of current node
     * @return left child
     */
    public BstNode<K, E> left()
    {
        return left;
    }

    /**
     * set left child of current node
     * @param p node to set as left
     * @return current left node
     */
    public BstNode<K, E> setLeft(BstNode<K, E> p)
    {
        p.parent = this;
        left = p;
        return left;
    }

    /**
     * get right child of current node
     * @return right child of node
     */
    public BstNode<K, E> right()
    {
        return right;
    }

    /**
     * set the right child of current node
     * @param p node to set as right child
     * @return was the setting successful
     */
    public BstNode<K, E> setRight(BstNode<K, E> p)
    {
        p.parent = this;
        right = p;
        return right;
    }
    /**
     * return parent of left node. 
     * @return parent of left node
     */
    public BstNode<K, E> parent()
    {
        return parent;
    }
    
    /**
     * Check if the current node is a leaf
     * @return is node a leaf   
     */
    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }
}