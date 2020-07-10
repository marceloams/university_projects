/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.view;

import br.inatel.autoboss.model.UsuarioGeral;
import br.inatel.autoboss.contoller.UsuarioGeralDAO;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao Leonardo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jPanel2.setBackground(new Color(0, 0, 0, 200));
    }
    
    String email;
    String senha;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jEmailText = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jEnterbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSenhatext = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(540, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/AutoBoss.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 720));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login_background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("E-MAIL");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 340, 10));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("SENHA");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jEmailText.setBackground(new java.awt.Color(51, 51, 51));
        jEmailText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jEmailText.setForeground(new java.awt.Color(255, 255, 255));
        jEmailText.setBorder(null);
        jEmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailTextActionPerformed(evt);
            }
        });
        jPanel3.add(jEmailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 340, -1));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 340, 10));

        jEnterbtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jEnterbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jEnterbtn.setForeground(new java.awt.Color(153, 153, 153));
        jEnterbtn.setText("Entrar");
        jEnterbtn.setBorder(null);
        jEnterbtn.setBorderPainted(false);
        jEnterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnterbtnActionPerformed(evt);
            }
        });
        jPanel3.add(jEnterbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 340, 60));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Ainda não é cadastrado?");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 210, -1));

        jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Cadastrar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 140, 20));

        jLabel5.setText("Copyright © 2019 Auto Boss");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, -1, -1));

        jSenhatext.setBackground(new java.awt.Color(51, 51, 51));
        jSenhatext.setForeground(new java.awt.Color(255, 255, 255));
        jSenhatext.setBorder(null);
        jPanel3.add(jSenhatext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 340, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 540, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailTextActionPerformed

    private void jEnterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnterbtnActionPerformed
        email = jEmailText.getText();
        senha = String.valueOf(jSenhatext.getPassword());
        
        int usuarioId;
        
        //variavel verifica se achou
        boolean achou;
        
        //criando um objeto usuarioGeralDAO
        UsuarioGeralDAO udao = new UsuarioGeralDAO();
        
        //verificando o usuario no bd
        achou = udao.verificaUsuarioEmailSenha(email, senha);
        
        //funcao de paginacao
        if(email.equals("") || senha.equals("")){
            JOptionPane.showMessageDialog(null, "E-mail ou/e senha inexistente(s)!");
            achou = false;
        }
        else if(achou){
            usuarioId = udao.retornaId(email);
            Perfil perfil = new Perfil(usuarioId);
            perfil.setVisible(true);
            dispose();  
        }
    }//GEN-LAST:event_jEnterbtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cadastrar cadastrar = new Cadastrar();
        cadastrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jEmailText;
    private javax.swing.JButton jEnterbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jSenhatext;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}