package excepciones;

/**
 *
 * @author Jason.
 */
public class ErrConsultar extends Exception {

    /**
     * Creates a new instance of <code>ErrConsultar</code> without detail
     * message.
     */
    public ErrConsultar() {
    }

    /**
     * Constructs an instance of <code>ErrConsultar</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErrConsultar(String msg) {
        super(msg);
    }
}
