/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Jogador extends Pessoa {
    private boolean freeAgent;
    private boolean tecnico;
    private ArrayList<Integer> numeroVitoriasDerrotas;
    private String ranqueamento;
    private ArrayList<Equipe> equipes;
    private ArrayList<Torneio> torneiosAnteriores;
    

    public Jogador() {
    }

    public Jogador(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha, boolean freeAgent, boolean tecnico, ArrayList<Integer> numeroVitoriasDerrotas, String ranqueamento, ArrayList<Equipe> equipes) {
        super(nome, email, CPF, dataDeNascimento, endereco, senha);
        this.username = username;
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
        this.ranqueamento = ranqueamento;
        this.equipes = equipes;
    }
    
    public Jogador(String nome, String CPF, Date dataDeNascimento, String endereco, boolean freeAgent, boolean tecnico, ArrayList<Integer> numeroVitoriasDerrotas, String ranqueamento, ArrayList<Equipe> equipes, ArrayList<Torneio> torneiosAnteriores) {
        super(nome, CPF, dataDeNascimento, endereco);
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
        this.ranqueamento = ranqueamento;
        this.equipes = equipes;
        this.torneiosAnteriores = torneiosAnteriores;
    }
    
    
    @Override
    public void criarLogin(String login) {
        this.username = login;
    }
    
    @Override
    public void criarSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void informarEmailContato(String email) {
        this.email = email;
    }
    
    public void atualizarDados(Torneio torneio, Equipe equipe) {
        this.torneiosAnteriores.add(torneio);
        this.equipes.add(equipe);
    }

    public double calcularRazaoVitoriasDerrotas() {
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

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }
    
    
}
