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
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphModel;
import um.*;

public class mainWindow extends JFrame implements ActionListener {

    private JPanel jContentPane = null;
    JPanel north;
    JPanel west;
    JButton bouton = new JButton("test");
    JGraph graph;
    JScrollPane scrollPane;
    DefaultGraphModel gm;
    JMenuBar barreMenu = null;
    JMenu fichier = null;
    JMenu edition = null;
    JMenuItem nouveau = null;
    JMenuItem ouvrir = null;
    JMenuItem sauvegarder = null;
    JMenuItem quitter = null;
    JToolBar bar = null;
    JToolBar barH = null;
    JButton btnNoeud = null;
    JButton btnArete = null;
    File file = null;
    JFileChooser choixFichier = new JFileChooser();
    Noeud noeud;
    Arete arete;
    Cursor curseurDefaut = new Cursor(Cursor.DEFAULT_CURSOR);
    Cursor curseurMain = new Cursor(Cursor.HAND_CURSOR);
    public static int ETAT = 0;

    public mainWindow() {

        super();
        initialize();
    }

    // methode pour initialiser la barre des menus
    private JMenuBar getJJMenuBar() {

        if (barreMenu == null) {
            barreMenu = new JMenuBar();
            barreMenu.add(getFile());
            barreMenu.add(getEdit());
        }

        return barreMenu;
    }

    // methode pour initialiser le JMenu "Fichier"
    private JMenu getFile() {

        if (fichier == null) {

            nouveau = new JMenuItem("Nouveau");
            ouvrir = new JMenuItem("Ouvrir...");
            quitter = new JMenuItem("Quitter");
            sauvegarder = new JMenuItem("Enregistrer");

            fichier = new JMenu();

            fichier.setText("Fichier");

            fichier.add(nouveau);
            fichier.add(ouvrir);
            //fichier.add(sauvegarder);
            fichier.addSeparator();
            fichier.add(quitter);
        }
        return fichier;

    }

    // methode pour initialiser le menu "Edition"
    private JMenu getEdit() {
        if (edition == null) {
            edition = new JMenu();
            edition.setText("Edition");
            edition.add("Modifier");
            edition.add("Supprimer");
        }
        return edition;
    }

    private JToolBar getJToolBarV() {
        if (bar == null) {

            bar = new JToolBar();

            bar.setPreferredSize(new java.awt.Dimension(70, 150));
            bar.setName("ToolBar");
            bar.setOrientation(JToolBar.VERTICAL);
            bar.setLocation(new java.awt.Point(0, 0));
            
            bar.setFloatable(false);

            // moche..
            bar.add(getBtnNoeud());
            bar.add(getBtnArete());
        }
        return bar;
    }

    private JToolBar getJToolBarH() {
        if (barH == null) {
            barH = new JToolBar();
            barH.setLocation(new java.awt.Point(25, 0));
            barH.setSize(new java.awt.Dimension(200, 40));
            barH.setFloatable(false);
            
            barH.add(bouton);
            
        }
        return barH;
    }

    private JButton getBtnNoeud() {

        if (btnNoeud == null) {

            ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/noeud.gif"));            
            btnNoeud = new JButton(icon);

            //btnNoeud.setText("Noeud");
            btnNoeud.setPreferredSize(new java.awt.Dimension(32, 32));
            btnNoeud.setToolTipText("Ajouter Noeud");

            btnNoeud.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println("actionPerformed()");
                    if (ETAT != 1) {
                        ETAT = 1;
                        System.out.println("etat 1 du bouton noeud");
                        //btnArete.setSelected(false);
                        setCursor(curseurMain);
                    } else {
                        ETAT = 0;
                        System.out.println("etat 0 du bouton noeud");
                        setCursor(curseurDefaut);
                    }
                }
            });
        }
        return btnNoeud;
    }

    
    // si on veut un bouton enfoncé : JToggleButton
    private JButton getBtnArete() {
        
        if (btnArete == null) {

            ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/iconeArete.jpg"));         
            btnArete = new JButton(icon);

            //btnArete.setText("Arete");
            btnArete.setPreferredSize(new java.awt.Dimension(32, 35));
            btnArete.setToolTipText("Ajouter une relation");

            btnArete.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {

                    if (ETAT != 2) {
                        ETAT = 2;
                        System.out.println("etat 2 du bouton arete : " + ETAT);
                        //btnNoeud.setSelected(false);
                        setCursor(curseurMain);
                    } else {
                        ETAT = 0;
                        System.out.println("etat 0 du bouton arete");
                        setCursor(curseurDefaut);
                    }
                    btnArete.setSelected(false);
                }
            });
        }
        return btnArete;
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {

            jContentPane = new JPanel();

            //initialisation du layout
            jContentPane.setLayout(new BorderLayout());

            //placement des JPanel et du scrollPane
            jContentPane.add(north, java.awt.BorderLayout.NORTH);
            jContentPane.add(west, java.awt.BorderLayout.WEST);
            jContentPane.add(scrollPane, java.awt.BorderLayout.CENTER);

        }
        return jContentPane;
    }

    private void initialize() {


        //initialisation des attributs
        north = new JPanel();
        west = new JPanel();

        //Définit un titre pour notre fenêtre
        this.setTitle("Graphe");

        //fenêtre de taille 900 sur 500
        this.setSize(900, 500);

        graph = new JGraph(gm);

        scrollPane = new JScrollPane(graph);

        this.setContentPane(getJContentPane());

        west.add(getJToolBarV());
        north.add(getJToolBarH());

        this.setJMenuBar(getJJMenuBar());


        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setJMenuBar(getJJMenuBar());



        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation((screenSize.width - getSize().width) / 2, (screenSize.height - getSize().height) / 2);
        // this.setJMenuBar(getMenu());

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
