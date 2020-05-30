
package Logic;

/**
 *
 * @author Miguel Lobato
 * @version 1.1 (2020.05.28)
 */
public class ElementAlreadyFilledException extends Exception {

    /**
     * Creates a new instance of <code>ElementAlreadyFilledException</code>
     * without detail message.
     */
    public ElementAlreadyFilledException() {
    }

    /**
     * Constructs an instance of <code>ElementAlreadyFilledException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ElementAlreadyFilledException(String msg) {
        super(msg);
    }
}
