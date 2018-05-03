//-------------------------------------------------------------------------
/**
 * Exception class for duplicate item errors
 * in search tree insertions.
 *
 * @author Mark Allen Weiss (with modifications by John Lewis)
 * @version 2010.04.28
 */
public class DuplicateItemException
    extends RuntimeException
{
    //~ Constructors ..........................................................

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    // ----------------------------------------------------------
    /**
     * Constructs this exception object.
     */
    public DuplicateItemException()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * Constructs this exception object.
     * @param message the error message.
     */
    public DuplicateItemException(String message)
    {
        super(message);
    }
}
