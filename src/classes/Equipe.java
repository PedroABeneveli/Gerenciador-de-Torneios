/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
// import classes.Jogador;

/**
 *
 * @author gustavo
 */
public class Equipe {
    
    // Atributos
    private boolean inscricao;
    private int colocacao;
    private String nome;
    private ArrayList<Integer> numeroVitoriasDerrotas;
    private int pontuacao;
    private Torneio torneio;
    private ArrayList<Jogador> jogadores;
    private String email;
    private String login;
    private String senha;
    private ArrayList<Avaliacao> avaliacoes; 
    
    // Construtor
    public Equipe(boolean inscricao, int colocacao, String nome, ArrayList<Integer> numeroVitoriasDerrotas, int pontuacao, Torneio torneio, ArrayList<Jogador> jogadores) {
        this.inscricao = inscricao;
        this.colocacao = colocacao;
        this.nome = nome;
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
        this.pontuacao = pontuacao;
        this.torneio = torneio;
        this.jogadores = jogadores;
    }
    
    // Método que retorna a razão entre o número de vitórias e o número de derrotas da equipe
    public double calcularRazaoWinLoss() {
        return numeroVitoriasDerrotas.get(0) / numeroVitoriasDerrotas.get(1);
    }
    
    // Método que adiciona um jogador à equipe
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }
    
    public void criarLogin(String login) {
        //se nao ha nenhum login igual existente
        this.login = login;
    }
    
    public void criarSenha(String senha) {
        //se a senha estiver de acordo
        this.senha = senha;
    }
    
    public void informarEmailContato(String email) {
        this.email = email;
    }

    // Getters e setters
    public boolean isInscricao() {
        return inscricao;
    }

    public void setInscricao(boolean inscricao) {
        this.inscricao = inscricao;
    }

    public int getColocacao() {
        return colocacao;
    }

    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Integer> getNumeroVitoriasDerrotas() {
        return numeroVitoriasDerrotas;
    }

    public void setNumeroVitoriasDerrotas(ArrayList<Integer> numeroVitoriasDerrotas) {
        this.numeroVitoriasDerrotas = numeroVitoriasDerrotas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    
}
