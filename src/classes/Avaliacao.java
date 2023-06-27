/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author gustavo
 */
public class Avaliacao implements Serializable {
    // variavel para arquivos
    private static final long serialVersionUID = 8L;
    
    // Atributos
    private double regras;
    private double organizacao;
    private double trapaca;
    private double jogadores;
    private Torneio torneio;
    private Equipe equipe;
    
    // Construtores

    public Avaliacao(Torneio torneio, Equipe equipe) {
        this.torneio = torneio;
        this.equipe = equipe;
    }
    
    public Avaliacao(double regras, double organizacao, double trapaca, double jogadores, Torneio torneio, Equipe equipe) {
        this.regras = regras;
        this.organizacao = organizacao;
        this.trapaca = trapaca;
        this.jogadores = jogadores;
        this.torneio = torneio;
        this.equipe = equipe;
    }
    
    // Método que retorna a média simples dos atributos da Avaliacao
    public double calculaAvaliacao() {
        return (regras+organizacao+trapaca+jogadores)/4;
    }
    
    // Getters e Setters
    public double getRegras() {
        return regras;
    }
    
    public void setRegras(double regras) {
        this.regras = regras;
    }

    public double getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(double organizacao) {
        this.organizacao = organizacao;
    }

    public double getTrapaca() {
        return trapaca;
    }

    public void setTrapaca(double trapaca) {
        this.trapaca = trapaca;
    }

    public double getJogadores() {
        return jogadores;
    }

    public void setJogadores(double jogadores) {
        this.jogadores = jogadores;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
    
}
