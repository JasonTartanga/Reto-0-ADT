/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author 2dam
 */
public class MyObjectOutputStream extends ObjectOutputStream {

    protected void writeStreamHead() throws IOException {
        reset();
    }

    public MyObjectOutputStream() throws IOException {
        super();
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
