import java.util.ArrayList;
import student.TestCase;

/**
 * @author Evan 33%
 * @author Cam 33%
 * @author Tyler Hogue 33%
 * @version 2018.4.18
 *
 */
public class NodeTest extends TestCase {
    private Node<Point> node1;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    
    /**
     * Set up testing variables
     */
    public void setUp() {
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        node1 = new Node<Point>(new Point(1, 1), list1);
    }
    
    /**
     * return the location of the node
     */
    public void testGetPoint() {
        assertEquals("(1,1)", node1.getPoint().toString());
    }
    
    /**
     * Set the location for the node
     */
    public void testSetPoint() {
        Point pt = new Point(3, 3);
        
        node1.setPoint(pt);
        
        assertEquals("(3,3)", node1.getPoint().toString());
        
        node1.setPoint(null);
        assertNull(node1.getPoint());
    }
    
    /**
     * Return list of places at location
     */
    public void testGetPlaces() {
        assertEquals(list1, node1.getPlaces());
    }
    
    /**
     * Set list of places at location
     */
    public void testSetPlaces() {
        node1.setPlaces(list2);
        
        assertEquals(list2, node1.getPlaces());
    }
    
    /**
     * Return string representation of location and information at
     * that location
     */
    public void testToString() {
        assertEquals("No places @ (1,1)", node1.toString());
        
        list1.add("Business");
        assertEquals("[Business] @ (1,1)", node1.toString());
        
        list1.add("School");
        assertEquals("[Business, School] @ (1,1)", node1.toString());     

        node1.setPoint(null);
        assertEquals("A location has not been set", node1.toString());
    }
}