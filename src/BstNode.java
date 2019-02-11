public class BstNode<K, E>
{
    private K key;
    private E element;
    private BstNode<K, E> left;
    private BstNode<K, E> right;
    private BstNode<K, E> parent;

    public BstNode()
    {
        left = right = parent = null;
    }

    public BstNode(K k, E val)
    {
        left = right = parent = null;
        key = k;
        element = val;
    }

    public BstNode(K k, E val, BstNode<K, E> l, BstNode<K, E> r)
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

    public BstNode<K, E> left()
    {
        return left;
    }

    public BstNode<K, E> setLeft(BstNode<K, E> p)
    {
        p.parent = this;
        return left = p;
    }

    public BstNode<K, E> right()
    {
        return right;
    }

    public BstNode<K, E> setRight(BstNode<K, E> p)
    {
        p.parent = this;
        return right = p;
    }

    public BstNode<K, E> parent()
    {
        return parent;
    }

    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }
}