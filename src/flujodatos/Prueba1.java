/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flujodatos;

import java.util.*;
import java.io.*;

/**
 *
 * @author usuario
 */
//Introducimos nun fichero  datos pedindoos ao usuario a ta que non 
//Queira mais.
public class Prueba1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FileInputStream fis=null;
        DataInputStream dis=null;
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar1.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            
            char resposta;
            int numero;
            do {
                System.out.println("Introduce o numero a gardar");
                numero = teclado.nextInt();
                dos.writeInt(numero);
                System.out.println("Queres añadir outro numero(S/N)");
                resposta = teclado.next().charAt(0);
            } while (resposta == 'S' || resposta == 's');
            dos.close();
            fos.close();
            try {
                fis = new FileInputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar1.txt");
                dis = new DataInputStream(fis);
                System.out.println("Vamos a leer");
                while (true) {
                    numero = dis.readInt();
                    System.out.println("Numero: " + numero);
                }
                
            } catch (EOFException f) {
                System.out.println("Fin fichero");
            }

        } catch (IOException e) {
            System.out.println("Excepcion");
        }
        finally{
            try{
            fis.close();
            dis.close();
            }catch(IOException e){
                System.out.println("Error de cerrado");
            }
        }

    }
}
