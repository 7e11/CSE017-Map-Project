import java.util.ArrayList;
import student.TestCase;

/**
 * @author Tyler Hogue
 * @version 2018.4.18
 *
 */
public class NodeTest extends TestCase {
    
    private Node<Point> node1;
    private ArrayList<String> list1;
    
    private Node<Point> node2;
    private ArrayList<String> list2;
    
    /**
     * Constructor to build testing framework
     */
    public NodeTest() {
        //empty cpnstructor for sake of Java
    }
    
    /**
     * Set up testing variables
     */
    public void setUp() {
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        node1 = new Node<Point>(new Point(1, 1), list1);
        node2 = new Node<Point>(new Point(2, 2), list2);
    }
    
    /**
     * return the location of the node
     */
    public void testGetPoint() {
        assertEquals("(1, 1)", node1.getPoint().toString());
    }
    
    /**
     * Set the location fo the node
     */
    public void testSetPoint() {
        
    }
}
