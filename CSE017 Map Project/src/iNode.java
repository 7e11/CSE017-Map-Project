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
     * @return the list of places at this location
     */
    public ArrayList<String> getPlaces();
    
    /**
     * @param list the list of places to add
     */
    public void setPlaces(ArrayList<String> list);
    
    /**
     * @return Point data about location (x and y coordinates)
     */
     
    public E getPoint();
    
    /**
     * Stores new data in the node at Point
     * @param point The point data to be associated with the node
     */
    public void setPoint(E point);
    
    /**
     * @return String representation of the data and list of
     * places in the node
     */
    public String toString();
}
