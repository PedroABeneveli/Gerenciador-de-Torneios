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
public class Organizador extends Pessoa {
    private double nota;
    private ArrayList<Torneio> torneiosCriados;
    private Torneio torneio;

    public Organizador() {
    }

    public Organizador(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha, double nota, ArrayList<Torneio> torneiosCriados, Torneio torneio) {
        super(nome, email, CPF, dataDeNascimento, endereco, senha);
        this.username = username;
        this.nota = nota;
        this.torneiosCriados = torneiosCriados;
        this.torneio = torneio;
    }
    
    public Organizador(String nome, String CPF, Date dataDeNascimento, String endereco, double nota, ArrayList<Torneio> torneiosCriados, Torneio torneio) {
        super(nome, CPF, dataDeNascimento, endereco);
        this.nota = nota;
        this.torneiosCriados = torneiosCriados;
        this.torneio = torneio;
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
    
    public void finalizarTorneio() {
        torneiosCriados.add(torneio);
        torneio = null;
    } 

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public ArrayList<Torneio> getTorneiosCriados() {
        return torneiosCriados;
    }

    public void setTorneiosCriados(ArrayList<Torneio> torneiosCriados) {
        this.torneiosCriados = torneiosCriados;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
