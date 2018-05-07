import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * @author Maxime Martin
 *
 */
public class StreetNodesTest extends TestCase {
    
    private StreetNodes bst1;
    private StreetNodes bst2;
    private Node<Point> nd1;
    private Point point1;
    private Point point2;
    private ArrayList<Node<Point>> location1;
    private ArrayList<String> descriptions1;
    
    /**
     * This is the setup method
     */
    public void setUp() {
        
        bst1 = new StreetNodes("rien");
        bst2 = new StreetNodes("prout");
        descriptions1 = new ArrayList<String>();
        descriptions1.add("La petite cuisine");
        point1 = new Point(1,1);
        point2 = new Point(-1,-1);
        nd1 = new Node(point1, descriptions1);
        location1 = new ArrayList<Node<Point>>();
    }

    /**
     * this is the test method for
     * getStreetName
     */
    public void testGetStreetName() {
        bst1.setStreetName("frites");
        assertEquals("frites", bst1.getStreetName());
    }
    
    /**
     * this is the test method for
     * setStreetName
     */
    public void testSetStreetName() {
        bst1.setStreetName("frites");
        assertEquals("frites", bst1.getStreetName());
    }
    
    /**
     * this is the test method
     * for getLocationStreet
     */
    public void testGetLocationStreet() {
        bst1.setLocationStreet(location1);
        assertEquals("[]", bst1.getLocationStreet().toString());
    }
    
    /**
     * This is the test method for
     * the setLocationStreet
     */
    public void testSetLocationStreet() {
        nd1.setPoint(point1);
        assertEquals("(1,1)",nd1.getPoint().toString());
        nd1.setPoint(point2);
        assertEquals("(-1,-1)",nd1.getPoint().toString());
    }
    
    /**
     * This is the test method
     * for the CompareTo method
     */
    public void testCompareTo() {
        bst1.setStreetName("Macron macaron");
        bst2.setStreetName("Sarkozi au lit");
        bst2.setStreetName("Hollande tient une amende");
        assertEquals(1, bst1.compareTo(bst2));
        bst2.setStreetName("Macron macaron");
        assertEquals(0, bst1.compareTo(bst2));
        
    }
    
    /**
     * this is the test method for
     * toString method
     */
    public void testToString() {
        assertEquals("rien []", bst1.toString());
    }
    
    /**
     * This is the test method for add point
     */
    public void testAddPoint() {
        bst1.addPoint(nd1);
        assertEquals("rien [[La petite cuisine] @ (1,1)]", bst1.toString());
    }
}