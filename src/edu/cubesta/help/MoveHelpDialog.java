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
 * Location : edu.cubesta.help
 * Class : MoveHelpDialog.java
 */

package edu.cubesta.help;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Créer la boîte de dialogue d'aide des mouvements
 * @author julien.gardet
 */

public class MoveHelpDialog extends JDialog {
    
    /**
     * Permet de créer la fenêtre de la boîte de dialogue d'aide des mouvements
     * @param parent
     * Le contenu de la fenêtre
     * @param title
     * Le titre de la fenêtre
     */

    public MoveHelpDialog(JFrame parent, String title) {
        super(parent, title);
        this.setSize(300,280);
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
        this.setContentPane(new MoveHelpPanel());
        this.setVisible(true);
    } 
}