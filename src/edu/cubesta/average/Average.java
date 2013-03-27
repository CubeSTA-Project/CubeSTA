/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.average;

/**
 * Permet de calculer la moyenne élaguée de plusieurs temps
 * @author yann.droy
 */

public class Average {
    
    /**
     * Variables globales
     */
    
    static int[] temps;
    static int best;
    static int worst;
    static int average;
    static int nbr = 0;

    /**
     * Va calculer la moyenne sur les temps donnés
     * Ainsi que déterminer le meilleur et le moins bon temps
     * @param nombre
     * le nombre de temps qui sont entrés
     */
    
    public Average(int nombre) {
        
        if(nombre >= 3){
            temps = new int[nombre];
            average = 0;
            best = 0;
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
        temps[nbr] = fait;
        nbr++;
    }
    
    /**
     * Tri par insertion et par ordre croissant des valeurs d'un tableau
     * @param liste
     * le tableau contenant les valeurs
     * @return le tableau trié
     */
    
    public static int[] sortTimes(int [] liste){
        int tmp;
        for(int i = 1; i < liste.length; i++){
            for(int j = i-1; j+1 > 0 && liste[j+1] <= liste[j]; j--){
                tmp = liste[j+1];
                liste[j+1] = liste[j];
                liste[j] = tmp;
            }
        }
        return liste;
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
        temps = sortTimes(temps);
        int avg = 0;
        for(int i = 1; i < nombre-1; i++){
                avg = avg + temps[i];
            }
            avg = avg/(nombre-2);
            return avg;
        }
    
    /**
     * Va recueillir la moyenne
     */
    
    public static void getAverage(){
        average = calculateAvg(temps, nbr);
    }
    
    /**
     * Va recueillir le meilleur temps
     * @param temps
     * le tableau des temps
     */
    
    public static int getBest(){
        temps = sortTimes(temps);
        best = temps[0];
        return best;
    }
    
    /**
     * Va recueillir le moins bon temps
     * @param temps
     * le tableau des temps
     */
    
    public static int getWorst(){
        temps = sortTimes(temps);
        worst = temps[(temps.length)-1];
        return worst;
    }
    
    /**
     * Va recueillir le tableau des temps triés
     * @param temps
     * le tableau des temps
     */
    
    public static int[] getSortTimes(){
        temps = sortTimes(temps);
        return temps;
    }
 }