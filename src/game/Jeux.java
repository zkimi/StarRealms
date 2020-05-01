package game;

import java.awt.Color;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import gameDeroulement.GameVsBot;
import gameDeroulement.GameVsPlayer;
import graphic.GameController;

public class Jeux {
	public static void main(String[] args) {
		Application.run(Color.BLACK, context -> {//On affiche simplement le menu pour savoir ou rediriger le joueur
			while (true) {
				int x = GameController.windowMenu(context);
				if (x == 1) {
					GameVsPlayer.startGame(context);
					break;
				}else if (x == 2) {
					GameVsBot.startGame(context);
					break;
				}				
			}
			context.exit(0);		
		});
	}
}
