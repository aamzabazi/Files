/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class preuba1 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
        String texto;
        char nomes_c[]=new char[255];
        int i=0;
        try{
            System.out.println("texto a gardar no ficheiro");
            texto=teclado.next();
            FileWriter fw =new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba2\\fichero2.txt");
            fw.write(texto);
            fw.write("\n");
            fw.write("Segundo 2 y 3");
            fw.close();
            //volvemos a abrir
            texto="Ultima linea";
            fw =new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba2\\fichero2.txt",true);
            fw.write(texto);
            fw.close();
            FileReader fr =new FileReader("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba2\\fichero2.txt");
            
        }
        catch(IOException e){
            System.out.println("Error E/S: "+ e);
            System.out.println("Leemos o ficheiro");
            
        }
    }
}
