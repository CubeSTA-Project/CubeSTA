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
 * Class : AlgoMaker.java
 */

package edu.cubesta.scramble;

/**
 * Permet de générer aléatoirement des mélanges
 * @author auxence.araujo
 */

public class AlgoMaker {
    
    /**
     * Variable globale
     */

    private char[][] scramble;
    
    /**
     * Génère un algorithme de mélange du cube
     * @param number 
     * nombre de mouvements
     */

    public AlgoMaker(int number) {
        char[] Mouvement = new char[]{'R','L','U','D','F','B'};
	char[] Sens = new char[]{'2','\'',' '};
        scramble = new char[2][number];
        int temporaire = randomBW(0,5);
        int temporaire2 = randomBW(0,5);
            for (int i = 1 ; i <= number; i++){
                int x = randomBW(0,5);
                int y = randomBW(0,2);
                    while (temporaire == x || temporaire2 == x){
			x = randomBW(0,5);
                    }
                temporaire2 = temporaire;
                temporaire = x;
                scramble[0][i-1] = Mouvement[x];
                scramble[1][i-1] = Sens[y];
            }
    }
    
    /**
     * Permet de générer un aléatoire entre deux bornes
     * @param min
     * Valeur minimale de l'aléatoire
     * @param max
     * Valeur maximale de l'aléatoire
     * @return
     * un entier aléatoire entre min et max
     */
    
    public static int randomBW (int min, int max){
        int x = (int)(min+Math.random()*(max-min+1));
        return x;
    }
    
    /**
     * Permet d'obtenir le mélange
     * @return 
     * un tableau de caractère bidimensionnel (dans une dimension le mouvement dans l'autre le sens)
     */

    public char[][] getScramble() {
        return scramble;
    }
    
    /**
     * Permet de modifier le mélange
     * @param scramble 
     * nouveau mélange
     */

    public void setScramble(char[][] scramble) {
        this.scramble = scramble;
    }   
}