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
 * Location : edu.cubesta.timer
 * Class : Average.java
 */

package edu.cubesta.timer;

/**
 * Permet de calculer la moyenne élaguée de plusieurs temps
 * @author yann.droy
 */

public class Average {
    
    /**
     * Variables globales
     */
    
    public static int[][] temps;
    static int best;
    static int worst;
    static int average;
    public static int nbr = 0;
    static int maxnbr;

    /**
     * Va calculer la moyenne sur les temps donnés
     * Ainsi que déterminer le meilleur et le moins bon temps
     * @param nombre
     * le nombre de temps qui sont entrés
     */
    
    public Average(int nombre) {
        if(nombre >= 3){
            temps = new int[3][nombre];
            average = 0;
            best = 0;
            maxnbr = nombre;
        }else{
            System.out.println("Pas assez de temps pour moyenne élaguée");
        }
    }
    
    /**
     * Va entrer chaque nouveau temps enregistré dans le tableau de temps
     * @param fait
     * Le temps qui vient d'être fait
     */
        
    public static void insertTime(int fait){
        if(nbr < maxnbr){
            temps[0][nbr] = fait;
            nbr++;
        }else{
            System.out.print("The average need to be reset");
        }
    }
    
    /**
     * Tri par insertion et par ordre croissant des valeurs d'un tableau
     * @param liste
     * le tableau contenant les valeurs
     * @return le tableau trié
     */
    
    public static int[] sortTimes(int[] liste){
        int[] sortedlist = new int[liste.length];
        System.arraycopy(liste, 0, sortedlist, 0, liste.length);
        int tmp;
        for(int i = 1; i < sortedlist.length; i++){
            for(int j = i-1; j+1 > 0 && sortedlist[j+1] <= sortedlist[j]; j--){ //TRI par insertion
                tmp = sortedlist[j+1];
                sortedlist[j+1] = sortedlist[j];
                sortedlist[j] = tmp;
            }
        }
        for(int i = sortedlist.length; i >= 0; i--){
            for(int j = i; j < sortedlist.length-1 && sortedlist[j] < 0; j++){ //TRI par selection des nombre négaitf (nombre négatif en bout de chaine)
                tmp = sortedlist[j+1];
                sortedlist[j+1] = sortedlist[j];
                sortedlist[j] = tmp;
            }
        }
        return sortedlist;
    }
    
    /**
     * Calcul de la moyenne
     * @param temps
     * la liste des temps
     * @param nombre
     * le nombre de temps
     * @return la valeur de la moyenne
     */
    
    public static int calculateAvg(int [] temps, int nombre){
        int[] temptemps = sortTimes(temps);
        int avg = 0;
        boolean hasDNF = false;
        for(int i = 1; i < nombre-1; i++){
                avg = avg + temptemps[i];
                if(temptemps[i] < 0){hasDNF = true;}
            }
            avg = avg/(nombre-2);
            if(hasDNF){avg = -1;}
            return avg;
        }
    
    /**
     * Va recueillir la moyenne
     */
    
    public static int getAverage(){
        if(nbr == maxnbr){
            average = calculateAvg(temps[0], maxnbr);
        }else{
            average = 0;  
        }
        return average;
    }
    
    /**
     * Va recueillir le meilleur temps
     */
    
    public static int getBest(){
        int[] temptemps = sortTimes(temps[0]);
        best =  temptemps[0];
        for(int i =0; i < temptemps.length && temptemps[i] == 0;i++){//Exclue les temps égals à zéro
            if(i+1 < temptemps.length){
                best =  temptemps[i+1];  
            }
        }
        return best;
    }
    
    /**
     * Va recueillir le moins bon temps
     */
    
    public static int getWorst(){
        int[] temptemps = sortTimes(temps[0]);
        worst = temptemps[(temptemps.length)-1];
        return worst;
    }
    
    /**
     * Va retourner le tableau des temps
     */
    
    public static int[][] getTimes(){
        return temps;
    }
    
    /**
     * Va recueillir le tableau des temps triés
     */
    
    public static int[] getSortTimes(){
        int[] temptemps = sortTimes(temps[0]);
        return temptemps;
    }
    
    /**
     * Verifie si l'average est remplis si il est rempli il sera vidé
     * @param nombre 
     * le nombre de temps qui sont entrés
     */
    
    public static void checkToReset(int nombre){
        if(nombre >= 3 && nbr == maxnbr){
            reset(nombre);
        }
    }
    
    /**
     * Permet de remettre à zéro le tableau de l'average
     * @param nombre 
     * taille du tableau
     */
    
    public static void reset(int nombre){
        temps = new int[3][nombre];
        average = 0;
        best = 0;
        maxnbr = nombre;
        nbr = 0;
    }
    
    /**
     * Permet d'obtenir le numéro du tour effectuer
     * @return 
     * retourne le numéro du tours (0 si il n'est pas définit)
     */

    public static int getRound() {
        int retour;
        if(Timer.tempsStop != 0){
            retour = (nbr >= maxnbr)?maxnbr:nbr;
        }else{
            retour = 0;
        }
        return retour;
    }
    
    /**
     * Permet de modifier la taille du tableau en cour d'usage
     * @param size 
     * Nouvelle taille du tableau
     */
    
    public static void changeAverageSize(int size){
        if(size >= 3){
            int[][] tempTable = new int[3][temps[0].length];
            for(int i = 0;i<temps[0].length;i++){
                for(int j = 0; j< 3; j++){
                    tempTable[j][i] = temps[j][i]; 
                }
            }
            temps = new int[3][size];
            for(int i = 0;i < tempTable[0].length && i < temps[0].length ;i++){
                for(int j = 0; j < 3; j++){
                    temps[j][i] = tempTable[j][i]; 
                }
            }
            maxnbr = size;
            nbr = (nbr > maxnbr)?maxnbr:nbr;
        }else{
            System.out.println("Pas assez de temps pour moyenne élaguée");
        }
    }

 }