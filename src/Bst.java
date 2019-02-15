/** BST implementation for Dictionary ADT */
/**
 * @author Josh Rehm
 * @version 1.6
 *
 * @param <K> Key value of the tree.
 * @param <E> Element value of the tree.
 */
public class Bst<K extends Comparable<? super K>, E>
{
    private BstNode<K, E> root; // Root of BST
    private int nodecount; // Size of BST

    /** Constructor */
    Bst()
    {
        root = null;
        nodecount = 0;
    }

    /**
     * Insert a record into the tree.
     * 
     * @param k Key value of the record.
     * @param e The record to insert.
     */
    public void insert(K k, E e)
    {
        root = inserthelp(root, k, e);
        nodecount++;
    }

    /**
     * @param rt Current node in insert.
     * @param k Key value of the record.
     * @param e The record to insert.
     * @return Returns node inserted
     */
    private BstNode<K, E> inserthelp(BstNode<K, E> rt, K k, E e)
    {
        if (rt == null)
        {
            return new BstNode<K, E>(k, e);
        }
        if (rt.key().compareTo(k) > 0)
        {
            rt.setLeft(inserthelp(rt.left(), k, e));
        } 
        else
        {
            rt.setRight(inserthelp(rt.right(), k, e));
        }
        return rt;
    }

    /**
     * Remove/return root node from dictionary.
     * 
     * @return The record removed, null if empty.
     */
    public E removeAny()
    {
        if (root != null)
        {
            E temp = root.element();
            root = removehelp(root, root.key());
            nodecount--;
            return temp;
        } 
        else
        {
            return null;
        }
    }
    
    /**
     * Remove a record from the tree.
     * 
     * @param k Key value of record to remove.
     * @return Record removed, or null if there is none.
     */
    public E remove(K k)
    {
        E temp = searchhelp(root, k); // find it
        if (temp != null)
        {
            root = removehelp(root, k); // remove it
            nodecount--;
        }
        return temp;
    }
    
    /**
     * Remove a record from the tree.
     * 
     * @param k Key value of record to remove.
     * @param e Element value of record to remove.
     */
    public void remove(K k, E e)
    {
        root = removehelp(root, k, e); // remove it
        nodecount--;
    }

    /**
     * Remove a node with key value k
     * 
     * @return The tree with the node removed
     */
    private BstNode<K, E> removehelp(BstNode<K, E> rt, K k)
    {
        if (rt == null)
        {
            return null;
        }
        if (rt.key().compareTo(k) > 0)
        {
            rt.setLeft(removehelp(rt.left(), k));
        } 
        else if (rt.key().compareTo(k) < 0)
        {
            rt.setRight(removehelp(rt.right(), k));
        } 
        else
        { // Found it, remove it
            
            if (rt.left() == null)
            {
                return rt.right();
            } 
            else if (rt.right() == null)
            {
                return rt.left();
            } 
            else
            { // Two children
                BstNode<K, E> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }
    
    /**
     * Remove a node with key value k
     * 
     * @return The tree with the node removed
     */
    private BstNode<K, E> removehelp(BstNode<K, E> rt, K k, E e)
    {
        if (rt == null)
        {
            return null;
        }
        if (rt.key().compareTo(k) > 0)
        {
            rt.setLeft(removehelp(rt.left(), k, e));
        } 
        else if (rt.key().compareTo(k) < 0)
        {
            rt.setRight(removehelp(rt.right(), k, e));
        }
        else
        { // Found it, remove it
            // Check first node for element for same name
            if (rt.element() != e) {
                rt.setRight(removehelp(rt.right(), k, e));
                return rt;
            }
            if (rt.left() == null)
            {
                return rt.right();
            } 
            else if (rt.right() == null)
            {
                return rt.left();
            } 
            else
            { // Two children
                BstNode<K, E> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }

    /**
     * @return Record with key k, null if none.
     * @param k The key value to find.
     */
    public E search(K k)
    {
        return searchhelp(root, k);
    }

    /**
     * Helper function to facilitate search function
     */
    private E searchhelp(BstNode<K, E> rt, K k)
    {
        if (rt == null)
        {
            return null;
        }
        if (rt.key().compareTo(k) > 0)
        {
            return searchhelp(rt.left(), k);
        } 
        else if (rt.key().compareTo(k) == 0)
        {
            return rt.element();
        } 
        else
        {
            return searchhelp(rt.right(), k);
        }
    }

    /**
     * @return Leftmost node in the tree.
     */
    public BstNode<K, E> getFirst()
    {
        if (root == null)
        {
            return null;
        }
        BstNode<K, E> n = root;
        while (n.left() != null)
        {
            n = n.left();
        }
        return n;
    }

    /**
     * @param n Previous node in iteration
     * @return Current node in iteration.
     */
    public BstNode<K, E> getNext(BstNode<K, E> n)
    {
        if (n.right() != null)
        {
            n = n.right();
            while (n.left() != null)
            {
                n = n.left();
            }
            return n;
        } 
        else
        {
            while (n.parent() != null && n == n.parent().right())
            {
                n = n.parent();
            }
            return n.parent();
        }
    }

    /**
     * dumps the bst to standard out.
     */
    public void dump()
    {
        System.out.println("BST Dump:");
        if (root == null)
        {
            System.out.println("Node has depth 0, Value (null)");
        }
        dumpHelp(root, 0);
        System.out.println("BST size is: " + size());
    }

    /**
     * @param rt Current node in recursion.
     * @param depth Keeps track of tree depth in recursion
     * @return False if starter node is null, otherwise returns true
     */
    private boolean dumpHelp(BstNode<K, E> rt, int depth)
    {
        if (rt == null)
        {
            return false;
        }
        dumpHelp(rt.left(), depth + 1);
        System.out.println("Node has depth " + depth + ", Value "
                + rt.element().toString());
        dumpHelp(rt.right(), depth + 1);
        return true;
    }

    /** @return Number of records in dictionary. */
    public int size()
    {
        return nodecount;
    }

    /**
     * @param rt Starter node
     * @return Minimum value from starting node
     */
    private BstNode<K, E> getmin(BstNode<K, E> rt)
    {
        if (rt.left() == null)
        {
            return rt;
        } 
        else
        {
            return getmin(rt.left());
        }
    }

    /**
     * @param rt Starter node
     * @return Minimum value from starting node
     */
    private BstNode<K, E> deletemin(BstNode<K, E> rt)
    {
        if (rt.left() == null)
        {
            return rt.right();
        } 
        else
        {
            rt.setLeft(deletemin(rt.left()));
            return rt;
        }
    }
}