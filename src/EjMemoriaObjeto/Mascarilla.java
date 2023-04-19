/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjMemoriaObjeto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Mascarilla {

    public int cod;
    private String tipo;
    public String cor;
    File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\EjMemoria\\Memoria14.dat");
    

    public Mascarilla(int cod, String tipo, String cor) {
        this.cod = cod;
        this.tipo = tipo;
        this.cor = cor;
        
    }
    //Cambiar el metodo para opcion VER_TODOS()
    public String getTipo() {
        return tipo;
    }

    public void ver() {
        System.out.println("O cod e: " + cod);
        System.out.println("O tipo e: " + getTipo());
        System.out.println("O cor e: " + cor);
    }

    public static ArrayList recupera(File fichero) throws FileNotFoundException, IOException {
        ArrayList<Mascarilla> ListaRecuperar = new ArrayList();
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
        int codigos = 0;
        String tipo,cor;
        fis = new FileInputStream(fichero);
        ois = new ObjectInputStream(fis);
        while (true) {
            ListaRecuperar.add(((Mascarilla)ois.readObject()));
        }
        } catch (EOFException e) {
                System.out.println("Fin de archivo");
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mascarilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        fis.close();
                ois.close();
        return ListaRecuperar;
    }

    public static void verTodos(File fichero) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            while(true){
                int codigos=ois.readInt();
                String tipo= ois.readUTF();
                String cor=ois.readUTF();
                System.out.println("Mascarilla:");
                System.out.println("O codigo e: "+codigos);
                System.out.println("O tipo e: "+tipo);//Cambiar el tipo y utilizar el metodo gettipo().
                System.out.println("A cor e: "+cor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el fichero");;
        } catch (IOException ex) {
            System.out.println("Fin de fichero");;
        }
    }

}
