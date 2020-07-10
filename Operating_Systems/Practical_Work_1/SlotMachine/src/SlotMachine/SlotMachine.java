/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import java.awt.event.*;

/**
 *
 * @author marce
 */
public class SlotMachine extends javax.swing.JFrame {

    //Credito
    static Credito credito = new Credito();

    //Sons
    static Som sCoin = new Som("src\\sounds\\CoinMario.wav");
    static Som sLoose = new Som("src\\sounds\\MarioDying.wav");
    static Som sWin5 = new Som("src\\sounds\\DilmaGanhar.wav");
    static Som sWin10 = new Som("src\\sounds\\YouWin.wav");
    static Som sInicio = new Som("src\\sounds\\WindowsStart.wav");
    static Som sFim = new Som("src\\sounds\\WindowsShutDown.wav");
    static Som sBtn = new Som("src\\sounds\\Button.wav");

    //Define as caracterisiticas do Jframe
    public SlotMachine() {
        initComponents(); //inicia componentes
        setResizable(false); //fixa o tamanho
        setLocationRelativeTo(null); //centraliza
        setVisible(true); //torna visivel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //desativa o btn de fechar
        
        //event listener para o btn de fechar || mostra opcao se deseja mesmo fechar
        this.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent e){
                int x = JOptionPane.showConfirmDialog(null,"Irá perder os seus créditos restantes, deseja mesmo sair?","close",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                if(x==JOptionPane.YES_OPTION){
                    e.getWindow().dispose();
                    sFim.play(false); //roda o som de shut down
                }else{
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelEspaco3 = new javax.swing.JLabel();
        labelEspaco1 = new javax.swing.JLabel();
        labelEspaco2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelCredito = new javax.swing.JLabel();
        btnJogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        labelEspaco3.setBackground(new java.awt.Color(255, 255, 255));
        labelEspaco3.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        labelEspaco3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEspaco3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon1.jpg"))); // NOI18N
        labelEspaco3.setOpaque(true);

        labelEspaco1.setBackground(new java.awt.Color(255, 255, 255));
        labelEspaco1.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        labelEspaco1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEspaco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon1.jpg"))); // NOI18N
        labelEspaco1.setOpaque(true);

        labelEspaco2.setBackground(new java.awt.Color(255, 255, 255));
        labelEspaco2.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        labelEspaco2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEspaco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon1.jpg"))); // NOI18N
        labelEspaco2.setOpaque(true);

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Créditos: R$");

        labelCredito.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelCredito.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCredito)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelCredito))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEspaco1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEspaco2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEspaco3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelEspaco3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEspaco2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEspaco1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnJogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MaquinaBraco.png"))); // NOI18N
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnJogar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnJogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Ação do btn
    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
         
        //roda o som do btn
        sBtn.play(false);
        
        //trava o btn enuanto esta rodando
        btnJogar.setEnabled(false);

        //modifica os creditos
        credito.sub();
        labelCredito.setText(""+credito.getValor());
            
        //declara as threads                                                                        
        Espaco e1 = new Espaco(labelEspaco1);     
        Espaco e2 = new Espaco(labelEspaco2);
        Espaco e3 = new Espaco(labelEspaco3);
        Verifica v = new Verifica(this,e1,e2,e3,labelCredito,credito,btnJogar,sCoin,sLoose,sWin5,sWin10,sFim);

        //roda as Threads
        e1.start();
        e2.start();
        e3.start();
        v.start();
    }//GEN-LAST:event_btnJogarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //String de entrada de credito
        String input = "";
        
        //entrada dos creditos
        do{
            try{ //try/catch para entrada de inteiros             
                input = JOptionPane.showInputDialog("Entre com a quantidade de créditos (Min=5): "); //entrada de credito
                if(input == null){ //caso seja pressionado cancelar ou o X
                    JOptionPane.showMessageDialog(null,"Que pena que não quis jogar :'( \n\n Volte Sempre! :)");
                    System.exit(0);
                }
                credito.setValor(Integer.parseInt(input)); //adc a quantia no credito
            }catch(NumberFormatException e){
                System.out.println(e);
                if(input.equals("")){ //caso entre com nenhuma quantia
                    JOptionPane.showMessageDialog(null,"Entre com algum valor! "); 
                }else{ //caso seja menor do que zero ou nao multiplo de 5
                    JOptionPane.showMessageDialog(null,"Somente números múltiplos de 5 e positivos são aceitos!");
                }
            }
        }while((credito.getValor() < 5) || (credito.getValor()%5 != 0) );
        sCoin.play(false); //roda o som de moeda
        
        //inicia o JFrame        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlotMachine();
                labelCredito.setText(""+credito.getValor());
            }
        });
        
        //roda o som de inicializacao
        sInicio.play(false);
        
        //System.out.println(sCoinPath);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel labelCredito;
    private javax.swing.JLabel labelEspaco1;
    private javax.swing.JLabel labelEspaco2;
    private javax.swing.JLabel labelEspaco3;
    // End of variables declaration//GEN-END:variables
}