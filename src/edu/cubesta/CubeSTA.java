/*****************************************************
 *       _                _____                        *
 *      | |              |  __ \                       *
 *      | | __ _  ______ | |__) |__  _ __   ___ _   _  *
 *  _   | |/ _` | ______ |  ___/ _ \| '_ \ / _ \ | | | *
 * | |__| | (_| |        | |  | (_) | | | |  __/ |_| | *
 *  \____/ \__,_|        |_|   \___/|_| |_|\___|\__, | *
 *                                               __/ | *
 *                                              |___/  *
 *                                                     * ... n'importe quoi !!!
 *******************************************************/
package edu.cubesta;

import edu.cubesta.cubewindows.CubeWindows;
import edu.cubesta.help.KeyHelpDialog;
import edu.cubesta.resources.Dialog;
import edu.cubesta.resources.L10n;
import edu.cubesta.timerwindows.TimerWindows;

/**
 * Classe principal permettant d'afficher une fenetre avec un patron mélanger et un chronomètre
 * @author julien.gardet yann.droy auxence.araujo
 * @version 1.0 
 */
public class CubeSTA {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        L10n l10n = new L10n();
        Dialog dial = new Dialog();
        CubeWindows cube = new CubeWindows();
        TimerWindows time = new TimerWindows();
    }
   
}
