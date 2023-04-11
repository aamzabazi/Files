/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjMemoria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner teclado= new Scanner(System.in);
        ArrayList<Mascarilla>ListaMascarillas=new ArrayList();
        int opcion;
        do{
           opcion=menu(); 
        switch (opcion) {
            case 1:
                System.out.println("Introduzca o cod da mascarilla.");
                int cod = teclado.nextInt();
                System.out.println("Introduce o tipo de mascarilla(simple,fp1,fp2)");
                String tipo = teclado.next();
                System.out.println("Introduce o cor da mascarilla.");
                String cor = teclado.next();
                Mascarilla Mascarilla1 = new Mascarilla(cod,tipo,cor);
                ListaMascarillas.add(Mascarilla1);
                break;
            case 2:
                System.out.println("Introduzca o cod da mascarilla a visualizar");
                int cod_buscar=teclado.nextInt();
                int posicion=-1;
                for(int i=0;i<ListaMascarillas.size();i++){
                    if(cod_buscar==ListaMascarillas.get(i).cod){
                        posicion=i;
                        break;
                    }
                }
                if(posicion==-1){
                    System.out.println("Non se encontrou");
                }
                else{
                    ListaMascarillas.get(posicion).ver();
                }
                break;
            case 3:
                ArrayList<String>ListaRecuperada=Mascarilla.recupera();
                System.out.println("Visualizaremos el nuevo array");
                for(int i=0;i<ListaRecuperada.size();i++){
                    System.out.println("z es: "+ListaRecuperada.get(i));
                }
                break;
        }
        }while(opcion!=6);
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolla una opcion");
        System.out.println("(1): Crear Mascarilla");
        System.out.println("(2): Ver datos de una Mascarilla");
        System.out.println("(3): Para Recuperar datos.");
        System.out.println("(6): Salir");
        int opcion = teclado.nextInt();
        return opcion;
    }
}
