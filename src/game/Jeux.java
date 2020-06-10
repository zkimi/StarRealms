package game;

import java.awt.Color;

import fr.umlv.zen5.Application;
import gameMode.DeathMatch;
import gameMode.GameVsBot;
import gameMode.GameVsPlayer;
import gameMode.ManHunt;
import gameMode.Hydra;
import graphic.Menu;
import save.Load;

public class Jeux {
	public static void main(String[] args) {
		Application.run(Color.BLACK, context -> {//On affiche simplement le menu pour savoir ou rediriger le joueur
			while (true) {
				int x = Menu.controller(context);
				switch (x) {
				case 1:
					System.out.println("L'utilisateur lance une partie de \"Joueur contre joueur\"");
					GameVsPlayer.startGame(context);
					break;

				case 2:
					System.out.println("L'utilisateur lance une partie de \"Joueur contre IA\"");
					GameVsBot.startGame(context);
					break;
				
				case 3:
					System.out.println("L'utilisateur lance une partie de \"DeathMatch\"");
					DeathMatch.startGame(context);
					break;
					
				case 4:
					System.out.println("L'utilisateur lance une partie de \"ManHunt\"");
					ManHunt.startGame(context);
					break;
					
				case 5:
					System.out.println("L'utilisateur navigue dans le menu d'ouverture de sauvegarde");
					Load.load(context);
					break;
					
				case 6:
					System.out.println("L'utilisateur lance une partie de \"Hydre\"");
					Hydra.startGame(context);
					

				}		
			}		
		});
	}
}
