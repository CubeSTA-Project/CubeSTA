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
 * Class : TimerGraphs.java
 */

package edu.cubesta.timerwindows;

import edu.cubesta.ressources.L10n;
import edu.cubesta.ressources.Listener;
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
        //this.setBackground(Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.BLACK);
        Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        Font font3= new Font(Font.SANS_SERIF, Font.BOLD, 15);
        Font font4 = new Font(Font.SANS_SERIF, Font.BOLD, 10);
        Font font5 = new Font(Font.SANS_SERIF, Font.BOLD, 9);
        String notice = "";
        Color colorNotice = Color.BLACK;
        String text = Timer.time2string(Timer.currentTime());
        Color colorText = Color.BLACK;
        if(Listener.inspection){
            notice = L10n.getLanguage(14);
            colorNotice = new Color(0, 128, 0);
            colorText = new Color (0,128,0);
            if(Timer.currentTime() >= 0 && Listener.startPenality){
                Timer.reset();
                Listener.inspection = false;
                Listener.didNotStart();
            }else if(Timer.currentTime() >= 0 && !Listener.startPenality){
                Timer.tempsStart = System.currentTimeMillis() + 2000;
                Listener.startPenality = true;
            }
        }
        if(Listener.endPenality || Listener.startPenality){
            int penality = 0;
            if(Listener.endPenality){penality = penality + 2;}
            if(Listener.startPenality){penality = penality + 2;}
            notice = "+" + penality + " " + L10n.getLanguage(11);
            colorNotice = Color.RED;
        }
        if(Listener.DNS){
            text = "DNS";
            colorText = Color.RED;
        }else if(Listener.DNF){
            text = "DNF";
            colorText = Color.RED;
        }
        g = drawTimerCenter(text, 47, g, font1, notice, font5, colorText, colorNotice);
        if(Average.getRound() != 0){
            g = drawRoundCenter(Average.getRound()+"", L10n.getOrdinal(Average.getRound()), L10n.getLanguage(0), g, font2, font4);
        }
        g.setFont(font3);
        int[][] time = Average.getTimes();
        for(int i = 1 ; i <= time[0].length ; i++){
            drawTimeList(i, Timer.time2string(time[0][i-1]), time[1][i-1], time[2][i-1], font3, font5, g );
        }
        g.setColor(Color.BLACK);
        g.setFont(font3);
        g = drawLeftResume(g);
        g.setColor(Color.BLACK);
        g.setFont(font4);
        g.drawString("F1 - Help", this.getWidth() - (int)g.getFontMetrics().getStringBounds("F4 - About", g).getWidth() - 5, this.getHeight() - 20);
        g.drawString("F4 - About", this.getWidth() - (int)g.getFontMetrics().getStringBounds("F4 - About", g).getWidth() - 5, this.getHeight() - 5);
    }
    
    /**
     * Affiche le numéro du tour centrer
     * @param number
     * numéro du tour
     * @param superscript
     * abréviation
     * @param round
     * I18n du mot "Tour"
     * @param g
     * le graphic sur lequel l'appliquer
     * @param fontN
     * police normale
     * @param fontE
     * police réduite
     * @return 
     * retourne le graphic finale
     */

    private Graphics drawRoundCenter(String number, String superscript, String round, Graphics g, Font fontN, Font fontE) {
        round = " " + round; //ajout d'un espace avant le texte
        g.setFont(fontN);
        int numberWidth = (int)(g.getFontMetrics().getStringBounds(number, g).getWidth());
        int roundWidth = (int)(g.getFontMetrics().getStringBounds(round, g).getWidth());
        g.setFont(fontE);
        int superWidth = (int)(g.getFontMetrics().getStringBounds(superscript, g).getWidth());
        int width = numberWidth + roundWidth + superWidth;
        int posNumber = (this.getWidth() - width)/2;
        int posSuper = (this.getWidth() - width)/2 + numberWidth;
        int posRound = (this.getWidth() - width)/2 + numberWidth + superWidth;
        g.setFont(fontN);
        g.drawString(number, posNumber, 83);
        g.drawString(round, posRound, 83);
        g.setFont(fontE);
        g.drawString(superscript, posSuper, 68);
        return g;
    }
    
    /**
     * Affiche le chronomètre au centre
     * @param string
     * Le temps du chronomètre
     * @param posY
     * Position verticale
     * @param g
     * Le graphic sur lequel appliquer
     * @param font
     * La police du chronomètre
     * @param note
     * L'annotation en dessous du chronomètre
     * @param fontNote
     * La police de l'annotation
     * @param color1
     * La couleur du temps
     * @param color2
     * La couleur de l'annotation
     * @return 
     * Retourne le graphic finale
     */
    
    private Graphics drawTimerCenter(String string, int posY, Graphics g, Font font, String note, Font fontNote, Color color1, Color color2) {
        g.setColor(color1);
        g.setFont(font);
        int width = (int)(g.getFontMetrics().getStringBounds(string, g).getWidth());
        int posX = (this.getWidth() - width)/2;
        g.drawString(string, posX, posY);
        g.setFont(fontNote);
        g.setColor(color2);
        int widthNote = (int)(g.getFontMetrics().getStringBounds(note, g).getWidth());
        int posXNote = this.getWidth() - posX - widthNote - 7;
        g.drawString(note, posXNote, posY + 11);
        g.setColor(Color.BLACK);
        return g;
    }
    
    /**
     * Affiche la liste de temps
     * @param position
     * Position du temps
     * @param time
     * le temps de la position
     * @param penality
     * Seconde de pénalité du temps
     * @param state
     * Etat du temps (Noir si false et Rouge si true)
     * @param fontN
     * Police normal
     * @param fontI
     * Police réduite
     * @param g
     * Le graphic sur lequel appliquer
     * @return 
     * Retourn le graphic final
     */
    
    private Graphics drawTimeList(int position, String time, int penality, int state, Font fontN, Font fontI, Graphics g ){
        g.setColor(Color.BLACK);
        g.setFont(fontN);
        int numberWidth = (int)(g.getFontMetrics().getStringBounds(position + " : ", g).getWidth());
        g.drawString(position + " : ", 15, 85+position*20);
        if(state == 1){
            time = "DNS";
            g.setColor(Color.RED);
        }else if(state == 2){
            time = "DNF";
            g.setColor(Color.RED);
        }
        int timeWidth = (int)(g.getFontMetrics().getStringBounds(time, g).getWidth());
        g.drawString(time, 15+numberWidth, 85+position*20);
        if(penality > 0){
            g.setColor(Color.RED);
            g.setFont(fontI);
            g.drawString(" (+" + penality + ")", 15+numberWidth+timeWidth, 85+position*20);
        }
        g.setColor(Color.BLACK);
        return g;
    }
    
    /**
     * Affiche le résumer à gauche
     * @param g
     * le graphic sur lequel l'appliquer
     * @return 
     * Retourne le graphic finale
     */
    
    private Graphics drawLeftResume(Graphics g){
        //Obtenir le plus grand texte
        int[] width = new int[4];
        width[0] = this.getWidth() - ((int)g.getFontMetrics().getStringBounds(L10n.getLanguage(1), g).getWidth()) - 15;
        width[1] = this.getWidth() - ((int)g.getFontMetrics().getStringBounds(Timer.time2string(Average.getAverage()), g).getWidth()) - 15;
        width[2] = this.getWidth() - ((int)g.getFontMetrics().getStringBounds(L10n.getLanguage(2), g).getWidth()) - 15;
        width[3] = this.getWidth() - ((int)g.getFontMetrics().getStringBounds(Timer.time2string(Average.getBest()), g).getWidth()) - 15;
        int posX = this.getWidth();
        for(int i = 0; i <= 3; i++){
            posX = (posX <= width[i])?posX:width[i];
        }
        //AVG
        g.drawString(L10n.getLanguage(1), posX, 105);
        if(Average.getAverage() < 0){g.setColor(Color.RED);}
        g.drawString((Average.getAverage() < 0)?"DNF":Timer.time2string(Average.getAverage()), posX, 125);
        //BEST
        g.setColor(Color.BLACK);
        g.drawString(L10n.getLanguage(2), posX, 165);
        if(Average.getBest() < 0){g.setColor(Color.RED);}
        g.drawString((Average.getBest() < 0)?"DNF":Timer.time2string(Average.getBest()), posX, 185);
        return g;
    }

}
