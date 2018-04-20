import java.util.ArrayList;

/**
 * @author Evan Hruskar
 * @author Tyler Hogue
 * @version 2018.04.20
 * @param <E> a generic, in this case will be Point
 */
public class Node<E> implements iNode<E> {
    private E data;
    private ArrayList<String> list;
    
    /**
     * O(1)
     * @param data the information describing the location (coordinate)
     * @param list the list of places to be explored at location
     */
    public Node(E data, ArrayList<String> list) {
        this.data = data;
        this.list = list;
    }

    @Override
    public ArrayList<String> getPlaces() {
        return list;
    }
    
    @Override
    public void setPlaces(ArrayList<String> places) {
        list = places;
    }

    @Override
    public E getPoint() {
        return data;
    }

    @Override
    public void setPoint(E point) {
        data = point;
    }
    
    @Override
    public String toString() {
        if(list.isEmpty()) {
            return "No places @ " + data.toString();
        }
        
        if(data == null) {
            //needs to throw an exception
        }
        
        String str = "[";
        
        for(int i = 0; i < list.size(); i++) {
            str += list.get(i) + ", ";
        }
        
        str += "] @ " + data.toString();
        
        return str;
    }
}