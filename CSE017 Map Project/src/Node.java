import java.util.ArrayList;

//import map.Node;
 //import map;

/**
 * @author Evan Hruskar 33%
 * @author Cam 33%
 * @author Tyler Hogue 33%
 * @version 2018.04.20
 * @param <E> a generic, in this case will be Point
 */
public class Node<E> implements iNode<E> {
    private E data;
    private ArrayList<String> list;
    private double distance; 
    private ArrayList<String> adjacentStreet;
    //These are the new added data field( dstance and adjStreet)
    
    /**
     * O(1)
     * @param data the information describing the location (coordinate)
     * @param list the list of places that can be explored at the 
     * specified location
     */
    public Node(E data, ArrayList<String> list) {
        this.data = data;
        this.list = list;
        this.setDistance(0);
        this.adjacentStreet = adjacentStreet;
        //initialized them in constructor
    }

    /*
     * (non-Javadoc)
     * @see iNode#getPlaces()
     * O(1)
     */
    @Override
    public ArrayList<String> getPlaces() {
        return list;
    }
    
    /*
     * (non-Javadoc)
     * @see iNode#setPlaces(java.util.ArrayList)
     * O(1)
     */
    @Override
    public void setPlaces(ArrayList<String> places) {
        list = places;
    }

    /*
     * (non-Javadoc)
     * @see iNode#getPoint()
     * O(1)
     */
    @Override
    public E getPoint() {
        return data;
    }

    /*
     * (non-Javadoc)
     * @see iNode#setPoint(java.lang.Object)
     * O(1)
     */
    @Override
    public void setPoint(E point) {
        data = point;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     * O(n)
     */
    @Override
    public String toString() {
        
        if(list.isEmpty()) {
            return "No places @ " + data.toString();
        }
        
        if (data == null) {
            return "A location has not been set";
        }
        
        return list.toString() + " @ " + data.toString();
    }
    
    public int compareTo(Node<E> E) {
        if(distance - E.getDistance() > 0) {
            return (int) (distance - E.getDistance());
        }
        if (distance - E.getDistance() < 0) {
            return (int) (distance - E.getDistance());
        } else {
            return 0;
        }
        
    }
    
    /**
     * @return distance
     */
    public double getDistance() {
        return distance;
    }
    
    /**
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
}