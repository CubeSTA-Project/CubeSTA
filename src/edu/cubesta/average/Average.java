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
    
    //Variables globales
    
    int[] temps = {1,13,15,9,18,12,8,17,10,4,16,5,6,3,1,2,20,0,11,14,19};
    int best;
    int worst;
    int average;

    /**
     * Va calculer la moyenne sur les temps donnés
     * Ainsi que déterminer le meilleur et le moins bon temps
     * @param nombre
     * le nombre de temps qui sont entrés
     */
    
    public Average(int nombre) {
        
        if(nombre >= 3){
            average = 0;
            best = 0;
            temps = triCroissant(temps);
            best = temps[0];
            worst = temps[nombre-1];
            average = calculAvg(temps, nombre);
        }
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
        
        int avg = 0;
        for(int i = 1; i < nombre-1; i++){
                avg = avg + temps[i];
            }
            avg = avg/(nombre-2);
            return avg;
        }
    }