/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingsimulator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author joaoleonardo
 */
public class Algorithm {
    
    JFrame frame;
    
    JPanel myPanel = new JPanel(new BorderLayout(10,10));
    JPanel label = new JPanel(new GridLayout(0,1,2,2));
    JPanel burst = new JPanel(new GridLayout(0,1,2,2));
    JPanel arrive = new JPanel(new GridLayout(0,1,2,2));
    
    JTextField burstTextFiel[] = new JTextField[100];
    JTextField arriveTextFiel[] = new JTextField[100];
    
    Object[] buttonText = { "FIFO", "RR"};
    
    int pid[] = new int[100];   // process ids
    int ar[] = new int[100];     // arrival times
    int bt[] = new int[100];     // burst or execution times
    int ct[] = new int[100];     // completion times
    int ta[] = new int[100];     // turn around times
    int wt[] = new int[100];     // waiting times 
    int temp;
    float avgwt=0,avgta=0;
    
    
    Algorithm(){
        frame = new JFrame("SCHEDULING SIMULATOR");
    }
    
    public void setTimes(int nProcess){
        label.add(new JLabel("PROCESS"));
        burst.add(new JLabel("BURST"));
        arrive.add(new JLabel("ARRIVE"));
        for(int i=0; i<nProcess; i++){
            label.add(new JLabel("P"+(i+1)));
            pid[i]=i+1;
        }
        myPanel.add(label, BorderLayout.WEST);
        
        for(int i=0; i<nProcess; i++){
            burstTextFiel[i] = new JTextField(3);
            burst.add(burstTextFiel[i]);
        }
        myPanel.add(burst, BorderLayout.CENTER);
        
        for(int i=0; i<nProcess; i++){
            arriveTextFiel[i] = new JTextField(3);
            arrive.add(arriveTextFiel[i]);
        }
        myPanel.add(arrive, BorderLayout.EAST);
        
        int result = JOptionPane.showOptionDialog(frame, myPanel, "PROCESS QEUE",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, buttonText, null);
        
        switch(result){
            case 0:
                fifo(nProcess);
                break;
            case 1:
                rr(nProcess);
                break;
        }

    }    
    
    public void fifo(int nProcess){
        System.out.println("fifo");
        for(int i=0; i<nProcess; i++){
            bt[i]=Integer.parseInt(burstTextFiel[i].getText());
            ar[i]=Integer.parseInt(arriveTextFiel[i].getText());
        }
        
        //sorting according to arrival times
		for(int i = 0 ; i<nProcess; i++)
		{
			for(int  j=0;  j<nProcess-(i+1) ; j++)
			{
				if( ar[j] > ar[j+1] )
				{
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
					temp = bt[j];
					bt[j] = bt[j+1];
					bt[j+1] = temp;
					temp = pid[j];
					pid[j] = pid[j+1];
					pid[j+1] = temp;
				}
			}
		}
		
		// finding completion times
		for(int  i = 0 ; i < nProcess; i++)
		{
			if( i == 0)
			{	
				ct[i] = ar[i] + bt[i];
			}
			else
			{
				if( ar[i] > ct[i-1])
				{
					ct[i] = ar[i] + bt[i];
				}
				else
					ct[i] = ct[i-1] + bt[i];
			}
			ta[i] = ct[i] - ar[i] ;          // turnaround time= completion time- arrival time
			wt[i] = ta[i] - bt[i] ;          // waiting time= turnaround time- burst time
			avgwt += wt[i] ;               // total waiting time
			avgta += ta[i] ;               // total turnaround time
		}
		
		System.out.println("\npid  arrival  brust  complete turn waiting");
		for(int  i = 0 ; i< nProcess;  i++)
		{
			System.out.println(pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t"  + wt[i] ) ;
		}
		
		System.out.println("\naverage waiting time: "+ (avgwt/nProcess));     // printing average waiting time.
		System.out.println("average turnaround time:"+(avgta/nProcess)); 
        
    }
    
    public void rr(int nProcess){
          System.out.println("rr");
          for(int i=0; i<nProcess; i++){
            ar[i]=Integer.parseInt(arriveTextFiel[i].getText());
        }
    }
    
}
