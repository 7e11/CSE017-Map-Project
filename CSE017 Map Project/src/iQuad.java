import java.util.List;

/**
 * @author Evan Hruskar
 * @version 2018.04.16
 */
public interface iQuad {
    /*
     * 2 Point variables data fields: topLeft and botRight, representing the top left and 
     * bottom right points respectively.
     * 1 Node variable data field to store the coordinates and additional information 
     * about the location (type of location: restaurant, school, etc.)
     * 4 Quad variables data fields: topLeftTree , topRightTree, botLeftTree,botRightTree; 
     * representing the top left, top right, bottom left, and bottom right 
     * quadrants of the map respectively.
     * 
     * Constructor like so: 
     * public Quad(Point topLeft, Point botRight)
     */
    
    /**
     * O(1)
     * Are the bounds inclusive or exclusive?
     * It will be helpful to create a method that takes a Point variable as parameter 
     * and return true if a node is within the bounds of a quadrant or false otherwise.
     * 
     * @param p a point
     * @return true if the point is in bounds
     */
    public boolean inQuad(Point p);
    
    /**
     * O(log(n))
     * This method takes the x and y coordinates of the location and a description of the 
     * location. In this assignment we will limit the description to the type of business or 
     * organization. E.g. school, restaurant, home, bank, etc.
     * This method will create a new Node (newNode) object with the parameters, and call 
     * the recursive insert method (described below) that takes a newNode object as a 
     * parameter
     * 
     * @param x of location
     * @param y of location
     * @param description of location E.g. school, restaurant, home, bank, etc.
     */
    public void insert(int x, int y, String description);
    
    /**
     * O(log(n))
     * This is the recursive helper method for insert
     * 
     * Base cases
     * (1) If newNode is null then end recursion (return)
     * (2) Current quad cannot contain newNode 
     * - outside of the boundaries
     * - end recursion (return)
     * (3) If we are at a quad of unit area (size = 1) 
     * -we cannot subdivide this quad further
     * - if the node field of quad null, set it to newNode
     * - else add newnode description to the list of places of the node and end the recursion
     * 
     * Recursive calls
     * 4 for each direction, topleft topright botleft botright
     * Example:
     * if newNode is in topLeftTree:
     * ((topLeft.X + botRight.X) / 2 >= newNode.X) and
     * ((topLeft.Y + botRight.Y) / 2 >= newNode.Y)
     * - if topLeftTree is null:
     * Set topLeftTree to a new Quad with bounds:
     * (topLeft.X, topLeft.Y) and (topLeft.X + botRight.X) / 2,(topLeft.Y + botRight.Y) / 2)
     * - call insert on topLeftTree with newNode as a parameter. Ex topLeftTree.insert(newNode)
     * 
     * @param newNode the node to insert
     */
    public void insert(Node<Point> newNode);
    
    /**
     * O(log(n))
     * This method takes the x and y coordinates of the location and return the Node 
     * containing all the data/places related to that location. This method creates a Point 
     * object (P) and calls the recursive search method with P as parameter
     * 
     * @param x of location
     * @param y of location
     * @return node which has all data/places related to that location
     */
    public Node<Point> search(int x, int y);
    
    /**
     * O(log(n))
     * Base cases
     * (1) Current quad cannot contain P 
     * - outside of the boundaries
     * - end recursion (return null)
     * (2) If node field of current quad not null end recursion (return the node field)
     * 
     * Recursive calls
     * 4 for each direction selected if p is in that tree:
     * Example:
     * if P is in topLeftTree
     * - if topLeftTree is null end recursion (return null)
     * - else call search on topLeftTree with P as parameter
     * 
     * @param p the location to search for
     * @return node containing all data/places for that location
     */
    public Node<Point> search(Point p);
    
    /**
     * O(n)
     * This method takes a String representing the type of place/business the user is 
     * interested in (bank, hospital, school, etc.), and return a list containing all the nodes 
     * with such places. 
     * This method will call a modified version of the above search method 
     * that will take a String and return an ArrayList of Node.
     * The design and implementation of this recursive (other) search method is entirely 
     * up to you.
     * 
     * The idea is this recursion will split 4 times and search every node in the Quad.
     * It will add to the arraylist and return it as a base case when there's nothing left
     * (Quad size gets to one or next quads are all null?)
     * 
     * @param type_of_place we are looking for
     * @return list containing all the nodes with such places
     */
    public List<Node<Point>> search (String type_of_place);
}
