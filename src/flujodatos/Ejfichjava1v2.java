/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flujodatos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejfichjava1v2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File fichero=new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\flujodatos\\insertar3.dat");
        ArrayList<String> ListaNomes = new ArrayList();
        ArrayList<String> ListaNNomes = new ArrayList();
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    pedir_numeros(ListaNomes);
                    break;
                case 2:
                    gardar_numeros(ListaNomes,fichero);
                    break;
                case 3:
                    ListaNNomes = leer_fichero(fichero);
                    break;
                case 4:
                    ver_datos(ListaNNomes);
                    break;
                case 5:
                    engadirUn(fichero);
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
        System.out.println("(1): Pedir palabraS");
        System.out.println("(2): Gardar PalabraS no Ficheiro");
        System.out.println("(3): Leer Ficheiro.");
        System.out.println("(4): Ver Datos.");
        System.out.println("(5): Añadir un numero.");
        System.out.println("(6): Salir");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public static void pedir_numeros(ArrayList<String> ListaNomes) {
        Scanner teclado = new Scanner(System.in);
        String palabra;
        char resposta;
        do {
            System.out.println("Introduzca o numeros a gardar na lista");
            palabra = teclado.next();
            ListaNumeros.add(palabra);
            System.out.println("Queres engadir outro numero mais?(S/N)");
            resposta = teclado.next().charAt(0);
        } while (resposta == 'S' || resposta == 's');

    }

    public static void gardar_numeros(ArrayList<String> ListaPalabras,File fichero) {
        String palabra;
        char resposta;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(fichero);
            dos = new DataOutputStream(fos);
            for (int i = 0; i < ListaNumeros.size(); i++) {
                fos.writeString(ListaNumeros.get(i));
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

    public static ArrayList<String> leer_fichero(File fichero) {
        ArrayList<Integer> ListaNNombres = new ArrayList();
        FileInputStream fis = null;
        DataInputStream dis = null;
        int numero;
        try {
            fis = new FileInputStream(fichero);
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

    public static void ver_datos(ArrayList<String> ListaNNumeros) {
        FileInputStream fis=null;
        DataInputStream dis=null;
        int numero;
        for (int i = 0; i < ListaNNumeros.size(); i++) {
            System.out.println("Numero: "+ListaNNumeros.get(i));
        }
    }

    public static void engadirUn(File fichero) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca o numero que queras engadir.");
        int numero = teclado.nextInt();
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(fichero, true);
            dos = new DataOutputStream(fos);
            dos.write(numero);
        } catch (IOException e) {
            System.out.println("Error en el archivo.");
        }

    }
    }
            
}
