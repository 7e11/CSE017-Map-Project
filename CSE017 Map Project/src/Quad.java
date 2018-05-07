import java.util.ArrayList;

/**
 * @author Evan Hruskar 33%
 * @author Cam 33%
 * @author Tyler 33%
 * @version 2018.04.18
 */
public class Quad implements iQuad {
    private Point topLeft;
    private Point botRight;
    
    private Node<Point> location;
    
    private Quad topLeftTree;
    private Quad topRightTree;
    private Quad botLeftTree;
    private Quad botRightTree;

    private BinarySearchTree<StreetNodes> bst;

    /**
     * @param topLeft
     * @param botRight
     */
    public Quad(Point topLeft, Point botRight) {
        this.topLeft = topLeft;
        this.botRight = botRight;
        location = null;
        topLeftTree = null;
        topRightTree = null;
        botLeftTree = null;
        botRightTree = null;
        bst = null;
    }

    /* (non-Javadoc)
     * @see iQuad#inQuad(Point)
     */
    @Override
    public boolean inQuad(Point p) {
        if (p.getX() >= topLeft.getX() &&
                p.getY() >= topLeft.getY() &&
                p.getX() <= botRight.getX() &&
                p.getY() <= botRight.getY()) {
            //recall botRight has larger y than topLeft
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see iQuad#insert(int, int, java.lang.String)
     */
    @Override
    public void insert(int x, int y, String description) {
        ArrayList<String> newList = new ArrayList<String>();
        newList.add(description);
        Node<Point> newNode = new Node<Point>(new Point(x, y), newList);
        insert(newNode);
    }

    /* (non-Javadoc)
     * @see iQuad#insert(Node)
     */
    @Override
    public void insert(Node<Point> newNode) {
        if (newNode == null) {
            return;
        }
        if (!inQuad(newNode.getPoint())) {
            return;
        }
        //if size is 1, cannot subdivide further
        if (topLeft.equals(botRight)) {
            if (location == null) {
                location = newNode;
            } else {
                location.getPlaces().addAll(newNode.getPlaces());
                //Added, same deal with streets.
                //a place with new streets added at the same point will update
                //the streets present.
                //however, duplicate streets are not allowed.
                location.getStreets().removeAll(newNode.getStreets());
                location.getStreets().addAll(newNode.getStreets());
            }
            return;
        }
        //recursive calls:
        //The ceil notaiton is super gross. but necessary to avoid floor (ints)
        //dividing by 2d in order to avoid the floor, then manually use ceiling.
        //topLeftTree
        if ((topLeft.getX() + botRight.getX()) / 2 >= newNode.getPoint().getX() && 
                (topLeft.getY() + botRight.getY()) / 2 >= newNode.getPoint().getY()) {
            if (topLeftTree == null) {
                Point mid = new Point((topLeft.getX() + botRight.getX()) / 2, (topLeft.getY() + botRight.getY()) / 2);
                topLeftTree = new Quad(topLeft, mid);
            }
            topLeftTree.insert(newNode);
            return;
        }
        //botLeftTree
        if ((topLeft.getX() + botRight.getX()) / 2 >= newNode.getPoint().getX()) {
            if (botLeftTree == null) {
                botLeftTree = new Quad(new Point(topLeft.getX(), (int) Math.ceil((topLeft.getY() + botRight.getY()) / 2d)), 
                        new Point((topLeft.getX() + botRight.getX()) / 2, botRight.getY()));
            }
            botLeftTree.insert(newNode);
            return;
        }
        //topRightTree
        if ((topLeft.getY() + botRight.getY()) / 2 >= newNode.getPoint().getY()) {
            if (topRightTree == null) {
                topRightTree = new Quad(new Point((int) Math.ceil((topLeft.getX() + botRight.getX()) / 2d), topLeft.getY()), 
                        new Point(botRight.getX(), (topLeft.getY() + botRight.getY()) / 2));
            }
            topRightTree.insert(newNode);
            return;
        }
        
        //botRightTree
        if (botRightTree == null) {
            Point mid = new Point((int) Math.ceil((topLeft.getX() + botRight.getX()) / 2d), (int) Math.ceil((topLeft.getY() + botRight.getY()) / 2d));
            botRightTree = new Quad(mid, botRight);
        }
        botRightTree.insert(newNode);
        return;
    }

    /* (non-Javadoc)
     * @see iQuad#search(int, int)
     */
    @Override
    public Node<Point> search(int x, int y) {
        Point newPoint = new Point(x, y);
        return search(newPoint);
    }

    /* (non-Javadoc)
     * @see iQuad#search(Point)
     */
    @Override
    public Node<Point> search(Point p) {
        if (!inQuad(p)) {
            return null;
        }
        if (location != null) {
            return location;
        }
        
        //recursive calls:
        //topLeftTree
        if ((topLeft.getX() + botRight.getX()) / 2 >= p.getX() && 
                (topLeft.getY() + botRight.getY()) / 2 >= p.getY()) {
            if (topLeftTree == null) {
                return null;
            }
            return topLeftTree.search(p);
        }
        //botLeftTree
        if ((topLeft.getX() + botRight.getX()) / 2 >= p.getX()) {
            if (botLeftTree == null) {
                return null;
            }
            return botLeftTree.search(p);
        }
        //topRightTree
        if ((topLeft.getY() + botRight.getY()) / 2 >= p.getY()) {
            if (topRightTree == null) {
                return null;
            }
            return topRightTree.search(p);
        }
        //botRightTree
        if (botRightTree == null) {
            return null;
        }
        return botRightTree.search(p);
    }

    /* (non-Javadoc)
     * @see iQuad#search(java.lang.String)
     */
    @Override
    public ArrayList<Node<Point>> search(String type_of_place) {
        ArrayList<Node<Point>> foundPlaces = new ArrayList<Node<Point>>();
        if (location != null && location.getPlaces().contains(type_of_place)) {
            //we've reached the end of the tree
            foundPlaces.add(location);
        }
        if (topLeftTree != null) {
             foundPlaces.addAll(topLeftTree.search(type_of_place));
        }
        if (botLeftTree != null) {
            foundPlaces.addAll(botLeftTree.search(type_of_place));
        }
        if (topRightTree != null) {
            foundPlaces.addAll(topRightTree.search(type_of_place));
        }
        if (botRightTree != null) {
            foundPlaces.addAll(botRightTree.search(type_of_place));
        }
        return foundPlaces;
    }
    
    /**
     * remeber to check for duplicates (for both places & streets)
     * Also be careful with references to newNode.
     * (it's possible to reference the same memory from both the bst and the quad)
     * @param x
     * @param y
     * @param description a single string description of the location
     * Note, this description will be the only element in ArrayList    
     * @param streets
     */
    public void insert(int x, int y, String description, String... streets) {
        ArrayList<String> newList = new ArrayList<String>();
        newList.add(description);
        Node<Point> newNode = new Node<Point>(new Point(x, y), newList);
        insert(newNode, streets);
    }
    
    /**
     * @param newNode
     *            node containing coordinates and string from previous insert
     *            method
     * @param streets
     */
    public void insert(Node<Point> newNode, String... streets) {
        if (newNode == null) {
            return;
        }
        if (!inQuad(newNode.getPoint())) {
            return;
        }
        
        Node<Point> searchNode = search(newNode.getPoint());
        
        // if newNode was not previously added to the Quad, then insert newNode using the old insert method
        // if these aren't null, they contain what newNode contains
        if (!((searchNode != null) && (searchNode.getPlaces().equals(newNode.getPlaces())))) {
            insert(newNode);
        }
        
        for (int i = 0; i < streets.length; i++) {
            //add street to the list of streets if it isn't already there
            if (!newNode.getPlaces().contains(streets[i])) {
                newNode.getPlaces().add(streets[i]);
            }
            
            StreetNodes sNode = new StreetNodes(streets[i]);
            
            // if sNode is not in the BST, add newNode to sNode and insert sNode into the BST
            if (bst.find(sNode) == null) {
                sNode.addPoint(newNode);
                bst.insert(sNode);
            }
            
            // if sNode is in the BST, then we get sNode from the BST and add
            // newNode to the list of sNode’s Node<Point> data field
            else {
                bst.find(sNode).addPoint(newNode);
            }
        }
    }
    
    /**
     * This method takes a street name and returns all the locations on
     * that street. It calls the find method of the BST class.
     * Note, streets can only exist in the tree if they have at least one location.
     * @param streetName the name of the street  we're looking for.
     * @return all locations on the street if found, null otherwise
     */
    public ArrayList<Node<Point>> streetSearch(String streetName) {
        if (bst.find(new StreetNodes(streetName)) == null) {
            return new ArrayList<Node<Point>>();
            //did this instead of returning null to make next methods easier.
        }
        return bst.find(new StreetNodes(streetName)).getLocationStreet();
    }
    
    /**
     * This method takes a street name and a type of place (school, library, etc.)
     * and returns all the type_of_place locations on that street.
     * It calls the find method of BST and filters the results.
     * @param streetName
     * @param type_of_place
     * @return all type_of_place locations on the street
     */
    public ArrayList<Node<Point>> streetSearch(String streetName, String type_of_place) {
        ArrayList<Node<Point>> validLocations = new ArrayList<>();
        for (Node<Point> node : streetSearch(streetName)) {
            if (node.getPlaces().contains(type_of_place)) {
                validLocations.add(node);
            }
        }
        return validLocations;
    }
    
    /**
     * This method takes an origin point, a street name, and a type of place (school, etc.)
     * and returns all the type of place locations on that street. It calls the find method of BST
     * and filters the results.
     * The results are returned in ORDER OF DISTANCE from the origin ASCENDING
     * update the distance field of the nodes and put all the nodes in a MinHeap.
     * Call removeMin until the heap is empty.
     * use distance formula to get distance between two points.
     * @param originX
     * @param originY
     * @param streetName
     * @param type_of_place
     * @return all type_of_place locations on the street in ORDER OF DISTANCE
     *         from the origin ASCENDING (closest...farthest)
     */
    public ArrayList<Node<Point>> streetSearch(int originX, int originY, String streetName, String type_of_place) {
        ArrayList<Node<Point>> validLocations = streetSearch(streetName, type_of_place);
        for (Node<Point> node : validLocations) {
            Point p = node.getPoint();
            double distance = Math.sqrt(Math.pow(originX - p.getX(), 2) + Math.pow(originY - p.getY(), 2));
            node.setDistance(distance);
        }
        //see https://stackoverflow.com/a/530289
        //not really sure about the right way to cast this stuff
        //we're going to make a dummy array in order for validLocations
        //to cast correctly.
        //Node<Point>[] type = (Node<Point>[]) new Object[0];
        
        MinHeap<Node<Point>> heap = new MinHeap<>(validLocations, validLocations.size(), validLocations.size());
        //could have called with 3rd param = 0
        ArrayList<Node<Point>> sortedLocations = new ArrayList<>();
        while (heap.heapsize() > 0) {
            sortedLocations.add(heap.removemin());
        }
        return sortedLocations;
    }
}
