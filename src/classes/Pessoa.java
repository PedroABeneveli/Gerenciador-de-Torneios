/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Pessoa {
    protected String nome;
    protected String email;
    protected String CPF;
    protected Date dataDeNascimento;
    protected String endereco;
    protected String senha;

    public Pessoa() {
            
    }
    
    public Pessoa(String nome, String email, String CPF, Date dataDeNascimento, String endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.senha = senha;
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