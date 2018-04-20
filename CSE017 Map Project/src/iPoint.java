
/**
 * @author Cam
 * @version 2018.04.18
 */
public interface iPoint {
    
    /**
     * O(1)
     * @return the x value
     */
    public int getX();

    /**
     * O(1)
     * @return the y value
     */
    public int getY();

    /**
     * O(1)
     * @param x value
     * @return the new x value
     */
    public int setX(int x);

    /**
     * O(1)
     * @param y y value
     * @return the new y value
     */
    public int setY(int y);
    
    /**
     * O(1)
     * @return a string representation of Point
     */
    public String toString();

    /**
     * O(1)
     * @param o the object to compare
     * @return true if they are the same, false otherwise
     */
    public boolean equals(Object o);
}