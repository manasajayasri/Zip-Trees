package edu.uwm.cs351;

/**
 * Interface defining the operations for a tree structure.
 *
 * @param <T> The type of elements stored in the tree, must implement Comparable.
 */

public interface TreeInterface<T extends Comparable<T>> {

	/**
     * Inserts a new node with the specified key into the tree.
     * 
     * @param key The key to insert into the tree.
     */
    public void insert(T key);

    /**
     * Deletes the node with the specified key from the tree, if it exists.
     * 
     * @param key The key of the node to be deleted.
     */    
    public void delete(T key);

    /**
     * Searches for a node with the specified key in the tree.
     * 
     * @param key The key to search for.
     * @return true if the node is found, false otherwise.
     */    
    public boolean search(T key);

    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns the height of the tree.
     * 
     * @return The height of the tree, or 0 if the tree is empty.
     */
    public int getHeight();

    /**
     * Returns the number of nodes in the tree.
     * 
     * @return The size of the tree.
     */
    public int getSize();

}
