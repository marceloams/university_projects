/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import javax.swing.JLabel;

/**
 *
 * @author marce
 */
public class Credito {
    
    //variaveis
    private static int valor;
    
    //getter do valor
    public int getValor() {
        return valor;
    }
    
    //setter do valor
    public void setValor(int valor) {
        Credito.valor = valor;
    }
    
    //soma R$5 -> 2 iguais
    public void soma5(){
        valor += 5;
    }
    
    //soma R$10 -> 3 iguais
    public void soma10(){
        valor += 10;
    }
    
    //Subtrai o valor de uma jogada (- R$5,00)
    public void sub(){
        valor -= 5;
    }
}
