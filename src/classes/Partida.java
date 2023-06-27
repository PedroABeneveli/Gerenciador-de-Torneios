/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Partida implements Serializable {
    // variavel para arquivos
    private static final long serialVersionUID = 6L;
    // Atributos
    private int numeroDeMapas;
    private ArrayList<Integer> resultadosParciais;
    private ArrayList<String> personagens;
    private Equipe equipe1, equipe2, vencedor;
    
    // Construtores
    public Partida() {
    
    }

    public Partida(int numeroDeMapas, ArrayList<Integer> resultadosParciais, ArrayList<String> personagens) {
        this.numeroDeMapas = numeroDeMapas;
        this.resultadosParciais = resultadosParciais;
        this.personagens = personagens;
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

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Equipe getVencedor() {
        return vencedor;
    }

    public void setVencedor(Equipe vencedor) {
        this.vencedor = vencedor;
    }
    
}
