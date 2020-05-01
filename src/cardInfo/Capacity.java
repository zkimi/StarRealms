package cardInfo;

import java.util.HashMap;

import gameDeroulement.Players;

public class Capacity {//� un type de capacit� est affect� une cl� qui a pour valeur l'intensit�, on effectue ainsi chacune de ces capacit�
	
	public static void applyCap(HashMap<String, Integer> cap, Players p) {
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
	
}
