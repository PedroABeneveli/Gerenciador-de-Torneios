/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import telas.TelaJogador;

/**
 *
 * @author gustavo
 */
public class Jogador extends Pessoa {
    // variavel para arquivos
    private static final long serialVersionUID = 2L;
    
    // Atributos
    private boolean freeAgent;
    private boolean tecnico;
    private ArrayList<Integer> numeroVitoriasDerrotas = new ArrayList<>(Arrays.asList(1, 1));
    private String ranqueamento;
    private ArrayList<Equipe> equipes = new ArrayList<>();
    
    // Conatrutores
    public Jogador() {
    }

    public Jogador(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha, boolean freeAgent, boolean tecnico) {
        super(nome, email, CPF, dataDeNascimento, endereco, senha);
        this.username = username;
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
    }

    public Jogador(String nome, String username, String CPF, Date dataDeNascimento, String endereco, String senha, boolean freeAgent, boolean tecnico) {
        super(nome, username, CPF, dataDeNascimento, endereco, senha);
        this.freeAgent = freeAgent;
        this.tecnico = tecnico;
    }
    
    // Implementação do método abstrato getTela da superclasse abstrata Pessoa, retorna um objeto da classe TelaJogador
    @Override
    public TelaInicial getTela() {
        return new TelaJogador();
    }
    
    // Atualiza os dados das equipes 
    public void atualizarDados(Equipe equipe) {
        this.equipes.add(equipe);
    }

    // Calcula a razão entre o número de vitórias e o número de derrotas do jogador
    public double calcularRazaoVitoriasDerrotas() {
        return numeroVitoriasDerrotas.get(0) / numeroVitoriasDerrotas.get(1);
    }

    // Getters e setters
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
