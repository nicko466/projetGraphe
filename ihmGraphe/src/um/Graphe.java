package um;

import java.awt.Point;
import java.util.List;

public class Graphe {

  public List sommets;
  public List aretes;
  public Noeud racine;
  public Noeud courant;
  
  static final int scale = 12;

  public void Graphe() {
        racine = new Noeud(Type.User, "Task_"+sommets.size(), 0, new Point(0,0));
        sommets.add(racine);
        courant = racine;
  }

  public void add(Type type) {
        Noeud noeud = new Noeud(type, "Task_"+sommets.size(), courant.getLevel()+1, new Point(courant.getPosition().x, courant.getPosition().y + scale));
        sommets.add(noeud);
        aretes.add(new Arete(courant, noeud));//attention aux références
        courant = noeud;
  }

  public void delete(int arg2) {
  }

}