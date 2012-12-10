/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um;

import ui.*;




/**
 *
 * @author nicko2
 */
public class Main {
    
    
    static Graphe graphe;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        graphe = new Graphe();
        new mainWindow();
    }
}
