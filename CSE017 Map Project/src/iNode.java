import java.util.ArrayList;

/**
 * @author Evan Hruskar
 * @author Tyler Hogue
 * @version 2018.04.18
 * @param <E> The type of location information to be 
 * stored in the node
 */
public interface iNode<E> {
    
    /**
     * O(1): returns the private Node.list field
     * @return the list of places at this location
     */
    public ArrayList<String> getPlaces();
    
    /**
     * O(1)
     * @param list the list of places to add
     */
    public void setPlaces(ArrayList<String> list);
    
    /**
     * O(1): simply returns the location data field  
     * @return Point data about location (x and y coordinates)
     */
    public E getPoint();
    
    /**
     * O(1): sets location to a new value (if ever necessary)
     * @param point The point data to be associated with the node
     */
    public void setPoint(E point);
    
    /**
     * O(n): needs to traverse entire ArrayList of places to concatenate
     * to "str" and return final result.
     * @return String representation of the data and list of
     * places in the node
     */
    public String toString();
}