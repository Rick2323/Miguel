/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Miglob
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
