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

/**
 *
 * @author usuario
 */
public class Mascarilla {

    protected int cod;
    private String tipo;
    protected String cor;
    File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\EjMemoria\\Memoria.dat");
    FileOutputStream fos = null;
    DataOutputStream dos = null;

    public Mascarilla(int cod, String tipo, String cor) throws FileNotFoundException, IOException {
        this.cod = cod;
        this.tipo = tipo;
        this.cor = cor;
        fos = new FileOutputStream(fichero, true);
        dos = new DataOutputStream(fos);
        dos.writeInt(this.cod);
        dos.writeUTF(this.tipo);
        dos.writeUTF(this.cor);
        fos.close();
        dos.close();
    }

    public String getTipo() {
        return tipo;
    }

    public void ver() {
        System.out.println("O cod e: " + cod);
        System.out.println("O tipo e: " + getTipo());
        System.out.println("O cor e: " + cor);
    }

    public static ArrayList recupera() throws FileNotFoundException, IOException {
        ArrayList<String> ListaRecuperar = new ArrayList();
        File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\EjMemoria\\Memoria.dat");
        FileInputStream fis = null;
        DataInputStream dis = null;
        fis = new FileInputStream(fichero);
        dis = new DataInputStream(fis);
        int codigos = 0;
        String tipo_cor;
        try {
            do {

                codigos = dis.readInt();
                String convertir = Integer.toString(codigos);
                ListaRecuperar.add(convertir);
                tipo_cor = dis.readUTF();
                ListaRecuperar.add(tipo_cor);
                tipo_cor = dis.readUTF();
                ListaRecuperar.add(tipo_cor);

            } while (codigos != -1);
        } catch (EOFException e) {
            System.out.println("Fin de archivo");
        }
        return ListaRecuperar;
    }

    public void verTodos() {

    }
}
