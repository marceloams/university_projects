/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsappimages;

import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import static whatsappimages.WhatsAppImages.screen;

/**
 *
 * @author joaoleonardo
 */
public class Receive {
    
    Semaphore semaphore = new Semaphore(1);
    
    public void receiveWithSemaphore(ImageIcon image, int position) {
        try {
            semaphore.acquire();
            screen.setSenderLabel(image);
            System.out.println("sender " + position);
        } catch (InterruptedException ex) {
        } finally {
            screen.setReceiverLabel(image);
            System.out.println("receiver " + position);
            semaphore.release();
        } 
    }
    
    public void receiveWithoutSemaphore(ImageIcon image, int position) {
        screen.setSenderLabel(image);
        System.out.println("sender " + position);
        screen.setReceiverLabel(image);
        System.out.println("receiver " + position);
    }
    
}
