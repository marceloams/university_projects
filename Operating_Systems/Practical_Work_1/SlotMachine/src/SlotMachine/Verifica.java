/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class Verifica extends Thread{
    
    //variaveis
    private Credito credito; //credito
    private Espaco e1; //espaco 1
    private Espaco e2; //espaco 2
    private Espaco e3; //espaco 3
    private Som sCoin; //moeda
    private Som sLoose; //derrota
    private Som sWin5; //ganha 5
    private Som sWin10; //ganha 10
    private Som sFim; //Windows shutting Down
    private JButton btnJogar; //botao de jogar
    private JLabel labelCr; //label dos creditos
    private JFrame maquina; //o jframe da maquina
    private boolean fim = false;
    private String input = ""; //para entrada de creditos
   
    //construtor
    Verifica(JFrame m, Espaco a, Espaco b, Espaco c, JLabel cr, Credito cred, JButton btn,Som coin, Som lost, Som win5, Som win10, Som sfim){
        maquina = m;
        e1 = a;
        e2 = b;
        e3 = c;
        labelCr = cr;
        credito = cred;
        btnJogar = btn;
        sCoin = coin;
        sLoose = lost;
        sWin5 = win5;
        sWin10 = win10;
        sFim = sfim;
    }
    
    @Override
    public void run(){
        
        while(!fim){ //enquanto os estados não terminarem
            if(!e1.getFim() || !e2.getFim() || !e3.getFim()){ //verifica se os 3 estados terminaram  
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Verifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{ //se sim
                fim = true; //seta fim              
                if((e1.getIde() == e2.getIde()) && (e1.getIde() == e3.getIde())){ //se 3 img iguais
                    sWin10.play(false); //roda som de ganhar 10
                    JOptionPane.showMessageDialog(maquina,"3 acertos! Ganhou R$10,00!!"); //mostra mensagem
                    credito.soma10(); //soma 10 creditos
                    labelCr.setText(""+credito.getValor()); //mostra os creditos
                }else if((e1.getIde() == e2.getIde()) || (e1.getIde() == e3.getIde()) || (e2.getIde() == e3.getIde())){ //se 2 img iguais
                    sWin5.play(false); //roda som de ganhar 5
                    JOptionPane.showMessageDialog(maquina,"2 acertos! Ganhou R$5,00!!"); //mostra mensagem
                    credito.soma5(); //soma 5 creditos
                    labelCr.setText(""+credito.getValor()); //mostra os creditos
                }else{
                    sLoose.play(false); //roda som de derrota
                    
                    JOptionPane.showMessageDialog(maquina,"Perdeu :("); //mensagem de derrota
                    
                    if(credito.getValor()==0){ //se não tem creditos
                        //entrada de creditos
                        do{
                            try{ //try/catch para entrada de inteiros
                                input = JOptionPane.showInputDialog("Entre com a quantidade de créditos (Min=5): "); //entrada de credito
                                if(input == null){ //caso seja pressionado cancelar ou o X
                                    JOptionPane.showMessageDialog(null,"Que pena que não quer mais jogar :'( \n\n Volte Sempre! :)");
                                    maquina.setEnabled(false); //desativa a maquina
                                    sFim.play(false); //roda o som de shut down
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
                        
                        sCoin.play(false); //roda som de moeda
                        labelCr.setText(""+credito.getValor()); //mostra creditos
                    }
                }
                btnJogar.setEnabled(true); //habilita o botao de jogar
            }
        }
    }
}
