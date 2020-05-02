package game;

import java.awt.Color;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import gameMode.DeathMatch;
import gameMode.GameVsBot;
import gameMode.GameVsPlayer;
import graphic.ChoiceCap;
import graphic.Menu;

public class Jeux {
	public static void main(String[] args) {
		Application.run(Color.BLACK, context -> {//On affiche simplement le menu pour savoir ou rediriger le joueur
			while (true) {
				int x = Menu.controller(context);
				switch (x) {
				case 1:
					GameVsPlayer.startGame(context);
					break;

				case 2:
					GameVsBot.startGame(context);
					break;
				
				case 3:
					DeathMatch.startGame(context);
					break;
					
				case 4:
					System.out.println("Chasse à l'homme");
					break;

				}		
			}		
		});
	}
}
