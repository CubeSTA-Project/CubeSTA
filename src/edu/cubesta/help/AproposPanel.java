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
 * Location : edu.cubesta.ressources
 * Class : AproposPanel.java
 */

package edu.cubesta.help;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Permet de gerer le contenue de la boite de dialogue Apropos
 * @author julien
 */
public class AproposPanel extends JPanel {
        
    /**
     * Permet de créer le contenue de la boite de dialogue Apropos
     * @param g 
     */
    
    @Override
    public void paintComponent(Graphics g){
        this.setBackground(Color.WHITE);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.black);
        Font font = new Font(Font.SERIF, Font.BOLD, 14);
        g.setFont(font);
        try{
            Image img = ImageIO.read(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
            g.drawImage(img, this.getWidth()-135, 15, 120, 120, this);
            g.drawString("CubeSTA Project", (120-(int)g.getFontMetrics().getStringBounds("CubeSTA Project", g).getWidth())/2+this.getWidth()-135, 150);
        }catch(IOException e){
        }
        font = new Font(Font.DIALOG_INPUT, Font.TYPE1_FONT, 12);
        g.setFont(font);
        g.drawString("This program is free software: you can redistribute", 5, 15);
        g.drawString("it and/or modify it under the terms of the GNU", 5, 30);
        g.drawString("General Public License as published by the Free", 5, 45);
        g.drawString("Software Foundation, either version 3 of the", 5, 60);
        g.drawString("License, or any later version.", 5, 75);
        font = new Font(Font.DIALOG_INPUT, 0, 11);
        g.setFont(font);
        g.drawString("This program is distributed in the hope that it", 5, 95);
        g.drawString("will be useful, but WITHOUT ANY WARRANTY; without", 5, 110);
        g.drawString("even the implied warranty of MERCHANTABILITY or", 5, 125);
        g.drawString("FITNESS FOR A PARTICULAR PURPOSE.  See the GNU", 5, 140);
        g.drawString("General Public License for more details.", 5, 155);
        font = new Font(Font.DIALOG_INPUT, 0, 11);
        g.setFont(font);
        g.drawString("You should have received a copy of the GNU General Public License along", 5, 175);
        g.drawString("with this program. If not, see http://www.gnu.org/licenses/.", 5, 190);
        font = new Font(Font.DIALOG_INPUT, 0, 11);
        g.setFont(font);
        g.drawString("\u00A9 Copyright 2013, Gardet Julien, Droy Yann, Araujo Auxence.", 5, 210);
        g.drawString("The logo is a derivate work from http://goo.gl/3OkH5.", 5, 240);
        g.drawString("Other legal notices on our website, http://goo.gl/6pX60.", 5, 255);
    }
}
