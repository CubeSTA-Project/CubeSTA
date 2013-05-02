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
 * Location : edu.cubesta.scramble
 * Class : CubeGUI.java
 */

package edu.cubesta.scramble;

/**
 * Permet d'initialiser un tableau de couleurs pour l'affichage du cube et de le mélanger
 * @author julien.gardet
 */

public class CubeGUI {
    
    /**
     * Variables globales
     */
    
    private static char[][] cubeGUI;
    private static TurnCube turn;
    
    /**
     * Initialise l'affichage du cube par défaut
     */

    public CubeGUI() {
        cubeGUI = new char[Character.MAX_VALUE][10];
        char[] colorList;
        colorList = new char[]{'G','W','Y','O','R','B'};
        for(int i = 0; i <= 5; i++){
            for(int j = 1; j <= 9; j++){
                cubeGUI[colorList[i]][j] = colorList[i];
            }
        }
    }
    
    /**
     * Permet de mélanger l'affichage du cube
     * @param scramble 
     * mélange à exécuter
     */

    public void scrambleCubeGUI(char[][] scramble) {
        turn = new TurnCube(cubeGUI);
        for(int i = 0; i < scramble[0].length; i++){
            selectedFace(scramble[0][i], scramble[1][i]);
        }
        setCubeGUI(turn.getCubeGUI());
    }
    
    /**
     * Sélectionne l'algorithme de déplacement des couleurs
     * @param movement
     * Face à déplacer (U: up / D : down / R : right / L : left / F : front / B : back )
     * @param direction 
     * direction du mouvement (' : dans le sens anti-horaire / 2 : deux fois / SP : dans le sens horaire)
     */
    
    public void selectedFace(char movement, char direction){
	if(movement == 'U'){turn.U(direction);}
	else if(movement == 'D'){turn.D(direction);}
	else if(movement == 'R'){turn.R(direction);}
	else if(movement == 'L'){turn.L(direction);}
	else if(movement == 'F'){turn.F(direction);}
	else if(movement == 'B'){turn.B(direction);}
    }
    
    /**
     * Affiche le cube ainsi que l'algorithme du mélange
     * @param scramble 
     * Mélange à afficher
     * @deprecated
     */

    public void displayCube(char[][] scramble) {
        System.out.print("\nAlgorithme : ");
        for(int i = 0; i < scramble[0].length ; i++){
            System.out.print(scramble[0][i] + "" + scramble[1][i] + " ");
        }
        
        System.out.print("\n\n");
        System.out.println("    " + cubeGUI['W'][9] + cubeGUI['W'][8] + cubeGUI['W'][7] + "       ");
        System.out.println("    " + cubeGUI['W'][6] + cubeGUI['W'][5] + cubeGUI['W'][4] + "       ");
        System.out.println("    " + cubeGUI['W'][3] + cubeGUI['W'][2] + cubeGUI['W'][1] + "       ");
        
        System.out.print("\n");
        System.out.print("" + cubeGUI['O'][7] + cubeGUI['O'][4] + cubeGUI['O'][1]);
        System.out.print(" " + cubeGUI['G'][1] + cubeGUI['G'][2] + cubeGUI['G'][3]);
        System.out.print(" " + cubeGUI['R'][3] + cubeGUI['R'][6] + cubeGUI['R'][9]);
        System.out.println(" " + cubeGUI['B'][9] + cubeGUI['B'][8] + cubeGUI['B'][7]);
        
        System.out.print("" + cubeGUI['O'][8] + cubeGUI['O'][5] + cubeGUI['O'][2]);
        System.out.print(" " + cubeGUI['G'][4] + cubeGUI['G'][5] + cubeGUI['G'][6]);
        System.out.print(" " + cubeGUI['R'][2] + cubeGUI['R'][5] + cubeGUI['R'][8]);
        System.out.println(" " + cubeGUI['B'][6] + cubeGUI['B'][5] + cubeGUI['B'][4]);
        
        System.out.print("" + cubeGUI['O'][9] + cubeGUI['O'][6] + cubeGUI['O'][3]);
        System.out.print(" " + cubeGUI['G'][7] + cubeGUI['G'][8] + cubeGUI['G'][9]);
        System.out.print(" " + cubeGUI['R'][1] + cubeGUI['R'][4] + cubeGUI['R'][7]);
        System.out.println(" " + cubeGUI['B'][3] + cubeGUI['B'][2] + cubeGUI['B'][1]);
        
        System.out.print("\n");
        System.out.println("    " + cubeGUI['Y'][1] + cubeGUI['Y'][2] + cubeGUI['Y'][3] + "       ");
        System.out.println("    " + cubeGUI['Y'][4] + cubeGUI['Y'][5] + cubeGUI['Y'][6] + "       ");
        System.out.println("    " + cubeGUI['Y'][7] + cubeGUI['Y'][8] + cubeGUI['Y'][9] + "       ");
    }
    
    /**
     * Affiche uniquement le cube
     * @deprecated
     */
    
    public void displayCube() {
        System.out.println("   " + cubeGUI['W'][9] + cubeGUI['W'][8] + cubeGUI['W'][7] + "      ");
        System.out.println("   " + cubeGUI['W'][6] + cubeGUI['W'][5] + cubeGUI['W'][4] + "      ");
        System.out.println("   " + cubeGUI['W'][3] + cubeGUI['W'][2] + cubeGUI['W'][1] + "      ");
        
        System.out.print("" + cubeGUI['O'][7] + cubeGUI['O'][4] + cubeGUI['O'][1]);
        System.out.print("" + cubeGUI['G'][1] + cubeGUI['G'][2] + cubeGUI['G'][3]);
        System.out.print("" + cubeGUI['R'][3] + cubeGUI['R'][6] + cubeGUI['R'][9]);
        System.out.println("" + cubeGUI['B'][9] + cubeGUI['B'][8] + cubeGUI['B'][7]);
        
        System.out.print("" + cubeGUI['O'][8] + cubeGUI['O'][5] + cubeGUI['O'][2]);
        System.out.print("" + cubeGUI['G'][4] + cubeGUI['G'][5] + cubeGUI['G'][6]);
        System.out.print("" + cubeGUI['R'][2] + cubeGUI['R'][5] + cubeGUI['R'][8]);
        System.out.println("" + cubeGUI['B'][6] + cubeGUI['B'][5] + cubeGUI['B'][4]);
        
        System.out.print("" + cubeGUI['O'][9] + cubeGUI['O'][6] + cubeGUI['O'][3]);
        System.out.print("" + cubeGUI['G'][7] + cubeGUI['G'][8] + cubeGUI['G'][9]);
        System.out.print("" + cubeGUI['R'][1] + cubeGUI['R'][4] + cubeGUI['R'][7]);
        System.out.println("" + cubeGUI['B'][3] + cubeGUI['B'][2] + cubeGUI['B'][1]);
        
        System.out.println("   " + cubeGUI['Y'][1] + cubeGUI['Y'][2] + cubeGUI['Y'][3] + "      ");
        System.out.println("   " + cubeGUI['Y'][4] + cubeGUI['Y'][5] + cubeGUI['Y'][6] + "      ");
        System.out.println("   " + cubeGUI['Y'][7] + cubeGUI['Y'][8] + cubeGUI['Y'][9] + "      ");
    }
    
    /**
     * Permet d'obtenir l'affichage du cube
     * @return 
     * Retourne un tableau bidimensionnel (dans une dimension la couleur dans l'autre la position)
     */

    public char[][] getCubeGUI() {
        return cubeGUI;
    }
    
    /**
     * Permet de modifier l'affichage du cube
     * @param cubeGUI 
     * nouvel affichage du cube
     */

    public void setCubeGUI(char[][] cubeGUI) {
        CubeGUI.cubeGUI = cubeGUI;
    }
}