package telas;

import classes.Jogador;
import classes.Organizador;
import classes.Pessoa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public static Pessoa usuarioLogado;
    // tabela hash que contem como chave o nome do usuario
    // e o valor é o objeto Pessoa, que tem o atributo senha, que ja eh a criptografia da concatenacao de ususaario e senha
    private HashMap<String, Pessoa> hashUsuarios = new HashMap<>();
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        resetTela();
        
        try {
            
            FileInputStream fileIn = new FileInputStream(new File("src\\arquivos\\login.txt"));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            hashUsuarios = (HashMap<String, Pessoa>) objectIn.readObject();
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
    
    // inicializa as caixas de texto sem texto e habilita os btns e caixas de texto
    private void resetTela() {
        txtUsuario.setText("");
        pswSenha.setText("");
        
        btnCadastro.setEnabled(true);
        btnLogin.setEnabled(true);
        txtUsuario.setEnabled(true);
        pswSenha.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDados = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsuario.setText("Usuário");

        lblSenha.setText("Senha");

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/enter32px.png"))); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblSenha))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pswSenha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin)))
                .addContainerGap())
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gerenciador de Torneios");

        btnCadastro.setText("Cadastrar novo Usuário");
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addComponent(btnCadastro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastro)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        new CadastroInicial().setVisible(true);
        // retiramos essa tela pra garantir que o usuario nao vai logar com uma outra tela aberta
        this.dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (hashUsuarios.containsKey(txtUsuario.getText())) {
            // desabilita os btns e caixas de texto pro usuario nao mexer nelas quando tiver um JOptionPane
            btnCadastro.setEnabled(false);
            btnLogin.setEnabled(false);
            txtUsuario.setEnabled(false);
            pswSenha.setEnabled(false);
            
            // transforma a char array da pswSenha em string
            String senha = new String(pswSenha.getPassword());
            
            // teste pra ver se eh admin
            if (txtUsuario.getText().equals("Administrador") && senha.equals("12345")) {
                new Admin().setVisible(true);
                this.dispose();
            // verificacao da senha de organizador ou jogador
            } else {
                Pessoa user = hashUsuarios.get(txtUsuario.getText());
                
                // juntamos o nome de usuario com a senha pra verificar se a codificacao eh igual
                String chave = txtUsuario.getText() + senha;
                String senhaCriptografada = criptografa(chave);
                
                if (senhaCriptografada.equals(user.getSenha())) {
                    JOptionPane.showMessageDialog(null, "Usuário logado com sucesso.", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                    // salva o usuario logado
                    usuarioLogado = user;
                    user.getTela().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            resetTela();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCadastro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
