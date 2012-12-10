package um;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;

public class Graphe {

  public List<Noeud> sommets;
  public List<Arete> aretes;
  public Noeud racine;
  public Noeud courant;
  
  static final int scaleY = 12;
  static final int scaleX = 12;

  public void Graphe() {
        racine = new Noeud(Type.User, "Task_"+sommets.size(), 0, new Point(0,0));
        sommets.add(racine);
        courant = racine;
  }

  public void add(Type type) {
        Noeud noeud = new Noeud(type, "Task_"+sommets.size(), courant.getLevel()+1, new Point(courant.getPosition().x, courant.getPosition().y + scaleY));
        sommets.add(noeud);
        aretes.add(new Arete(courant, noeud));//attention aux références
        courant = noeud;
  }

  public void delete(int arg2) {
  }
  
  private int countLevel(List<Noeud> listeNoeud, int level){
      int count = 0;
      Iterator<Noeud> it = listeNoeud.iterator();
      while(it.hasNext()){
          if(it.next().getLevel()==level)count++;
      }
      return count;
  }
}