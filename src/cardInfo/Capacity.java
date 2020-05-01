package cardInfo;

import java.awt.Color;
import java.util.HashMap;

import gameDeroulement.GameProgression;
import gameDeroulement.Players;
import graphic.GameController;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;

public class Capacity {//à un type de capacité est affecté une clé qui a pour valeur l'intensité, on effectue ainsi chacune de ces capacité
	
	static String choice = "unknown";
	static String possibility1;
	static String possibility2;
	
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
			
			case "Choice":	
				choice(cap, c);
				break;
				
			default:
				break;
			}
		}
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
	
	private static void embassyYatch(HashMap<String, Integer> cap, Players p) {//capacité unique à Embassy yatch, si + de 2 bases en jeu, pioche 2 cartes
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
	
	private static void opponentDiscard(HashMap<String, Integer> cap, Players p) { // le joueur adverse DOIT défausser une carte de son choix.
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
	
	private static void choice(HashMap<String, Integer> cap, Cards c) {
		
		System.out.println("Lancement de l'écran de choix pour la carte : "+c.getTitle());
		
		String number = String.valueOf(cap.get("Choice"));
		String[] valeurs = number.split(""); 
		int[] integers = new int[valeurs.length]; 

		for (int i = 0; i < integers.length; i++){
		    integers[i] = Integer.parseInt(valeurs[i]); 
		}
		
		if (integers[0] == 1) { // si 1 alors pts Authority OU pts Trade
			choice = "AorT";
			possibility1 = "A"+integers[1];
			possibility2 = "T"+integers[2];
		}
		else if (integers[0] == 2) { // si 2 alors pts Trade OU pts Attaque
			choice = "TorC";
			possibility1 = "T"+integers[1];
			possibility2 = "C"+integers[2];
		}
		else if (integers[0] == 3) { // si 1 alors pts Attaque OU cap spé
			choice = "CorS";
			possibility1 = "C"+integers[1];
			possibility2 = "S"+integers[2];
		}
		
		Application.run(Color.BLACK, context ->{
			GameProgression.choice(context,c,choice,possibility1, possibility2);
		});
		
	}
	
}
