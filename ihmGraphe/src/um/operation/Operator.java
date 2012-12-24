package um.operation;

import um.Graphe;
import um.Noeud;


public class Operator{
    private String name;
    private Noeud n1;
    private Graphe g;

    public Noeud getN1() {
        return n1;
    }
    
    public Operator(String name, Noeud n1){
        this.name = name;
        this.n1 = n1;
        g.getOperator().add(this);
    }
  
    public String getName(){
        return name;
    }
}