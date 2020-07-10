/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author marce
 */
public class Som implements LineListener{
    
    //variaveis
    boolean playCompleted;
    
    //variaveis de som
    File audioFile;
    AudioInputStream audioStream;
    AudioFormat format;
    DataLine.Info info;
    Clip audioClip;
    
    //construtor
    Som(String audioFilePath){
        audioFile = new File(audioFilePath);
    }
    
    /**
     * Play a given audio file.
     * @param audioFilePath Path of the audio file.
     */
    public void play(boolean loop){
 
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
 
            format = audioStream.getFormat();
 
            info = new DataLine.Info(Clip.class, format);
 
            audioClip = (Clip) AudioSystem.getLine(info);
 
            audioClip.addLineListener((LineListener) this);
 
            audioClip.open(audioStream);
            
            if(loop)
                audioClip.loop(10);  // loop 10 times
             
            audioClip.start();
             
            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
}    
    
    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();  
        if(type == LineEvent.Type.STOP) {
                playCompleted = true;
        }
    }
}
