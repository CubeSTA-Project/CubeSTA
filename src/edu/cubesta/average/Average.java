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
    
    double[] temps = {12.89,13.15,17.78,14.63,15.09,10.98,11.32,12.12,21.49,18.61,19.11,16.21,13.08,17.35,20.39,18.12,10.26,11.18,16.77,13.02,14.95,12.36,12.78,17,65,16.33,10,44,13,69};
    
    double[] tous;
    double[] derniers5 = new double[5];
    double[] derniers12 = new double[12];
    double average;
    double average5;
    double average12;
    double best;
    double worst;
    int L = temps.length;

    /**
     * Va calculer les moyennes élaguées sur 5 et sur 10
     * Ainsi que la moyenne sur tous les temps
     */
    
    public Average() {
        
        tous = triCroissant(temps);
        best = tous[0];
        worst = tous[(tous.length)-1];
        average = calculAvg(tous, average,true);
        
        if(L >= 5){
            int Case = 0;
            for(int i = L-1; i >= L-5; i--){
                derniers5[Case] = temps[i];
                Case++;
            }
            derniers5 = triCroissant(derniers5);
            average5 = calculAvg(derniers5, average5,false);
        }
        
        if(L >= 12){
            int Case = 0;
            for(int i = L-1; i >= L-12; i--){
                derniers12[Case] = temps[i];
                Case++;
            }
            derniers12 = triCroissant(derniers12);
            average12 = calculAvg(derniers12, average12,false);
        }
    }
    
    /**
     * Tri par insertion et par ordre croissant des valeurs d'un tableau
     * @param liste
     * le tableau contenant les valeurs
     * @return le tableau trié
     */
    
    public static double[] triCroissant(double [] liste){
        
        double tmp;
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
     * Calcul de la moyenne élaguée
     * @param temps
     * la liste des temps
     * @param avg
     * la moyenne élaguée que l'on veut calculer : tout, 5 ou 12 temps
     * @param all 
     * booléen qui dit si la moyenne doit être élaguée ou non; true = oui
     * @return la valeur de la moyenne élaguée
     */
    
    public static double calculAvg(double [] temps, double avg, boolean all){
        
        if(all){
            for(int i = 0; i < temps.length; i++){
                avg = avg + temps[i];
            }
            avg = avg/temps.length;
            return avg;
        }else{
            for(int i = 1; i < (temps.length)-1; i++){
                avg = avg + temps[i];
            }
            avg = avg/((temps.length)-2);
            return avg;
        }
    }
}
