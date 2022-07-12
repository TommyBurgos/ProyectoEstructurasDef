/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author tommy_Burgos
 */
public class miObjectOutputStream extends ObjectOutputStream {
    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader(); //To change body of generated methods, choose Tools | Templates.
        return;
    }
      miObjectOutputStream() throws IOException
    {
 
        // Super keyword refers to parent class instance
        super();
    }
 

    public miObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
