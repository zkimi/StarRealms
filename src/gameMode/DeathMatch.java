package gameMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import gameComponent.Bot;
import gameComponent.Market;
import gameComponent.Player;
import graphic.EndGame;
import graphic.GraphDeathMatch;
import graphic.MainGame;

public class DeathMatch {
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
		ArrayList<Player> death = new ArrayList<Player>();
		while (true) {
			for (int i = playerList.size() - 1; i >=0; i--) {
				if (playerList.get(i).getLife() <= 0) {//Si le joueur est mort on le retire de la liste
					death.add(playerList.get(i));
					playerList.remove(i);
					if (i == 0 ) {
						playerList.get(playerList.size()-1).pickCardsInHand(5);
					}else {
						playerList.get(i-1).pickCardsInHand(5);
					}
					continue;
				}
				GraphDeathMatch.controller(i , playerList, context);
				playerList.get(i).endTurn();
				if (i == 0 ) {
					playerList.get(playerList.size()-1).pickCardsInHand(5);
				}else {
					playerList.get(i-1).pickCardsInHand(5);
				}			
			}
			
			if (playerList.size() == 1) {// si il n'y a plus qu'un joueur en vie il a gagné
				enGame(context, playerList.get(0));
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
