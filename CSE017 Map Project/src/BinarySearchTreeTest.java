import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.20
 *
 */
public class BinarySearchTreeTest extends TestCase {

    private BinarySearchTree<String> bst;
    
    /**
     * setup the bst.
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        bst = new BinarySearchTree<>();
        bst.insert("O");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        bst.insert("T");
        bst.insert("P");
        bst.insert("W");
    }

    /**
     * Test method for {@link BinarySearchTree#BinarySearchTree()}.
     */
    @Test
    public void testBinarySearchTree() {
        assertNotNull(bst);
    }

    /**
     * Test method for {@link BinarySearchTree#insert(java.lang.Comparable)}.
     */
    @Test
    public void testInsert() {
        //insertions done in setUp()
        assertEquals("O", bst.find("O"));
        assertEquals("E", bst.find("E"));
        assertEquals("D", bst.find("D"));
        
        //cover exception
        try {
            bst.insert("D");
        }
        catch (Exception e) {
            assertTrue(e instanceof DuplicateItemException);
        }
    }

    /**
     * Test method for {@link BinarySearchTree#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemove() {
        //cover exception
        try {
            bst.remove("dragon");
        }
        catch (Exception e) {
            assertTrue(e instanceof ItemNotFoundException);
        }

        //no children removal
        bst.remove("D");
        assertNull(bst.find("D"));
        bst.remove("W");
        assertNull(bst.find("W"));

        //one child removal
        bst.remove("E");
        assertNull(bst.find("E"));
        assertEquals("F", bst.find("F"));
        bst.remove("T");
        assertNull(bst.find("T"));
        assertEquals("P", bst.find("P"));
        
        //recreate tree for two child removal
        bst = new BinarySearchTree<>();
        bst.insert("O");
        bst.insert("E");
        bst.insert("D");
        bst.insert("F");
        bst.insert("T");
        bst.insert("P");
        bst.insert("W");
        
        bst.remove("O");
        assertNull(bst.find("O"));
        //this does work, verified with the debugger
    }

    /**
     * Test method for {@link BinarySearchTree#findMin()}.
     */
    @Test
    public void testFindMin() {
        assertEquals("D", bst.findMin());
        BinarySearchTree<Integer> fakeTree = new BinarySearchTree<>();
        assertNull(fakeTree.findMin());
    }

    /**
     * Test method for {@link BinarySearchTree#findMax()}.
     */
    @Test
    public void testFindMax() {
        assertEquals("W", bst.findMax());
        BinarySearchTree<Integer> fakeTree = new BinarySearchTree<>();
        assertNull(fakeTree.findMax());
    }

    /**
     * Test method for {@link BinarySearchTree#find(java.lang.Comparable)}.
     */
    @Test
    public void testFind() {
        assertNull("baron", bst.find("baron"));
        assertNotNull(bst.find("F"));
    }

    /**
     * Test method for {@link BinarySearchTree#makeEmpty()}.
     */
    @Test
    public void testMakeEmpty() {
        bst.makeEmpty();
        assertTrue(bst.isEmpty());
    }

    /**
     * Test method for {@link BinarySearchTree#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(bst.isEmpty());
        bst.makeEmpty();
        assertTrue(bst.isEmpty());
    }

}
