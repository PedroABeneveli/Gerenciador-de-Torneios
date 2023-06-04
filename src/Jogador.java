/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Jogador  extends Pessoa {
    private String username;
    private boolean freeAgent;
    private boolean tecnico;
    private ArrayList<Integer> numeroVitoriasDerrotas;
    private String ranqueamento;
    private ArrayList<Equipe> equipe;

    public Jogador() {
    }

    public Jogador(String username, boolean freeAgent, boolean tecnico, ArrayList<Integer> numeroVitoriasDerrotas, String ranqueamento, ArrayList<Equipe> equipe) {
        this.username = username;
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
        this.ranqueamento = ranqueamento;
        this.equipe = equipe;
    }

    public Jogador(String username, boolean freeAgent, boolean tecnico, ArrayList<Integer> numeroVitoriasDerrotas, String ranqueamento, ArrayList<Equipe> equipe, String nome, String email, String CPF, Date dataDeNascimento, String endereco, String senha) {
        super(nome, email, CPF, dataDeNascimento, endereco, senha);
        this.username = username;
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
        this.ranqueamento = ranqueamento;
        this.equipe = equipe;
    }

    public double calcularRazaoKillDeath() {
        return numeroVitoriasDerrotas.get(0) / numeroVitoriasDerrotas.get(1);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFreeAgent() {
        return freeAgent;
    }

    public void setFreeAgent(boolean freeAgent) {
        this.freeAgent = freeAgent;
    }

    public boolean isTecnico() {
        return tecnico;
    }

    public void setTecnico(boolean tecnico) {
        this.tecnico = tecnico;
    }

    public ArrayList<Integer> getnumeroVitoriasDerrotas() {
        return numeroVitoriasDerrotas;
    }

    public void setnumeroVitoriasDerrotas(ArrayList<Integer> numeroVitoriasDerrotas) {
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
    }

    public String getRanqueamento() {
        return ranqueamento;
    }

    public void setRanqueamento(String ranqueamento) {
        this.ranqueamento = ranqueamento;
    }

    public ArrayList<Equipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Equipe> equipe) {
        this.equipe = equipe;
    }
    
    
}
