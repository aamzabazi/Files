/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class LectVocal {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
       FileWriter fw;
       FileReader fr;
       int numletras;
       String texto;
       char nomes_c[]=new char[255];
       try{
           System.out.println("Introduce o texto a gardar no ficheiro");
           texto=teclado.nextLine();
           fw= new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba3\\Ficherop3.txt");
           fw.write(texto);
           fw.close();
           System.out.println("Ahora vamos a contar cuantas vocales tiene el texto");
           fr= new FileReader("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba3\\Ficherop3.txt");
               numletras= fr.read();
           System.out.println(numletras);

           fr.close();
       }
       catch(IOException e){
           System.out.println("Error de excepcion");
    }
       //&& (numletras= fr.read(nomes_c))==32 )
    }
}
