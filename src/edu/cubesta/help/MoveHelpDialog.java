/* Project : CubeSTA
 * Location : edu.cubesta.help
 * Class : MoveHelpDialog.java
 */
package edu.cubesta.help;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Créer la boite de dialogue d'aide des mouvements
 * @author julien.gardet
 */
public class MoveHelpDialog extends JDialog {
    
    /**
     * Permet de créer la fenêtre de la boite de dialogue d'aide des mouvements
     * @param parent
     * Le contenue de la fenêtre
     * @param title
     * Le titre de la fenêtre
     */

    public MoveHelpDialog(JFrame parent, String title) {
        super(parent, title);
        this.setSize(300,250);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        this.setContentPane(new MoveHelpPanel());
        this.setVisible(true);
    }
    
}
