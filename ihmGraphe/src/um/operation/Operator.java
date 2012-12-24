package um.operation;

import um.Noeud;


public class Operator{
    private String name;
    private Object n1;
    
    public Operator(String name, Object o){
        this.name = name;
        this.n1 = o;
    }
  
    public String getName(){
        return name;
    }
}