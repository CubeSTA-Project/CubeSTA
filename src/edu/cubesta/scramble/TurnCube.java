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
 * Class : TurnCube.java
 */

package edu.cubesta.scramble;

/**
 * Permet de déplacer les couleurs du tableau en fonction des mouvements donnés
 * @author yann.droy
 */

public class TurnCube {
    
    /**
     * Variables globales
     */
    
    private char[][] cubeGUI;
    private char tmp;
    
    /**
     * Initialise les fonctions de déplacement des couleurs
     * @param cubeGUISend 
     * couleur du cube à déplacer
     */

    public TurnCube(char[][] cubeGUISend) {
        cubeGUI = new char[Character.MAX_VALUE][10];
        cubeGUI = cubeGUISend;
    }
    
    /**
     * Retourne le nombre d'exécutions en fonction du caractère donné
     * @param direction
     * direction du mouvement (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     * @return 
     * Retourne le nombre de fois que l'algorithme de déplacement des couleur doit être exécuté
     */
    
    private int turnNumber(char direction){
        int N;
        if(direction == '\''){
            N = 3;
        }else if(direction == '2'){
            N = 2;
        }else{
            N = 1;
        }
        return N;
    }
    
    /**
     * Déplace les couleur selon le mouvement U (up)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */

    public void F(char direction){
	for(int i = 1; i<= turnNumber(direction); i++){
            turnFace('G');
            turnAxes('W',new int[]{1,2,3},'R',new int[]{1,2,3},'Y',new int[]{1,2,3},'O',new int[]{1,2,3});
        }
    }
    
    /**
     * Déplace les couleur selon le mouvement D (down)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */
    
    public void B(char direction){
        for(int i = 1; i<= turnNumber(direction); i++){
            turnFace('B');
            turnAxes('W',new int[]{9,8,7},'O',new int[]{9,8,7},'Y',new int[]{9,8,7},'R',new int[]{9,8,7});
        }
    }
         
    /**
     * Déplace les couleur selon le mouvement R (right)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */
    
    public void R(char direction){
        for(int i = 1; i<= turnNumber(direction); i++){
            turnFace('R');
            turnAxes('G',new int[]{3,6,9},'W',new int[]{7,4,1},'B',new int[]{3,6,9},'Y',new int[]{3,6,9});
        }
    }
        
    /**
     * Déplace les couleur selon le mouvement L (left)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */
    
    public void L(char direction){
        for(int i = 1; i<= turnNumber(direction); i++){
            turnFace('O');
            turnAxes('G',new int[]{1,4,7},'Y',new int[]{1,4,7},'B',new int[]{1,4,7},'W',new int[]{9,6,3});
        }
    }
         
    /**
     * Déplace les couleur selon le mouvement F (front)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */
    
    public void D(char direction){
        for(int i = 1; i <= turnNumber(direction); i++){
            turnFace('Y');
            turnAxes('O',new int[]{9,6,3},'G',new int[]{7,8,9},'R',new int[]{1,4,7},'B',new int[]{3,2,1});
        }
    }
        
    /**
     * Déplace les couleur selon le mouvement B (back)
     * @param direction 
     * direction (' : dans le sens anti-horaire / 2 : deux fois / vide : dans le sens horaire) 
     */
    
    public void U(char direction){
        for(int i = 1; i<= turnNumber(direction); i++){
            turnFace('W');
            turnAxes('B',new int[]{7,8,9},'R',new int[]{9,6,3},'G',new int[]{3,2,1},'O',new int[]{1,4,7});
        }
    }
    
    /**
     * Exécute une rotation dans le sens horaire des couleurs d'une face
     * @param face 
     * Choix de la face (B : blue / W : white / R : red / G : green / Y : yellow / O : orange)
     */
    
    private void turnFace(char face){
        tmp = cubeGUI[face][1]; cubeGUI[face][1] = cubeGUI[face][7]; cubeGUI[face][7] = cubeGUI[face][9]; cubeGUI[face][9] = cubeGUI[face][3]; cubeGUI[face][3] = tmp;
        tmp = cubeGUI[face][2]; cubeGUI[face][2] = cubeGUI[face][4]; cubeGUI[face][4] = cubeGUI[face][8]; cubeGUI[face][8] = cubeGUI[face][6]; cubeGUI[face][6] = tmp;
    }
    
    /**
     * Exécute une rotation dans le sens horaire des couleurs selon un axe
     * @param colorA
     * Couleur initiales
     * @param positionA
     * Position de la couleur initiale {droite,centre,gauche}
     * @param colorB
     * Seconde couleur
     * @param positionB
     * Position de la seconde couleur {droite,centre,gauche}
     * @param colorC
     * Troisième couleur
     * @param positionC
     * Position de la troisième couleur {droite,centre,gauche}
     * @param colorD
     * Couleur finale
     * @param positionD 
     * Position de la couleur finale {droite,centre,gauche}
     */
    
    private void turnAxes(char colorA, int[] positionA, char colorB, int[] positionB, char colorC, int[] positionC, char colorD, int[] positionD ){
        tmp = cubeGUI[colorD][positionD[0]]; cubeGUI[colorD][positionD[0]] = cubeGUI[colorC][positionC[0]]; cubeGUI[colorC][positionC[0]] = cubeGUI[colorB][positionB[0]]; cubeGUI[colorB][positionB[0]] = cubeGUI[colorA][positionA[0]]; cubeGUI[colorA][positionA[0]] = tmp;
        tmp = cubeGUI[colorD][positionD[1]]; cubeGUI[colorD][positionD[1]] = cubeGUI[colorC][positionC[1]]; cubeGUI[colorC][positionC[1]] = cubeGUI[colorB][positionB[1]]; cubeGUI[colorB][positionB[1]] = cubeGUI[colorA][positionA[1]]; cubeGUI[colorA][positionA[1]] = tmp;
        tmp = cubeGUI[colorD][positionD[2]]; cubeGUI[colorD][positionD[2]] = cubeGUI[colorC][positionC[2]]; cubeGUI[colorC][positionC[2]] = cubeGUI[colorB][positionB[2]]; cubeGUI[colorB][positionB[2]] = cubeGUI[colorA][positionA[2]]; cubeGUI[colorA][positionA[2]] = tmp;
    }
    
    /**
     * Permet d'obtenir l'affichage du cube
     * @return 
     * Retourne un tableau bidimensionnel (dans une dimension la couleur et dans l'autre la position)
     */

    public char[][] getCubeGUI() {
        return cubeGUI;
    }
    
    /**
     * Permet de modifier l'affichage du cube
     * @param cubeGUI 
     * Nouvel affichage du cube
     */

    public void setCubeGUI(char[][] cubeGUI) {
        this.cubeGUI = cubeGUI;
    }
}