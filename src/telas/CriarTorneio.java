/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Jogo;
import classes.Pessoa;
import classes.Torneio;
import classes.Organizador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CriarTorneio extends javax.swing.JFrame {
    
    private ArrayList<Torneio> listaTorneios;
    // atributo para controlar se o usuário já selecionou um jogo
    private boolean pesquisouJogo;
    // torneio criado
    private Torneio torneioCriado;
    
    /**
     * Creates new form CriarTorneio
     */
    public CriarTorneio() {
        initComponents();
        
        // abre o arquivo com a lista de torneios
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\torneios.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            listaTorneios = (ArrayList<Torneio>) objectIn.readObject();
            fileIn.close();
            objectIn.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
        } catch (IOException e) {
            System.out.println("Erro inicializando stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao achei a classe");
        }
        
        pesquisouJogo = false;
        estadoInicial();
    }
    
    // habilita, desabilita campos e preenche as areas de texto com seus valores iniciais
    private void estadoInicial() {
        txtNome.setText("");
        frmData.setText("");
        txtNomeJogo.setText("");
        txtFormato.setText("");
        txtNumEtapas.setText("");
        
        txtNome.setEnabled(true);
        txtFormato.setEnabled(true);
        txtNumEtapas.setEnabled(true);
        frmData.setEnabled(true);
        txtNomeJogo.setEnabled(false);      // Pois nesse campo de texto será escrito um atributo, não é modificável
        btnAtualizar.setEnabled(true);
        btnEscolherJogo.setEnabled(true);
        btnSair.setEnabled(true);
        btnSalvar.setEnabled(true);
    }
    
    private boolean armazenarLista() {
        // escreve o atributo listaTorneios no arquivo
        try {
            
            FileOutputStream fileOut = new FileOutputStream(new File("src\\arquivos\\torneios.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            objectOut.writeObject(listaTorneios);
            
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
    
    // salva a alteracao que sera feita no organizador
    private boolean armazenarMudancasHash() {
        HashMap<String, Pessoa> hashUsers = new HashMap<>();
        // faz a leitura do arquivo login.txt
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\login.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            hashUsers = (HashMap<String, Pessoa>) objectIn.readObject();
            fileIn.close();
            objectIn.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
            return false;
        } catch (IOException e) {
            System.out.println("Erro inicializando stream input");
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Nao achei a classe");
            return false;
        }
        
        // salva o novo torneio na lista de torneios do organizador e atualiza a hashTable
        ((Organizador) Login.usuarioLogado).addTorneio(torneioCriado);
        hashUsers.replace(Login.usuarioLogado.getUsername(), (Organizador) Login.usuarioLogado);       
         
        // salva a mudanca na hash
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        frmData = new javax.swing.JFormattedTextField();
        lblJogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEscolherJogo = new javax.swing.JButton();
        txtNomeJogo = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        lblFormato = new javax.swing.JLabel();
        lblNumeroEtapas = new javax.swing.JLabel();
        txtFormato = new javax.swing.JTextField();
        txtNumEtapas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criação de Torneios");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/trofeu32px.png")).getImage());

        lblNome.setText("Nome:");

        lblData.setText("Data:");

        try {
            frmData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblJogo.setText("Jogo");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar32px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEscolherJogo.setText("Escolher Jogo");
        btnEscolherJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherJogoActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar o nome do jogo");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblFormato.setText("Formato:");

        lblNumeroEtapas.setText("Número de etapas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEscolherJogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtNomeJogo)
                            .addComponent(txtFormato)
                            .addComponent(txtNumEtapas)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumeroEtapas)
                                    .addComponent(lblNome)
                                    .addComponent(lblData)
                                    .addComponent(frmData, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJogo)
                                    .addComponent(lblFormato))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frmData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscolherJogo)
                    .addComponent(btnAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFormato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumeroEtapas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscolherJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherJogoActionPerformed
        pesquisouJogo = true;
        new BuscaJogos().setVisible(true);
    }//GEN-LAST:event_btnEscolherJogoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (!pesquisouJogo || (pesquisouJogo && BuscaJogos.jogoSelecionado == null))
            // se abriu a tela de pesquisa de jogos, mas não escolheu um ou não abriu a tela
            JOptionPane.showMessageDialog(null, "Selecione um jogo primeiro", "Aviso", JOptionPane.WARNING_MESSAGE);
        else {
            Jogo jogo = BuscaJogos.jogoSelecionado;
            txtNomeJogo.setText(jogo.getNome());
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean cadastroOk = true;
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome Inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            cadastroOk = false;
        }
        if (frmData.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
            cadastroOk = false;
        }
        if (!pesquisouJogo || (pesquisouJogo && BuscaJogos.jogoSelecionado == null)) {
            JOptionPane.showMessageDialog(null, "Escolha um jogo", "Aviso", JOptionPane.WARNING_MESSAGE);
            cadastroOk = false;
        }
        if (txtFormato.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Formato Inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            cadastroOk = false;
        }
        if (txtNumEtapas.getText().isBlank() || !txtNumEtapas.getText().chars().allMatch(Character::isDigit)) {
            JOptionPane.showMessageDialog(null, "Número de etapas inválido, deve ser númerico!", "Aviso", JOptionPane.WARNING_MESSAGE);
            cadastroOk = false;
        }
        
        if (cadastroOk) {
            try {
                Date dataRealizacao = new SimpleDateFormat("dd/MM/yyyy").parse(frmData.getText());
                Torneio torneio = new Torneio(txtNome.getText(), dataRealizacao, txtFormato.getText(), Integer.parseInt(txtNumEtapas.getText()), BuscaJogos.jogoSelecionado);
                torneioCriado = torneio;
                listaTorneios.add(torneio);
                boolean deuCerto = armazenarLista();
                if (Login.usuarioLogado instanceof Organizador) {
                    armazenarMudancasHash();
                }
                if (deuCerto) {
                    JOptionPane.showMessageDialog(null, "Torneio criado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                    new TelaOrganizador().setVisible(true);
                    this.dispose();
                }
            } catch (ParseException e) {
                System.out.println("Problema na leitura da data");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja cancelar a criação desse torneio?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // 0 = sim, 1 = nao
        
        if (resp == 0) {
            new TelaOrganizador().setVisible(true);
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
            java.util.logging.Logger.getLogger(CriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarTorneio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarTorneio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEscolherJogo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField frmData;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblJogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumeroEtapas;
    private javax.swing.JTextField txtFormato;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeJogo;
    private javax.swing.JTextField txtNumEtapas;
    // End of variables declaration//GEN-END:variables
}
