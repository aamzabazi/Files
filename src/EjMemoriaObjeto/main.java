/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjMemoriaObjeto;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Mascarilla> ListaMascarillas = new ArrayList();
        File fichero = new File("C:\\Users\\usuario\\Documents\\NetBeansProjects\\PruebasFicheros\\src\\EjMemoria\\Memoria14.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    int posicionm = -1;
                    System.out.println("Introduzca o cod da mascarilla.");
                    int cod = teclado.nextInt();
                    System.out.println("Introduce o tipo de mascarilla(simple,fp1,fp2)");
                    String tipo = teclado.next();
                    System.out.println("Introduce o cor da mascarilla.");
                    String cor = teclado.next();
                    Mascarilla Mascarilla1 = new Mascarilla(cod, tipo, cor);
                    ListaMascarillas.add(Mascarilla1);
                    for (int i = 0; i < ListaMascarillas.size(); i++) {
                        if (ListaMascarillas.get(i).cod == cod) {
                            posicionm = i;
                            break;
                        }
                    }
                    /*
                    try{
                    fos = new FileOutputStream(fichero, true);
                    oos= new ObjectOutputStream(fos);
                    oos.writeInt(ListaMascarillas.get(posicionm).cod);
                    oos.writeUTF(ListaMascarillas.get(posicionm).getTipo());
                    oos.writeUTF(ListaMascarillas.get(posicionm).cor);
                    oos.close();
                    fos.close();
                    }catch(IOException e){
                        System.out.println("Error");
                    }
                     */
                    break;
                case 2:
                    try {

                    fos = new FileOutputStream(fichero, true);
                    oos = new ObjectOutputStream(fos);
                    for (int i = 0; i < ListaMascarillas.size(); i++) {
                        oos.writeInt(ListaMascarillas.get(i).cod);
                        oos.writeUTF(ListaMascarillas.get(i).getTipo());
                        oos.writeUTF(ListaMascarillas.get(i).cor);
                    }
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Error");
                }
                break;
                case 3:
                    ArrayList<Mascarilla> ListaRecuperada = Mascarilla.recupera(fichero);
                    System.out.println("Visualizaremos el nuevo array");
                    for (int i = 0; i < ListaRecuperada.size(); i++) {
                        System.out.println("Codigo  es: " + ListaRecuperada.get(i).cod);
                        System.out.println("Tipo es: " + ListaRecuperada.get(i).getTipo());
                        System.out.println("Cor es : " + ListaRecuperada.get(i).cor);
                    }
                    break;
                case 4:
                    Mascarilla.verTodos(fichero);
                    break;
            }
        } while (opcion != 6);
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolla una opcion");
        System.out.println("(1): Crear Mascarilla en ArrayList");
        System.out.println("(2): Gardar");
        System.out.println("(3): Para Recuperar datos.");
        System.out.println("(4): Buscar e ver mascarilla(desde fichero)");
        System.out.println("(6): Salir");
        int opcion = teclado.nextInt();
        return opcion;
    }
}
