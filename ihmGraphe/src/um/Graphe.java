package um;

import java.util.List;

public class Graphe {

  public List sommets;
  public List aretes;
  public Noeud racine;
  public Noeud courant;

  public void Graphe() {
        racine = new Noeud(Type.User, "Task_"+sommets.size());
        sommets.add(racine);
        courant = racine;
  }

  public void add(Type type) {
  }

  public void delete(int arg2) {
  }

}