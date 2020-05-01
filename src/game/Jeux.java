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
				int x = GameController.menu(context);
				switch (x) {
				case 1:
					GameVsPlayer.startGame(context);
					break;

				case 2:
					GameVsBot.startGame(context);
					break;
				
				case 3:
					System.out.println("Combat à mort");
					break;
					
				case 4:
					System.out.println("Chasse à l'homme");
					break;

				}		
			}		
		});
	}
}
