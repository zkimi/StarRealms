package gameMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import gameComponent.Market;
import gameComponent.Player;
import gameComponent.TeamTwo;
import graphic.EndGame;
import graphic.GraphDeathMatch;
import graphic.GraphHydraTwo;
import graphic.MainGame;

public class hydra {
	public static void startGame(ApplicationContext context) {
		Market.initializeCards();
		Player p1 = new Player("Joueur 1");
		Player p2 = new Player("Joueur 2");
		Player p3 = new Player("Joueur 3");
		Player p4 = new Player("Joueur 4");
		ArrayList<Player> playersList = new ArrayList<>();
		
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		playersList.add(p4);
		Collections.shuffle(playersList);
		
		
		p1.distributeCards(8, CoreSet.scout);
		p1.distributeCards(2, CoreSet.viper);
		
		p2.distributeCards(8, CoreSet.scout);
		p2.distributeCards(2, CoreSet.viper);
		
		p3.distributeCards(8, CoreSet.scout);
		p3.distributeCards(2, CoreSet.viper);
		
		p4.distributeCards(8, CoreSet.scout);
		p4.distributeCards(2, CoreSet.viper);
		
		// On mélange les cartes de chaque joueur
		p1.shuffleCards();
		p2.shuffleCards();
		p3.shuffleCards();
		p4.shuffleCards();
		
		TeamTwo t1 = new TeamTwo(playersList.get(0), playersList.get(1), 1, "Team 1");
		TeamTwo t2 = new TeamTwo(playersList.get(2), playersList.get(3), 2, "Team 2");
		t1.pickCardsInHand(3);
		t2.pickCardsInHand(5);
		
		mainGame(t1, t2, playersList, context);
	}
	
	private static void mainGame(TeamTwo t1, TeamTwo t2,ArrayList<Player> playerList, ApplicationContext context){
		while (true) {
			if(t1.isFirst()) {
				for (Player player : t1) {
					GraphHydraTwo.controller(player, t1, t2, playerList, context);
					player.endTurn();
				}
				
				t1.setId(2);
				t2.setId(1);
				t2.pickCardsInHand(5);
				
			}else{
				for (Player player : t2) {
					GraphHydraTwo.controller(player, t2, t1, playerList, context);
					player.endTurn();
				}
				t1.setId(1);
				t2.setId(2);
				t1.pickCardsInHand(5);
			}
			
			//on arrete le jeu
			if (t1.getLife() < 1 || t2.getLife() < 1) {
				break;
			}
		}
		if (t1.getLife()<1) {
			enGame(context, new Player(t2.getName()));
		}else{
			enGame(context, new Player(t1.getName()));
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
