/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Date;
import telas.TelaOrganizador;

/**
 *
 * @author gustavo
 */
public class Organizador extends Pessoa {
    // variavel para arquivos
    private static final long serialVersionUID = 3L;
    // Atributos
    private double nota;
    private ArrayList<Torneio> torneiosCriados = new ArrayList<>();
    
    // Construtores
    public Organizador() {
    }

    public Organizador(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha, double nota, ArrayList<Torneio> torneiosCriados) {
        super(nome, email, CPF, dataDeNascimento, endereco, senha);
        this.username = username;
        this.nota = nota;
        this.torneiosCriados = torneiosCriados;
    }
    
    public Organizador(String nome, String username, String CPF, Date dataDeNascimento, String endereco, String senha) {
        super(nome, username, CPF, dataDeNascimento, endereco, senha);
    }
    
    public Organizador(String nome, String username, String email, String CPF, Date dataDeNascimento, String endereco, String senha) {
        super(nome, username, email, CPF, dataDeNascimento, endereco, senha);
    }
    
    
    // Implementação do método abstrato getTela da superclasse abstrata Pessoa, retorna um objeto da classe TelaJogador
    @Override
    public TelaInicial getTela() {
        return new TelaOrganizador();
    }
    
    // Calcula a avaliação média dos seus torneios criados
    public double calculaAvaliação() {
        if (torneiosCriados.size() > 0) {
            long soma = 0;
            for (Torneio torneio : torneiosCriados) {
                soma += torneio.calcularNota();
            }
            return soma / torneiosCriados.size();
        }
        return -1;
    }
    
    // adicionar um novo torneio
    public void addTorneio(Torneio torneio) {
        this.torneiosCriados.add(torneio);
    }
    
    // Getters e setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
