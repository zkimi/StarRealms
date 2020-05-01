package gameDeroulement;

import java.util.ArrayList;
import java.util.Random;

import cardInfo.Cards;
import cardsDetails.CoreSet;
import fr.umlv.zen5.ApplicationContext;
import graphic.GameController;

public class GameProgression {
	
	public static void startGame(ApplicationContext context) {
		Market.initializeCards();
		Players p1 = new Players("Joueur 1");
		Players p2 = new Players("Joueur 2");
		  
		ArrayList<Players> playersList = new ArrayList<>();
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
			System.out.println("Main de " +p2.getName()+" : ");
			p2.pickCardsInHand(5);
			System.out.println(p2.showHand());
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
			System.out.println("Main de " +p1.getName()+" : ");
			p1.pickCardsInHand(5);
			System.out.println(p1.showHand());
			maingame(p1, p2, context);
			
		}
		
		
		
		
	}
	
	public static void maingame(Players p1,Players p2, ApplicationContext context){
		while (true) {
			if(p1.isfirst()) {
				GameController.window(p1, p2, context);
				p1.second();
				p2.first();
				//p2.pickCardsInHand(5);
				
			}else{
				GameController.window(p2, p1, context);
				p2.second();
				p1.first();
				//p1.pickCardsInHand(5);
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
	
	public static void enGame(ApplicationContext context, Players winner) {
		while (true) {
			int x = GameController.windowEnd(context, winner);
			if (x == 1) {
				menu(context);
				break;
			}else if (x == 2) {
				break;
			}
			
		}
		context.exit(0);
	}
	
	public static void menu(ApplicationContext context) {
		while (true) {
			int x = GameController.menu(context);
			if (x == 1) {
				startGame(context);
				break;
			}else if (x == 2) {
				startGame(context);
				break;
			}
			
		}
		context.exit(0);
	}
	
	public static void choice(ApplicationContext contextChoice,Cards c, String choice, String pos1, String pos2, Players p) {
		while (true) {
			int choix = GameController.windowChoice(contextChoice, c, choice, pos1, pos2);
			if (choix == 1) {
				
				if (pos1.startsWith("T")) {
					p.addTradePoint(Integer.parseInt(pos1.substring(1,pos1.length())));
					break;
				} else if (pos1.startsWith("A")) {
					p.addAuthority(Integer.parseInt(pos1.substring(1,pos1.length())));
					break;
				} else if (pos1.startsWith("C")) {
					p.addFightPoint(Integer.parseInt(pos1.substring(1,pos1.length())));
					break;
				}
				
			} else if (choix == 2) {
				
				if (pos2.startsWith("T")) {
					p.addTradePoint(Integer.parseInt(pos2.substring(1,pos2.length())));
					break;
				} else if (pos2.startsWith("C")) {
					p.addFightPoint(Integer.parseInt(pos2.substring(1,pos2.length())));
					break;
				} else if (pos2.startsWith("S")) {
					// reconnaitre la capacité spé appel à une autre func.
					break;
				}
				
			}
			break;
		}
	}
	
}
