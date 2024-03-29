/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public abstract class Pessoa implements Serializable {
    // variavel para arquivos
    private static final long serialVersionUID = 1L;
    // Atributos
    protected String nome;
    protected String username;
    protected String email;
    protected String CPF;
    protected Date dataDeNascimento;
    protected String endereco;
    protected String senha;

    // Construtores
    public Pessoa() {
            
    }
    
    public Pessoa(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.CPF = CPF;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.senha = senha;
    }
    
    public Pessoa(String nome, String username, String CPF, Date dataDeNascimento, String endereco, String senha) {
        this.nome = nome;
        this.username = username;
        this.CPF = CPF;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.senha = senha;
    }
    
    // Assinatura dos métodos abstratos getTela, criarLogin, criarSenha e informarEmailContato
    public abstract TelaInicial getTela();

    // Getters e setters
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
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
