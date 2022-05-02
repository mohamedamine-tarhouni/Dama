package game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import events.IA;
import events.Round;
import events.Verifications;
import model.Match;
import model.Piece;
import utilitaires.Menu;
import utilitaires.Utilitaires;

public class Game {
	
	//le menu
	Match match = Menu.menu_Principale();
	
	//le plateau
	String[][] board = new String[match.getSize()][match.getSize()];
	ArrayList<Piece> alP = new ArrayList<Piece>();
	//le hashMap qui va contenir toute les pions
	HashMap<String, Piece> hmPieces = new HashMap<String, Piece>();
	
	//la date de creation du fichier 
	Date date = Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh'H'mm");
	String Filename = dateFormat.format(date);

	public void game() {
		Utilitaires.draw_Board(board);
		Utilitaires.add_Pieces_To_List(alP, board.length);
		Utilitaires.add_Pieces_To_Board(alP, hmPieces, board);
		Utilitaires.read_Board(board);
		while (!match.getJ1().isLost() && !match.getJ2().isLost()) {
			if (match.getJ1().isTour()) {
				Round.round(hmPieces, board, match.getJ1(), Filename);
				match.getJ2().setTour(true);
			} else {
				if (match.getJ2().isControlled()) {
					Round.round(hmPieces, board, match.getJ2(), Filename);

				} else {
					IA.round_IA(hmPieces, board, match.getJ2(), Filename);
				}
				match.getJ1().setTour(true);
			}
			match.getJ1().setNbPieces(Utilitaires.get_Nb_Pieces(hmPieces, match.getJ1().getCouleur()));
			match.getJ2().setNbPieces(Utilitaires.get_Nb_Pieces(hmPieces, match.getJ2().getCouleur()));
			Verifications.verif_If_Player_Lost(match.getJ1());
			Verifications.verif_If_Player_Lost(match.getJ2());

		}
		if (match.getJ1().isLost()) {
			System.out.println(match.getJ2().getName() + " GAGNANT!!!");
		} else {
			System.out.println(match.getJ1().getName() + " GAGNANT!!!");
		}
		Utilitaires.write_Board_To_File(board, Filename);
	}
}
