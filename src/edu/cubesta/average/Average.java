/****************************************************************************************
 *                                                                                      *  
 *  _|      _|                                  _|_|_|                                  * 
 *    _|  _|    _|_|_|  _|_|_|    _|_|_|        _|    _|  _|  _|_|    _|_|    _|    _|  * 
 *      _|    _|    _|  _|    _|  _|    _|      _|    _|  _|_|      _|    _|  _|    _|  * 
 *      _|    _|    _|  _|    _|  _|    _|      _|    _|  _|        _|    _|  _|    _|  * 
 *      _|      _|_|_|  _|    _|  _|    _|      _|_|_|    _|          _|_|      _|_|_|  * 
 *                                                                                  _|  * 
 *                                                                              _|_|    *
 *                                                                                      *
 ***************************************************************************************/
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
    static int maxnbr;

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
            temps[nbr] = fait;
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
        for(int i = 0;i<liste.length;i++){
            sortedlist[i] = liste[i]; 
        }
        int tmp;
        for(int i = 1; i < sortedlist.length; i++){
            for(int j = i-1; j+1 > 0 && sortedlist[j+1] <= sortedlist[j]; j--){
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
        for(int i = 1; i < nombre-1; i++){
                avg = avg + temptemps[i];
            }
            avg = avg/(nombre-2);
            return avg;
        }
    
    /**
     * Va recueillir la moyenne
     */
    
    public static int getAverage(){
        if(nbr == maxnbr){
            average = calculateAvg(temps, maxnbr);
        }else{
            average = 0;  
        }
        return average;
    }
    
    /**
     * Va recueillir le meilleur temps
     * @param temps
     * le tableau des temps
     */
    
    public static int getBest(){
        int[] temptemps = sortTimes(temps);
        best = temptemps[0];
        return best;
    }
    
    /**
     * Va recueillir le moins bon temps
     * @param temps
     * le tableau des temps
     */
    
    public static int getWorst(){
        int[] temptemps = sortTimes(temps);
        worst = temptemps[(temptemps.length)-1];
        return worst;
    }
    
    /**
     * Va recueillir le tableau des temps triés
     * @param temps
     * le tableau des temps
     */
    
    public static int[] getSortTimes(){
        int[] temptemps = sortTimes(temps);
        return temptemps;
    }
    
    /**
     * Verifie si l'average est remplis si il est rempli il sera vidé
     * @param nombre 
     * le nombre de temps qui sont entrés
     */
    
    public static void checkToReset(int nombre){
        if(nombre >= 3 && nbr == maxnbr){
            temps = new int[nombre];
            average = 0;
            best = 0;
            maxnbr = nombre;
            nbr = 0;
        }
    }
 }