package model;

import java.util.ArrayList;
import java.util.HashMap;
//Mouvement va contenir toutes proprietés du mouvement
public class Mouvement {
	private boolean possible_Moves_Exist; //il existe des mouvement pour le pion
	private ArrayList<String> Possible_Moves; //une liste qui contient les mouvements possibles
	private HashMap<String, Piece> Eat_Moves;//une hashmap qui contient les pion à manger
	private ArrayList<String> tabMovable;//une liste qui contient les pions bougables

	public boolean isPossible_Moves_Exist() {
		return possible_Moves_Exist;
	}

	public void setPossible_Moves_Exist(boolean possible_Moves_Exist) {
		this.possible_Moves_Exist = possible_Moves_Exist;
	}

	public ArrayList<String> getPossible_Moves() {
		return Possible_Moves;
	}

	public void setPossible_Moves(ArrayList<String> possible_Moves) {
		Possible_Moves = possible_Moves;
	}

	public HashMap<String, Piece> getEat_Moves() {
		return Eat_Moves;
	}

	public void setEat_Moves(HashMap<String, Piece> eat_Moves) {
		Eat_Moves = eat_Moves;
	}

	public ArrayList<String> getTabMovable() {
		return tabMovable;
	}

	public void setTabMovable(ArrayList<String> tabMovable) {
		this.tabMovable = tabMovable;
	}

	public Mouvement(boolean possible_Moves_Exist, ArrayList<String> possible_Moves, HashMap<String, Piece> eat_Moves,
			ArrayList<String> tabMovable) {
		super();
		this.possible_Moves_Exist = possible_Moves_Exist;
		Possible_Moves = possible_Moves;
		Eat_Moves = eat_Moves;
		this.tabMovable = tabMovable;
	}

}
