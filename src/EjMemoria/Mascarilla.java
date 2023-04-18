/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjMemoria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Mascarilla {

    protected int cod;
    private String tipo;
    protected String cor;
    File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\EjMemoria\\Memoria14.dat");
    

    public Mascarilla(int cod, String tipo, String cor) {
        this.cod = cod;
        this.tipo = tipo;
        this.cor = cor;
        
    }

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
        DataInputStream dis = null;
        try {
        int codigos = 0;
        String tipo,cor;
        fis = new FileInputStream(fichero);
        dis = new DataInputStream(fis);
        while (codigos!=1) {
                codigos = dis.readInt();
                tipo = dis.readUTF();
                cor = dis.readUTF();
            Mascarilla mascarilla = new Mascarilla(codigos, tipo, cor);
            ListaRecuperar.add(mascarilla);
        }
        } catch (EOFException e) {
                System.out.println("Fin de archivo");
            }
        fis.close();
                dis.close();
        return ListaRecuperar;
    }

    public static void verTodos(File fichero) {
         FileInputStream fis = null;
        DataInputStream dis = null;
        try{
            fis = new FileInputStream(fichero);
            dis = new DataInputStream(fis);
            while(true){
                int codigos=dis.readInt();
                String tipo= dis.readUTF();
                String cor=dis.readUTF();
                System.out.println("Mascarilla:");
                System.out.println("O codigo e: "+codigos);
                System.out.println("O tipo e: "+tipo);
                System.out.println("A cor e: "+cor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el fichero");;
        } catch (IOException ex) {
            System.out.println("Fin de fichero");;
        }
    }
    public  static int buscar_F(int codbuscar,File fichero){
        int encontrado=-1;
        FileInputStream fis=null;
        DataInputStream dis=null;
            try{
                fis= new FileInputStream(fichero);
                dis= new DataInputStream(fis);
                while(encontrado!=-1){
                if(codbuscar==dis.readInt()){
                    encontrado=codbuscar;
                    //break;
                }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no encontrado");
            } catch (IOException ex) {
                Logger.getLogger(Mascarilla.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return encontrado;
    }
}
