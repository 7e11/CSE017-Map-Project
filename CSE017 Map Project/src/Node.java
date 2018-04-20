import java.util.ArrayList;

public class Node<E> implements iNode<E> {
    
    private E data;
    private ArrayList<String> list;
    
    /**
     * @param data the information describing the location (coordinate)
     * @param list the list of places to be explored at location
     */
    public Node(E data, ArrayList<String> list) {
        this.data = data;
        this.list = list;
    }

    @Override
    // O(1): returns the private Node.list field
    public ArrayList<String> getPlaces() {
        
        return list;
    }
    
    public void setPlaces(ArrayList<String> places) {
        
        list = places;
    }

    @Override
    
    // O(1): simply returns the location data field  
    public E getPoint() {
        return data;
    }

    @Override
    // O(1): sets location to a new value (if ever necessary)
    public void setPoint(E point) {
        data = point;
        
    }
    
    @Override
    // O(n): needs to traverse entire ArrayList of places to concatenate
    // to "str" and return final result.
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
