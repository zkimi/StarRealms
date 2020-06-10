package gameMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import gameComponent.Bot;
import gameComponent.Market;
import gameComponent.Player;
import graphic.EndGame;
import graphic.MainGame;

public class GameVsBot {
	
	public static void initFromFile(ApplicationContext context, List<String> lines) {
		Market.initializeMarketFromFile(lines.get(lines.size()-3), lines.get(lines.size()-2), lines.get(lines.size()-1));
		Player p1 = Player.initPlayerFromFile(lines.get(1), lines.get(2), lines.get(3), lines.get(4), lines.get(5), lines.get(6), lines.get(7), lines.get(8),lines.get(9),lines.get(10));
		Bot p2 = Bot.initBotFromFile(lines.get(11), lines.get(12), lines.get(13), lines.get(14), lines.get(15), lines.get(16), lines.get(17), lines.get(18),lines.get(19),lines.get(20));
		ArrayList<Player> playersList = new ArrayList<>();
		playersList.add(p1);
		playersList.add(p2);
		
		maingame(p1, p2, context);
	}
	
	public static void startGame(ApplicationContext context){
		Market.initializeCards();
		Player p1 = new Player("Joueur 1");
		Bot p2 = new Bot("Joueur 2");
		  
		ArrayList<Player> playersList = new ArrayList<>();
		playersList.add(p1);
		playersList.add(p2);
		
		p1.distributeCards(8, CoreSet.scout);
		p1.distributeCards(2, CoreSet.viper);
		
		p2.distributeCards(8, CoreSet.scout);
		p2.distributeCards(2, CoreSet.viper);
		
		// On mélange les cartes de chaque joueur
		p1.shuffleCards();
		p2.shuffleCards();
		
		// Etape 1 : On choisit le joueur qui démarre la partie au hasard (ce dernier commencera avec 3 cartes) :
		System.out.println("Le premier joueur sera :");
		
		Random randomizer = new Random();
		int n = randomizer.nextInt(2);
		if (n == 1) {
			p1.first();
			p2.second();

			System.out.println(p1.getName());
			
			System.out.println("Le joueur : " +p1.getName()+ " piochera 3 cartes et son adversaire (" +p2.getName()+") en piochera 5.");
			
			System.out.println("Main de "+ p1.getName() +" : ");
			p1.pickCardsInHand(3);
			System.out.println(p1.showHand());
			System.out.println("\n");
			maingame(p1, p2, context);
		}else {
			p2.first();
			p1.second();

			System.out.println("Player "+p2.getName());
			
			System.out.println("Le joueur : " +p2.getName()+ " piochera 3 cartes et son adversaire (" +p1.getName()+") en piochera 5.");
			
			System.out.println("Main de "+ p2.getName() +" : ");
			p2.pickCardsInHand(3);
			System.out.println(p2.showHand());
			System.out.println("\n");
			maingame(p1, p2, context);
			
		}
		
		
		
		
	}
	
	public static void maingame(Player p1,Bot p2, ApplicationContext context){
		while (true) {
			if(p1.isfirst()) {
				MainGame.controller(p1, p2, context);
				p1.endTurn(); //a la fin du tour les ships en jeux partent
				p1.second();
				p2.first();
				p2.pickCardsInHand(5);
				
			}else{			
				p2.turn(p1);
				p2.endTurn(); //a la fin du tour les ships en jeux partent
				p2.second();
				p1.first();
				p1.pickCardsInHand(5);
			}
			
			//on arrete le jeu
			if (p1.getLife() < 1 || p2.getLife() < 1) {
				break;
			}
		}
		if (p1.getLife()<1) {
			enGame(context, p2);
		}else{
			enGame(context, p1);
		}
		
	}
	
	public static void enGame(ApplicationContext context, Player winner){
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
