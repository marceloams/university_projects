/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingsimulator;

import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author joaoleonardo
 */
public class SchedulingSimulator {
    
    static Algorithm algorithm = new Algorithm();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int nProcess = 0;
        
        do{
            try{ //try/catch para entrada de inteiros
                nProcess = (Integer.parseInt(JOptionPane.showInputDialog("Quantos processos estão chegando na Fila?")));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro! (Somente números inteiros são aceitos)");
                System.out.println(e);
            }
        }while((nProcess <= 0));
        
        algorithm.setTimes(nProcess);
        
    }
    
}
