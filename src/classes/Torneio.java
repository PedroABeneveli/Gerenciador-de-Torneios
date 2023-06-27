/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Torneio implements Serializable {
    // variavel para arquivos
    private static final long serialVersionUID = 5L;
    // Atributos
    private String nome;
    private int numeroDeEquipes;
    private boolean temEquipes;
    private Date DataDeRealizacao;
    private String formato;
    private int numeroDeEtapas;
    private boolean ativo = true;       // um torneio sempre eh criado ativo
    private Jogo jogo;
    private ArrayList<Partida> partidas = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
    
    // Construtores
    public Torneio() {
        
    } 

    public Torneio(String nome, Date DataDeRealizacao, String formato, int numeroDeEtapas, Jogo jogo) {
        this.nome = nome;
        this.DataDeRealizacao = DataDeRealizacao;
        this.formato = formato;
        this.numeroDeEtapas = numeroDeEtapas;
        this.jogo = jogo;
    }    

    // percorre as equipes e determina qual eh a com colocacao 1
    public Equipe vencedor() {
        // TODO
        return null;
    }
    
    // com base nas avaliações vinculadas, calcula a nota média
    public float calcularNota() {
        if (avaliacoes.size() > 0) {
            long soma = 0;
            for (Avaliacao avaliacao : avaliacoes) {
                soma += avaliacao.calculaAvaliacao();
            }
            return soma / avaliacoes.size();
        }
        return -1;
    }
    
    // Getters e setters
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
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
    
    public void addAvaliacoes(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }
    
    
}
