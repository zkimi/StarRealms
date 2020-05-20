package game;

import java.awt.Color;
import java.io.IOException;

import fr.umlv.zen5.Application;
import gameMode.DeathMatch;
import gameMode.GameVsBot;
import gameMode.GameVsPlayer;
import gameMode.ManHunt;
import graphic.Menu;
import graphic.graphicLoad;

public class Jeux {
	public static void main(String[] args) {
		Application.run(Color.BLACK, context -> {//On affiche simplement le menu pour savoir ou rediriger le joueur
			while (true) {
				int x = Menu.controller(context);
				switch (x) {
				case 1:
					try {
						GameVsPlayer.startGame(context);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;

				case 2:
					try {
						GameVsBot.startGame(context);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				
				case 3:
					DeathMatch.startGame(context);
					break;
					
				case 4:
					ManHunt.startGame(context);
					break;
					
				case 5:
					System.out.println("je charge");
					graphicLoad.controller(context);

				}		
			}		
		});
	}
}
