/* Project : CubeSTA
 * Location : edu.cubesta.help
 * Class : MoveHelpPanel.java
 */
package edu.cubesta.help;

import edu.cubesta.resources.L10n;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Permet de gerer le contenue de la boite de dialogue d'aide des touches
 * @author julien.gardet
 */
public class MoveHelpPanel extends JPanel {
    
    /**
     * Permet de créer le contenue de la boite de dialogue d'aide des mouvements
     * @param g 
     */
    
    @Override
    public void paintComponent(Graphics g){
        this.setBackground(Color.WHITE);
        Font font = new Font("Sans", Font.BOLD, 20);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("\u2328 " + L10n.getLanguage(16), 10, 25);
        font = new Font("Sans", 0, 12);
        g.setFont(font);
        for(int i = 14; i <= 22; i++){
            g.drawString(L10n.getLanguageHelp(i), 10, 50+20*(i-13));
        }
    }
    
}
