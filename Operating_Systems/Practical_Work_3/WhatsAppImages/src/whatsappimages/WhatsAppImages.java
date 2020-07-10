/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsappimages;

import javax.swing.JFrame;

/**
 *
 * @author joaoleonardo
 */
public class WhatsAppImages {
    
    static Screen screen = new Screen();

    public static void main(String[] args) {
        
        JFrame frame = screen;
        frame.setTitle("WhatsAppImages");
        frame.setSize(595, 680);
        frame.setResizable(false); //fixa o tamanho
        frame.setLocationRelativeTo(null); //centraliza
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
