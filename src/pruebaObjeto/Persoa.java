/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaObjeto;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Persoa implements Serializable {
    protected int dni,edad;
    protected String nome;
    public Persoa(int dni,int edad,String nome){
        this.dni=dni;
        this.edad=edad;
        this.nome=nome;
    }
    public void nombrar(){
        System.out.println("Estas llamando a "+this.nome);
    }


    public String toString() {
        return "Persoa{" + "dni=" + dni + ", edad=" + edad + ", nome=" + nome + '}';
    }
}
