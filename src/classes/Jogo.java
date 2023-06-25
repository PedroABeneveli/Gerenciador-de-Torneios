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
public class Jogo {
    private String nome;
    private String criadora;
    private String publicadora;
    private Date dataDeCriacao;
    private ArrayList<String> mapas;
    private String condicaoVitoria;
    private ArrayList<Torneio> torneios;
    
    public Jogo() {
        
    }

    public Jogo(String nome, String criadora, String publicadora, Date dataDeCriacao, ArrayList<String> mapas, String condicaoVitoria, ArrayList<Torneio> torneios) {
        this.nome = nome;
        this.criadora = criadora;
        this.publicadora = publicadora;
        this.dataDeCriacao = dataDeCriacao;
        this.mapas = mapas;
        this.condicaoVitoria = condicaoVitoria;
        this.torneios = torneios;
    }
    
    public Jogo(String nome, String criadora, String publicadora, Date dataDeCriacao, ArrayList<String> mapas, String condicaoVitoria) {
        this.nome = nome;
        this.criadora = criadora;
        this.publicadora = publicadora;
        this.dataDeCriacao = dataDeCriacao;
        this.mapas = mapas;
        this.condicaoVitoria = condicaoVitoria;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCriadora() {
        return criadora;
    }

    public void setCriadora(String criadora) {
        this.criadora = criadora;
    }

    public String getPublicadora() {
        return publicadora;
    }

    public void setPublicadora(String publicadora) {
        this.publicadora = publicadora;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public ArrayList<String> getMapas() {
        return mapas;
    }

    public void setMapas(ArrayList<String> mapas) {
        this.mapas = mapas;
    }

    public String getCondicaoVitoria() {
        return condicaoVitoria;
    }

    public void setCondicaoVitoria(String condicaoVitoria) {
        this.condicaoVitoria = condicaoVitoria;
    }

    public ArrayList<Torneio> getTorneios() {
        return torneios;
    }

    public void setTorneios(ArrayList<Torneio> torneios) {
        this.torneios = torneios;
    }
    
    
    
}
