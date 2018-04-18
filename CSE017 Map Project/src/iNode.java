

/**
 * @author Evan Hruskar
 * @author Tyler Hogue
 * @version 2018.04.16
 *
 */
public interface iNode<E> {

    /**
     * @return The location of the node (x,y)
     */
    public E getLocation();
    
    /**
     * Set the location of the node container
     * 
     * @param location The new (x,y) location for the node 
     */
    public void setLocation(E location);
    
    /**
     * @return the names of places in an array list of strings
     */
    public ArrayList<E> getPlaces();
    
    /**
     * Insert list of places
     * @param list The list of places to be added
     */
    public void setPlaces(ArrayList<E> list);
    
    /**
     * @return information about the node
     */
     
    public E getData();
    
    /**
     * Stores new data in the node at Point
     * @param data The data to be added to the node
     */
    public void setData(E data);
    
    /**
     * @return String representation of the data and places in
     * the node
     */
    public String toString();
}
