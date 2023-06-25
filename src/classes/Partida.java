/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Partida {
    // Atributos
    private int numeroDeMapas;
    private ArrayList<Integer> resultadosParciais;
    private ArrayList<String> personagens;
    private Torneio torneio;
    
    // Construtores
    public Partida() {
    
    }

    public Partida(int numeroDeMapas, ArrayList<Integer> resultadosParciais, ArrayList<String> personagens, Torneio torneio) {
        this.numeroDeMapas = numeroDeMapas;
        this.resultadosParciais = resultadosParciais;
        this.personagens = personagens;
        this.torneio = torneio;
    }
    
    // Getters e setters
    public int getNumeroDeMapas() {
        return numeroDeMapas;
    }

    public void setNumeroDeMapas(int numeroDeMapas) {
        this.numeroDeMapas = numeroDeMapas;
    }

    public ArrayList<Integer> getResultadosParciais() {
        return resultadosParciais;
    }

    public void setResultadosParciais(ArrayList<Integer> resultadosParciais) {
        this.resultadosParciais = resultadosParciais;
    }

    public ArrayList<String> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<String> personagens) {
        this.personagens = personagens;
    }
    
}
