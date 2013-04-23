/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.help;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author julien
 */
public class KeyHelpDialog extends JDialog {

    public KeyHelpDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        this.setSize(500,300);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        this.setContentPane(new KeyHelpPanel());
        this.setVisible(true);
    }
    
}
