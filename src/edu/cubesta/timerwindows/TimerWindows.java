/* Project : CubeSTA
 * Location : edu.cubesta.timerwindows
 * Class : TimerWindows.java
 */
package edu.cubesta.timerwindows;

import edu.cubesta.resources.L10n;
import edu.cubesta.resources.Listener;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Permet de gérer le contenue de la fenêtre du chronomètre
 * @author julien.gardet
 */
public class TimerWindows extends JFrame {
    
    /**
     * Variable Globale
     */

    private static CardLayout cl = new CardLayout();
    private static JPanel content = new JPanel();
        
    /**
     * Permet de créer et de gérer le contenue fenêtre du chronomètre
     */
    
    public TimerWindows(){
        this.setTitle(L10n.getLanguage(4));
        this.setSize(250, 450);
        int posX = (Toolkit.getDefaultToolkit().getScreenSize().width-810)/2+570;
        int posY = (Toolkit.getDefaultToolkit().getScreenSize().height-450)/2;
        this.setLocation(posX, posY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        TimerGraphs pan = new TimerGraphs();
        content.setLayout(cl);
        content.add(pan, "timer");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new Listener());
        refreshScreen();
    }
    
    /**
     * Permet d'actualiser le temps du chronomètre
     */
    
     private void refreshScreen(){
         while(true){
            try {
                this.setTitle(L10n.getLanguage(4));
                TimerGraphs panel = new TimerGraphs();
                content.add(panel, "timer");
                cl.show(content, "timer");
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimerWindows.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
}
