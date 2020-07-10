/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsappimages;

import javax.swing.ImageIcon;

/**
 *
 * @author joaoleonardo
 */
public class ThreadSend implements Runnable {
    
    Receive receive;
    
    ImageIcon image;
    boolean enableSemaphore;
    int position;
    
    public ThreadSend(Receive receive, ImageIcon image, boolean enableSemaphore, int position) {
        this.receive = receive;
        this.image = image;
        this.enableSemaphore = enableSemaphore;
        this.position = position;
    }

    @Override
    public void run() {
        System.out.println("Thread postion: " + position );
        if(enableSemaphore){
            receive.receiveWithSemaphore(image, position);
        } else {
            receive.receiveWithoutSemaphore(image, position);
        }
    }
    
}
