import java.util.*;

public class Binary<Key extends Comparable<Key>, Value> 
{
    public Node root;             // root of BST

    private class Node 
    {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) 
        {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Binary() 
    {
         root = null;

    }

    public int size() 
    {
      return size(root); 
    }

    // return number of key-value pairs in BST rooted at x
    public int size(Node x) 
    {
        if (x == null) 
        {
            return 0;
        }
        return x.size;
    }
   
    public Value get(Key key) 
    {
        if (key == null)
        {
            System.out.println("Key cannot be null");
        }
        return get(root,key);
        
        
    }

    public Value get(Node x, Key key) 
    {
        if(x==null)
        {
            return null;
        }
        int cmp = key.compareTo(x.key);
        while(x!=null){
            if(cmp < 0)
        {
            return get(x.left, key);
        }
        else if (cmp > 0)
        {
            return get(x.right, key);
        }
       else
        {
            return x.val;
        }
    }
    return  null;
        
}

  
    public void put(Key key, Value val) 
    {
        if(key == null)
        {
            System.out.println("Key cannot be null");
        }
        root = put(root, key, val);  
    }
    public Node put(Node x, Key key, Value val) 
    {
        if (x == null)
        {
            x = new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
            x.left = put(x.left, key, val);
            //x.size++;
        }
        else if(cmp > 0)
        {
            x.right = put(x.right, key, val);
            //x.size++;
        }
        else
        {
            val=x.val;
        }
        //x.size++;
        x.size = size(x.left)+size(x.right)+1;
        return x;
    }

   
    public Key min() 
    {
       if(size()==0)
       {
        System.out.println("Empty");
       }
       return min(root).key;
    } 
    public Node min(Node x) 
    { 
       if (x.left == null)
        {
            return x;
        }
        return min(x.left);  
    }
    public Key max(){
        return max(root).key;
    }
    public Node max(Node x){
        if (x.right == null){
            return x;
        }
        return max(x.right);
    }
   
    public Key floor(Key key) 
    {
        Node y = floor(root,key);
        if(y == null)
        {
            throw new IllegalArgumentException ("The node is empty");
        }
        return y.key;
    } 

    public Node floor(Node x, Key key) 
    {
        if (x == null) 
        {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) 
        {
            return x;
        }
        if (cmp < 0) 
        {
            return floor(x.left, key);
        }
        Node a = floor(x.right, key);
        if (a != null) 
        {
            return a;
        }
        else return x;
    //     return null;
       
    } 
   
    public Key select(int k) 
    {
        return select(root, k).key;
    }

    // // Return key of rank k. 
    public Node select(Node x, int k) 
    {
        if(x == null)
        {
            return null;
        }
        int t = size(x.left);
        if (t>k) 
        {
            return select(x.left, k);
        }
        else if(t < k)
        {
            return select(x.right, k-t-1);
        }
        else
        {
            return x;
        }          
    } 
    
    public Iterable<Key> keys()
    {
         return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi) 
    {
       
        ArrayList<Key> array = new ArrayList<Key>();
        keys(root, array, lo, hi);
        return array;
    } 

    public void keys(Node x,ArrayList<Key> array, Key lo, Key hi) 
    { 
        if (x == null) return;
        int cop = lo.compareTo(x.key);
        int cmp = hi.compareTo(x.key);
        if (cop < 0) keys(x.left, array, lo, hi);
        if (cop <= 0 && cmp >= 0) array.add(x.key);
        if (cmp > 0) keys(x.right, array, lo, hi);
    } 
   
   
}
