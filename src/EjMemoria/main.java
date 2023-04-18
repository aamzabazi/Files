/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjMemoria;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        DataOutputStream dos = null;
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
                    try{
                    fos = new FileOutputStream(fichero, true);
                    dos = new DataOutputStream(fos);
                    dos.writeInt(ListaMascarillas.get(posicionm).cod);
                    dos.writeUTF(ListaMascarillas.get(posicionm).getTipo());
                    dos.writeUTF(ListaMascarillas.get(posicionm).cor);
                    dos.close();
                    fos.close();
                    }catch(IOException e){
                        System.out.println("Error");
                    }
                    
                    break;
                case 2:
                    System.out.println("Introduzca o cod da mascarilla a visualizar");
                    int cod_buscar = teclado.nextInt();
                    int posicion = -1;
                    for (int i = 0; i < ListaMascarillas.size(); i++) {
                        if (cod_buscar == ListaMascarillas.get(i).cod) {
                            posicion = i;
                            break;
                        }
                    }
                    if (posicion == -1) {
                        System.out.println("Non se encontrou");
                    } else {
                        ListaMascarillas.get(posicion).ver();
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
                case 5:
                    System.out.println("Introduce o codigo da mascarilla a buscar");
                    int codbuscar=teclado.nextInt();
                    codbuscar=Mascarilla.buscar_F(codbuscar, fichero);
                    break;
            }
        } while (opcion != 6);
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolla una opcion");
        System.out.println("(1): Crear Mascarilla");
        System.out.println("(2): Ver datos de una Mascarilla");
        System.out.println("(3): Para Recuperar datos.");
        System.out.println("(4): Buscar e ver mascarilla(desde fichero)");
        System.out.println("(6): Salir");
        int opcion = teclado.nextInt();
        return opcion;
    }
}
