package model;
//la classe Piece contient toutes les infos dur les pions
public class Piece {
	String name, colour;
	int id, y, x;
	boolean isQueen;

	public Piece(String name, String colour, int id, int y, int x, boolean isQueen) {
		super();
		this.name = name;
		this.colour = colour;
		this.id = id;
		this.y = y;
		this.x = x;
		this.isQueen = isQueen;
	}
	//le nom du pions
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//le couleur du pions
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	//l'id du pion
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// les coordonnées du pion
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	//true s'il est une dame
	public boolean isQueen() {
		return isQueen;
	}

	public void setQueen(boolean isQueen) {
		this.isQueen = isQueen;
	}

}
