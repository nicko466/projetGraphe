/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author nicko2
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.GraphModel;
import um.*;

public class mainWindow extends JFrame{
    
JPanel north;
JPanel west;
JButton noeud1;
JButton noeud2;
JGraph graph;
DefaultGraphModel gm;


public mainWindow(){
    
    super();
    //initialisation des attributs
    north = new JPanel();
    west = new JPanel();
    noeud1 = new JButton("N1");
    noeud2 = new JButton("N2");
    gm = new DefaultGraphModel(Main.graphe.sommets, AttributeMap.emptyAttributeMap);
    graph = new JGraph(gm);
    
    
    
    
    JScrollPane scrollPane = new JScrollPane(graph);
    
    
    //Ajout de listeners
    noeud1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                noeud1ActionLister(ae);
            }
        });

    noeud2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               noeud2ActionLister(ae);
            }
        });
    //Définit un titre pour notre fenêtre
    this.setTitle("Graphe");
    //fenêtre de taille 900 sur 500
    this.setSize(900,500);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Initialisation du layout
    this.setLayout(new BorderLayout());
    
    //Placement des Jpanel
    this.add(north,BorderLayout.NORTH);
    this.add(west,BorderLayout.WEST);
    this.add(scrollPane,BorderLayout.CENTER);
    //coloration des panels
    north.setBackground(Color.red);
    west.setBackground(Color.black);
    
    //Ajout des boutons dans les panels
    west.add(noeud1);
    west.add(noeud2);
    //Et enfin, la rendre visible        
    this.setVisible(true);
  }


    public void noeud1ActionLister(ActionEvent ae){
        System.out.println("Clique bouton 1");
    }

    public void noeud2ActionLister(ActionEvent ae){
        System.out.println("Clique bouton 2");
    }





}

