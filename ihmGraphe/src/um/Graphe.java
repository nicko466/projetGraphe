package um;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import um.operation.Binary;
import um.operation.Operator;

public class Graphe {

  public List<Noeud> sommets;
  public List<Arete> aretes;
  public Noeud racine;
  public Noeud courant;
  public static ArrayList<Operator> op;
  
  static final int scaleY = 12;
  static final int scaleX = 12;

  public void Graphe() {
        racine = new Noeud(Type.User, "Task_"+sommets.size(), 0, new Point(0,0));
        sommets.add(racine);
        courant = racine;
        this.op = new ArrayList<Operator>();
  }

  public void add(Type type) {
        Noeud noeud = new Noeud(type, "Task_"+sommets.size(), courant.getLevel()+1, new Point(courant.getPosition().x, courant.getPosition().y + scaleY));
        sommets.add(noeud);
        aretes.add(new Arete(courant, noeud));//attention aux références
        courant = noeud;
  }

  public void delete() {
        if(courant!=racine) sommets.remove(courant);
        courant = racine;
        Iterator<Operator> it = op.iterator();
        while(it.hasNext()){
            Operator current = it.next();
            if(current instanceof Binary){
                if(current.getN1() == this.courant || ((Binary) current).getN2() == this.courant) Graphe.op.remove(current);
            }
            else if(current.getN1() == this.courant) Graphe.op.remove(current);
      }
  }
  
  public ArrayList<Operator> getOperator() {
        return op;
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