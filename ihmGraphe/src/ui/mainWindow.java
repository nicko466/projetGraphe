    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author nicko2
 */
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.text.Position;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultGraphModel;
import um.*;
import um.operation.Operator;

public class mainWindow extends JFrame implements ActionListener {

    mainWindow mW ;
    
    private JPanel jContentPane = null;
    JPanel north;
    JPanel south;
    //JGraph graph;
    mxGraph graphx;
    String nomD;
    Object v0;
    mxGraphComponent graphComponent;
    Object parent;
    JScrollPane scrollPane;
    DefaultGraphModel gm;
    JMenuBar barreMenu = null;
    JMenu fichier = null;
    JMenu edition = null;
    JMenuItem nouveau = null;
    JMenuItem ouvrir = null;
    JMenuItem sauvegarder = null;
    JMenuItem quitter = null;
    JMenuItem supp = null;
    JToolBar bar = null;
    JToolBar barH = null;
    JButton btnNoeud = null;
    JButton btnArete = null;
    JButton jbtnNew = null;
    JButton jbtnOpen = null;
    JButton jbtnSave = null;
    JButton jbtnExit = null;
    JButton jbtnCopy = null;
    
    JButton btn1 = null;
    JButton btn2 = null;
    JButton btn3 = null;
    JButton btn4 = null;
    JButton btn5 = null;
    JButton btn6 = null;
    JButton btn7 = null;
    JButton btn8 = null;
    JButton btn9 = null;
                                
    
    
    
    File file = null;
    JFileChooser choixFichier = new JFileChooser();
    Noeud noeud;
    Arete arete;
    Graphe graphe ;
    Dialogue diag;
    DefaultGraphCell myCell;
    Cursor curseurDefaut = new Cursor(Cursor.DEFAULT_CURSOR);
    Cursor curseurMain = new Cursor(Cursor.HAND_CURSOR);

    public mainWindow() {

        super();
        this.mW = this;
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
            ouvrir.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.open();
                }
            });            
            
            
            quitter = new JMenuItem("Quitter");
            quitter.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.dispose();
                }
            });            

            sauvegarder = new JMenuItem("Enregistrer");
            sauvegarder.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.saveAs();
                }
            });            
            

            fichier = new JMenu();

            fichier.setText("Fichier");

            fichier.add(nouveau);
            fichier.add(ouvrir);
            fichier.add(sauvegarder);
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
            
            supp = new JMenuItem("Supprimer");
            supp.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    graphx.removeCells();
                }
            });             
            
            edition.add(supp);
            
        }
        return edition;
    }

    private JToolBar getJToolBarV() {
        if (bar == null) {

            bar = new JToolBar();

            bar.setName("Barre flottante");
            bar.setOrientation(JToolBar.HORIZONTAL);
            //bar.setLayout(java.awt.BorderLayout.PAGE_END);
            bar.setSize(new java.awt.Dimension(120, 40));
            bar.setPreferredSize(new java.awt.Dimension(200, 40));
            bar.setLocation(new java.awt.Point(25, 0));
            bar.setFloatable(true);

            // TODO : moche..
            bar.add(getBtnAjouter());
            bar.add(getBtnSupprimer());

        }
        return bar;
    }

    private JToolBar getJToolBarH() {
        if (barH == null) {
            barH = new JToolBar();
            barH.setLocation(new java.awt.Point(25, 0));
            barH.setSize(new java.awt.Dimension(200, 40));
            barH.setFloatable(false);

            jbtnOpen.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.open();
                }
            });             
            
            jbtnExit.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.dispose();
                }
            }); 
            
            jbtnSave.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    mW.saveAs();
                }
            });             

            north.add(jbtnNew);
            north.add(jbtnOpen);
            north.add(jbtnCopy);
            north.add(jbtnSave);
            north.add(jbtnExit);

        }
        return barH;
    }

    private JButton getBtnAjouter() {

        if (btnNoeud == null) {

            
            ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/image/add.jpg"));
            btnNoeud = new JButton(icon1);
            btnNoeud.setToolTipText("Ajouter un noeud");

            btnNoeud.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    diag = new Dialogue(mW, "Relation entre noeud");

                    //ajouter();
                    setCursor(curseurMain);
                }
            });
        }
        return btnNoeud;
    }

    // (si on veut un bouton enfoncé : JToggleButton)
    private JButton getBtnSupprimer() {

        if (btnArete == null) {

            btnArete = new JButton(" - ");

            //btnArete.setText("Arete");
            btnArete.setPreferredSize(new java.awt.Dimension(2, 2));
            btnArete.setToolTipText("Supprimer un noeud");

            btnArete.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    //v0 =graphx.getSelectionCell();
                    
                    graphx.removeCells();
                    setCursor(curseurMain);
                }
            });
        }
        return btnArete;
    }

    // JPanel principal composé de nord et sud
    public JPanel getJContentPane() {
        if (jContentPane == null) {

            jContentPane = new JPanel();

            //initialisation du layout
            jContentPane.setLayout(new BorderLayout());

            //placement des JPanel et du scrollPane
            jContentPane.add(north, java.awt.BorderLayout.NORTH);
            jContentPane.add(south, java.awt.BorderLayout.PAGE_END);


        }
        return jContentPane;
    }

    void open() {
        choixFichier.showOpenDialog(null);
        if (choixFichier.getSelectedFile() != null) {
            file = choixFichier.getSelectedFile();
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ois.close();

            } catch (Exception err) {
                System.out.println("Erreur" + err);
            }
        }
    }


    void saveAs() {
        choixFichier.showSaveDialog(null);
        if (choixFichier.getSelectedFile() != null) {
            file = choixFichier.getSelectedFile();
            try {
                FileOutputStream fis = new FileOutputStream(file);
                ObjectOutputStream ois = new ObjectOutputStream(fis);
                ois.close();
            } catch (Exception err) {
                System.out.println("Erreur" + err);
            }
        }
    }

    void ajouter() {
        
        v0 = graphx.getSelectionCell();
        
        graphx.getModel().beginUpdate();
        try {
            
           
            graphe.add(Type.Interaction,1);
            Object v2 = graphx.insertVertex(parent, null, "Enfant", graphe.sommets.get(graphe.sommets.size()-1).getPosition().x, graphe.sommets.get(graphe.sommets.size()-1).getPosition().y, 80, 30);
            graphx.insertEdge(parent, null,"", v0, v2);
        } finally {
            graphx.getModel().endUpdate();
        }
        
    }

    private void initialize() {


        
        graphe = new Graphe();

        //initialisation des attributs
        north = new JPanel();
        south = new JPanel();

        //création icon des boutons
        ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/image/add.jpg"));        
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/image/info.png"));
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/image/save.png"));
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/image/exit.png"));
        ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/image/copy.png"));


        //initialisation les boutons de la barre du haut
        jbtnNew = new JButton(icon1);
        jbtnOpen = new JButton(icon2);
        jbtnSave = new JButton(icon3);
        jbtnCopy = new JButton(icon5);
        jbtnExit = new JButton(icon4);
        
        
        

        //Définit un titre pour notre fenêtre
        this.setTitle("Graphe");

        //fenêtre de taille 900 sur 500
        this.setSize(900, 500);

        //ajoute les jToolBars
        south.add(getJToolBarV());
        north.add(getJToolBarH());

        this.setJMenuBar(getJJMenuBar());


        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setJMenuBar(getJJMenuBar());

        this.setContentPane(getJContentPane());

        // initialise le graphe

        graphx = new mxGraph();
        Object parent = graphx.getDefaultParent();




        mxGraphComponent graphComponent = new mxGraphComponent(graphx);
        getContentPane().add(graphComponent);


        // initialise les composants du graphe
//        graphComponent = new mxGraphComponent(graphx);
//        graphComponent.setSize(new Dimension(400, 400));

        // ajoute les composants au JPanel principal
        //getJContentPane().add(graphComponent);

        // chargement du graphe avec une racine
        graphx.getModel().beginUpdate();

        v0 = graphx.insertVertex(parent, null, "Racine", 400, 20, 80, 20);
        graphx.getModel().endUpdate();



        //this.setContentPane(getContentPane());

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
