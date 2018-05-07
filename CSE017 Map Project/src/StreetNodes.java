import java.util.ArrayList;

/**
 * @author Maxime Martin
 * 
 */
public class StreetNodes {
    
    private String streetName;
    private ArrayList<Node<Point>> locationStreet;
    
    /**
     * 
     * @param street
     */
    public StreetNodes(String street) {
        this.streetName=street;
        locationStreet = new ArrayList<Node<Point>>();
    }
    
    /**
     * @return streetName, it is just the
     * getter method for the streetName field
     * O(1)
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * 
     * @param streetName it is just the
     * setter method for the streetName field
     * O(1)
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * 
     * @return locationStreet, it is just the
     * getter method for the streetName field
     * O(1)
     */
    public ArrayList<Node<Point>>  getLocationStreet() {
        return locationStreet;
    }
    /**
     * 
     * @param locationStreet it is just the
     * setter method for the streetName field
     * O(1)
     */
    public void setLocationStreet(ArrayList<Node<Point>>  locationStreet) {
        this.locationStreet = locationStreet;
    }
    /**
     * 
     * @param o
     * @return an integer, 0 if they are the same name
     * and 1 if they are different 
     * O(1)
     */
    public int compareTo(StreetNodes o) {
        if(o.getStreetName() == this.streetName) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    /**
     * @param n
     * @return location street
     * O(1)
     */
    public boolean addPoint(Node<Point> n) {
        return locationStreet.add(n);
}   
    /**
     * @return streetName
     * prints a string representation of
     * then street name
     */
    public String toString() {
        String str = streetName + " " + locationStreet.toString();
        return str;
    }
}