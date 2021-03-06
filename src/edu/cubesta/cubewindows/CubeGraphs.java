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
 * Location : edu.cubesta.cubewindows
 * Class : CubeGraphs.java
 */

package edu.cubesta.cubewindows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Permet de créer le contenu de la fenêtre de mélange
 * @author julien.gardet
 */

public class CubeGraphs extends JPanel {
    
    /**
     * Variables globales
     */
    
    private char[][] cubeGUI;
    private char[][] algo;
    
    /**
     * Initialise la classe avec des données d'affichage
     * @param cubeGUIsend
     * Le cube à afficher
     * @param algosend 
     * Le texte du mélange à afficher
     */
    
    public CubeGraphs(char[][] cubeGUIsend, char[][] algosend){
        cubeGUI = cubeGUIsend;
        algo = algosend; 
    }
    
    /**
     * Permet de créer le contenu de la fenêtre avec les données initiales
     * @param g 
     */
    
    @Override
    public void paintComponent(Graphics g){
        this.setBackground(Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        int pointUnit = ((this.getHeight()<this.getWidth())?this.getHeight():this.getWidth()-30)/12;
        for(int j = 1, k = 9; j <= 3; j++){
            for(int i = 4; i <= 6 ; i++, k--){
                g.setColor(getColorCube(cubeGUI['W'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 4, k = 9; j <= 6; j++){
            for(int i = 10; i <= 12 ; i++, k--){
                g.setColor(getColorCube(cubeGUI['B'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 4, k = 1; j <= 6; j++){
            for(int i = 4; i <= 6 ; i++, k++){
                g.setColor(getColorCube(cubeGUI['G'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 7, k = 1; j <= 9; j++){
            for(int i = 4; i <= 6 ; i++, k++){
                g.setColor(getColorCube(cubeGUI['Y'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int i = 3, k = 1; i >= 1; i--){
            for(int j = 4; j <= 6 ; j++, k++){
                g.setColor(getColorCube(cubeGUI['O'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int i = 9, k = 9; i >= 7; i--){
            for(int j = 4; j <= 6 ; j++, k--){
                g.setColor(getColorCube(cubeGUI['R'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        String algoString = "";
        for(int i = 0; i < algo[0].length ; i++){
            algoString += algo[0][i] + "" + algo[1][i] + " ";
        }
        g.setColor(Color.BLACK);
        Font font = new Font("Ubuntu", Font.BOLD, 15);
        g.setFont(font);
        g.drawString(algoString, 0*pointUnit+5, 11*pointUnit);
    }
    
    /**
     * Permet de retourner la couleur correspondant à un caractère
     * @param color
     * Le caractère correspondant à une couleur (B : blue / W : white / R : red / G : green / Y : yellow / O : orange)
     * @return 
     * Une couleur (e.g. Color.NomDeLaCouleur)
     */
    
    private Color getColorCube(char color){
        if(color == 'R'){return Color.RED;}
        else if(color == 'G'){return Color.GREEN;}
        else if(color == 'B'){return Color.BLUE;}
        else if(color == 'Y'){return Color.YELLOW;}
        else if(color == 'O'){return Color.ORANGE;}
        else if(color == 'W'){return Color.WHITE;}
        else{return Color.BLACK;}

    } 
}