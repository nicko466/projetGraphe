/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.operation;

import um.Noeud;

/**
 *
 * @author nicko2
 */
public class Binary extends Operator{
    private Noeud n2;
    
    public Binary(String name, Noeud n1, Noeud n2){
        super(name, n1);
        this.n2 = n2;
    }
}
