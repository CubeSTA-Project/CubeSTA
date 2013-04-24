/* Project : CubeSTA
 * Location : edu.cubesta.ressource
 * Class : Dialog.java
 */
package edu.cubesta.resources;

import edu.cubesta.timer.Average;
import javax.swing.JOptionPane;

/**
 * Permet de gerer le contenue de la boite de dialogue d'aide des mouvements
 * @author julien.gardet
 */
public class Dialog {
    
    /**
     * Variable Super Globale
     */
    
    private static int numberOfScramble;
    private static int numberOfTime;
    private static int inspectionTime;
    
    /**
     * Définit les variable par défault
     */

    public Dialog() {
        numberOfScramble = 25;
        numberOfTime = 5;
        inspectionTime = 15000;
    }
    
    /**
     * Affiche une boite de dialogue pour changer le nombre de mouvement pour le mélange
     * @return 
     * Retourne le nombre entrer
     */
    
    public static int setNOS(){
        int retour = numberOfScramble;
        try{
            retour = Integer.valueOf(showInputDialog(L10n.getLanguage(5) + " - CubeSTA", L10n.getLanguage(7))).intValue();
            setNumberOfScramble(retour);
        } catch (NumberFormatException ex) {
            showErrorDialog(L10n.getLanguage(13) + " - CubeSTA", L10n.getLanguage(12));
        }
        return retour;
    }
    
    /**
     * Affiche un boite de dialogue pour changer le nombre de temps pour le calcul de l'average
     * @return 
     * Retourn le valeur entrer
     */
    
    public static int setNOT(){
        int retour = numberOfTime;
        try{
            retour = Integer.valueOf(showInputDialog(L10n.getLanguage(5) + " - CubeSTA", L10n.getLanguage(8))).intValue();
        } catch (NumberFormatException ex) {
            showErrorDialog(L10n.getLanguage(13) + " - CubeSTA", L10n.getLanguage(12));
        }
        if(retour < 3){
            showAlertDialog(L10n.getLanguage(6) + " - CubeSTA", L10n.getLanguage(9));
        }else{
            Average.changeAverageSize(retour);
            setNumberOfTime(retour);
        }
        return retour;
    }
    
    /**
     * Permet de modifier la langue
     */
    
    public static void setLAN(){
        try{
            L10n.setLanguage((String)JOptionPane.showInputDialog(null,L10n.getLanguage(10),L10n.getLanguage(5) + " - CubeSTA", JOptionPane.QUESTION_MESSAGE, null, L10n.listLanguage(), L10n.listLanguage()[0]));
        } catch (NullPointerException ex) {
        }
    }
    
    /**
     * Permet de modifier le temps d'inspection
     * @return 
     * Retourne la valeur entrer
     */
    
    public static int setINS(){
        int retour = inspectionTime;
        try{
            retour = Integer.valueOf(showInputDialog(L10n.getLanguage(5) + " - CubeSTA", L10n.getLanguage(17))).intValue()*1000;
            setInspectionTime(retour);
        } catch (NumberFormatException ex) {
            showErrorDialog(L10n.getLanguage(13) + " - CubeSTA", L10n.getLanguage(12));
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
    
    private static String showInputDialog(String title, String question){
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
    
    private static void showAlertDialog(String title, String question){
        JOptionPane.showMessageDialog(null, question, title, JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Affiche une boite de dialogue d'erreur
     * @param title
     * Titre de la fenêtre
     * @param question 
     * Question à poser
     */
    
    private static void showErrorDialog(String title, String question){
        JOptionPane.showMessageDialog(null, question, title, JOptionPane.ERROR_MESSAGE);
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
    
    /**
     * Permet d'obtenir la valeur de la variable du temps d'inspection
     * @return 
     * Retourne sa valeur
     */

    public static int getInspectionTime() {
        return inspectionTime;
    }
    
    /**
     * Permet de définir la variable de temps d'inspection
     * @param inspectionTime 
     * Le nouvelle valeur à définir
     */

    private static void setInspectionTime(int inspectionTime) {
        Dialog.inspectionTime = inspectionTime;
    }
    
}
