package um;

import java.awt.Point;

public class Noeud {

  private Type type;
  public String name;
  public Point position;

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return position;
    }

    public Type getType() {
        return type;
    }
    
    public int getLevel() {
        return level;
    }
  
  private int level;

  public Noeud(Type type, String name, int level, Point position) {
      this.type = type;
      this.name = name;
      this.level = level;
      this.position = position;
      //TODO ouvrir une fenêtre d'interaction
  }

  
}