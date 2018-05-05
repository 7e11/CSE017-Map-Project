import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * @author Evan Hruskar 33%
 * @author Cam 33%
 * @author Tyler 33%
 * @version 2018.04.19
 */
public class QuadTest extends TestCase {
    private Quad map;

    /* (non-Javadoc)
     * @see student.TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        map = new Quad(new Point(0, 0), new Point(5, 5));
    }

    /**
     * Test method for {@link Quad#Quad(Point, Point)}.
     */
    @Test
    public void testQuad() {
        //no getters and setters for topLeft and botRight
        //just check if it's null
        assertNotNull(map);
    }

    /**
     * Test method for {@link Quad#inQuad(Point)}.
     */
    @Test
    public void testInQuad() {
        //obviously on the map
        assertTrue(map.inQuad(new Point(2, 2)));
        //bottom right corner
        assertTrue(map.inQuad(new Point(5, 5)));
        //top right corner
        assertTrue(map.inQuad(new Point(0, 0)));
        
        //fail topLeft X check
        assertFalse(map.inQuad(new Point(-1, 0)));
        //fail topLeft Y check
        assertFalse(map.inQuad(new Point(0, -1)));
        //fail botRight x check
        assertFalse(map.inQuad(new Point(6, 5)));
        //fail botRight y check
        assertFalse(map.inQuad(new Point(5, 6)));
    }

    /**
     * Test method for {@link Quad#insert(int, int, java.lang.String)}.
     */
    @Test
    public void testInsertIntIntString() {
        //topLeft insert
        map.insert(0, 0, "baron");
        assertTrue(map.search(0, 0).getPlaces().contains("baron"));
        map.insert(0, 0, "ahri");
        assertTrue(map.search(0, 0).getPlaces().contains("ahri"));
        //top Right insert
        map.insert(5, 0, "dragon");
        assertTrue(map.search(5, 0).getPlaces().contains("dragon"));
        map.insert(5, 0, "leona");
        assertTrue(map.search(5, 0).getPlaces().contains("leona"));
        //botLeft insert
        map.insert(0, 5, "tower");
        assertTrue(map.search(0, 5).getPlaces().contains("tower"));
        map.insert(0, 5, "jinx");
        assertTrue(map.search(0, 5).getPlaces().contains("jinx"));
        //botRight insert
        map.insert(5, 5, "nexus");
        assertTrue(map.search(5, 5).getPlaces().contains("nexus"));
        map.insert(5, 5, "janna");
        assertTrue(map.search(5, 5).getPlaces().contains("janna"));
        
        //do some midsection inserts
        //topLeft (kind of) insert
        map.insert(2, 1, "inhibitor");
        assertTrue(map.search(2, 1).getPlaces().contains("inhibitor"));
        //topRight ish insert
        map.insert(3, 2, "blue");
        assertTrue(map.search(3, 2).getPlaces().contains("blue"));
        //botLeft ish insert
        map.insert(1, 4, "red");
        assertTrue(map.search(1, 4).getPlaces().contains("red"));
        //botRight ish insert
        map.insert(3, 5, "scuttle");
        assertTrue(map.search(3, 5).getPlaces().contains("scuttle")); 
    }
    
    /**
     * Test method for {@link Quad#insert(Node)}.
     */
    @Test
    public void testInsertNodeOfPoint() {
        //just a few coverage tests.
        Quad mapCopy = new Quad(new Point(0, 0), new Point(5, 5));
        mapCopy.insert(null);
        ArrayList<String> dummyStringArray = new ArrayList<String>();
        dummyStringArray.add("wont work");
        Node<Point> dummyNode = new Node<Point>(new Point(-4, -4), dummyStringArray);
        mapCopy.insert(dummyNode);
        assertNotNull(mapCopy);
        //not the greatest way of testing this.
        //however, I'm not sure how to test things which do nothing
        //if they work correctly, WIHTOUT implementing .equals().
    }

    /**
     * Test method for {@link Quad#search(int, int)}.
     */
    @Test
    public void testSearchIntInt() {
        assertNull(map.search(-5, -5));
        assertNull(map.search(0, 0));
        assertNull(map.search(0, 5));
        assertNull(map.search(5, 0));
        assertNull(map.search(5, 5));
        
        map.insert(3, 2, "blue");
        assertTrue(map.search(3, 2).getPlaces().contains("blue"));
    }

    /**
     * Test method for {@link Quad#search(java.lang.String)}.
     */
    @Test
    public void testSearchString() {
        map.insert(0, 0, "baron");
        map.insert(0, 0, "baron");
        //top Right insert
        map.insert(5, 0, "dragon");
        map.insert(5, 0, "leona");
        //botLeft insert
        map.insert(0, 5, "tower");
        map.insert(0, 5, "jinx");
        //botRight insert
        map.insert(5, 5, "baron");
        map.insert(5, 5, "janna");
        
        ArrayList<Node<Point>> check = new ArrayList<Node<Point>>();
        ArrayList<String> places1 = new ArrayList<String>();
        places1.add("baron");
        places1.add("baron");
        check.add(new Node<Point>(new Point(0, 0), places1));
        ArrayList<String> places2 = new ArrayList<String>();
        places2.add("baron");
        places2.add("janna");
        check.add(new Node<Point>(new Point(5, 5), places2));
        
        //assertEquals(check, map.search("baron"));
        //expected:<[(0,0) - [baron, baron], (5,5) - [baron, janna]]> 
        //but was: <[(0,0) - [baron, baron], (5,5) - [baron, janna]]>
        //probably b/c node doesn't have a .equals()
        //but it does have a toString() !
        assertEquals(check.toString(), map.search("baron").toString());
    }
    
    /**
     * 
     */
    @Test
    public void testInsertIntIntStringStringArray() {
        
    }
    
    /**
     * 
     */
    @Test
    public void testStreetSearchString() {
        map.insert(0, 0, "center", "river", "midlane");
        assertEquals(1, map.streetSearch("river").size()); //one location on street
        assertEquals(1, map.streetSearch("midlane").size());
        assertEquals(0, map.streetSearch("doesntexist").size());
    }
    
    /**
     * 
     */
    @Test
    public void testStreetSearchStringString() {
        map.insert(0, 0, "scuttle", "river");
        map.insert(1, 1, "baron", "river");
        map.insert(2, 2, "dragon", "river");
        assertEquals(1, map.streetSearch("river", "scuttle").size());
        assertEquals(0, map.streetSearch("river", "red").size());
    }
    
    /**
     * 
     */
    @Test
    public void testStreetSearchIntIntStringString() {
        map.insert(0, 0, "scuttle", "river");
        map.insert(0, 0, "ahri", "river"); //adds second place to same location
        //this is vital because otherwise it would be difficult to differentiate the nodes
        //if they all had just one shared place.
        map.insert(1, 1, "baron", "river");
        map.insert(1, 1, "ahri", "river");
        
        map.insert(4, 4, "dragon", "river");
        map.insert(4, 4, "ahri", "river");
        //desired order with (1,2): baron, scuttle, dragon
        ArrayList<Node<Point>> sortedDist = map.streetSearch(1, 2, "river", "ahri");
        assertTrue(sortedDist.get(0).getPlaces().contains("baron"));
        assertTrue(sortedDist.get(1).getPlaces().contains("scuttle"));
        assertTrue(sortedDist.get(2).getPlaces().contains("dragon"));
    }
}
