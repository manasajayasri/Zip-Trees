import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.AVLTree;

public class AVLTreeTest {
	
    AVLTree<Integer> tree = new AVLTree<>();
    
    // testing empty AVL tree
    @Test
    public void testEmptyTree01() {
        assertTrue(tree.isEmpty()); 
    }

    @Test
    public void testEmptyTree02() {
        assertEquals(0, tree.getSize()); 
    }

    @Test
    public void testEmptyTree03() {
        assertFalse(tree.search(10)); 
    }

    @Test
    public void testEmptyTree04() {
    	assertEquals(0, tree.getHeight()); 
    }

    @Test
    public void testEmptyTree05() {
        tree.delete(5);
        assertTrue(tree.isEmpty());
    }

    // testing insert method
	@Test
    public void testInsert1() {
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        assertEquals(3, tree.getSize());
    }
	
	@Test
    public void testInsert2() {
        tree.insert(10);
        tree.insert(10);
        assertEquals(2, tree.getSize()); 
    }
	@Test
	public void testInsert3() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        tree.insert(null);
	    });
	    assertTrue(tree.isEmpty());
	}

	@Test
	public void testInsert4() {
	    tree.insert(5);
	    assertEquals(1, tree.getSize());
	}

	@Test
	public void testInsert5() {
	    tree.insert(Integer.MAX_VALUE);
	    assertEquals(1, tree.getSize());
	    assertTrue(tree.search(Integer.MAX_VALUE));
	}

	@Test
	public void testInsert6() {
	    tree.insert(Integer.MIN_VALUE);
	    assertEquals(1, tree.getSize());
	    assertTrue(tree.search(Integer.MIN_VALUE));
	}

	@Test
	public void testInsert7() {
	    for (int i = 0; i < 1000; i++) {
	        tree.insert(i);
	    }
	    assertEquals(1000, tree.getSize());
	    for (int i = 0; i < 1000; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testInsert8() {
	    for (int i = 10; i > 0; i--) {
	        tree.insert(i);
	    }
	    assertEquals(10, tree.getSize());
	    for (int i = 1; i <= 10; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testInsert9() {
	    for (int i = 1; i <= 10; i++) {
	        tree.insert(i);
	    }
	    assertEquals(10, tree.getSize());
	    for (int i = 1; i <= 10; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testInsert10() {
	    for (int i = 0; i > -10; i--) {
	        tree.insert(i);
	    }
	    assertEquals(10, tree.getSize());
	    for (int i = -9; i < 0; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testInsert11() {
	    tree.insert(5);
	    tree.insert(5);
	    tree.insert(5);
	    assertEquals(3, tree.getSize());
	    assertTrue(tree.search(5));
	}

	@Test
	public void testInsert12() {
	    tree.insert(3);
	    tree.insert(2);
	    tree.insert(1);
	    assertEquals(3, tree.getSize());
	    assertTrue(tree.search(1));
	    assertTrue(tree.search(2));
	    assertTrue(tree.search(3));
	}
	
	// testing search
	@Test
	public void testSearch1() {
	    assertFalse(tree.search(10));
	}

	@Test
	public void testSearch2() {
	    tree.insert(5);
	    assertTrue(tree.search(5));
	}

	@Test
	public void testSearch3() {
	    tree.insert(5);
	    assertFalse(tree.search(10));
	}
	
	@Test
    public void testSearch4() {
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        assertTrue(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
        assertFalse(tree.search(20)); // Not inserted
    }
	
	@Test
    public void testSearch5() {
        int[] values = {5, 15, 25, 35, 65, 75};		//In a Complex Tree
        for (int value : values) {
            tree.insert(value);
        }
        for (int value : values) {
            assertTrue("Failed to find " + value, tree.search(value));
        }
        assertFalse(tree.search(0));
        assertFalse(tree.search(40));
        assertFalse(tree.search(80));
    }

	@Test
	public void testSearch6() {
	    for (int i = 10; i > 0; i--) {
	        tree.insert(i);
	    }
	    for (int i = 1; i <= 10; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testSearch7() {
	    for (int i = 1; i <= 10; i++) {
	        tree.insert(i);
	    }
	    for (int i = 1; i <= 10; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testSearch8() {
	    for (int i = 0; i < 1000; i++) {
	        tree.insert(i);
	    }
	    for (int i = 0; i < 1000; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testSearch9() {
	    for (int i = 0; i > -10; i--) {
	        tree.insert(i);
	    }
	    for (int i = -9; i < 0; i++) {
	        assertTrue(tree.search(i));
	    }
	}

	@Test
	public void testSearch10() {
	    tree.insert(5);
	    tree.insert(5);
	    assertTrue(tree.search(5));
	}

	@Test
	public void testSearch12() {
	    assertFalse(tree.search(null));
	}

	//testing AVL Delete
	
    @Test
    public void testDelete1() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.delete(70);
        assertEquals(2, tree.getSize());
        assertFalse(tree.search(70));
    }
    
    @Test
    public void testDelete2() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.delete(30);
        assertEquals(6, tree.getSize());
        assertFalse(tree.search(30));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }
    
    @Test
    public void testInsertAndSearchNegativeNumbers() {
        tree.insert(-5);
        tree.insert(-10);
        assertTrue(tree.search(-5));
        assertTrue(tree.search(-10));
    }
    
    @Test
    public void testDeleteNegativeNumbers() {
        tree.insert(-5);
        tree.insert(-5);
        tree.delete(-5); 
        assertTrue(tree.search(-5)); 
        tree.delete(-5); 
        assertFalse(tree.search(-5));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.delete(30); 
        assertEquals(6, tree.getSize());
        assertFalse(tree.search(30));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }
    
    @Test
    public void testDeleteNodeWithTwoChildrenNoBalancing() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.delete(70); 
        assertEquals(6, tree.getSize());
        assertFalse(tree.search(70));
        assertTrue(tree.search(60));
        assertTrue(tree.search(80));
    }
    
    @Test
    public void testDeleteRootNodeWithTwoChildren() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.delete(50); 
        assertEquals(6, tree.getSize());
        assertFalse(tree.search(50));
        assertTrue(tree.search(60));
        assertTrue(tree.search(70));
    }
    

    @Test
    public void testDeleteNonExistentNode() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.delete(80); 
        assertEquals(3, tree.getSize());
        assertTrue(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
    }
    
 
    @Test
    public void testDeleteFromEmptyTree() {
        tree.delete(10); 
        assertEquals(0, tree.getSize());
        assertFalse(tree.search(10));
    }
    
    @Test
    public void testDeleteOnlyNode() {
        tree.insert(10);
        tree.delete(10); 
        assertEquals(0, tree.getSize());
        assertFalse(tree.search(10));
    }

 
}