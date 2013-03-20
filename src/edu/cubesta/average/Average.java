/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.average;

/**
 *
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

    /**
     * Va calculer la moyenne sur les temps donnés
     * Ainsi que déterminer le meilleur et le moins bon temps
     * @param nombre
     * le nombre de temps qui sont entrés
     */
    
    public Average(int nombre) {
        
        if(nombre >= 3){
            int nbr = 0;
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
    
    public static void insérerTemps(int fait, int nbr){
        temps[nbr] = fait;
        nbr++;
    }
    
    /**
     * Va recueillir la moyenne
     * @param temps
     * le tableau des temps
     * @param nombre
     * le nombre de temps
     */
    
    public static void recueillirAverage(int[] temps, int nombre){
        average = calculAvg(temps, nombre);
    }
    
    /**
     * Va recueillir le meilleur temps
     * @param temps
     * le tableau des temps
     */
    
    public static int recueillirBest(int[] temps){
        best = temps[0];
        return best;
    }
    
    /**
     * Va recueillir le moins bon temps
     * @param temps
     * le tableau des temps
     */
    
    public static int recueillirWorst(int[] temps){
        worst = temps[(temps.length)-1];
        return worst;
    }
    
    /**
     * Va recueillir le tableau des temps triés
     * @param temps
     * le tableau des temps
     */
    
    public static int[] recueillirTempsTriés(int[] temps){
        temps = triCroissant(temps);
        return temps;
    }
    
    /**
     * Tri par insertion et par ordre croissant des valeurs d'un tableau
     * @param liste
     * le tableau contenant les valeurs
     * @return le tableau trié
     */
    
    public static int[] triCroissant(int [] liste){
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
    
    public static int calculAvg(int [] temps, int nombre){
        temps = triCroissant(temps);
        int avg = 0;
        for(int i = 1; i < nombre-1; i++){
                avg = avg + temps[i];
            }
            avg = avg/(nombre-2);
            return avg;
        }
    }