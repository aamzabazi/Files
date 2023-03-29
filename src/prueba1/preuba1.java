    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;
    import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class preuba1 {




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      String texto;
        Scanner teclado = new Scanner (System.in);   
        ArrayList<Character> nomes=new ArrayList();
        char nomes_c[]=new char[255];
        int i=0;
      try{
            //Abrimos o ficheiro para escribir
            System.out.println("texto a gardar no ficheiro:?");
            texto=teclado.nextLine();
            FileWriter fw=new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba1\\fichero1.txt");
            //Escribimos no fichero un String e un caracter 97 (a)
            fw.write(texto);
            fw.write('\n');
            fw.write("outra");
            fw.write('\n');
            fw.write("1+");
            //Pechamos o ficheiro
            fw.close(); 
            
            //Abrimolo para engadir o final
            texto="engadimos ó final";
            
            fw=new FileWriter("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba1\\fichero1.txt",true);
            fw.write(" texto final");
            fw.close();
            
                //Abrimolo para ler, debe existir
            FileReader fr=new FileReader("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\prueba1\\fichero1.txt");
            //Leemos o fichero e o amosamos por pantalla
            System.out.println("Leemos o ficheiro...");
            int valor=fr.read();
            while(valor!=-1){
                if((char)valor=='\n')
                {
                   texto=String.valueOf(nomes_c,0,i);
                   System.out.print("\nNomes convertido... "+texto);
                   i=0;
                }
                nomes_c[i]=((char)valor);
                valor=fr.read();                          
                i++;
                
            }
            
            if (valor==-1)
            {
              texto=String.valueOf(nomes_c,0,i);
              System.out.println("\nNomes ultimo "+texto);  
            }
            //Pechamos o ficheiro
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }           
        
    }
    
}
    
    
    
