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
    
    static int numberOfScramble;
    static int numberOfTime;

    public Dialog() {
        numberOfScramble = 25;
        numberOfTime = 5;
    }
    
    public static int setNOS(){
        int retour = Integer.valueOf(showInputDialog("Option - Scramble", "Entrer le nombre de mouvement pour les mélanges !")).intValue();
        setNumberOfScramble(retour);
        return retour;
    }
    
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
    
    public static String showInputDialog(String title, String question){
        String answer = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
        return answer;
    }
    
    public static void showAlertDialog(String title, String question){
        JOptionPane.showMessageDialog(null, question, title, JOptionPane.WARNING_MESSAGE);
    }

    public static int getNumberOfScramble() {
        return numberOfScramble;
    }

    public static void setNumberOfScramble(int numberOfScramble) {
        Dialog.numberOfScramble = numberOfScramble;
    }

    public static int getNumberOfTime() {
        return numberOfTime;
    }

    public static void setNumberOfTime(int numberOfTime) {
        Dialog.numberOfTime = numberOfTime;
    }
    
}
