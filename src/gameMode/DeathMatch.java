package gameMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import gameComponent.Market;
import gameComponent.Player;
import graphic.EndGame;
import graphic.GraphDeathMatch;

public class DeathMatch {
	
	public static void initFromFile(ApplicationContext context, List<String> lines) {
		Market.initializeMarketFromFile(lines.get(lines.size()-3), lines.get(lines.size()-2), lines.get(lines.size()-1));
		//On tous les joueurs 
		ArrayList<Player> playersList = new ArrayList<>();
		int i = 2;
		while (lines.get(i).split(" ")[0].equals("Player")){
			Player p =  Player.initPlayerFromFile(lines.get(i), lines.get(i+1), lines.get(i+2), lines.get(i+3), lines.get(i+4), lines.get(i+5), lines.get(i+6), lines.get(i+7),lines.get(i+8),lines.get(i+9));
			i+=10;
			playersList.add(p);
		}
		System.out.println(playersList);
		mainGame(playersList, context,Integer.parseInt(lines.get(1).split(": ")[1]));
	
	}
	
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
		mainGame(playersList, context, playersList.size() - 1);
	}
	
	private static void mainGame(ArrayList<Player> playerList,ApplicationContext context, int i){
		ArrayList<Player> death = new ArrayList<Player>();
		while (true) {
			while (i >=0) {
				if (playerList.get(i).getLife() <= 0) {//Si le joueur est mort on le retire de la liste
					death.add(playerList.get(i));
					playerList.remove(i);
					if (i == 0 ) {
						playerList.get(playerList.size()-1).pickCardsInHand(5);
					}else {
						playerList.get(i-1).pickCardsInHand(5);
					}
					i--;
					continue;
				}
				GraphDeathMatch.controller(i , playerList, context);
				playerList.get(i).endTurn();
				if (i == 0 ) {
					playerList.get(playerList.size()-1).pickCardsInHand(5);
				}else {
					playerList.get(i-1).pickCardsInHand(5);
				}	
				i--;
			}
			
			if (playerList.size() == 1) {// si il n'y a plus qu'un joueur en vie il a gagné
				enGame(context, playerList.get(0));
				break;
			}
			i = playerList.size() - 1;
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
