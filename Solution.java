import java.util.*;

public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        Node x = root;
       if(key == null){
            throw new IllegalArgumentException("There is not key conatin in the root");
       }
       else{
            while(x.key != key){
                int cmp = key.compareTo(x.key);
                if(cmp < 0){
                    x = x.left;
                }
                else{
                    x = x.right;
                }
            }
            return true;
       }
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(key == null){
            System.out.println("key cannot be null");
        }
        Node x = root;
        while(x.key != key){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }
            else if(cmp > 0){
                x = x.right;
            }
        }
        if(x.key == key){
            System.out.println(x.val);
        }
        return x.val;
    }

    // /**
    //  * Inserts the specified key-value pair into the symbol table, overwriting the old 
    //  * value with the new value if the symbol table already contains the specified key.
    //  * Deletes the specified key (and its associated value) from this symbol table
    //  * if the specified value is {@code null}.
    //  *
    //  * @param  key the key
    //  * @param  val the value
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public void put(Key key, Value val) 
        {
        Node n = new Node(key,val);
        if(root == null){
            root = n;
        }
        else{
            Node x = root;
            Node node;
            while(true){
                node = x;
                int cmp = key.compareTo(x.key);
                if(cmp < 0){
                    x = x.left;
                    if(x == null){
                        node.left = n;
                        size = size + 1;
                        return;
                    }
                    else if(x.key == key){
                        x.val = val;
                        return;
                    }
                }
                else if(cmp > 0){
                    x = x.right;
                    if(x == null){
                        node.right = n;
                        size = size + 1;
                        return;
                    }
                    else if(x.key == key){
                        x.val = val;
                        return;
                    }
                }
            }
        }
        size = size + 1;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node x = root;
            while(x.left != null){
                x = x.left;
            }
            return x.key;
       }
    } 

    public Key max() { 
        if(isEmpty()){
            throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node x = root;
            while(x.right != null){
                x = x.right;
            }
            return x.key;
       }
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key){
        if(isEmpty()){
            System.out.println("key cannot be null");
        }
        Node x = root;
        Node node = null;
        while(x != null){
            node = x;
            int cmp = key.compareTo(node.key);
            if(key == null){
            System.out.println("key cannot be null");
            }
            if(cmp == 0){
                return node.key;
            }
            if(cmp < 0){
                x = node.left;
            }
            else if(cmp > 0){
                x = node.right;
                int cm = key.compareTo(x.key);
                if(cm < 0 ){
                    return node.key;
                }
               else{
                    x = node.right;
                } 
            }
        }
        return node.key;
    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

    //Return key of rank k.
    public Key select(Key key){
        if(isEmpty()){
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node x = root;
        Node node = null;
        while(x != null){
            node = x;
            int cmp = key.compareTo(node.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(cmp > 0){
                x = node.right;
            }
            else if(cmp < 0){
                x = node.left;
                int cm = key.compareTo(node.key);
                if(cm > 0 ){
                    return x.key;
                }
                else{
                    x = node.left;
                } 
            }
        }
        return node.key;
    }
    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public void keys(Key lo, Key hi){
        if(lo == null || hi == null){
            System.out.println("key cannot be null");
        }
        Node x = root;
        Node node;
        while(x != null) {
            node = x;
            if(node == null) { 
                return; 
            } 
            int cmp = lo.compareTo(node.key);
            int cm = hi.compareTo(node.key); 
            if (cmp < 0) { 
                x = node.left;
            }
            if (cmp <= 0 && cm >= 0) { 
                System.out.print(node.key + " "); 
            } 
            if (cm > 0) { 
                x = node.right;
            }
        }
    }
    
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution <String, Integer> obj = new Solution <String, Integer>();
        obj.put("ABDUL",1);
        obj.get("ABDUL");
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        obj.get("SAI");
        obj.put("TASHI",4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select("HRITHIKH"));
        obj.keys("ABDUL","TASHI");
        System.out.println();
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        obj.get("SAMAL");
        obj.put("NIMA",7);
        System.out.println(obj.size());
        obj.get("CHIMI");
        System.out.println(obj.floor("CHIMI"));
        obj.put("SONAM",8);
        obj.keys("ABDUL","TASHI");
    }
}