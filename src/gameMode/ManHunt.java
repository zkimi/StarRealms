package gameMode;

import java.util.ArrayList;
import java.util.Collections;

import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import gameComponent.Market;
import gameComponent.Player;
import graphic.EndGame;
import graphic.GraphDeathMatch;

public class ManHunt {
	public static void startGame(ApplicationContext context) {
		Market.initializeCards();
		Player p1 = new Player("Joueur 1");
		Player p2 = new Player("Joueur 2");
		Player p3 = new Player("Joueur 3");
		ArrayList<Player> playersList = new ArrayList<>();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		
		p1.distributeCards(8, CoreSet.scout);
		p1.distributeCards(2, CoreSet.viper);
		
		p2.distributeCards(8, CoreSet.scout);
		p2.distributeCards(2, CoreSet.viper);
		
		p3.distributeCards(8, CoreSet.scout);
		p3.distributeCards(2, CoreSet.viper);
		
		// On mélange les cartes de chaque joueur
		p1.shuffleCards();
		p2.shuffleCards();
		p3.shuffleCards();
		
		Collections.shuffle(playersList);
		playersList.get(playersList.size()-1).pickCardsInHand(3);
		mainGame(playersList, context);
	}
	
	private static void mainGame(ArrayList<Player> playerList,ApplicationContext context){
		int win = 0;
		while (true) {
			for (int i = playerList.size() - 1; i >=0; i--) {
				GraphDeathMatch.controller(i , playerList, context);
				playerList.get(i).endTurn();
				if (i == 0 ) {//On verifie si son voisin n'est pas mort et si non il pioche
					if (playerList.get(playerList.size()-1).getLife() <= 0) {
						win ++;
						enGame(context, playerList.get(i));
						break;
					}
					playerList.get(playerList.size()-1).pickCardsInHand(5);
				}else {					
					if (playerList.get(i-1).getLife() <= 0) {
						win ++;
						enGame(context, playerList.get(i));
						break;
					}
					playerList.get(i-1).pickCardsInHand(5);
				}
			}
			if (win != 0) {
				break;
			}
		}	
	}
	
	public static void enGame(ApplicationContext context, Player winner) {
		while (true) {
			int x = EndGame.controller(context, winner);
			if (x == 1) {
				startGame(context);
				break;
			}else if (x == 2) {
				break;
			}
			
		}
		context.exit(0);
	}
}
