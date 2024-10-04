import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs351.ZIPTree;
import edu.uwm.cs351.AVLTree;
import edu.uwm.cs351.TreeInterface;

import static org.junit.Assert.*;

public class TestEfficiency {
    private static final int POWER = 20;
    private static final int MAX = 1 << POWER;
    private static final int TESTS = MAX / POWER;

    private TreeInterface<Integer> zipTree,avlTree;
    private Integer[] items;
    private Random random;

    @Before
    public void setUp() {
    	avlTree = new AVLTree<>();
    	zipTree = new ZIPTree<>();
        items = new Integer[MAX];
        random = new Random();

        for (int i = 0; i < MAX; i++) {
            items[i] = i;
        }

        // Randomly insert items into the Zip Tree and Avl Tree
        for (int i = 0; i < MAX; i++) {
            int index = random.nextInt(MAX - i);
            zipTree.insert(items[index]);
            avlTree.insert(items[index]);
            items[index] = items[MAX - i - 1];
        }
    }

    @Test
    public void testSearchZIP() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            assertTrue(zipTree.search(items[index]));
        }
    }

    @Test
    public void testSearchAVL() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            assertTrue(avlTree.search(items[index]));
        }
    }

    
    @Test
    public void testInsertZIP() {
        for (int i = 0; i < TESTS; i++) {
            int newItem = MAX + i;
            zipTree.insert(newItem);
            assertTrue(zipTree.search(newItem));
        }
    }
    
    @Test
    public void testInsertAVL() {
        for (int i = 0; i < TESTS; i++) {
            int newItem = MAX + i;
            avlTree.insert(newItem);
            assertTrue(avlTree.search(newItem));
        }
    }

    @Test
    public void testDeleteZIP() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            zipTree.delete(items[index]);
            assertFalse(zipTree.search(items[index]));
        }
    }
    
    

    @Test
    public void testDeleteAVL() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            avlTree.delete(items[index]);
            assertFalse(avlTree.search(items[index]));
        }
    }
    

    @Test
    public void testSize() {
        assertEquals(MAX, zipTree.getSize());
    }
}