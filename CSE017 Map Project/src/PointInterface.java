
/**
 * @author Cam
 *@version 2018.04.18
 */
public interface PointInterface {
    /**
     * @return the x value
     */
    public int getX();

    /**
     * @return the y value
     */
    public int getY();

    /**
     * @param x
     *            x value
     * @return sets x value
     */
    public int setX(int x);

    /**
     * @param y
     *            y value
     * @return sets y value
     */
    public int setY(int y);

    public String toString();

    public boolean equals(Object o);
}
