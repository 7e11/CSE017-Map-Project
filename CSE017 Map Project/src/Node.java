import java.util.ArrayList;

/**
 * @author Evan Hruskar 33%
 * @author Cam 33%
 * @author Tyler Hogue 33%
 * @version 2018.04.20
 * @param <E>
 *            a generic, in this case will be Point
 */
public class Node<E> implements iNode<E>, Comparable<Node<E>> {
    private E data;
    private ArrayList<String> places; // getter and setter
    private double distance;
    // streets adjacent to location
    private ArrayList<String> streets;

    /**
     * O(1)
     * 
     * @param data
     *            the information describing the location (coordinate)
     * @param places
     *            the list of places that can be explored at the specified location
     */
    public Node(E data, ArrayList<String> places) {
        this.data = data;
        this.places = places;
        this.distance = 0;
        this.streets = new ArrayList<String>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see iNode#getPlaces() O(1)
     */
    @Override
    public ArrayList<String> getPlaces() {
        return places;
    }

    /*
     * (non-Javadoc)
     * 
     * @see iNode#setPlaces(java.util.ArrayList) O(1)
     */
    @Override
    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }

    /*
     * (non-Javadoc)
     * 
     * @see iNode#getPoint() O(1)
     */
    @Override
    public E getPoint() {
        return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see iNode#setPoint(java.lang.Object) O(1)
     */
    @Override
    public void setPoint(E point) {
        data = point;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString() O(n)
     */
    @Override
    public String toString() {

        if (places.isEmpty()) {
            return "No places @ " + data.toString();
        }

        if (data == null) {
            return "A location has not been set";
        }

        return places.toString() + " @ " + data.toString();
    }

    /**
     * 
     * @param Node
     * @return the difference in the distance O(1)
     */
    public int compareTo(Node<E> Node) {
        return (int) (distance - Node.getDistance());
    }

    /**
     * @return distance, its the getter method for distance O(1)
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance
     *            its the setter method for distance O(1)
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return streets its the getter for streets O(1)
     */
    public ArrayList<String> getStreets() {
        return streets;
    }

    /**
     * @param streets
     *            its the setter for the streets data field O(1)
     */
    public void setStreets(ArrayList<String> streets) {
        this.streets = streets;
    }

}