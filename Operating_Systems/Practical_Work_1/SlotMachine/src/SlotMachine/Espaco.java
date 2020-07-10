/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class Espaco extends Thread{
    
    //variaveis
    private final JLabel label; //para editar a imagem
    private int id = 0; //a imagem que será o objetivo
    private int atual; //a imagem atual
    private boolean fim = false; //determina o fim da thread
    private String img; //o caminho da imagem
    
    //construtor
    Espaco(JLabel l){
        label = l;
    }
    
    //getter do id
    public int getIde() {
        return id;
    }
    
    //getter do fim
    public boolean getFim() {
        return fim;
    }
    
    @Override
    public void run(){
        
        //define o objetivo
        Random r = new Random();
        id = r.nextInt(7);
        
        //zera a flag
        atual = 0;
        
        while(!fim){
            
            if(id == 0){//se o objetivo for a primeira img
                img = "/img/Icon"+atual+".jpg"; //caminho da img
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(img))); //seta img
                fim = true; //seta o fim
            }else if(atual != id){//se não for o objetivo     
                atual++; //incrementa uma imagem
                img = "/img/Icon"+atual+".jpg"; //caminho da img
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(img))); //seta img
                try {  
                    Thread.sleep(300); //tempo que de espera
                } catch (InterruptedException ex) {
                    Logger.getLogger(Espaco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                fim = true; //seta o ffim
            }
        }
    }
    
}
