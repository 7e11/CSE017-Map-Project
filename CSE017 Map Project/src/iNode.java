/**
 * 
 */

/**
 * @author Evan Hruskar
 * @author Tyler Hogue
 * @version 2018.04.16
 *
 */
public interface iNode<T> {

    /**
     * @return The location of the node (x,y)
     */
    public Point getLocation();
    
    /**
     * Set the location of the node container
     * 
     * @param location The new (x,y) location for the node 
     */
    public void setLocation(Point location);
    
    /*
     * @return the names of places in an array list of strings
     */
    public String[] getPlaces();
    
    /*
     * Insert list of places
     * @param list The list of places to be added
     */
    public void setPlaces(String[] list);
    
    /*
     * @return information about the node
     */
    public T getData();
    
    /*
     * Stores new data in the node at Point
     * @param data The data to be added to the node
     */
    public void setData(T data);
    
    /*
     * @return String representation of the data and places in
     * the node
     */
    public String toString();
}
