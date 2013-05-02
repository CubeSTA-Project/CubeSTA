/**
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * © Copyright 2013, Gardet Julien, Droy Yann, Araujo Auxence.
 * 
 * The logo in edu.cubesta.ressources.favicon.png is a derivate work from
 * <http://commons.wikimedia.org/w/index.php?title=File:Rubik%27s_cube.svg&oldid=70000649>.
 * 
 * Other legal notices on <http://cubesta-project.github.io/CubeSTA/legals.html>.
 */
/* Project : CubeSTA
 * Location : edu.cubesta
 * Class : CubeSTA.java
 */

package edu.cubesta;

import edu.cubesta.cubewindows.CubeWindows;
import edu.cubesta.ressources.Dialog;
import edu.cubesta.ressources.L10n;
import edu.cubesta.timerwindows.TimerWindows;

/**
 * Classe principale permettant d'afficher une fenêtre avec un patron mélangé et un chronomètre
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