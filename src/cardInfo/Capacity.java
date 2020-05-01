package cardInfo;

import java.awt.Color;
import java.util.HashMap;

import gameDeroulement.GameProgression;
import gameDeroulement.Players;
import graphic.GameController;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;

public class Capacity {//� un type de capacit� est affect� une cl� qui a pour valeur l'intensit�, on effectue ainsi chacune de ces capacit�
	
	private static String choice = "unknown";
	private static String possibility1;
	private static String possibility2;
	
	public static void applyCap(HashMap<String, Integer> cap, Players p, Cards c) {
		for (String key : cap.keySet()) {
			switch (key) {
			case "AttackPoint":
				giveAttackPoint(cap, p);
				break;
			
			case "TradePoint":
				giveTradePoint(cap, p);
				break;
				
			case "Draw":
				draw(cap, p);
				break;
			
			case "Authority": 
				giveAuthority(cap, p);
				break;
				
			case "EmbassyYatch":
				embassyYatch(cap, p);
				break;
			
			case "OpponentDiscard":	
				//opponentDiscard();
				break;
				
			case "FleetHQ":	
				fleetHQ(p);
				break;

			default:
				break;
			}
		}
	}
	
	public static boolean isChoiceCard(Cards c) {
		return c.getCapacity().get("Choice") != null;
	}
	
	private static void giveAttackPoint(HashMap<String, Integer> cap, Players p) {
		p.addFightPoint(cap.get("AttackPoint"));
	}
	
	private static void giveTradePoint(HashMap<String, Integer> cap, Players p) {
		p.addTradePoint(cap.get("TradePoint"));
	}
	
	private static void draw(HashMap<String, Integer> cap, Players p) {
		p.pickCardsInHand(cap.get("Draw"));
	}
	
	private static void giveAuthority(HashMap<String, Integer> cap, Players p) {
		p.addAuthority(cap.get("Authority"));
	}
	
	private static void embassyYatch(HashMap<String, Integer> cap, Players p) {//capacit� unique � Embassy yatch, si + de 2 bases en jeu, pioche 2 cartes
		int count = 0;
		for (Cards card : p.getTable()) {
			if (card.getType().equals("Base")) {
				count++;
			}
		}
		if (count >= 2) {
			p.pickCardsInHand(2);
		}		
	}
	
	private static void opponentDiscard(HashMap<String, Integer> cap, Players p) { // le joueur adverse DOIT d�fausser une carte de son choix.
		// code
	}
	
	private static void fleetHQ(Players p) { // FLEET HQ : all ship get "Add 1 Combat"
		int count = 0;
		for (Cards card : p.getTable()) {
			if (card.getType().equals("Ship")) {
				count++;
			}
		}
		if (count >= 1) {
			p.addFightPoint(count);
		}
	}
	
	public static void choice(HashMap<String, Integer> cap, Cards c, Players p, ApplicationContext context) {
				
		System.out.println("Lancement de l'�cran de choix pour la carte : "+c.getTitle());
		
		String number = String.valueOf(cap.get("Choice")); // on prend la valeur de la cl� Choice
		String[] valeurs = number.split(""); // on split chaque num�ro dans un tableau
		int[] integers = new int[valeurs.length];  // on cr�� tableau de int de la longueur du tableau de str

		for (int i = 0; i < integers.length; i++){ // pour chaque case du tableau int
		    integers[i] = Integer.parseInt(valeurs[i]); // on y met la valeur du string converti en INT
		}
		
		if (integers[0] == 1) { // si premier digit = 1 alors pts Authority OU pts Trade
			choice = "AorT"; // interpretation de ces 3 champs ensuite par GameView
			possibility1 = "A"+integers[1];
			possibility2 = "T"+integers[2];
		}
		else if (integers[0] == 2) { // si premier digit =  2 alors pts Trade OU pts Attaque
			choice = "TorC"; // interpretation de ces 3 champs ensuite par GameView
			possibility1 = "T"+integers[1];
			possibility2 = "C"+integers[2];
		}
		else if (integers[0] == 3) { // si premier digit = 3 alors pts Attaque OU cap sp�
			choice = "CorS"; // interpretation de ces 3 champs ensuite par GameView
			possibility1 = "C"+integers[1];
			possibility2 = "S"+integers[2];
		}
		else if (integers[0] == 4) { // si premier digit = 4 alors pts Authoruty OU Attaque
			choice = "AorC"; // interpretation de ces 3 champs ensuite par GameView
			possibility1 = "A"+integers[1];
			possibility2 = "C"+integers[2];
		}
		
		GameProgression.choice(context,c,choice,possibility1, possibility2, p); // lancement de l'�cran de choix avec r�cup du clic.

		
	}
	
}
