/* Project : CubeSTA
 * Location : edu.cubesta.timerwindows
 * Class : TimerGraphs.java
 */
package edu.cubesta.timerwindows;

import edu.cubesta.timer.Average;
import edu.cubesta.timer.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Permet de créer le contenue de la fenêtre du chronomètre
 * @author julien.gardet
 */
public class TimerGraphs extends JPanel {
    
    
    /**
     * Permet de créer le contenue de la fenêtre avec les données initial
     * @param g 
     */
    
    @Override
    public void paintComponent(Graphics g){
        this.setBackground(Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
        Font font1 = new Font("", Font.BOLD, 50);
        Font font2 = new Font("Sans", Font.BOLD, 30);
        Font font3= new Font("Sans", Font.BOLD, 15);
        Font font4 = new Font("Sans", Font.BOLD, 10);
        g.setFont(font1);
        g.drawString(Timer.time2string(Timer.currentTime()), 15, 50);
        if(Average.getRound() != 0){
            g.setFont(font2);
            g.drawString(Average.getRound() + "   Tour", 52, 83);
            g.setFont(font4);
            if(Average.getRound() == 1){
                g.drawString("er", 70, 68);
            }else{
                g.drawString("ème", 70, 68);
            }
        }
        g.setFont(font3);
        int[] time = Average.getSortTimes();
        for(int i = 1 ; i<= time.length ; i++){
            g.drawString(i + " : " + Timer.time2string(time[i-1]), 15, 85+i*20);
        }
        g.drawString("Average", 155, 105);
        g.drawString(Timer.time2string(Average.getAverage()), 155, 125);
        g.drawString("Best", 155, 165);
        g.drawString(Timer.time2string(Average.getBest()), 155, 185);
    }

}
