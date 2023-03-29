/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flujodatos;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ejfichjava1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> ListaNumeros = new ArrayList();
        ArrayList<Integer> ListaNNumeros = new ArrayList();
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    pedir_numeros(ListaNumeros);
                    break;
                case 2:
                    gardar_numeros(ListaNumeros);
                    break;
                case 3:
                    ListaNNumeros = leer_fichero();
                    break;
                case 4:
                    ver_datos(ListaNNumeros);
                    break;
                case 5:
                    engadirUn();
                    break;
                case 6:
                    System.out.println("Cerrando programa.");
                    break;
            }
        } while (opcion != 6);
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolla una opcion");
        System.out.println("(1): Pedir Numeros");
        System.out.println("(2): Gardar Numeros no Ficheiro");
        System.out.println("(3): Leer Ficheiro.");
        System.out.println("(4): Ver Datos.");
        System.out.println("(5): Añadir un numero.");
        System.out.println("(6): Salir");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public static void pedir_numeros(ArrayList<Integer> ListaNumeros) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        char resposta;
        do {
            System.out.println("Introduzca o numeros a gardar na lista");
            numero = teclado.nextInt();
            ListaNumeros.add(numero);
            System.out.println("Queres engadir outro numero mais?(S/N)");
            resposta = teclado.next().charAt(0);
        } while (resposta == 'S' || resposta == 's');

    }

    public static void gardar_numeros(ArrayList<Integer> ListaNumeros) {
        int numero;
        char resposta;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar2.txt");
            dos = new DataOutputStream(fos);
            for (int i = 0; i < ListaNumeros.size(); i++) {
                fos.write(ListaNumeros.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error E/S");
        } finally {
            try {
                fos.close();
                dos.close();
            } catch (IOException e) {
                System.out.println("Error de cierre");
            }
        }
    }

    public static ArrayList<Integer> leer_fichero() {
        ArrayList<Integer> ListaNNumeros = new ArrayList();
        FileInputStream fis = null;
        DataInputStream dis = null;
        int numero;
        try {
            fis = new FileInputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar2.txt");
            dis = new DataInputStream(fis);
            numero = 0;
            while (true) {
                numero = dis.read();
                if (numero == -1) {
                    break;
                }
                ListaNNumeros.add(numero);
            }
            fis.close();
            dis.close();
        } catch (EOFException f) {
            System.out.println("Fin de fichero");
        } catch (FileNotFoundException ex) {
            System.out.println("Non se encontrou o ficheiro");;
        } catch (IOException ex) {
            System.out.println("Error de acceso");
        }
        return ListaNNumeros;
    }

    public static void ver_datos(ArrayList<Integer> ListaNNumeros) {
        FileInputStream fis=null;
        DataInputStream dis=null;
        int numero;
        try{
            fis = new FileInputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar2.txt");
            dis = new DataInputStream(fis);
            numero=0;
            while(true){
                numero=dis.read();
                if(numero==-1){
                    break;
                }
                System.out.println("Numero: "+numero);
            }
            fis.close();
            dis.close();
        }catch(IOException e){
            System.out.println("Error en el fichero");
        }
    }

    public static void engadirUn() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca o numero que queras engadir.");
        int numero = teclado.nextInt();
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar2.txt", true);
            dos = new DataOutputStream(fos);
            dos.write(numero);
        } catch (IOException e) {
            System.out.println("Error en el archivo.");
        }

    }
}
