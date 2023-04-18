/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaObjeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class main {

    public static void main(String[] args) {

        File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\pruebaObjeto\\fichero.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois= null;
        try {
            fos = new FileOutputStream(fichero);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(new Persoa(1,27,"ahmed"));
            oos.writeObject(new Persoa(3,34,"daniel"));
            fos.close();
            oos.close();
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            while(fichero.exists()){
                Persoa Persoa1 = (Persoa)ois.readObject();
                System.out.println(Persoa1.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Eror e/s");
        } catch (ClassNotFoundException ex) {
            System.out.println("calse no encontrada");;
        }finally{
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                System.out.println("Eror e/s");
            }
            
        }
    }
}
