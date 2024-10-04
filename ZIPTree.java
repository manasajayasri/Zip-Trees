package edu.uwm.cs351;

import java.util.Random;

public class ZIPTree<T extends Comparable<T>> implements TreeInterface<T> {

    private ZipNode<T> root;
    private Random randomGenerator; 
    
    private static class ZipNode<DataT> {
        DataT key;
        ZipNode<DataT> left, right;
        int rank;

        ZipNode(DataT key, int rank) {
            this.key = key;
            this.rank = rank;
        }
    }
    
    public ZIPTree() {
        this.root = null;
        this.randomGenerator = new Random();
    }

    @Override
    public void insert(T key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = insertRecursive(root, key);
    }
    
    private ZipNode<T> insertRecursive(ZipNode<T> node, T key) {
        if (node == null) {
            return new ZipNode<>(key, generateGeometricRank());
        }
        
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, key);
        } else {
            // Duplicate keys are not allowed; handle as needed
            return node;
        }
        
        // Maintain the heap property by rank
        if (node.left != null && node.left.rank > node.rank) {
            node = rotateRight(node);
        }
        if (node.right != null && node.right.rank > node.rank) {
            node = rotateLeft(node);
        }
        return node;
    }

    private ZipNode<T> rotateRight(ZipNode<T> node) {
        ZipNode<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    private ZipNode<T> rotateLeft(ZipNode<T> node) {
        ZipNode<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    @Override
    public void delete(T key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = deleteRecursive(root, key);
    }

    private ZipNode<T> deleteRecursive(ZipNode<T> node, T key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            if (node.left.rank > node.right.rank) {
                node = rotateRight(node);
                node.right = deleteRecursive(node.right, key);
            } else {
                node = rotateLeft(node);
                node.left = deleteRecursive(node.left, key);
            }
        }
        return node;
    }

    public int generateGeometricRank() {
        double p = 0.5;
        return (int) Math.ceil(Math.log(1 - randomGenerator.nextDouble()) / Math.log(1 - p));
    }

    @Override
    public boolean search(T key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        ZipNode<T> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(ZipNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightHelper(node.left);
        int rightHeight = getHeightHelper(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int getSize() {
        return getSizeHelper(root);
    }

    private int getSizeHelper(ZipNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeHelper(node.left) + getSizeHelper(node.right);
    }
}
