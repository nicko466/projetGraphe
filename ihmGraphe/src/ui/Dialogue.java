/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import org.jgraph.graph.DefaultGraphCell;
import um.Graphe;
import um.operation.Binary;
import um.operation.Operator;
//import um.operation.BinaryOp;

/**
 *
 * @author rb-ka
 */
public class Dialogue extends JDialog implements ActionListener {

    /**
     * 
     */
    JComboBox jComboBoxRel;
    JTabbedPane onglets;
    JPanel onglet1;
    JPanel onglet2;
    ButtonGroup rep;
    Box panneauRadio;
    String arete;
    String iconeArete;
    JLabel picture;
    JRadioButton op1;
    JRadioButton op2;
    DefaultGraphCell myCell;
    Binary rel;
    Graphe ope;

    mainWindow mW;

    Dialogue(final mainWindow mW, String titre) {
        super((JFrame) null, titre, true);

        this.mW=mW;
        onglets = new JTabbedPane(JTabbedPane.TOP);

        onglet1 = new JPanel();
        onglet2 = new JPanel();
        
        
        onglets.add("Opérateurs unaires",onglet2);
        onglets.add("Opérateurs binaires",onglet1);
        
        this.add(onglets);

        JButton bouton = new JButton("OK");
        bouton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mW.ajouter();
                                        dispose();
				}
			});

        JButton bouton2 = new JButton("OK");
        bouton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(op1.isSelected()){
                                            
                                            mW.ajouter();
                                            dispose();
                                        } 
                                        if(op2.isSelected()){
                                            mW.ajouter();
                                            dispose();
                                        }
				}
			});


        jComboBoxRel = new JComboBox();
        Actualiser();
        //jComboBoxRel.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBoxRel.addActionListener(this);

        
        panneauRadio = Box.createVerticalBox();
        rep = new ButtonGroup();
        op1 = new JRadioButton("Choix 1");
        //op1.setName("ghj");
        op2 = new JRadioButton("Choix 2");
        op1.setSelected(true);
        rep.add(op1);
        rep.add(op2);
        getContentPane().setLayout(new FlowLayout());
        panneauRadio.add(op2);
        panneauRadio.add(op1);
        
        op1.addActionListener(this);
        op2.addActionListener(this);


        onglet1.add(new JLabel("Choisir la relation : "), BorderLayout.NORTH);
        onglet2.add(new JLabel("Choisir la relation : "), BorderLayout.NORTH);

        onglet1.add(jComboBoxRel, BorderLayout.NORTH);
        onglet1.add(bouton);

        onglet2.add(panneauRadio);
        onglet2.add(bouton2, BorderLayout.LINE_END);

        pack();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((screenSize.width - getSize().width) / 2, (screenSize.height - getSize().height) / 2);
        setVisible(true);

    }

    public void Actualiser() {

        jComboBoxRel.removeAllItems();
        for (int i = 0; i < ope.getOperator().size(); i++) {
            Operator op = ope.getOperator().get(i);
            jComboBoxRel.addItem(op);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        //picture.setIcon(new ImageIcon("images/" + op1.getActionCommand()+ ".jpg"));
        
        //dispose();
    }
}
