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
     * Insert a place into the list for that location
     * @param place name of the place to be inserted
     */
    public void insertPlace(String place);
    
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
