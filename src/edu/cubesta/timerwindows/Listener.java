/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.timerwindows;

import edu.cubesta.cubewindows.CubeWindows;
import edu.cubesta.timer.Average;
import edu.cubesta.timer.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La classe permet d'écouter sur quelle touche l'utilisateur appuie
 * @author julien
 */
public class Listener implements KeyListener {
    
    /**
     * Variable Globale
     */
    
    boolean start;
    Timer time;
    Average avg;
    int numberAVG;
    
    /**
     * Initialise la classe avec la classe Timer et Average
     */

    public Listener() {
        time = new Timer();
        start = true;
        numberAVG = 5;
        avg = new Average(numberAVG);
    }
    
    /**
     * La fonction est appeler lorsque la touche retourne un charactère unicode
     * @param e 
     */
    
    @Override
    public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY TYPED: ");
    }
    
    /**
     * la fonction est appeler lorsque la touche vient d'être appuyer
     * @param e 
     */

    @Override
    public void keyPressed(KeyEvent e) {
        //displayInfo(e, "KEY PRESSED: ");
        if(e.getKeyCode() == 32){//Space
            if(start){
                Timer.reset();
                Timer.start();
                start = false;
                Average.checkToReset(numberAVG);//Verifie si les temps sont plein afin d'être de remis à zéro
            }else{
                int timeDone = Timer.stop();
                Average.insertTime(timeDone);
                start = true;
                CubeWindows.changeScreen();
            }
        }
    }

    /**
     * La fonction est appeler lorsque la touche est relacher
     * @param e 
     */
    
    @Override
    public void keyReleased(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
    }
    
    /**
     * Affiche une information sur la touche qui vient d'être appuyer
     * @param e
     * parametre de la touche appuyer
     * @param keyStatus 
     * Statut de la touche (Pressed/Typed/Released)
     * @deprecated
     */
    
    private void displayInfo(KeyEvent e, String keyStatus){
        
        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
        
        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }
        
        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
        
        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }
        
        System.out.println(keyStatus + "\n"
                + "    " + keyString + "\n"
                + "    " + modString + "\n"
                + "    " + actionString + "\n"
                + "    " + locationString + "\n");
    }
    
}
