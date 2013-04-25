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
 * Class : CubeWindows.java
 */

package edu.cubesta.cubewindows;

import edu.cubesta.ressources.Dialog;
import edu.cubesta.ressources.L10n;
import edu.cubesta.ressources.Listener;
import edu.cubesta.scramble.AlgoMaker;
import edu.cubesta.scramble.CubeGUI;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Permet de créer et gérer la fenêtre de mélange
 * @author julien.gardet
 */
public class CubeWindows extends JFrame {
    
    /**
     * Variable Globale
     */
    
    private static char[][] cubeGUI;
    private static char[][] algoGUI;
    private static CardLayout cl = new CardLayout();
    private static JPanel content = new JPanel();
        
    /**
     * Permet d'initialiser une fenêtre
     */
    
    public CubeWindows(){
        this.setTitle(L10n.getLanguage(3) + " - CubeSTA");
        this.setSize(550, 450);
        int posX = (Toolkit.getDefaultToolkit().getScreenSize().width-810)/2;
        int posY = (Toolkit.getDefaultToolkit().getScreenSize().height-450)/2;
        this.setLocation(posX, posY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        createCube();
        CubeGraphs pan = new CubeGraphs(cubeGUI,algoGUI);
        content.setLayout(cl);
        content.add(pan, "cube");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new Listener());
    }
    
    /**
     * Permet de générer un nouveau mélange
     */
    
    private static void createCube(){
        CubeGUI cube = new CubeGUI();
        AlgoMaker algo = new AlgoMaker(Dialog.getNumberOfScramble());
        cube.scrambleCubeGUI(algo.getScramble());
        cubeGUI = cube.getCubeGUI();
        algoGUI = algo.getScramble();
    }
    
    /**
     * Permet de recharger le mélange de la fenêtre
     */
     public static void changeScreen(){
            createCube();
            CubeGraphs panel = new CubeGraphs(cubeGUI,algoGUI);
            content.add(panel, "cube");
            cl.show(content, "cube");
     }

}
