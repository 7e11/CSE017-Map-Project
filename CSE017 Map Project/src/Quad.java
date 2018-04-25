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
}