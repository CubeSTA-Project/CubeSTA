/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta;

import edu.cubesta.timer.Average;
import javax.swing.JOptionPane;

/**
 *
 * @author julien
 */
public class Dialog {
    
    /**
     * Variable Super Globale
     */
    
    private static int numberOfScramble;
    private static int numberOfTime;
    
    /**
     * Définit les variable par défault
     */

    public Dialog() {
        numberOfScramble = 25;
        numberOfTime = 5;
    }
    
    /**
     * Affiche une boite de dialogue pour changer le nombre de mouvement pour le mélange
     * @return 
     * Retourne le nombre entrer
     */
    
    public static int setNOS(){
        int retour = Integer.valueOf(showInputDialog("Option - Scramble", "Entrer le nombre de mouvement pour les mélanges !")).intValue();
        setNumberOfScramble(retour);
        return retour;
    }
    
    /**
     * Affiche un boite de dialogue pour changer le nombre de temps pour le calcul de l'average
     * @return 
     * Retourn le valeur entrer
     */
    
    public static int setNOT(){
        int retour = Integer.valueOf(showInputDialog("Option - Scramble", "Entrer le nombre de temps par average !")).intValue();
        if(retour < 3){
            showAlertDialog("Alert - CubeSTA", "Le nombre est trop petit");
        }else{
            Average.changeAverageSize(retour);
            setNumberOfTime(retour);
        }
        return retour;
    }
    
    /**
     * Permet de générer une boite de dialogue avec une entrer
     * @param title
     * Titre de la fenêtre
     * @param question
     * Question à poser
     * @return 
     * Retourne la valeur entrer
     */
    
    public static String showInputDialog(String title, String question){
        String answer = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
        return answer;
    }
    
    /**
     * Affiche une boite de dialogue d'alerte
     * @param title
     * Titre de la fenêtre
     * @param question 
     * Question à poser
     */
    
    public static void showAlertDialog(String title, String question){
        JOptionPane.showMessageDialog(null, question, title, JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Permet d'obtenir la variable du nombre de mouvement pour les mélange
     * @return 
     * Retourne la valeur de la variabel
     */

    public static int getNumberOfScramble() {
        return numberOfScramble;
    }
    
    /**
     * Permet de définir la variable du nombre de mouvement du mélange
     * @param numberOfScramble 
     * Valeur à définir pour la variable
     */

    private static void setNumberOfScramble(int numberOfScramble) {
        Dialog.numberOfScramble = numberOfScramble;
    }
    
    /**
     * Permet d'obtenir la variable du nombre de temps pour l'average
     * @return 
     * Retourne la valeur de la variable
     */

    public static int getNumberOfTime() {
        return numberOfTime;
    }
    
    /**
     * Permet de définir la variable du nombre de temps pour l'average
     * @param numberOfTime 
     * Valeur à définir pour la variable
     */

    private static void setNumberOfTime(int numberOfTime) {
        Dialog.numberOfTime = numberOfTime;
    }
    
}
