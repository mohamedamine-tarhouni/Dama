package model;
//contient toute les infos des joueurs
public class Joueur {
	String name;
	String couleur;
	boolean tour, isControlled, lost;
	int nbPoints, nbPieces;

	public Joueur(String name, String couleur, boolean tour, boolean isControlled, boolean lost, int nbPoints,
			int nbPieces) {
		super();
		this.name = name;
		this.couleur = couleur;
		this.tour = tour;
		this.isControlled = isControlled;
		this.lost = lost;
		this.nbPoints = nbPoints;
		this.nbPieces = nbPieces;
	}
	//nom du joueur
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//couleur du joueur
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	//true si c'est le tour du joueur
	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}
	//true si le joueur est une personne
	public boolean isControlled() {
		return isControlled;
	}

	public void setControlled(boolean isControlled) {
		this.isControlled = isControlled;
	}
	//true si le joueur a perdu la partie
	public boolean isLost() {
		return lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

}
