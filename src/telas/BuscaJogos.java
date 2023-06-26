/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Jogo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class BuscaJogos extends javax.swing.JFrame {
    
    // atributos para saber qual tela que instanciou esta
    public static boolean vemAdmin;
    public static boolean vemBuscaTorneio;
    public static boolean vemCadastroTorneio;
    // lista lida do arquivo pra ter todos os jogos
    private ArrayList<Jogo> todosJogos;
    // Lista com os jogos mostrados na tabela
    private ArrayList<Jogo> jogosFiltrados;
    // jogo selecionado na tabela
    public static Jogo jogoSelecionado = null;
    public static int selecionadoIdx = -1;
    
    /**
     * Creates new form BuscaJogos
     */
    public BuscaJogos() {
        initComponents();
        
        todosJogos = new ArrayList<>();
        jogosFiltrados = new ArrayList<>();
        
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\jogos.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            todosJogos = (ArrayList<Jogo>) objectIn.readObject();
            fileIn.close();
            objectIn.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arq. não encontrado");
        } catch (IOException e) {
            System.out.println("Erro inicializando stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Nao achei a classe");
        }
        
        montarTabela(todosJogos);
        
        // coloca os valores iniciais dos campos e botoes
        txtCriadora.setEnabled(true);
        txtCriadora.setText("");
        txtNome.setEnabled(true);
        txtNome.setText("");
        txtPublicadora.setEnabled(true);
        txtPublicadora.setText("");
        frmLancamento.setEnabled(true);
        frmLancamento.setText("");
        btnPesquisar.setEnabled(true);
        btnVoltar.setEnabled(true);
        if (vemAdmin) {
            btnCadastro.setEnabled(true);
            btnCadastro.setVisible(true);
        } else {
            btnCadastro.setEnabled(false);
            btnCadastro.setVisible(false);
        }
    }
    
    private void montarTabela(ArrayList<Jogo> listaJogos) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome", "Criadora", "Publicadora", "Lançamento"}, 0);
        
        for (int i = 0 ; i < listaJogos.size() ; i++) {
            Object linha[] = {listaJogos.get(i).getNome(), 
                              listaJogos.get(i).getCriadora(), 
                              listaJogos.get(i).getPublicadora(),
                              listaJogos.get(i).getDataDeCriacao().toString()};
            modelo.addRow(linha);
        }
        
        tblJogos.setModel(modelo);
        
        tblJogos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblJogos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblJogos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblJogos.getColumnModel().getColumn(3).setPreferredWidth(20);
    }
    
    private void resetarOrigem() {
        vemAdmin = false;
        vemBuscaTorneio = false;
        vemCadastroTorneio = false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrTabela = new javax.swing.JScrollPane();
        tblJogos = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCriadora = new javax.swing.JLabel();
        lblPublicadora = new javax.swing.JLabel();
        lblLancamento = new javax.swing.JLabel();
        txtCriadora = new javax.swing.JTextField();
        frmLancamento = new javax.swing.JFormattedTextField();
        txtPublicadora = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jogos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Criadora", "Publicadora", "Lançamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJogosMouseClicked(evt);
            }
        });
        scrTabela.setViewportView(tblJogos);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit32px.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        lblCriadora.setText("Criadora");

        lblPublicadora.setText("Publicadora");

        lblLancamento.setText("Lançamento");

        try {
            frmLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar32px.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mais32px.png"))); // NOI18N
        btnCadastro.setText("Cadastrar Jogo");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(frmLancamento, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome))
                            .addComponent(lblLancamento))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCriadora)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPublicadora)
                                    .addComponent(lblCriadora))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPublicadora)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblCriadora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCriadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLancamento)
                    .addComponent(lblPublicadora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frmLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPublicadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnCadastro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Deseja encerrar a busca?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // 0 = sim, 1 = nao

        if (resp == 0) {
            if (vemAdmin) {
                resetarOrigem();
                new Admin().setVisible(true);
                this.dispose();
            } else {
                resetarOrigem();
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // pra saber na outra tela que não há um jogo selecionado
        selecionadoIdx = -1;
        new CadastroJogo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String nome, publicadora, criadora;
        nome = txtNome.getText();
        publicadora = txtPublicadora.getText();
        criadora = txtCriadora.getText();
        // lista com os jogos a serem exibidos na tabela
        jogosFiltrados.clear();
        // Se tem data
        if (!frmLancamento.getText().equals("  /  /    "))
            try {
                // se a data for valida, podemos fazer a busca
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(frmLancamento.getText());
                
                // procura em todos os elementos da lista pra ver aqueles que tem as partes dadas nos txtField e mesma data
                for (int i = 0 ; i < todosJogos.size() ; i++) {
                    Jogo jogo = todosJogos.get(i);
                    if (jogo.getNome().contains(nome) && jogo.getPublicadora().contains(publicadora) 
                            && jogo.getCriadora().contains(criadora) && jogo.getDataDeCriacao().equals(data))
                        jogosFiltrados.add(jogo);
                }
            } catch(ParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida!", "Não foi possível realizar o cadastro", JOptionPane.ERROR_MESSAGE);
            }
        else {
            // procura em todos os elementos da lista pra ver aqueles que tem as partes dadas nos txtField
            for (int i = 0 ; i < todosJogos.size() ; i++) {
                Jogo jogo = todosJogos.get(i);
                if (jogo.getNome().contains(nome) && jogo.getPublicadora().contains(publicadora) 
                        && jogo.getCriadora().contains(criadora))
                    jogosFiltrados.add(jogo);
            }
        }
        
        if (!jogosFiltrados.isEmpty())
            montarTabela(jogosFiltrados);
        else
            JOptionPane.showMessageDialog(null, "Nenhum jogo corresponde a esses parâmetros!", "Falha", JOptionPane.WARNING_MESSAGE);
        
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblJogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJogosMouseClicked
        int resp, idx = tblJogos.getSelectedRow();
        
        if (idx >= 0 && idx < jogosFiltrados.size()) {
            Jogo jogo = jogosFiltrados.get(idx);
            if (!vemAdmin) {
                jogoSelecionado = jogo;
                // confirma se o usuario quer selecionar esse jogo
                resp = JOptionPane.showConfirmDialog(null, "Deseja selecionar o jogo " + jogo.getNome() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                // 0 = sim, 1 = nao
                if (resp == 0) {
                    selecionadoIdx = idx;
                    this.dispose();
                }
            } else {
                resp = JOptionPane.showConfirmDialog(null, "Deseja ver os dados do jogo?", "Confirmar", JOptionPane.YES_NO_OPTION);
                // 0 = sim, 1 = nao

                if (resp == 0) {
                    selecionadoIdx = idx;
                    new CadastroJogo().setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_tblJogosMouseClicked

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
            java.util.logging.Logger.getLogger(BuscaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaJogos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField frmLancamento;
    private javax.swing.JLabel lblCriadora;
    private javax.swing.JLabel lblLancamento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPublicadora;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tblJogos;
    private javax.swing.JTextField txtCriadora;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPublicadora;
    // End of variables declaration//GEN-END:variables
}
