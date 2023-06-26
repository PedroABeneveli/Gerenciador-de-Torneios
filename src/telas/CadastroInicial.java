/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Jogador;
import classes.Organizador;
import classes.Pessoa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.HashMap;
import javax.swing.JOptionPane;


/**
 *
 * @author gustavo
 */
public class CadastroInicial extends javax.swing.JFrame {
    
    private Jogador jogador;
    private Organizador organizador;
    private HashMap<String, Pessoa> hashUsers;
    
    /**
     * Creates new form CadastrarJogador
     */
    public CadastroInicial() {
        initComponents();
        pnlCadastroJogador.setVisible(false);
        
        // faz a leitura do arquivo login.txt
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\login.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            hashUsers = (HashMap<String, Pessoa>) objectIn.readObject();
            fileIn.close();
            objectIn.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
        } catch (IOException e) {
            System.out.println("Erro inicializando stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao achei a classe");
        }
    }
    
    // vai receber o username e o objeto tipo pessoa, e vai armazenar na hash do arquivo login.txt
    // retorna false se o cadastro falhou
    private boolean armazenarHash(Pessoa cadastro) {
        hashUsers.put(cadastro.getUsername(), cadastro);
        // escreve a hash modificada no arquivo
        try {
            
            FileOutputStream fileOut = new FileOutputStream(new File("src\\arquivos\\login.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            objectOut.writeObject(hashUsers);
            
            objectOut.close();
            fileOut.close();
            
            return true;
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
            return false;
        } catch (IOException e) {
            System.out.println("Erro inicializando stream");
            return false;
        }
    }
    
    // criptografa a sring dada e retorna ela em uma string com sua representação em hexadecimal
    private String criptografa(String palavra) {
        String cript;
        try {
            // define o tipo de criptografia utilizada
            MessageDigest mesDig = MessageDigest.getInstance("SHA-256");
            
            // criptografa a string dada
            byte[] seqBytesCrip = mesDig.digest(palavra.getBytes(StandardCharsets.UTF_8));
            
            // pega a sequencia de bytes e transforma em uma string dos bytes em base hexadecimal
            cript = new BigInteger(1, seqBytesCrip).toString(16);
            
        } catch (NoSuchAlgorithmException erro) {
            System.out.println("Erro de algoritmo errado");
            cript = "erro";
        }
        
        return cript;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnCadastrarJogador = new javax.swing.JButton();
        btnCadastrarOrganizador = new javax.swing.JButton();
        pnlCadastroJogador = new javax.swing.JPanel();
        lblTecnico = new javax.swing.JLabel();
        lblEquipe = new javax.swing.JLabel();
        btnFinalizarCadastroJogador = new javax.swing.JButton();
        btnCancelarCadastroJogador = new javax.swing.JButton();
        rbtNaoTecnico = new javax.swing.JRadioButton();
        rbtSimTecnico = new javax.swing.JRadioButton();
        rbtSimFreeAgent = new javax.swing.JRadioButton();
        rbtNaoFreeAgent = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        pswConfirmaSenha = new javax.swing.JPasswordField();
        frmDataDeNascimento = new javax.swing.JFormattedTextField();
        frmCPF = new javax.swing.JFormattedTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        lblTitulo.setText("Cadastro Inicial");

        lblNome.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblNome.setText("Nome:");

        lblCPF.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblCPF.setText("CPF:");

        lblDataNascimento.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblDataNascimento.setText("Data de nascimento:");

        lblEndereco.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblUsername.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblUsername.setText("Username:");

        btnCadastrarJogador.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnCadastrarJogador.setText("Cadastrar Jogador");
        btnCadastrarJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarJogadorActionPerformed(evt);
            }
        });

        btnCadastrarOrganizador.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnCadastrarOrganizador.setText("Cadastrar Organizador");
        btnCadastrarOrganizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarOrganizadorActionPerformed(evt);
            }
        });

        pnlCadastroJogador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCadastroJogador.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlCadastroJogadorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblTecnico.setText("Deseja ser técnico de equipe?");

        lblEquipe.setText("Pertence a alguma equipe?");

        btnFinalizarCadastroJogador.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnFinalizarCadastroJogador.setText("Finalizar Cadastro");
        btnFinalizarCadastroJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroJogadorActionPerformed(evt);
            }
        });

        btnCancelarCadastroJogador.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnCancelarCadastroJogador.setText("Cancelar");
        btnCancelarCadastroJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroJogadorActionPerformed(evt);
            }
        });

        rbtNaoTecnico.setText("Não");

        rbtSimTecnico.setText("Sim");
        rbtSimTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSimTecnicoActionPerformed(evt);
            }
        });

        rbtSimFreeAgent.setText("Sim");
        rbtSimFreeAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSimFreeAgentActionPerformed(evt);
            }
        });

        rbtNaoFreeAgent.setText("Não");

        javax.swing.GroupLayout pnlCadastroJogadorLayout = new javax.swing.GroupLayout(pnlCadastroJogador);
        pnlCadastroJogador.setLayout(pnlCadastroJogadorLayout);
        pnlCadastroJogadorLayout.setHorizontalGroup(
            pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroJogadorLayout.createSequentialGroup()
                .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlCadastroJogadorLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnFinalizarCadastroJogador)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelarCadastroJogador))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadastroJogadorLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroJogadorLayout.createSequentialGroup()
                                        .addComponent(rbtSimTecnico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbtNaoTecnico))
                                    .addGroup(pnlCadastroJogadorLayout.createSequentialGroup()
                                        .addComponent(rbtSimFreeAgent)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbtNaoFreeAgent)))
                                .addComponent(lblEquipe))))
                    .addGroup(pnlCadastroJogadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTecnico)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlCadastroJogadorLayout.setVerticalGroup(
            pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroJogadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTecnico)
                .addGap(9, 9, 9)
                .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtNaoTecnico)
                    .addComponent(rbtSimTecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEquipe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtSimFreeAgent)
                    .addComponent(rbtNaoFreeAgent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(pnlCadastroJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCadastroJogador)
                    .addComponent(btnCancelarCadastroJogador))
                .addGap(30, 30, 30))
        );

        lblEmail.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblEmail.setText("Email para contato (opcional):");

        lblSenha.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblSenha.setText("Senha:");

        lblConfirmarSenha.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblConfirmarSenha.setText("Confirmar senha:");

        try {
            frmDataDeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            frmCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSenha)
                            .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmarSenha)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(lblNome)
                            .addComponent(lblCPF))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCadastrarJogador)
                                    .addComponent(pswConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(btnCadastrarOrganizador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addComponent(txtEndereco)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEndereco)
                                            .addComponent(lblEmail)
                                            .addComponent(lblDataNascimento)
                                            .addComponent(frmCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(frmDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(86, 86, 86)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlCadastroJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(75, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(26, 26, 26)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCPF)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(frmCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataNascimento)
                        .addGap(12, 12, 12)
                        .addComponent(frmDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCadastroJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirmarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pswConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarJogador)
                    .addComponent(btnCadastrarOrganizador)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarOrganizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarOrganizadorActionPerformed
        boolean cadastroOk = true;
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtUsername.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Username inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        } else if (hashUsers.containsKey(txtUsername.getText())) {
            cadastroOk = false;
            JOptionPane.showMessageDialog(null, "Username já existente!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        if (frmCPF.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (frmDataDeNascimento.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtEndereco.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Endereco inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (!txtEmail.getText().isBlank()) {
            if (!(txtEmail.getText().contains("@") && txtEmail.getText().contains(".com"))) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
                cadastroOk = false;
            }
        } 
        
        if (String.valueOf(pswSenha.getPassword()).isBlank()) {
            JOptionPane.showMessageDialog(null, "Senha inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        // inicializa aqui pra ide nao reclamar
        String senhaCript = "";
        if (String.valueOf(pswConfirmaSenha.getPassword()).equals(String.valueOf(pswSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Cofirmação de senha não coerente!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        } else {
            // criptografa a chave pra salvar no usuario
            String chave = txtUsername.getText() + String.valueOf(pswSenha.getPassword());
            senhaCript = criptografa(chave);
            if (senhaCript.equals("erro")) {
                cadastroOk = false;
                JOptionPane.showMessageDialog(null, "Desculpe, problema interno", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (cadastroOk) {
            if (!txtEmail.getText().isBlank()) {
                try {
                    Date data = new SimpleDateFormat("dd/MM/yyyy").parse(frmDataDeNascimento.getText());
                    organizador = new Organizador(txtNome.getText(), txtUsername.getText(), frmCPF.getText(), data, txtEndereco.getText(), senhaCript);
                } catch (Exception e) {
                    
                }
                
            } else {
                try {
                    Date data = new SimpleDateFormat("dd/MM/yyyy").parse(frmDataDeNascimento.getText());
                    organizador = new Organizador(txtNome.getText(), txtUsername.getText(), txtEmail.getText(), frmCPF.getText(), data, txtEndereco.getText(), senhaCript);
                } catch (Exception e) {
                    
                }
            }
            
            boolean cadastroFeito = armazenarHash(organizador);
            if (cadastroFeito) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                new Login().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnCadastrarOrganizadorActionPerformed

    private void btnCadastrarJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarJogadorActionPerformed
            pnlCadastroJogador.setVisible(true);
    }//GEN-LAST:event_btnCadastrarJogadorActionPerformed

    private void pnlCadastroJogadorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlCadastroJogadorAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlCadastroJogadorAncestorAdded

    private void btnCancelarCadastroJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroJogadorActionPerformed
        pnlCadastroJogador.setVisible(false);
    }//GEN-LAST:event_btnCancelarCadastroJogadorActionPerformed

    private void btnFinalizarCadastroJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroJogadorActionPerformed
        boolean cadastroOk = true;
        // verificacao dos atributos gerais
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtUsername.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Username inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        } else if (hashUsers.containsKey(txtUsername.getText())) {
            cadastroOk = false;
            JOptionPane.showMessageDialog(null, "Username já existente!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        if (frmCPF.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (frmDataDeNascimento.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtEndereco.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Endereco inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (!txtEmail.getText().isBlank()) {
            if (!(txtEmail.getText().contains("@") && txtEmail.getText().contains(".com"))) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
                cadastroOk = false;
            }
        } 
        
        if (String.valueOf(pswSenha.getPassword()).isBlank()) {
            JOptionPane.showMessageDialog(null, "Senha inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        // inicializa aqui pra ide nao reclamar
        String senhaCript = "";
        if (!String.valueOf(pswConfirmaSenha.getPassword()).equals(String.valueOf(pswSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Cofirmação de senha não coerente!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        } else {
            // criptografa a chave pra salvar no usuario
            String chave = txtUsername.getText() + String.valueOf(pswSenha.getPassword());
            senhaCript = criptografa(chave);
            if (senhaCript.equals("erro")) {
                cadastroOk = false;
                JOptionPane.showMessageDialog(null, "Desculpe, problema interno", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (!rbtSimTecnico.isSelected() && !rbtNaoTecnico.isSelected() && !rbtSimFreeAgent.isSelected() && !rbtNaoFreeAgent.isSelected()) {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
        } else if (!rbtSimTecnico.isSelected() && !rbtNaoTecnico.isSelected()) {
            JOptionPane.showMessageDialog(null, "Nenhuma opção de técnico foi selecionada", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
        } else if (!rbtSimFreeAgent.isSelected()&& !rbtNaoFreeAgent.isSelected()) {
            JOptionPane.showMessageDialog(null, "Nenhuma opção de time foi selecionada", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean freeAgent, tecnico;
            if (rbtSimTecnico.isSelected()) {
                tecnico = true;
            } else {
                tecnico = false;
            }
            
            if (rbtNaoFreeAgent.isSelected()) {
                freeAgent = true;
            } else {
                freeAgent = false;
            }
            if (cadastroOk) {
                if (!txtEmail.getText().isBlank()) {
                    try {
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(frmDataDeNascimento.getText());
                        jogador = new Jogador(txtNome.getText(), txtUsername.getText(), frmCPF.getText(), data, txtEndereco.getText(), senhaCript, freeAgent, tecnico);
                    } catch (Exception e) {

                    }

                } else {
                    try {
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(frmDataDeNascimento.getText());
                        jogador = new Jogador(txtNome.getText(), txtUsername.getText(), txtEmail.getText(), frmCPF.getText(), data, txtEndereco.getText(), senhaCript, freeAgent, tecnico);
                    } catch (Exception e) {

                    }
                }
            }
            
            // armazena o novo objeto na hash table e fecha a tela
            boolean cadastroSucesso = armazenarHash(jogador);
            if (cadastroSucesso) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                new Login().setVisible(true);
                this.dispose();
            }
            
        }
    }//GEN-LAST:event_btnFinalizarCadastroJogadorActionPerformed

    private void rbtSimTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSimTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtSimTecnicoActionPerformed

    private void rbtSimFreeAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSimFreeAgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtSimFreeAgentActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja descartar os dados e voltar para a tela de login?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // 0 = sim, 1 = nao

        if (resp == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarJogador;
    private javax.swing.JButton btnCadastrarOrganizador;
    private javax.swing.JButton btnCancelarCadastroJogador;
    private javax.swing.JButton btnFinalizarCadastroJogador;
    private javax.swing.JButton btnSair;
    private javax.swing.JFormattedTextField frmCPF;
    private javax.swing.JFormattedTextField frmDataDeNascimento;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEquipe;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlCadastroJogador;
    private javax.swing.JPasswordField pswConfirmaSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JRadioButton rbtNaoFreeAgent;
    private javax.swing.JRadioButton rbtNaoTecnico;
    private javax.swing.JRadioButton rbtSimFreeAgent;
    private javax.swing.JRadioButton rbtSimTecnico;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
