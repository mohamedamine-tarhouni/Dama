package events;

//import java.security.AlgorithmParameterGenerator;
import java.util.HashMap;

import model.Piece;
import utilitaires.File_Manager;
import utilitaires.Utilitaires;

public class Events {

//transformer le pion arrivé à la fin en une dame
	public static void transfrom_To_Queen(HashMap<String, Piece> hmP, Piece P, String[][] board) {
		// le pion n'est pas une dame
		if (!P.isQueen()) {
			// si le pion est blanc
			if (P.getColour() == "Blanc") {
				if (P.getY() == 1) {
					hmP.remove(P.getName());
					P.setQueen(true);
					P.setName("QB" + String.valueOf(P.getId()));
					board[P.getY()][P.getX()] = P.getName();
					hmP.put(P.getName(), P);
				}
			} else {
				// si le pion est noir
				if (P.getY() == board.length - 2) {
					hmP.remove(P.getName());
					P.setQueen(true);
					P.setName("QN" + String.valueOf(P.getId()));
					board[P.getY()][P.getX()] = P.getName();
					hmP.put(P.getName(), P);
				}
			}
		}

	}

//move sert à bouger un pion(piece) et le transformer en dame si possible
	public static void move(HashMap<String, Piece> hmP, Piece P, String[][] board, int x, int y) {
		board[P.getY()][P.getX()] = ".";
		P.setX(x);
		P.setY(y);
		board[P.getY()][P.getX()] = P.getName();
		transfrom_To_Queen(hmP, P, board);
	}

	// le 'predator' mange 'victim'
	public static void eat_Event(Piece predator, Piece victim, String[][] board, HashMap<String, Piece> hmP,String Filename) {
		System.out.println(predator.getName() + " a mangé " + victim.getName());
		File_Manager.writeToFile(Filename, predator.getName() + " a mangé " + victim.getName()+"\n\n");
		board[victim.getY()][victim.getX()] = Utilitaires.get_Position(board, victim.getX(), victim.getY());
		hmP.remove(victim.getName());
	}

}
