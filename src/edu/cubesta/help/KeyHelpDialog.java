/* Project : CubeSTA
 * Location : edu.cubesta.help
 * Class : KeyHelpDialog.java
 */
package edu.cubesta.help;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Créer la boite de dialogue d'aide des touches
 * @author julien.gardet
 */
public class KeyHelpDialog extends JDialog {
    
    /**
     * Permet de créer la fenêtre de la boite de dialogue d'aide des touches
     * @param parent
     * Le contenue de la fenêtre
     * @param title
     * Le titre de la fenêtre
     */

    public KeyHelpDialog(JFrame parent, String title) {
        super(parent, title);
        this.setSize(500,320);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        this.setContentPane(new KeyHelpPanel());
        this.setVisible(true);
    }
    
}
