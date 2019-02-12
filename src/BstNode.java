/**
 * @author Josh
 * @version 1.6
 *
 * @param <K> Key value of the element.
 * @param <E> Element value of the element.
 */
public class BstNode<K, E>
{
    private K key;
    private E element;
    private BstNode<K, E> left;
    private BstNode<K, E> right;
    private BstNode<K, E> parent;

    // Default Constructor
    public BstNode()
    {
        left = right = parent = null;
    }
    
    /**
     * @param k Key value of the element
     * @param val Element value of the element
     */
    public BstNode(K k, E val)
    {
        left = right = parent = null;
        key = k;
        element = val;
    }

    /**
     * @return Key value
     */
    public K key()
    {
        return key;
    }

    /**
     * @param k New key value
     * @return New key value
     */
    public K setKey(K k)
    {
        return key = k;
    }

    /**
     * @return Element value
     */
    public E element()
    {
        return element;
    }

    /**
     * @param v New element value
     * @return New element value
     */
    public E setElement(E v)
    {
        return element = v;
    }

    /**
     * @return Left node
     */
    public BstNode<K, E> left()
    {
        return left;
    }

    /**
     * @param p Parent node
     * @return Parent node's new left node
     */
    public BstNode<K, E> setLeft(BstNode<K, E> p)
    {
        p.parent = this;
        return left = p;
    }

    /**
     * @return Right node
     */
    public BstNode<K, E> right()
    {
        return right;
    }

    /**
     * @param p Parent node
     * @return Parent node's new right node
     */
    public BstNode<K, E> setRight(BstNode<K, E> p)
    {
        p.parent = this;
        return right = p;
    }

    /**
     * @return Parent node
     */
    public BstNode<K, E> parent()
    {
        return parent;
    }

}