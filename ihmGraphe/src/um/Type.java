package um;

public enum Type {
    User(0), Abstraction(1), Application(2), Interaction(3);
 
	/** L'attribut qui contient la valeur associé à l'enum */
	private final int value;
 
	/** Le constructeur qui associe une valeur à l'enum */
	private Type(int value) {
		this.value = value;
	}
 
	/** La méthode accesseur qui renvoit la valeur de l'enum */
	public int getValue() {
		return this.value;
	}
};