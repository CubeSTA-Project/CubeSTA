/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.scramble;

/**
 * Permet de gégérer aléatoirement des mélanges
 * @author auxence.araujo
 */
public class AlgoMaker {
    
    /**
     * Variable Globale
     */

	private char[][] scramble;
    
    /**
     * Génère un algorithme de mélange du cube
     * @param number 
     * nombre de mouvements
     */

    public AlgoMaker(int number) {
        char[] Mouvement;
        Mouvement = new char[]{'R','L','U','D','F','B'};
		char[] Sens;
        Sens = new char[]{'2','\'',' '};
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
                //System.out.print(Mouvement[x] + "" + Sens[y] + " " );
                scramble[0][i-1] = Mouvement[x];
                scramble[1][i-1] = Sens[y];
            }
    }
    
    /**
     * Permet de générer un aléatoire entre deux bornes
     * @param min
     * Valeur minimal de l'aléatoire
     * @param max
     * Valeur maximal de l'aléatoire
     * @return Un entier aléatoire entre min et max
     */
    
    public static int randomBW (int min, int max){
        int x = (int)(min+Math.random()*(max-min+1));
        return x;
    }
    
    /**
     * Permet d'obtenir le mélange
     * @return 
     * Un tableau de caractère bidimensionnel (dans une dimension le mouvement dans l'autre le sens)
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
