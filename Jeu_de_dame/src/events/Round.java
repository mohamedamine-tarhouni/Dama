package events;

import java.util.HashMap;

import game.Texts;
import model.Joueur;
import model.Mouvement;
import model.Piece;
import utilitaires.Utilitaires;

public class Round {

//round sert à gerer un tour pour un joueur
	public static void round(HashMap<String, Piece> hmPiece, String[][] board, Joueur joueur,String Filename) {
		//on continue tant que le joueur n'a pas perdu et c'est son tour
		while (joueur.isTour() && !joueur.isLost()) {
			System.out.println("\n\n" + Texts.display_Player_Turn + joueur.getName() + "\n");
			Utilitaires.displayPlayer(joueur);
			Mouvement mvt = new Mouvement(false, null, hmPiece, null);
			Utilitaires.get_Movable_Pieces(mvt, hmPiece, board, joueur.getCouleur());
			if (mvt.getTabMovable().isEmpty()) {
				joueur.setLost(true);
			} else {
				Utilitaires.display_List(mvt.getTabMovable(), Texts.display_Possible_Pieces);
				System.out.println(Texts.piece_Choice);
				//choix du pion à bouger
				String choix = Utilitaires.saisieString().toUpperCase();
				while (!mvt.getTabMovable().contains(choix)) {
					System.out.println("choix invalide");
					choix = Utilitaires.saisieString().toUpperCase();
				}
				// prev_pos est la position precedente de Pion avant de le bouger
				String prev_pos = Utilitaires.get_Position(board, hmPiece.get(choix).getX(), hmPiece.get(choix).getY());
				mvt = Verifications.possible_Moves(hmPiece, hmPiece.get(choix), board, true);
				Utilitaires.display_List(mvt.getPossible_Moves(), Texts.display_Positions + choix + " : ");
				Utilitaires.read_Board(board);

				System.out.println(Texts.position_Choice);
				//choix de la position
				String choix_pos = Utilitaires.saisieString().toUpperCase();

				while (!Verifications.verif_Choice(choix_pos, mvt.getPossible_Moves()) && !choix_pos.equals("0")) {
					choix_pos = Utilitaires.saisieString().toUpperCase();
				}
				//on peut annuler notre choix de pion en mettant "0"
				if (!choix_pos.equals("0")) {
					if (mvt.getEat_Moves().containsKey(choix_pos)) {
						Events.eat_Event(hmPiece.get(choix), mvt.getEat_Moves().get(choix_pos), board, hmPiece,Filename);
						joueur.setNbPoints(joueur.getNbPoints() + 1);

					}
					//transformation du position choisi en coordonnées
					int x = choix_pos.charAt(0);
					x = x - 64;
					int y = Integer.valueOf(choix_pos.substring(1));
					//affichage du message
					utilitaires.File_Manager.writeToFile(Filename,joueur.getName() + " a bougé " + hmPiece.get(choix).getName() + " de " + prev_pos
							+ " à " + Utilitaires.get_Position(board, x, y)+"\n\n");
					System.out.println(joueur.getName() + " a bougé " + hmPiece.get(choix).getName() + " de " + prev_pos
							+ " à " + Utilitaires.get_Position(board, x, y));
					Events.move(hmPiece, hmPiece.get(choix), board, x, y);
					joueur.setTour(false);

				}
			}

			Utilitaires.reinitBoard(hmPiece, board);
			Utilitaires.read_Board(board);

		}

	}
}
