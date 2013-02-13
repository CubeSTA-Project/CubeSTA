/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author julien
 */
public class Graphs extends JPanel {
    
    char[][] cubeGUI;
    char[][] algo;
    
    /**
     * 
     * @param cubeGUIsend 
     */
    
    public Graphs(char[][] cubeGUIsend, char[][] algosend){
        cubeGUI = cubeGUIsend;
        algo = algosend;
        
    }
    
    /**
     * 
     * @param g 
     */
    
    public void paintComponent(Graphics g){
        this.setBackground(Color.WHITE);
        int pointUnit = this.getHeight()/12;
        for(int j = 1, k = 9; j <= 3; j++){
            for(int i = 4; i <= 6 ; i++, k--){
                g.setColor(getColorCube(cubeGUI['W'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 4, k = 9; j <= 6; j++){
            for(int i = 10; i <= 12 ; i++, k--){
                g.setColor(getColorCube(cubeGUI['B'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 4, k = 1; j <= 6; j++){
            for(int i = 4; i <= 6 ; i++, k++){
                g.setColor(getColorCube(cubeGUI['G'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int j = 7, k = 1; j <= 9; j++){
            for(int i = 4; i <= 6 ; i++, k++){
                g.setColor(getColorCube(cubeGUI['Y'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int i = 3, k = 1; i >= 1; i--){
            for(int j = 4; j <= 6 ; j++, k++){
                g.setColor(getColorCube(cubeGUI['O'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        for(int i = 9, k = 9; i >= 7; i--){
            for(int j = 4; j <= 6 ; j++, k--){
                g.setColor(getColorCube(cubeGUI['R'][k]));
                g.fillRect(i*pointUnit, j*pointUnit, 1*pointUnit, 1*pointUnit);
                g.setColor(Color.BLACK);
                g.drawRect(i*pointUnit-1, j*pointUnit-1, 1*pointUnit+1, 1*pointUnit+1);
            }
        }
        String algoString = "";
        for(int i = 0; i < algo[0].length ; i++){
            algoString += algo[0][i] + "" + algo[1][i] + " ";
        }
        g.setColor(Color.BLACK);
        Font font = new Font("Ubuntu", Font.BOLD, 20);
        g.setFont(font);
        g.drawString(algoString, 0*pointUnit+5, 11*pointUnit);
    }
    
    /**
     * 
     * @param color
     * @return 
     */
    
    public Color getColorCube(char color){
        if(color == 'R'){return Color.RED;}
        else if(color == 'G'){return Color.GREEN;}
        else if(color == 'B'){return Color.BLUE;}
        else if(color == 'Y'){return Color.YELLOW;}
        else if(color == 'O'){return Color.ORANGE;}
        else if(color == 'W'){return Color.WHITE;}
        else{return Color.BLACK;}

    }
    
}
