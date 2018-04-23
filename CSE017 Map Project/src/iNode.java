import java.util.ArrayList;

/**
 * @author Evan Hruskar 33%
 * @author Cam 33%
 * @author Tyler Hogue 33%
 * @version 2018.04.20
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
     * @param list the list of places to set for this location
     */
    public void setPlaces(ArrayList<String> list);
    
    /**
     * O(1)
     * @return Point data about location (x and y coordinates)
     */
    public E getPoint();
    
    /**
     * O(1)
     * @param point The point data to be associated with the node
     */
    public void setPoint(E point);
    
    /**
     * O(n): Iterate through the entire list and append list into
     * output string using ArrayList's toString()
     * @return String representation of the data and list of
     * places in the node
     */
    public String toString();
}