import java.util.ArrayList;

/**
 * @author Maxime Martin
 * 
 */
public class StreetNodes implements Comparable<StreetNodes> {

    private String name; // it's implied that it's a street name
    private ArrayList<Node<Point>> locations; // same with locations.

    /**
     * 
     * @param street
     *            name of street
     */
    public StreetNodes(String street) {
        this.name = street;
        locations = new ArrayList<Node<Point>>();
    }

    /**
     * @return streetName, it is just the getter method for the streetName field
     *         O(1)
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            it is just the setter method for the streetName field O(1)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return locationStreet, it is just the getter method for the streetName field
     *         O(1)
     */
    public ArrayList<Node<Point>> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *            it is just the setter method for the streetName field O(1)
     */
    public void setLocations(ArrayList<Node<Point>> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @param o
     * @return an integer, 0 if they are the same name and 1 if they are different
     *         O(1)
     */
    public int compareTo(StreetNodes o) {
        // the previous implementation of compareTo was incorrect.
        return name.compareTo(o.name);
        // only compare street names
    }

    /**
     * @param n
     * @return location street O(1)
     */
    public boolean addPoint(Node<Point> n) {
        return locations.add(n);
    }

    /**
     * @return streetName prints a string representation of then street name
     */
    public String toString() {
        return name + " " + locations.toString();
    }
}
