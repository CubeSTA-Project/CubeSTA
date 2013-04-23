/* Project : CubeSTA
 * Location : edu.cubesta.timerwindows
 * Class : Listener.java
 */
package edu.cubesta.resources;

import edu.cubesta.cubewindows.CubeWindows;
import edu.cubesta.help.KeyHelpDialog;
import edu.cubesta.help.MoveHelpDialog;
import edu.cubesta.timer.Average;
import edu.cubesta.timer.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La classe permet d'écouter sur quelle touche l'utilisateur appuie
 *
 * @author julien.gardet
 */
public class Listener implements KeyListener {

    /**
     * Variable Globale
     */
    static boolean start;
    public static boolean endPenality;
    public static boolean startPenality;
    public static boolean inspection;
    public static boolean DNS;
    public static boolean DNF;
    Timer time;
    Average avg;

    /**
     * Initialise la classe avec la classe Timer et Average
     */
    public Listener() {
        time = new Timer();
        start = true;
        avg = new Average(Dialog.getNumberOfTime());
        endPenality = false;
        startPenality = false;
        inspection = false;
        DNS = false;
        DNF = false;
    }

    /**
     * La fonction est appeler lorsque la touche retourne un charactère unicode
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY TYPED: ");
    }

    /**
     * la fonction est appeler lorsque la touche vient d'être appuyer
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //displayInfo(e, "KEY PRESSED: ");
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {//Space
            if (start) {
                Timer.reset();
                Timer.start();
                if (inspection && startPenality) {
                    Timer.tempsStart = Timer.tempsStart - 2000;
                    Average.temps[1][Average.nbr] = Average.temps[1][Average.nbr] + 2;
                } else {
                    startPenality = false;
                }
                start = false;
                endPenality = false;
                inspection = false;
                DNS = false;
                DNF = false;
                Average.checkToReset(Dialog.getNumberOfTime());//Verifie si les temps sont plein afin d'être de remis à zéro
            } else {
                int timeDone = Timer.stop();
                Average.insertTime(timeDone);
                start = true;
                CubeWindows.changeScreen();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {//Echap
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_F10) {//F10
            int setNOS = Dialog.setNOS();
            CubeWindows.changeScreen();
        } else if (e.getKeyCode() == KeyEvent.VK_F11) {//F11
            int setNOT = Dialog.setNOT();
        } else if (e.getKeyCode() == KeyEvent.VK_F12) {//F12
            CubeWindows.changeScreen();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {//R
            Average.reset(Dialog.getNumberOfTime());
            Timer.reset();
            start = true;
            endPenality = false;
            startPenality = false;
            inspection = false;
            DNS = false;
            DNF = false;
        }else if(e.getKeyCode() == KeyEvent.VK_F1){ //F1
            start = true;
            Timer.reset();
            KeyHelpDialog khd = new KeyHelpDialog(null, "\u2328 " + L10n.getLanguage(15), true);
        }else if(e.getKeyCode() == KeyEvent.VK_F2){ //F1
            start = true;
            Timer.reset();
            MoveHelpDialog mhd = new MoveHelpDialog(null, "\u2328 " + L10n.getLanguage(16), true);
        }else if (e.getKeyCode() == KeyEvent.VK_F3) {//F3
            Dialog.setLAN();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && start && Average.nbr != 0 && !DNS && !DNF && !inspection) {//entrer
            penality();
        } else if (e.getKeyCode() == KeyEvent.VK_SHIFT && start && !inspection) {//Maj
            Timer.reset();
            Average.checkToReset(Dialog.getNumberOfTime());
            Timer.tempsStart = System.currentTimeMillis() + 15000;
            inspection = true;
            startPenality = false;
            endPenality = false;
            DNS = false;
            DNF = false;
        } else if ((e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_F) && start && Average.nbr != 0 && !inspection && !DNS){//D
            didNotFinish();
        } else if (e.getKeyCode() == KeyEvent.VK_S && start && !inspection){//S
            Average.checkToReset(Dialog.getNumberOfTime());
            didNotStart();
        }
    }

    /**
     * La fonction est appeler lorsque la touche est relacher
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
    }

    /**
     * Affiche une information sur la touche qui vient d'être appuyer (from
     * Oracle)
     *
     * @param e parametre de la touche appuyer
     * @param keyStatus Statut de la touche (Pressed/Typed/Released)
     * @deprecated
     */
    private void displayInfo(KeyEvent e, String keyStatus) {

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

    public void penality() {
        if (endPenality) {
            endPenality = false;
            Timer.tempsStop = Timer.tempsStop - 2000;
            Average.temps[0][Average.nbr - 1] = Timer.currentTime();
            Average.temps[1][Average.nbr - 1] = Average.temps[1][Average.nbr - 1] - 2;
        } else {
            endPenality = true;
            Timer.tempsStop = Timer.tempsStop + 2000;
            Average.temps[0][Average.nbr - 1] = Timer.currentTime();
            Average.temps[1][Average.nbr - 1] = Average.temps[1][Average.nbr - 1] + 2;
        }
    }

    public static void didNotStart() {
        Average.insertTime(-1);
        Average.temps[1][Average.nbr - 1] = 0;
        Average.temps[2][Average.nbr - 1] = 1;
        DNS = true;
        DNF = false;
        start = true;
        endPenality = false;
        startPenality = false;
        inspection = false;
        CubeWindows.changeScreen();
    }

    public static void didNotFinish() {
        Average.temps[0][Average.nbr - 1] = -1;
        Average.temps[1][Average.nbr - 1] = 0;
        Average.temps[2][Average.nbr - 1] = 2;
        DNS = false;
        DNF = true;
        start = true;
        endPenality = false;
        startPenality = false;
        inspection = false;
    }
}
