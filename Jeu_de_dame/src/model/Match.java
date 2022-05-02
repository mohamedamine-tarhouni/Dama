package model;
//Match contient les propriet�s de la partie
public class Match {
	int size;//la taille de la carte
	Joueur j1, j2;//les deux joueurs

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public Match(int size, Joueur j1, Joueur j2) {
		super();
		this.size = size;
		this.j1 = j1;
		this.j2 = j2;
	}

}
