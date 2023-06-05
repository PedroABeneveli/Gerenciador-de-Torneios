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
public class Torneio {
    private String nome;
    private int numeroDeEquipes;
    private boolean temEquipes;
    private Date DataDeRealizacao;
    private ArrayList<String> formato;
    private int numeroDeEtapas;
    private boolean ativo;
    private Jogo jogo;
    private ArrayList<Equipe> equipes;
    private ArrayList<Partida> partidas;
    private ArrayList<Avaliacao> avaliacoes;
    
    public Torneio() {
        
    } 
    
    public Torneio(String nome, int numeroDeEquipes, boolean temEquipes, Date DataDeRealizacao, ArrayList<String> formato, int numeroDeEtapas, boolean ativo, Jogo jogo, ArrayList<Equipe> equipes, ArrayList<Partida> partidas) {
        this.nome = nome;
        this.numeroDeEquipes = numeroDeEquipes;
        this.temEquipes = temEquipes;
        this.DataDeRealizacao = DataDeRealizacao;
        this.formato = formato;
        this.numeroDeEtapas = numeroDeEtapas;
        this.ativo = ativo;
        this.jogo = jogo;
        this.equipes = equipes;
        this.partidas = partidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeEquipes() {
        return numeroDeEquipes;
    }

    public void setNumeroDeEquipes(int numeroDeEquipes) {
        this.numeroDeEquipes = numeroDeEquipes;
    }

    public boolean isTemEquipes() {
        return temEquipes;
    }

    public void setTemEquipes(boolean temEquipes) {
        this.temEquipes = temEquipes;
    }

    public Date getDataDeRealizacao() {
        return DataDeRealizacao;
    }

    public void setDataDeRealizacao(Date DataDeRealizacao) {
        this.DataDeRealizacao = DataDeRealizacao;
    }

    public ArrayList<String> getFormato() {
        return formato;
    }

    public void setFormato(ArrayList<String> formato) {
        this.formato = formato;
    }

    public int getNumeroDeEtapas() {
        return numeroDeEtapas;
    }

    public void setNumeroDeEtapas(int numeroDeEtapas) {
        this.numeroDeEtapas = numeroDeEtapas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    
}
