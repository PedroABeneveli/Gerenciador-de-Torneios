/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Avaliacao;
import classes.Jogador;
import classes.Equipe;
import classes.Pessoa;
import classes.Torneio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class InscricaoEquipe extends javax.swing.JFrame {
    // atributo pra saber se clicou na tela de busca
    private boolean buscouJogador;
    private ArrayList<Jogador> listaJogadores;
    private Equipe equipe;
    private Avaliacao avaliacao;
    
    /**
     * Creates new form InscricaoTorneio
     */
    public InscricaoEquipe() {
        initComponents();
        
        JOptionPane.showMessageDialog(null, "Para escolher um jogador, primeiro escolha um ao apertar o botão Adicionar Jogador, e depois pressione no botão atualizar jogador", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        listaJogadores = new ArrayList<>();
        listaJogadores.add((Jogador) Login.usuarioLogado);
        buscouJogador = false;
        
        montarTxaCmb();
        estadoInicial();
    }
    
    // coloca os valores padroes para os campos
    private void estadoInicial() {
        txtNome.setText("");
        txtEmail.setText("");
        txaJogadores.setText("");
        
        txaJogadores.setEnabled(false);
        txtEmail.setEnabled(true);
        txtNome.setEnabled(true);
        btnAdicionarJogador.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnConfirmar.setEnabled(true);
    }
    
    // monta a txa e a cmb
    private void montarTxaCmb() {
        // reinicio esses elementos para ver quais elementos irao aparecer
        txaJogadores.setText("");
        cmbRepresentante.removeAllItems();
        cmbRepresentante.addItem("Escolha um jogador");

        // adiciono os usernames a combobox e a string com os nomes dos jogadores
        String txtArea = "";
        for (Jogador jogador : listaJogadores) {
            cmbRepresentante.addItem(jogador.getUsername());
            txtArea += jogador.getUsername();
            txtArea += "\n";
        }           
        txaJogadores.setText(txtArea);
    }
    
    // salva a alteracao feita nos jogadores
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
        // salva a nova relacao de equipe em todos os jogadores
        for (Jogador jogador : listaJogadores) {
            jogador.atualizarDados(equipe);
            hashUsers.replace(jogador.getUsername(), jogador);
        }
         
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
    
    // salva a alteracao no torneio e salva no arquivo
    private boolean armazenarMudancasTorneios() {
        // abre o arquivo com a lista de torneios
        ArrayList<Torneio> listaTorneios = new ArrayList<>();
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\torneios.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            listaTorneios = (ArrayList<Torneio>) objectIn.readObject();
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
        
        int idxTorneio = listaTorneios.indexOf(BuscaTorneios.torneioSelecionado);
        if (idxTorneio >= 0) {
            listaTorneios.remove(idxTorneio);
            BuscaTorneios.torneioSelecionado.addAvaliacoes(avaliacao);
            listaTorneios.add(idxTorneio, BuscaTorneios.torneioSelecionado);
        }
        
        // escreve a lista listaTorneios no arquivo
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
        lblJogadores = new javax.swing.JLabel();
        srcJogadores = new javax.swing.JScrollPane();
        txaJogadores = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdicionarJogador = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        lblRepresentante = new javax.swing.JLabel();
        cmbRepresentante = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inscrição");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/trofeu32px.png")).getImage());

        lblNome.setText("Nome da Equipe:");

        lblJogadores.setText("Participantes:");

        txaJogadores.setColumns(20);
        txaJogadores.setRows(5);
        srcJogadores.setViewportView(txaJogadores);

        btnAdicionarJogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/encontrarEquipe32px.png"))); // NOI18N
        btnAdicionarJogador.setText("Adicionar Jogador");
        btnAdicionarJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarJogadorActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar32px.png"))); // NOI18N
        btnConfirmar.setText("Confirmar Inscrição");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblRepresentante.setText("Representante:");

        cmbRepresentante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um jogador" }));

        lblEmail.setText("E-mail de contato:");

        btnAtualizar.setText("Atualizar Jogadores");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRepresentante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbRepresentante, 0, 211, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarJogador))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblJogadores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(srcJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJogadores)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(srcJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionarJogador)
                            .addComponent(lblRepresentante)
                            .addComponent(cmbRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnAtualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarJogadorActionPerformed
        buscouJogador = true;
        new BuscaJogadores().setVisible(true);
    }//GEN-LAST:event_btnAdicionarJogadorActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // primeiro, para adicionar o jogador escolhido, colocamos ele na lista
        if (!buscouJogador || (buscouJogador && BuscaJogadores.jogadorSelecionado == null)) {
            JOptionPane.showMessageDialog(null, "Selecione um jogador primeiro", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            listaJogadores.add(BuscaJogadores.jogadorSelecionado);
            montarTxaCmb();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        boolean cadastroOk = true;
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        if (!(txtEmail.getText().contains("@") && txtEmail.getText().contains(".com"))) {
            JOptionPane.showMessageDialog(null, "Email inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        if (cmbRepresentante.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha um representante!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (cadastroOk) {
            // pega qual o indice do representante (indexado em 1)
            int idxCmb = cmbRepresentante.getSelectedIndex();
            equipe = new Equipe(txtNome.getText(), listaJogadores, listaJogadores.get(idxCmb-1));
            equipe.informarEmailContato(txtEmail.getText());
            
            avaliacao = new Avaliacao(BuscaTorneios.torneioSelecionado, equipe);
            equipe.setAvaliacoes(avaliacao);
            
            boolean deuCerto1 = armazenarMudancasHash();
            boolean deuCerto2 = armazenarMudancasTorneios();
            if (deuCerto1 && deuCerto2) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                new MostrarTorneio().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblJogadores = new javax.swing.JLabel();
        srcJogadores = new javax.swing.JScrollPane();
        lstJogadores = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdicionarJogador = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        lblRepresentante = new javax.swing.JLabel();
        cmbRepresentante = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome da Equipe:");

        lblJogadores.setText("Participantes:");

        lstJogadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Jogador 1", "Jogador 2", "Jogador 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        srcJogadores.setViewportView(lstJogadores);

        btnAdicionarJogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/encontrarEquipe32px.png"))); // NOI18N
        btnAdicionarJogador.setText("Adicionar Jogador");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnVoltar.setText("Voltar");

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar32px.png"))); // NOI18N
        btnConfirmar.setText("Confirmar Inscrição");

        lblRepresentante.setText("Representante:");

        cmbRepresentante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um jogador" }));

        lblEmail.setText("E-mail de contato:");

        lblSenha.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srcJogadores)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRepresentante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbRepresentante, 0, 154, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarJogador))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblJogadores)
                            .addComponent(lblSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmail))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJogadores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarJogador)
                    .addComponent(lblRepresentante)
                    .addComponent(cmbRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(InscricaoEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscricaoEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscricaoEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscricaoEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InscricaoEquipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarJogador;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbRepresentante;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblJogadores;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRepresentante;
    private javax.swing.JScrollPane srcJogadores;
    private javax.swing.JTextArea txaJogadores;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
