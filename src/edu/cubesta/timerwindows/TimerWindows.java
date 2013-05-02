/**
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * © Copyright 2013, Gardet Julien, Droy Yann, Araujo Auxence.
 * 
 * The logo in edu.cubesta.ressources.favicon.png is a derivate work from
 * <http://commons.wikimedia.org/w/index.php?title=File:Rubik%27s_cube.svg&oldid=70000649>.
 * 
 * Other legal notices on <http://cubesta-project.github.io/CubeSTA/legals.html>.
 */
/* Project : CubeSTA
 * Location : edu.cubesta.timerwindows
 * Class : TimerWindows.java
 */

package edu.cubesta.timerwindows;

import edu.cubesta.ressources.L10n;
import edu.cubesta.ressources.Listener;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Permet de gérer le contenu de la fenêtre du chronomètre
 * @author julien.gardet
 */

public class TimerWindows extends JFrame {
    
    /**
     * Variables globales
     */

    private static CardLayout cl = new CardLayout();
    private static JPanel content = new JPanel();
        
    /**
     * Permet de créer et de gérer le contenu fenêtre du chronomètre
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