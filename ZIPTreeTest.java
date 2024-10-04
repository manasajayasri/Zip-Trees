import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.ZIPTree;


public class ZIPTreeTest {
	
    ZIPTree<Integer> tree = new ZIPTree<>();
    
    // testing empty ZIPTree
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
    
    // insert tests
    @Test
    public void testInsert0() {
        tree.insert(5);
        assertTrue(tree.search(5));
    }

    @Test
    public void testInsert1() {
        for (int i = 10; i > 0; i--) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert2() {
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert3() {
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert4() {
        for (int i = 0; i > -10; i--) {
            tree.insert(i);
        }
        for (int i = -9; i < 0; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert5() {
        assertThrows(IllegalArgumentException.class, () -> {
            tree.insert(null);
        });
    }
    
    @Test
    public void testInsert6() {
        tree.insert(0);
        assertTrue(tree.search(0));
    }

    @Test
    public void testInsert7() {
        for (int i = -5; i <= 5; i++) {
            tree.insert(i);
        }
        for (int i = -5; i <= 5; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert8() {
        for (int i = 0; i < 100; i+=2) {
            tree.insert(i);
        }
        for (int i = 0; i < 100; i+=2) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert9() {
        for (int i = -100; i <= 100; i+=10) {
            tree.insert(i);
        }
        for (int i = -100; i <= 100; i+=10) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert10() {
        for (int i = 1000; i > 0; i-=100) {
            tree.insert(i);
        }
        for (int i = 1000; i > 0; i-=100) {
            assertTrue(tree.search(i));
        }
    }
    
    @Test
    public void testInsertAndSearchNegativeNumbers() {
        tree.insert(-5);
        tree.insert(-10);
        assertTrue(tree.search(-5));
        assertTrue(tree.search(-10));
    }
    
    //Testing ZIPTree Search 
    
    @Test
    public void testSearch1() {
        assertFalse(tree.search(10));
    }

    @Test
    public void testSearch2() {
        tree.insert(15);
        assertTrue(tree.search(15));
    }

    @Test
    public void testSearch3() {
        tree.insert(15);
        assertFalse(tree.search(10));
    }

    @Test
    public void testSearch4() {
        int[] values = {20, 10, 30, 25, 5};
        for (int value : values) {
            tree.insert(value);
        }
        for (int value : values) {
            assertTrue(tree.search(value));
        }
        assertFalse(tree.search(40));
    }

    @Test
    public void testSearch5() {
        for (int i = 0; i < 100; i++) {
            tree.insert(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(tree.search(i));
        }
        assertFalse(tree.search(101));
        assertFalse(tree.search(-1));
    }

    //Testing ZIPTree Delete 

    @Test
    public void testDelete1() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.delete(10);
        assertFalse(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
        tree.insert(20);
        assertTrue(tree.search(20));
    }

    @Test
    public void testDelete2() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        tree.delete(25); 

        assertEquals(3, tree.getSize());
        assertTrue(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
    }

    @Test
    public void testDelete3() {
        tree.insert(-5);
        tree.insert(-10);
        tree.delete(-10); 
        assertFalse(tree.search(-10)); 
        tree.insert(-15);
        assertTrue(tree.search(-15)); 
    }
    
    @Test
    public void testDelete4() {
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.delete(20);
        assertFalse(tree.search(20));
        assertTrue(tree.search(15));
        assertTrue(tree.search(10));
    }
    
    @Test
    public void testDelete5() {
        tree.insert(25);
        tree.insert(20);
        tree.insert(30);
        tree.delete(30);
        assertFalse(tree.search(30));
        assertTrue(tree.search(25));
        assertTrue(tree.search(20));
    }
    
    @Test
    public void testDelete6() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(25);
        tree.insert(75);
        tree.insert(125);
        tree.insert(175);

        tree.delete(50);

        assertEquals(6, tree.getSize());
        assertFalse(tree.search(50));
        assertTrue(tree.search(100));
        assertTrue(tree.search(150));
        assertTrue(tree.search(25));
        assertTrue(tree.search(75));
        assertTrue(tree.search(125));
        assertTrue(tree.search(175));
    }   
    
    @Test
    public void testDelete7() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        tree.delete(10);

        assertEquals(6, tree.getSize());
        assertFalse(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
        assertTrue(tree.search(3));
        assertTrue(tree.search(7));
        assertTrue(tree.search(12));
        assertTrue(tree.search(17));
    }
    
    @Test
    public void testDelete8() {
        tree.insert(70);
        tree.insert(50);
        tree.insert(80);
        tree.insert(40);
        tree.insert(60);
        tree.insert(75);
        tree.insert(90);

        tree.delete(70);

        assertEquals(6, tree.getSize());
        assertFalse(tree.search(70));
        assertTrue(tree.search(50));
        assertTrue(tree.search(80));
        assertTrue(tree.search(40));
        assertTrue(tree.search(60));
        assertTrue(tree.search(75));
        assertTrue(tree.search(90));
    }


    @Test
    public void testDelete9() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        tree.delete(12);

        assertEquals(6, tree.getSize());
        assertFalse(tree.search(12));
        assertTrue(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
        assertTrue(tree.search(3));
        assertTrue(tree.search(7));
        assertTrue(tree.search(17));
    }

    @Test
    public void testDelete10() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        tree.delete(5);

        assertEquals(2, tree.getSize());
        assertFalse(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
    }
    
    @Test
    public void testDelete11() {
        tree.insert(200);
        tree.insert(150);
        tree.insert(250);

        tree.delete(150);

        assertEquals(2, tree.getSize());
        assertFalse(tree.search(150));
        assertTrue(tree.search(200));
        assertTrue(tree.search(250));
    }

    @Test
    public void testDelete12() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        tree.delete(20); 

        assertEquals(3, tree.getSize());
        assertTrue(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
    }
    
    @Test
    public void testDelete13() {
        tree.insert(80);
        tree.insert(60);
        tree.insert(90);

        tree.delete(75); 

        assertEquals(3, tree.getSize());
        assertTrue(tree.search(80));
        assertTrue(tree.search(60));
        assertTrue(tree.search(90));
    }
    
    @Test
    public void testDelete14() {
        tree.insert(10);
        tree.delete(10);
        assertFalse(tree.search(10));
        assertTrue(tree.isEmpty());
    }
    
    @Test
    public void testDeleteFromEmptyTree() {
        tree.delete(5);
        assertFalse(tree.search(5));
    }
    
    @Test
    public void testInsertAndDeleteMultipleValues2() {
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);

        assertEquals(7, tree.getSize());
        assertTrue(tree.search(30));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
        assertTrue(tree.search(10));
        assertTrue(tree.search(25));
        assertTrue(tree.search(35));
        assertTrue(tree.search(45));

        tree.delete(30);
        tree.delete(10);
        tree.delete(45);

        assertEquals(4, tree.getSize());
        assertFalse(tree.search(30));
        assertFalse(tree.search(10));
        assertFalse(tree.search(45));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
        assertTrue(tree.search(25));
        assertTrue(tree.search(35));
    }
    
    @Test
    public void testInsertAndDeleteMultipleValues() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        assertEquals(7, tree.getSize());
        assertTrue(tree.search(10));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
        assertTrue(tree.search(3));
        assertTrue(tree.search(7));
        assertTrue(tree.search(12));
        assertTrue(tree.search(17));

        tree.delete(10);
        tree.delete(3);
        tree.delete(17);

        assertEquals(4, tree.getSize());
        assertFalse(tree.search(10));
        assertFalse(tree.search(3));
        assertFalse(tree.search(17));
        assertTrue(tree.search(5));
        assertTrue(tree.search(15));
        assertTrue(tree.search(7));
        assertTrue(tree.search(12));
    }
    
    @Test
    public void testAverageRank() {
        int numInsertions = 10000;
        double totalRank = 0;
        for (int i = 0; i < numInsertions; i++) {
            totalRank += tree.generateGeometricRank();
        }
        double averageRank = totalRank / numInsertions;
        assertTrue(Math.abs(averageRank - 2) < 0.1);
    }



}
