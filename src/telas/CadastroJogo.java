/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Jogo;
import classes.Pessoa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author gustavo
 */
public class CadastroJogo extends javax.swing.JFrame {
    
    private Jogo jogo;
    private ArrayList<Jogo> listaJogos;
    /**
     * Creates new form CadastroJogo
     */
    public CadastroJogo() {
        initComponents();
        
        // abre o arquivo com a lista de jogos pra gravar nela
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\jogos.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            listaJogos = (ArrayList<Jogo>) objectIn.readObject();
            fileIn.close();
            objectIn.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
        } catch (IOException e) {
            System.out.println("Erro inicializando stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao achei a classe");
        }
        
        // inicializando os campos dependendo se um jogo foi escolhido
        estadoInicial();
        if (BuscaJogos.selecionadoIdx != -1) {
            Jogo selecionado = BuscaJogos.jogoSelecionado;
            
            // colocando os textos em suas areas
            // formatando a data
            Format formatador = new SimpleDateFormat("ddMMYYYY HH:mm:ss");
            // como temos o valor em horas que não nos interessa, usamos o .split pra pegar apenas a parte relevante
            frmDataDePublicação.setText((formatador.format(selecionado.getDataDeCriacao())).split(" ")[0]);
            
            // montando e colocando a string da area de texto
            String mapas = "";
            for (String s : selecionado.getMapas())
                mapas += s + '\n';
            txaMapas.setText(mapas);
            
            txtCondicaoDeVitoria.setText(selecionado.getCondicaoVitoria());
            txtCriadora.setText(selecionado.getCriadora());
            txtNome.setText(selecionado.getNome());
            txtPublicadora.setText(selecionado.getPublicadora());
            
            // habilitando e desabilitando elementos
            txtCondicaoDeVitoria.setEnabled(false);
            txtCriadora.setEnabled(false);
            txtNome.setEnabled(false);
            txtPublicadora.setEnabled(false);
            frmDataDePublicação.setEnabled(false);
            txaMapas.setEnabled(false);
            
            btnEditar.setVisible(true);
            btnEditar.setEnabled(true);
            btnExcluir.setVisible(true);
            btnExcluir.setEnabled(true);
            btnFinalizarCadastro.setEnabled(false);
        } else {
            btnEditar.setEnabled(false);
            btnEditar.setVisible(false);
            btnExcluir.setEnabled(false);
            btnExcluir.setVisible(false);
        }
    }
    
    private void estadoInicial() {
        // habilita os elementos
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnFinalizarCadastro.setEnabled(true);
        btnSair.setEnabled(true);
        txtCondicaoDeVitoria.setEnabled(true);
        txtCriadora.setEnabled(true);
        txtNome.setEnabled(true);
        txtPublicadora.setEnabled(true);
        frmDataDePublicação.setEnabled(true);
        txaMapas.setEnabled(true);
        
        // coloca valores padrão nos campos de texto
        txtCondicaoDeVitoria.setText("");
        txtCriadora.setText("");
        txtNome.setText("");
        txtPublicadora.setText("");
        frmDataDePublicação.setText("");
        txaMapas.setText("");
    }
    
    private boolean armazenarLista() {
        // escreve o atributo listaJogos no arquivo
        try {
            
            FileOutputStream fileOut = new FileOutputStream(new File("src\\arquivos\\jogos.txt"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            objectOut.writeObject(listaJogos);
            
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

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCriadora = new javax.swing.JLabel();
        txtCriadora = new javax.swing.JTextField();
        lblPublicadora = new javax.swing.JLabel();
        txtPublicadora = new javax.swing.JTextField();
        lblDataPublicacao = new javax.swing.JLabel();
        lblCondicaoVitoria = new javax.swing.JLabel();
        txtCondicaoDeVitoria = new javax.swing.JTextField();
        frmDataDePublicação = new javax.swing.JFormattedTextField();
        lblMapas = new javax.swing.JLabel();
        srcMapas = new javax.swing.JScrollPane();
        txaMapas = new javax.swing.JTextArea();
        btnFinalizarCadastro = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblTitulo.setText("Cadastrar Jogo");

        lblNome.setText("Nome:");

        lblCriadora.setText("Criadora:");

        lblPublicadora.setText("Publicadora:");

        lblDataPublicacao.setText("Data de publicação:");

        lblCondicaoVitoria.setText("Condição de vitória:");

        try {
            frmDataDePublicação.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblMapas.setText("Mapas:");

        txaMapas.setColumns(20);
        txaMapas.setRows(5);
        srcMapas.setViewportView(txaMapas);

        btnFinalizarCadastro.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnFinalizarCadastro.setText("Finalizar Cadastro");
        btnFinalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCriadora)
                            .addComponent(txtCriadora, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPublicadora)
                            .addComponent(txtPublicadora, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frmDataDePublicação, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataPublicacao)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnFinalizarCadastro)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEditar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExcluir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                    .addComponent(btnSair))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCondicaoDeVitoria, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addComponent(lblCondicaoVitoria)
                                        .addComponent(lblMapas)
                                        .addComponent(srcMapas))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(38, 38, 38)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCriadora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCriadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPublicadora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPublicadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDataPublicacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frmDataDePublicação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCondicaoVitoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCondicaoDeVitoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMapas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srcMapas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCadastro)
                    .addComponent(btnSair)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroActionPerformed
        boolean cadastroOk = true;
        
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        } else if (BuscaJogos.selecionadoIdx == -1) {
            // o indice selecionado eh -1, estamos cadastrando um novo jogo
            for (Jogo jogoLista : listaJogos) {
                if (jogoLista.getNome().equals(txtNome.getText())) {
                    JOptionPane.showMessageDialog(null, "Jogo já cadastrado.", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
                    cadastroOk = false;
                    break;
                }
            }
        }
        
        if (txtCriadora.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Criadora inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtPublicadora.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Publicadora inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (frmDataDePublicação.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txtCondicaoDeVitoria.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Condição de vitória inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (txaMapas.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Mapas inválidos!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            cadastroOk = false;
        }
        
        if (cadastroOk) {
            try {
                Date dataDePublicacao = new SimpleDateFormat("dd/MM/yyyy").parse(frmDataDePublicação.getText());
                String arrMapas[] = txaMapas.getText().split("\n");
                ArrayList<String> mapas = new ArrayList<>(Arrays.asList(arrMapas));
                jogo = new Jogo(txtNome.getText(), txtCriadora.getText(), txtPublicadora.getText(), dataDePublicacao, mapas, txtCondicaoDeVitoria.getText());
                if (BuscaJogos.selecionadoIdx == -1) {    
                    // adiciona o elem a lista
                    listaJogos.add(jogo);
                } else {
                    // troca o valor do elemento pelo criado agora
                    listaJogos.set(BuscaJogos.selecionadoIdx, jogo);
                }
                boolean deuCerto = armazenarLista();
                if (deuCerto) {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                    new BuscaJogos().setVisible(true);
                    this.dispose();
                }
            } catch (ParseException ex) {
            }
        }
    }//GEN-LAST:event_btnFinalizarCadastroActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja descartar os dados e cancelar o cadastro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // 0 = sim, 1 = nao

        if (resp == 0) {
            new BuscaJogos().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // desabilito editar pra não clicarem de novo, mas deixo os outros habilitados pois podem ser utilizados
        btnEditar.setEnabled(false);
        btnFinalizarCadastro.setEnabled(true);
        btnExcluir.setEnabled(true);
        
        txtCondicaoDeVitoria.setEnabled(true);
        txtCriadora.setEnabled(true);
        txtNome.setEnabled(true);
        txtPublicadora.setEnabled(true);
        frmDataDePublicação.setEnabled(true);
        txaMapas.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir esse jogo do sistema?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // 0 = sim, 1 = nao

        if (resp == 0)  {
            listaJogos.remove(BuscaJogos.jogoSelecionado);
            boolean deuCerto = armazenarLista();
            if (deuCerto) {
                JOptionPane.showMessageDialog(null, "Jogo excluído com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                new BuscaJogos().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnSair;
    private javax.swing.JFormattedTextField frmDataDePublicação;
    private javax.swing.JLabel lblCondicaoVitoria;
    private javax.swing.JLabel lblCriadora;
    private javax.swing.JLabel lblDataPublicacao;
    private javax.swing.JLabel lblMapas;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPublicadora;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane srcMapas;
    private javax.swing.JTextArea txaMapas;
    private javax.swing.JTextField txtCondicaoDeVitoria;
    private javax.swing.JTextField txtCriadora;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPublicadora;
    // End of variables declaration//GEN-END:variables
}
